import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) {
        final int PORT = 8189;
        final String IP_ADDRESS = "localhost";

        Socket socket;
        Scanner msg;
        DataInputStream in;
        DataOutputStream out;

        try {
            socket = new Socket(IP_ADDRESS, PORT);
            System.out.println("Вы подключились к серверу!");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            msg = new Scanner(new InputStreamReader(System.in));

            new Thread(() -> {
                try {
                    while (true) {
                        String str = in.readUTF();

                        System.out.println("Сервер: " + str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        out.close();
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            new Thread(() -> {
                try {
                    while (true) {
                        String str = msg.nextLine();

                        if (str.equals("/end")) {
                            break;
                        }

                        out.writeUTF("" + str);
                        out.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    msg.close();
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
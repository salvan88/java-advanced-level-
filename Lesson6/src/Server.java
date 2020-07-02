import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {

        ServerSocket server;
        Socket socket;
        Scanner msg;
        DataInputStream in;
        DataOutputStream out;

        final int PORT = 8189;

        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен!");

            socket = server.accept();
            System.out.println("Клиент подключился!");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            msg = new Scanner(new InputStreamReader(System.in));

            new Thread(() -> {
                try {
                    while (true) {
                        String str = in.readUTF();

                        if (str.equals("/end")) {
                            break;
                        }

                        System.out.println("Клиент: " + str);
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
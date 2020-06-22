package task2;

public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов","7589684");
        phoneBook.add("Петров","6387945");
        phoneBook.add("Иванов","5876458");
        phoneBook.add("Петров","1236589");

        phoneBook.get("Иванов");
        phoneBook.get("Петров");
    }
}

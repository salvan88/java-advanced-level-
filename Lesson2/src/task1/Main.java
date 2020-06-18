package task1;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"75", "89", "13", "56"},
                {"15", "16", "58", "87"},
                {"63", "54", "-21", "89"},
                {"9", "0", "67", "65"}
        };

        try {
            System.out.println("Сумма элементов массива равна: " + Array.Args(arr));
        } catch(MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch(MyArrayDataException e) {
            System.out.println(e.getMessage() + "строки " + e.getNumber() + " и столбца " + e.getNumber1());
        }
    }
}

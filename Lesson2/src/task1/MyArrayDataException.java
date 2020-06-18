package task1;

public class MyArrayDataException extends NumberFormatException{
    private int number;
    private int number1;

    public int getNumber() {
        return number;
    }

    public int getNumber1() {
        return number1;
    }

    public MyArrayDataException(String s, int number, int number1) {
        super(s);
        this.number = number;
        this.number1 = number1;
    }
}

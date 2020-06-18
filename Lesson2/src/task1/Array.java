package task1;


public class Array {
    public static int Args(String[][] arr1){
        int result = 0;

        for(int i = 0; i < arr1.length; i++){

            if(arr1[i].length != 4) {
                throw new MyArraySizeException("Задан массив некорректной размерности. Введите массив размерностью 4х4.");
            }

            for(int j = 0; j < arr1.length; j++) {
                try {
                    result += Integer.parseInt(arr1[i][j]);
                } catch(NumberFormatException e) {
                    throw new MyArrayDataException("В указанном массиве находится некорректный элемент по координатам ", i+1, j+1);
                }
            }
        }
        return result;
    }
}
package org.example;

public class App
{
    public static void main( String[] args ) {

        String[][] strings = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}

        };
        try {
            int result = fourByFourArraySum(strings);
            System.out.println(result);
        } catch (MyArrayDataException e){
            e.printStackTrace();
        } catch (MyArraySizeException e){
            e.printStackTrace();
        }


    }
    public static int fourByFourArraySum(String[][] strings) throws MyArraySizeException, MyArrayDataException{
        int result = 0;

        if (strings.length != 4){
            throw new MyArraySizeException("The array should have [4] rows, not [" + strings.length +"]");
        }
        for (int i = 0; i < strings.length; i++){
            if (strings[i].length != 4){
                throw new MyArraySizeException("The row [" + i + "] should have [4] elements, not [" + strings[i].length + "]");
            }
        }

        for (int i = 0; i < strings.length; i++){
            for (int j = 0; j < strings[i].length; j ++) {
                try {
                    int number = Integer.parseInt(strings[i][j]);
                    result += number;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return result;
    }
}

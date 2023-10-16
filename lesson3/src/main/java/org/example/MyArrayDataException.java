package org.example;

public class MyArrayDataException extends Exception {

    public MyArrayDataException(int index, int element) {
        super("The String element at myArray[" + index + "][" + element + "] can not be converted to Integer");
    }
}

package ru.geekbains;

import java.util.Arrays;
import java.util.ArrayList;

public class App
{
    public static void main( String[] args )
    {
        Integer[] ints = {1, 2, 3, 4, 5, 6, 7};
        exchangeTwoElementsInArray(ints, 0, 3);
        ArrayList<Integer> intsList = turnArrayIntoList(ints);
        System.out.println(intsList);

        String[] strings = {"A", "B", "C", "D"};
        exchangeTwoElementsInArray(strings, 0, 3);
        ArrayList<String> stringsList = turnArrayIntoList(strings);
        System.out.println(stringsList);

        Box<Fruit> fruitBox = new Box<>(new Apple(), new Orange());
        Box<Apple> appleBox = new Box<>(new Apple(), new Apple(), new Apple());
        Box<Orange> orangeBox  = new Box<>(new Orange(), new Orange());


        System.out.println(fruitBox.compare(appleBox));
        System.out.println(appleBox.compare(orangeBox));



    }

    public static void exchangeTwoElementsInArray(Object[] array, int i, int j){
        Object elementI = array[i];
        Object elementJ = array[j];
        array[i] = elementJ;
        array[j] = elementI;

    }
    public static <T> ArrayList<T> turnArrayIntoList(T[] array){
        ArrayList<T> arrayList = new ArrayList<T>(Arrays.asList(array));
        return arrayList;

    }
}

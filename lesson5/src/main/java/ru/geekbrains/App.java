package ru.geekbrains;

import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
        String[] strings = new String[]{
                "Create",
                "Create",
                "an",
                "an",
                "an",
                "array",
                "with",
                "with",
                "with",
                "with",
                "a",
                "set",
                "of",
                "of",
                "words"
        };

        Set<String> stringSet = new LinkedHashSet<>(List.of(strings));
        System.out.println(stringSet);

        Map<String, Integer> map = new LinkedHashMap<>();
        for (String fromArray: strings){
            map.put(fromArray, map.getOrDefault(fromArray, 0) + 1);
        }
        System.out.println(map.toString());



        PhoneBook phoneBook = new PhoneBook();
        System.out.println(phoneBook);
        System.out.println(phoneBook.get("Lola"));

        phoneBook.add("Zuzu", "906090");
        phoneBook.add("Anna", "88000");
        phoneBook.add("Boris", "555", "3535");
        phoneBook.add("Boris", "555", "3535");
        phoneBook.add("Lola", "777555");
        phoneBook.add("Lola", "777555");
        phoneBook.add("Lola", "3333444");
        phoneBook.add("Lola", "1234", "1234");
        phoneBook.add("Lola", "1234", "1234");

        System.out.println(phoneBook);
        System.out.println(phoneBook.get("Lola"));
        System.out.println(phoneBook.get("Pupa"));

    }
}

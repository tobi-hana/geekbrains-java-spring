package ru.geekbrains;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.Collections;
import java.util.LinkedHashSet;

public class PhoneBook {
    private TreeMap<String, LinkedHashSet<String>> book;

    public PhoneBook(){
        book = new TreeMap<>();
    }

    public void add(String name, String... phoneNumbers){
        if (book.containsKey(name)) {
            Collections.addAll(book.get(name), phoneNumbers);
            return;
        }
        book.put(name, new LinkedHashSet<>(Arrays.asList(phoneNumbers)));
    }

    public LinkedHashSet<String> get(String name){
        return book.getOrDefault(name, new LinkedHashSet<>());
    }

    @Override
    public String toString() {
        return "PhoneBook:\n" + book;
    }
}

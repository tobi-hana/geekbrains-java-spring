package ru.geekbrains;

import java.lang.reflect.InvocationTargetException;

public class MainApp {

    public static void main(String[] args) throws Exception {
        TesterClass.start(FirstClass.class);
    }
}

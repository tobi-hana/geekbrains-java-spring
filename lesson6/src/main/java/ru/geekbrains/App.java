package ru.geekbrains;

public class App 
{
    public static void main( String[] args ){
        App.method1();
        App.method2();

    }
    public static void method1(){
        final int SIZE = 10_000_000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];

        for(int i = 0; i < SIZE; i++) arr[i] = 1.0F;
        long a = System.currentTimeMillis();
        for(int i = 0; i < SIZE; i++)
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        System.out.print("TOTAL ");
        System.out.println(System.currentTimeMillis() - a);
        System.out.println();
    }
    public static void method2(){
        final int SIZE = 10_000_000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];

        for(int i = 0; i < SIZE; i++) arr[i] = 1.0F;

        long a = System.currentTimeMillis();
        float[] arrFirst = new float[HALF];
        float[] arrSecond = new float[HALF];
        System.arraycopy(arr, 0, arrFirst, 0, HALF);
        System.arraycopy(arr, HALF, arrSecond, 0, HALF);
        System.out.print("Division of array ");
        System.out.println(System.currentTimeMillis() - a);

        Thread threadFirst = new Thread(() -> {
            long b = System.currentTimeMillis();
            for(int i = 0; i < HALF; i++)
                arrFirst[i] = (float)(arrFirst[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            System.out.print("First Thread ");
            System.out.println(System.currentTimeMillis() - b);

        });
        Thread threadSecond = new Thread(() -> {
            long b = System.currentTimeMillis();
            for(int i = 0; i < HALF; i++)
                arrSecond[i] = (float)(arrSecond[i] * Math.sin(0.2f + (i + HALF) / 5) * Math.cos(0.2f + (i + HALF) / 5) * Math.cos(0.4f + (i + HALF) / 2));
            System.out.print("Second Thread ");
            System.out.println(System.currentTimeMillis() - b);

        });
        threadFirst.start();
        threadSecond.start();
        try {
            threadFirst.join();
            threadSecond.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long c = System.currentTimeMillis();
        System.arraycopy(arrFirst, 0, arr, 0, HALF);
        System.arraycopy(arrSecond, 0, arr, HALF, HALF);
        System.out.print("Combine arrays ");
        System.out.println(System.currentTimeMillis() - c);
        System.out.print("TOTAL ");
        System.out.println(System.currentTimeMillis() - a);

    }
}

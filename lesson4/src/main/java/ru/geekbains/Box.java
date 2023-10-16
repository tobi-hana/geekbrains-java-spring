package ru.geekbains;

import java.util.ArrayList;

public class Box <T extends Fruit>{
    private ArrayList<T> fruits;


    public Box(T... fruits){
        this.fruits = new ArrayList<>();
        for (T fruit : fruits){
            this.fruits.add(fruit);
        }
    }

    public void addFruit(T fruit){
        fruits.add(fruit);
    }

    public ArrayList<T> getFruits(){
        return fruits;
    }

    public float getWeight(){
        float mass = 0;
        for (T fruit : fruits){
            mass += fruit.getWeight();
        }
        return mass;
    }

    public boolean compare(Box<?> other){
        return (Math.abs(getWeight() - other.getWeight()) < 0.001f);

    }

    public void transferFruitsTo(Box<T> other){
        if (this == other){
            System.out.println("It's the same box!!!");
            return;
        }
        for (T fruit: fruits){
            other.addFruit(fruit);
        }
        fruits.clear();
    }



}

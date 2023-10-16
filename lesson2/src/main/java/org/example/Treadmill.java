package org.example;

public class Treadmill implements Obstacle{
    private double length;

    public void doSomething(Moves participant){
        participant.run(this);

    }

    public Treadmill(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }


}

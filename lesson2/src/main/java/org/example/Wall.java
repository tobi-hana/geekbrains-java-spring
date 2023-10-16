package org.example;

public class Wall implements Obstacle {
    private double height;

    public void doSomething(Moves participant){
        participant.jump(this);
    }

    public Wall(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }


}

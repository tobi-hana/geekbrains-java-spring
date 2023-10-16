package org.example;

public class Cat implements Moves {
    private String name;
    private double maxRunLength;
    private double maxJumpHeight;
    private boolean thereAreObstacles;

    @Override
    public void run(Treadmill treadmill) {
        if (thereAreObstacles) {
            return;
        }
        thereAreObstacles = true;
        if (treadmill.getLength() > maxRunLength) {
            System.out.printf("Cat '%s' can't run %.1f meters \n", name, treadmill.getLength());
            System.out.println();
            return;
        }
        thereAreObstacles = false;
        System.out.printf("Cat '%s' successfully passed %.1f meters on this treadmill \n",
                name, treadmill.getLength());
    }

    @Override
    public void jump(Wall wall) {
        if (thereAreObstacles) {
            return;
        }
        thereAreObstacles = true;
        if (wall.getHeight() > maxJumpHeight) {
            System.out.printf("Cat '%s' can't jump %.1f meters \n", name, wall.getHeight());
            System.out.println();
            return;
        }
        thereAreObstacles = false;
        System.out.printf("Cat '%s' successfully jumped over %.1f meter wall \n",
                name, wall.getHeight());
    }


    public Cat(String name, double maxRunLength, double maxJumpHeight) {
        this.name = name;
        this.maxRunLength = maxRunLength;
        this.maxJumpHeight = maxJumpHeight;
        thereAreObstacles = false;

    }

   public boolean thereAreObstacles(){
        return thereAreObstacles;
   }
}
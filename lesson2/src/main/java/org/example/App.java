package org.example;

public class App {
    public static void main( String[] args ) {
        Moves[] participants = {
                new Cat("A", 1, 1),
                new Cat("B", 2, 2),
                new Human("C", 3, 3),
                new Human("D", 5, 5)};

        Obstacle[] obstacles = {
                new Treadmill(2),
                new Wall(2),
                new Treadmill(3),
                new Wall(3)};

        for (Moves participant : participants){
            for (Obstacle obstacle : obstacles){
                obstacle.doSomething(participant);
                if (participant.thereAreObstacles()){
                    break;
                }
            }
            if (!participant.thereAreObstacles()) {
                System.out.println("This participant passed all obstacles!!!!");
                System.out.println();
            }
        }

    }
}

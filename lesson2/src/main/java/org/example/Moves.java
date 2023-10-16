package org.example;

public interface Moves {
    void run (Treadmill treadmill);
    void jump(Wall wall);

    boolean thereAreObstacles();
    /** returns true if there are no obstacles
     *
     */
}

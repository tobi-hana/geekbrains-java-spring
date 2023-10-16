package ru.geek.brains;

public class App {

    public static void main(String[] args) {

        TaskTracker taskTracker = new TaskTracker();
        taskTracker.printTasks();
        Task task1 = new Task(1, "first", "Sam", "Tom", "Clean", "Done");
        Task task2 = new Task(2, "second", "Alice", "Betty", "Mail", "In process");
        Task task3 = new Task(3, "third");
        Task task4 = new Task(4, "forth");
        Task task5 = new Task(5, "fifth");
        Task task6 = new Task(6, "first");
        Task task7 = new Task(7, "first");
        Task task8 = new Task(8, "first");
        Task task9 = new Task(9, "first");

        taskTracker.printTasks();
        taskTracker.addTask(task1);
        taskTracker.addTask(task2);
        taskTracker.addTask(task3);
        taskTracker.addTask(task1);

        taskTracker.addTask(task4);
        taskTracker.addTask(task5);
        taskTracker.addTask(task6);
        taskTracker.addTask(task1);

        taskTracker.addTask(task7);
        taskTracker.addTask(task8);
        taskTracker.addTask(task9);
        taskTracker.addTask(task1);

        taskTracker.printTasks();

        taskTracker.deleteLast(1);
        taskTracker.printTasks();

        taskTracker.addTask(task1);
        taskTracker.printTasks();

        taskTracker.deleteFirst("first");
        taskTracker.printTasks();

        taskTracker.addTask(task1);
        taskTracker.printTasks();

        taskTracker.deleteAll("first");
        taskTracker.printTasks();




    }
}

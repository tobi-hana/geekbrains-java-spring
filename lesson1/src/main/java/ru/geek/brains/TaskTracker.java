package ru.geek.brains;

public class TaskTracker {
    Task[] tasks;
    int length;

    public TaskTracker(){
        tasks = new Task[10];
        length = 0;
    }

    public void addTask(Task task){
        if (length < 10) {
            tasks[length] = task;
            length++;
            System.out.printf("Task %d has been added\n", length);
            return;
        }
        System.out.println("This tracker is full. Create a new one.");

    }
    public void printTasks(){
        for (int i = 0; i < length; i++){
            System.out.println(tasks[i]);
        }
        System.out.println();
    }
    public void deleteFirst(int id){
        for (int i = 0; i < length; i++){
            if (tasks[i].getId() == id){
                tasks[i] = null;
                break;
            }
        }
        for (int i = 0; i < length; i++) {
            if (tasks[i] == null) {
                for (int j = i; j < length - 1; j++) {
                    tasks[j] = tasks[j + 1];
                }
            }
        }
        length--;
    }
    public void deleteFirst(String name){
        for (int i = 0; i < length; i++){
            if (tasks[i].getName().equals(name)){
                tasks[i] = null;
                break;
            }
        }
        for (int i = 0; i < length; i++) {
            if (tasks[i] == null) {
                for (int j = i; j < length - 1; j++) {
                    tasks[j] = tasks[j + 1];
                }
            }
        }
        length--;
    }
    public void deleteLast(int id){
        for (int i = 0; i < length; i++){
            if (tasks[length - 1 - i].getId() == id){
                tasks[length - 1 - i] = null;
                break;
            }
        }
        for (int i = 0; i < length; i++) {
            if (tasks[i] == null) {
                for (int j = i; j < length - 1; j++) {
                    tasks[j] = tasks[j + 1];
                }
            }
        }
        length--;
    }
    public void deleteLast(String name){
        for (int i = 0; i < length; i++){
            if (tasks[length - 1 - i].getName().equals(name)){
                tasks[length - 1 - i] = null;
                break;
            }
        }
        for (int i = 0; i < length; i++) {
            if (tasks[i] == null) {
                for (int j = i; j < length - 1; j++) {
                    tasks[j] = tasks[j + 1];
                }
            }
        }
        length--;
    }
    public void deleteAll(int id) {
        int deleted = 0;
        for (int i = 0; i < length; i++) {
            if (tasks[i].getId() == id) {
                tasks[i] = null;
                deleted++;
            }
        }
        for (int c = 0; c < deleted; c++) {
            for (int i = 0; i < length; i++) {
                if (tasks[i] == null) {
                    for (int j = i; j < length - 1; j++) {
                        tasks[j] = tasks[j + 1];
                    }
                }
            }
        }
        length -= deleted;
    }
    public void deleteAll(String name) {
        int deleted = 0;
        for (int i = 0; i < length; i++) {
            if (tasks[i].getName().equals(name)) {
                tasks[i] = null;
                deleted++;
            }
        }
        for (int c = 0; c < deleted; c++) {
            for (int i = 0; i < length; i++) {
                if (tasks[i] == null) {
                    for (int j = i; j < length - 1; j++) {
                        tasks[j] = tasks[j + 1];
                    }
                }
            }
        }
        length -= deleted;
    }
}

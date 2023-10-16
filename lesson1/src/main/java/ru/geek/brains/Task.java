package ru.geek.brains;

public class Task {
    private int id;
    private String name;
    private String creator;
    private String performer;
    private String description;
    private String state;

    public Task(int id, String name, String creator, String performer, String description, String state) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.performer = performer;
        this.description = description;
        this.state = state;
    }

    public Task(int id, String name) {
        this.id = id;
        this.name = name;
        this.creator = "Unknown";
        this.performer = "Unknown";
        this.description = "Unknown";
        this.state = "Unknown";
    }
    public Task(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", name: '" + name + '\'' +
                ", creator: '" + creator + '\'' +
                ", performer: '" + performer + '\'' +
                ", description: '" + description + '\'' +
                ", state: '" + state + '\'' ;
    }
}

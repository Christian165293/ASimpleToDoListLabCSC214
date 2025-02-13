package org.example;

public class Task {

    private String name;
    private String status;
    private String description;

    public Task(String inTaskName, String inTaskStatus, String inTaskDescription) {
        name = inTaskName;
        status = inTaskStatus;
        description = inTaskDescription;
    }

    public void markComplete() {
        status = "Complete";
    }

    public void markIncomplete() {
        status = "Incomplete";
    }

    public void changeDescription(String inTaskDescription) {
        description = inTaskDescription;
    }

    public void changeTaskName(String inTaskName) {
        name = inTaskName;
    }


    public String getTaskName() {
        return name;
    }

    public String getTaskStatus() {
        return status;
    }

    public String getTaskDescription() {
        return description;
    }

    public String toString() {
        return String.format("Task Name: %s\tStatus: %s\tDescription: %s", name, status, description);
    }
}
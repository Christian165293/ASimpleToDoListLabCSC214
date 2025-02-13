package org.example;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks = new ArrayList<>();

    public TaskList(String inTaskName, String inTaskStatus, String inTaskDescription) {
        Task task = new Task(inTaskName, inTaskStatus, inTaskDescription);
        tasks.add(task);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(String inTaskName, String inTaskStatus, String inTaskDescription) {
        Task task = new Task(inTaskName, inTaskStatus, inTaskDescription);
        tasks.add(task);
    }

    public void clearTaskList() {
        tasks.clear();
    }

    public String toStringAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("Task list:").append("\n");
        for (Task task : tasks) {
            sb.append(task.toString()).append("\n"); // Append each task on a new line
        }
        return sb.toString();
    }

    public String toStringComplete() {
        StringBuilder sb = new StringBuilder();
        sb.append("Complete Task List:").append("\n");
        for (Task task : tasks) {
            if (task.getTaskStatus().equals("Complete")) {
                sb.append(task.toString()).append("\n"); // Append each task on a new line
            }
        }
        return sb.toString();
    }

    public String toStringIncomplete() {
        StringBuilder sb = new StringBuilder();
        sb.append("Incomplete Task List:").append("\n");
        for (Task task : tasks) {
            if (task.getTaskStatus().equals("Incomplete")) {
                sb.append(task.toString()).append("\n"); // Append each task on a new line
            }
        }
        return sb.toString();
    }
}
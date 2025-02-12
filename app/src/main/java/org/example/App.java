package org.example;

public class App {
    public static void main(String[] args) {
        TaskList taskList = new TaskList("testing", "Complete", "testing my code");
        System.out.println(taskList.toStringAll());
        taskList.addTask("inccorectTest", "Incomplete", "testing for incomplete");
        System.out.println(taskList.toStringAll());
        System.out.println(taskList.toStringComplete());
        System.out.println(taskList.toStringIncomplete());
        taskList.clearTaskList();
        System.out.println(taskList.toStringAll());

    }
}

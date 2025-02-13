package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskList taskList = null;

        while (true) {
            System.out.println("\n--- Task Manager Menu ---");
            System.out.println("1. Create a new TaskList");
            System.out.println("2. Add a Task");
            System.out.println("3. Mark a Task as Complete");
            System.out.println("4. Mark a Task as Incomplete");
            System.out.println("5. Change Task Description");
            System.out.println("6. Change Task Name");
            System.out.println("7. View All Tasks");
            System.out.println("8. View Complete Tasks");
            System.out.println("9. View Incomplete Tasks");
            System.out.println("10. Clear TaskList");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter initial task name: ");
                    String taskName = scanner.nextLine();
                    String taskStatus = getValidStatus(scanner);
                    System.out.print("Enter initial task description: ");
                    String taskDescription = scanner.nextLine();
                    taskList = new TaskList(taskName, taskStatus, taskDescription);
                    System.out.println("TaskList created successfully!");
                    break;

                case 2:
                    if (taskList == null) {
                        System.out.println("Please create a TaskList first.");
                        break;
                    }
                    System.out.print("Enter task name: ");
                    String newTaskName = scanner.nextLine();
                    String newTaskStatus = getValidStatus(scanner);
                    System.out.print("Enter task description: ");
                    String newTaskDescription = scanner.nextLine();
                    taskList.addTask(newTaskName, newTaskStatus, newTaskDescription);
                    System.out.println("Task added successfully!");
                    break;

                case 3:
                    if (taskList == null) {
                        System.out.println("Please create a TaskList first.");
                        break;
                    }
                    System.out.print("Enter the task name to mark as complete: ");
                    String completeTaskName = scanner.nextLine();
                    for (Task task : taskList.getTasks()) {
                        if (task.getTaskName().equals(completeTaskName)) {
                            task.markComplete();
                            System.out.println("Task marked as complete!");
                            break;
                        }
                    }
                    break;

                case 4:
                    if (taskList == null) {
                        System.out.println("Please create a TaskList first.");
                        break;
                    }
                    System.out.print("Enter the task name to mark as incomplete: ");
                    String incompleteTaskName = scanner.nextLine();
                    for (Task task : taskList.getTasks()) {
                        if (task.getTaskName().equals(incompleteTaskName)) {
                            task.markIncomplete();
                            System.out.println("Task marked as incomplete!");
                            break;
                        }
                    }
                    break;

                case 5:
                    if (taskList == null) {
                        System.out.println("Please create a TaskList first.");
                        break;
                    }
                    System.out.print("Enter the task name to change description: ");
                    String descTaskName = scanner.nextLine();
                    System.out.print("Enter the new description: ");
                    String newDescription = scanner.nextLine();
                    for (Task task : taskList.getTasks()) {
                        if (task.getTaskName().equals(descTaskName)) {
                            task.changeDescription(newDescription);
                            System.out.println("Task description updated!");
                            break;
                        }
                    }
                    break;

                case 6:
                    if (taskList == null) {
                        System.out.println("Please create a TaskList first.");
                        break;
                    }
                    System.out.print("Enter the task name to change its name: ");
                    String oldTaskName = scanner.nextLine();
                    System.out.print("Enter the new task name: ");
                    String updatedTaskName = scanner.nextLine();
                    for (Task task : taskList.getTasks()) {
                        if (task.getTaskName().equals(oldTaskName)) {
                            task.changeTaskName(updatedTaskName);
                            System.out.println("Task name updated!");
                            break;
                        }
                    }
                    break;

                case 7:
                    if (taskList == null) {
                        System.out.println("Please create a TaskList first.");
                        break;
                    }
                    System.out.println(taskList.toStringAll());
                    break;

                case 8:
                    if (taskList == null) {
                        System.out.println("Please create a TaskList first.");
                        break;
                    }
                    System.out.println(taskList.toStringComplete());
                    break;

                case 9:
                    if (taskList == null) {
                        System.out.println("Please create a TaskList first.");
                        break;
                    }
                    System.out.println(taskList.toStringIncomplete());
                    break;

                case 10:
                    if (taskList == null) {
                        System.out.println("Please create a TaskList first.");
                        break;
                    }
                    taskList.clearTaskList();
                    System.out.println("TaskList cleared!");
                    break;

                case 11:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static String getValidStatus(Scanner scanner) {
        while (true) {
            System.out.print("Enter task status (Complete/Incomplete): ");
            String status = scanner.nextLine();
            if (status.equals("Complete") || status.equals("Incomplete")) {
                return status;
            } else {
                System.out.println("Invalid status. Please enter either 'Complete' or 'Incomplete' (case-sensitive).");
            }
        }
    }
}
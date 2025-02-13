package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task("Test Task", "Incomplete", "This is a test task.");
    }

    @Test
    void testMarkComplete() {
        task.markComplete();
        assertEquals("Complete", task.getTaskStatus());
    }

    @Test
    void testMarkIncomplete() {
        task.markComplete();
        task.markIncomplete();
        assertEquals("Incomplete", task.getTaskStatus());
    }

    @Test
    void testChangeDescription() {
        task.changeDescription("Updated description.");
        assertEquals("Updated description.", task.getTaskDescription());
    }

    @Test
    void testChangeTaskName() {
        task.changeTaskName("Updated Task");
        assertEquals("Updated Task", task.getTaskName());
    }
}
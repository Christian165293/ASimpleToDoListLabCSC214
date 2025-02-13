package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    private TaskList taskList;

    @BeforeEach
    void setUp() {
        taskList = new TaskList("Initial Task", "Incomplete", "Initial Description");
    }

    @Test
    void testAddTask() {
        taskList.addTask("New Task", "Complete", "New Description");
        ArrayList<Task> tasks = taskList.getTasks();
        assertEquals(2, tasks.size());
        assertEquals("New Task", tasks.get(1).getTaskName());
    }

    @Test
    void testClearTaskList() {
        taskList.clearTaskList();
        assertEquals(0, taskList.getTasks().size());
    }

    @Test
    void testToStringAll() {
        taskList.addTask("New Task", "Complete", "New Description");
        String output = taskList.toStringAll();
        assertTrue(output.contains("Initial Task"));
        assertTrue(output.contains("New Task"));
    }

    @Test
    void testToStringComplete() {
        taskList.addTask("New Task", "Complete", "New Description");
        String output = taskList.toStringComplete();
        assertTrue(output.contains("New Task"));
        assertFalse(output.contains("Initial Task"));
    }

    @Test
    void testToStringIncomplete() {
        taskList.addTask("New Task", "Complete", "New Description");
        String output = taskList.toStringIncomplete();
        assertTrue(output.contains("Initial Task"));
        assertFalse(output.contains("New Task"));
    }
}
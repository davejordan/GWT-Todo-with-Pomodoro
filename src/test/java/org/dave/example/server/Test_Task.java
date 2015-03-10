package org.dave.example.server;

import org.dave.example.shared.Task;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test_Task {

    Task task;

    @Before
    public void setUp() throws Exception {
        task = new Task();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void test_increaseTotalInterruptions_from0To5() throws Exception {
        task.increaseTotalInterruptions(5);
        assertEquals(5, task.getTotalInterruptions());
    }

    @Test
    public void test_incrementCompletedPomodoroCount_from0to1() throws Exception {
        task.incrementCompletedPomodoroCount();
        assertEquals(1,task.getCompletedPomodoroCount());
    }
}
package org.dave.example.client;

import org.dave.example.server.PomodoroDrop1OnStartTimer;
import org.dave.example.shared.Task;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Test_RunTimedTaskSession {

    private PomodoroDrop1OnStartTimer timer;
    private RunTimedTaskSession session;
    private Task task;

    @Before
    public void setUp() throws Exception {
        timer = new PomodoroDrop1OnStartTimer();
        task = new Task();
        session = new RunTimedTaskSession(timer, task);
    }

    @After
    public void tearDown() throws Exception {

    }



    @Test
    public void test_InterruptSession_InitialisesAs0() throws Exception {
        assertEquals(0, session.getCountOfSessionInterruptions());
    }

    @Test
    public void test_getTimeRemaining_InitialisesAs0() throws Exception {
        assertEquals(0,session.getTimeRemaining());
    }

    @Test
    public void test_GetCountOfSessionInterruptions_IntialisesAs0() throws Exception {
        assertEquals(0, session.getCountOfSessionInterruptions());
    }

    @Test
    public void test_GetTimeRemaining_DecreasesFromStart() throws Exception {
        session.startSession(2);
        assertEquals(1, session.getTimeRemaining());
    }

    @Test
    public void test_GetTimeRemaining_Is0OnExpiry() throws Exception {
        session.startSession(1);
        assertEquals(0, session.getTimeRemaining());
    }


    @Test
    public void test_GetCountOfSessionInterruptions_InterruptingAddsCount() throws Exception {
        session.startSession(2);
        session.interruptSession();
        assertEquals(1, session.getCountOfSessionInterruptions());
    }


    @Test
    public void test_IsSessionRunning_InitalisesFalse() throws Exception {
        assertFalse(session.isSessionRunning());
    }

    @Test
    public void test_IsSessionRunning_TrueOnRunningSession() throws Exception {
        session.startSession(2);
        assertTrue(session.isSessionRunning());
    }

    @Test
    public void test_IsSessionRunning_FalseOnExpiredSession() throws Exception {
        session.startSession(1);
        assertFalse(session.isSessionRunning());
    }

    @Test
    public void test_CancelSession_SetsIsRunningFalse() throws Exception {
        session.startSession(2);
        session.cancelSession();
        assertFalse(session.isSessionRunning());
    }

    @Test
    public void test_Update_TasksPomodoroCountIncreases() throws Exception {
        session.startSession(1);
        assertEquals(1, task.getCompletedPomodoroCount());
    }

    @Test
    public void test_InterruptSession_DoesNotAffectFinishedSessions() throws Exception {
        session.startSession(1);
        session.interruptSession();
        assertEquals(0,session.getCountOfSessionInterruptions());
    }

    @Test
    public void test_Update_TaskInterruptionsIncrease() throws Exception {
        session.startSession(2);
        session.interruptSession();
        timer.forwardTimerToEnd();
        assertEquals(1, task.getTotalInterruptions());
    }


}
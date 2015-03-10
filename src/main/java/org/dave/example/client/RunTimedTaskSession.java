package org.dave.example.client;

import org.dave.example.shared.Task;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by David on 13/02/2015.
 */
public class RunTimedTaskSession implements Observer{

    private boolean sessionIsRunning = false;
    private int countOfSessionInterruptions = 0;

    private PomodoroTimer timer;
    private Task task;

    public RunTimedTaskSession(PomodoroTimer timer, Task task) {
        this.timer = timer;
        this.task = task;
        timer.addObserver(this);
    }

    public void startSession(int duration_ms) {
        sessionIsRunning = true;
        timer.startTimer(duration_ms);
    }

    public void cancelSession() {
        sessionIsRunning = false;
    }

    public void interruptSession() {
        if (sessionIsRunning) {
            countOfSessionInterruptions++;
        }
    }

    public int getTimeRemaining() {
        return timer.checkTimeRemaining_ms();
    }

    public int getCountOfSessionInterruptions() {
        return countOfSessionInterruptions;
    }

    public boolean isSessionRunning(){
        return sessionIsRunning;
    }

    @Override
    public void update(Observable o, Object arg) {
        finishTimedSession();
    }

    private void finishTimedSession() {
        sessionIsRunning = false;
        task.incrementCompletedPomodoroCount();
        task.increaseTotalInterruptions(countOfSessionInterruptions);
    }

}

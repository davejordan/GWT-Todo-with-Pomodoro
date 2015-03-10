package org.dave.example.server;

import org.dave.example.client.PomodoroTimer;

/**
 * Created by David on 13/02/2015.
 */
public class PomodoroDrop1OnStartTimer extends PomodoroTimer {
    int duration_ms;

    private void sendNotifyMessage() {
        setChanged();
        notifyObservers();
    }

    @Override
    public void startTimer(int duration_ms) {
        this.duration_ms = --duration_ms;
        if (this.duration_ms <=0){
            sendNotifyMessage();
        }
    }


    @Override
    public int checkTimeRemaining_ms() {
        return duration_ms;
    }

    public void forwardTimerToEnd() {
        this.duration_ms = 0;
        sendNotifyMessage();
    }
}

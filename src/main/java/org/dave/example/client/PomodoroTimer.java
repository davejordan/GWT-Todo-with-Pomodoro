package org.dave.example.client;

import java.util.Observable;

/**
 * Created by David on 13/02/2015.
 */
public abstract class PomodoroTimer extends Observable{
    public abstract void startTimer(int duration_ms);
    public abstract int checkTimeRemaining_ms();
}

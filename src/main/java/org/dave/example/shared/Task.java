package org.dave.example.shared;

import java.io.Serializable;

/**
 * Created by David on 11/02/2015.
 */
public class Task implements Serializable{

    private int completedPomodoroCount = 0;
    private int totalInterruptions = 0;
    private boolean taskIsEmpty = true;
    private String name;

    public Task() {

    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCompletedPomodoroCount() {
        return completedPomodoroCount;
    }

    public int getTotalInterruptions() {
        return totalInterruptions;
    }

    public void increaseTotalInterruptions(int interruption_count){
        this.totalInterruptions += interruption_count;
    }

    public void incrementCompletedPomodoroCount() {
        completedPomodoroCount++;
    }

    /*public boolean isTaskEmpty(){
        return taskIsEmpty;
    }*/

    public void setTaskAsFull(){
        taskIsEmpty = false;
    }

    @Override
    public String toString(){
        return name;
    }
}
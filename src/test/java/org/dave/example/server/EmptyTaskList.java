package org.dave.example.server;

import org.dave.example.shared.Task;

import java.util.Collections;
import java.util.Set;

/**
 * Created by David on 14/02/2015.
 */
public class EmptyTaskList implements TaskList {

//    @Override
//    public Task getTask(TaskIdentifier task_id) throws NoSuchElementException {
//        throw new NoSuchElementException();
//    }

    @Override
    public Set<Task> getAllTasks() {
        return Collections.emptySet();
    }
}

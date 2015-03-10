package org.dave.example.server;

import org.dave.example.shared.Task;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by David on 14/02/2015.
 */
public class SingleTaskList implements TaskList {

    private HashMap<String,Task> map = new HashMap<String, Task>();

    public SingleTaskList() {
        Task task = new Task();
        task.setTaskAsFull();
        map.put("test", task);
    }

//    @Override
//    public Task getTask(TaskIdentifier task_id) {
//        return map.get(task_id);
//    }

    @Override
    public Set<Task> getAllTasks() {
        return new LinkedHashSet<Task>(map.values());
    }
}

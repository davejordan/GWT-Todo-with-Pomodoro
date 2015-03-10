package org.dave.example.server;

import org.dave.example.shared.Task;

import java.io.IOException;
import java.util.Set;

/**
 * Created by David on 12/02/2015.
 */
public interface TaskList {
//    public Task getTask(String name) throws ItemNotFoundException;

  public Set<Task> getAllTasks() throws IOException;

  //Get completed tasks, get in-complete tasks, etc

}

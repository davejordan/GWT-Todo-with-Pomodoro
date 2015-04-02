package org.dave.example.server;

import org.dave.example.shared.Task;
import org.dave.example.shared.TaskList;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

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
  public int size() {
    return map.size();
  }

  @Override
  public void add(Task task) {
    map.put(task.getName(), task);
  }

  @Override
  public void clear() {
    map.clear();
  }

  @Override
  public Collection<Task> getCollection() {
    return null;
  }

  @Override
  public Iterator<Task> iterator() {
    return null;
  }

  @Override
  public void forEach(Consumer<? super Task> action) {

  }

  @Override
  public Spliterator<Task> spliterator() {
    return null;
  }
}

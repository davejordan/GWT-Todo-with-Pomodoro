package org.dave.example.server;

import org.dave.example.shared.Task;
import org.dave.example.shared.TaskList;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by David on 14/02/2015.
 */
public class EmptyTaskList implements TaskList {

//    @Override
//    public Task getTask(TaskIdentifier task_id) throws NoSuchElementException {
//        throw new NoSuchElementException();
//    }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public void add(Task task) {

  }

  @Override
  public void clear() {

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

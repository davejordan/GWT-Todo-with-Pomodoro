package org.dave.example.shared;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by David on 12/03/2015.
 */
public class SimpleTaskList implements TaskList {

  private Set<Task> taskSet;

  public SimpleTaskList(Collection<Task> collection) {
    taskSet = new HashSet<>(collection);
  }

  public SimpleTaskList() {
    taskSet = new HashSet<>();
  }

  @Override
  public int size() {
    return taskSet.size();
  }

  @Override
  public void add(Task task) {
    taskSet.add(task);
  }

  @Override
  public void clear() {
    taskSet.clear();
  }

  @Override
  public Collection<Task> getCollection() {
    return taskSet;
  }

  @Override
  public Iterator<Task> iterator() {
    return taskSet.iterator();
  }

}
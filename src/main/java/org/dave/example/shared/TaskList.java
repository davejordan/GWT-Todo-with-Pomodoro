package org.dave.example.shared;

import java.util.Collection;

/**
 * Created by David on 12/02/2015.
 */
public interface TaskList extends Iterable<Task> {

  public int size();

  public void add(Task task);

  public void clear();

  public Collection<Task> getCollection();

}

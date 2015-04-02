package org.dave.example.TaskSource;

import com.google.gson.Gson;
import org.dave.example.shared.Task;
import org.dave.example.shared.TaskList;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

/**
 * Created by David on 14/02/2015.
 */
public class SimpleStaticJSONTaskList implements TaskList {

  private Map<String, Task> map = new HashMap<String, Task>();

  public SimpleStaticJSONTaskList(String jsonString) throws IOException {
    Gson gson = new Gson();
    TodoistTaskDAO[] todoistPojo = gson.fromJson(jsonString, TodoistTaskDAO[].class);
    for (TodoistTaskDAO i : todoistPojo) {
      String name = i.getName();
      Task task = new Task();
      task.setName(i.getContent());
      map.put(name, task);
    }
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

  /*@Override
  public Task getTask(String name) {
      return map.get(name);
  }
*/
 /* @Override
  public Set<Task> getAllTasks() {
    return new LinkedHashSet<Task>(map.values());
  }
*/

}

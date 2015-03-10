package org.dave.example.server;

import com.google.gson.Gson;
import org.dave.example.server.TaskList;
import org.dave.example.server.TodoistTaskPOJO;
import org.dave.example.shared.Task;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by David on 14/02/2015.
 */
public class SimpleStaticJSONTaskList implements TaskList {

  private Map<String, Task> map = new HashMap<String, Task>();

  public SimpleStaticJSONTaskList(String jsonString) throws IOException {
    Gson gson = new Gson();
    TodoistTaskPOJO[] todoistPojo = gson.fromJson(jsonString, TodoistTaskPOJO[].class);
    for (TodoistTaskPOJO i : todoistPojo) {
      String name = i.getName();
      Task task = new Task();
      task.setName(i.getContent());
      map.put(name, task);
    }
  }

  /*@Override
  public Task getTask(String name) {
      return map.get(name);
  }
*/
  @Override
  public Set<Task> getAllTasks() {
    return new LinkedHashSet<Task>(map.values());
  }
}

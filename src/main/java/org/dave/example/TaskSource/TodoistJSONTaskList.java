package org.dave.example.TaskSource;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.dave.example.shared.Task;
import org.dave.example.shared.TaskList;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

/**
 * Created by David on 15/02/2015.
 */
public class TodoistJSONTaskList implements TaskList {
  private final TaskSource inputSource;
  private String streamEncoding = "UTF-8";

  private Set<Task> taskSet = new HashSet<>();

  public TodoistJSONTaskList(TaskSource inputSource) {
    this.inputSource = inputSource;
    resetTaskSetFromSource();
  }

//    @Override
//    public Task getTask(String name) {
//        return null;
//    }

/*  @Override
  public Set<Task> getAllTasks() throws IOException {
    if (taskSet.isEmpty()) {
      resetTaskSetFromSource();
    }
    return taskSet;
  }*/

  private void resetTaskSetFromSource() {
    taskSet.clear();
    Set<TaskTransmissionRepresentation> transmissionsSet = tokenizeJSONInputStreamToPOJOSet();
    for (TaskTransmissionRepresentation transmissionTask : transmissionsSet) {
      Task task = convertTransmissionToTask(transmissionTask);
      taskSet.add(task);
    }
  }

  private Task convertTransmissionToTask(TaskTransmissionRepresentation transmission) {
    Task task = new Task();
    task.setName(transmission.getName());
    return task;
  }

  public Set<TaskTransmissionRepresentation> tokenizeJSONInputStreamToPOJOSet() {
    String jsonString = readJsonString();
    Gson gson = new Gson();
    TodoistDownloadDAO dlPOJO = gson.fromJson(jsonString, TodoistDownloadDAO.class);
    Set<TaskTransmissionRepresentation> pojoSet = new HashSet<TaskTransmissionRepresentation>(Arrays.asList(dlPOJO.getTasks()));
    return pojoSet;
  }

  private String readJsonString() {
    String jsonString = "";
    try {
      jsonString = IOUtils.toString(inputSource.getInputStream(), streamEncoding);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return jsonString;
  }

  @Override
  public Iterator<Task> iterator() {
    return taskSet.iterator();
  }

  @Override
  public void forEach(Consumer<? super Task> action) {
    taskSet.forEach(action);
  }

  @Override
  public Spliterator<Task> spliterator() {
    return taskSet.spliterator();
  }

  @Override
  public int size() {
    return taskSet.size();
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
}

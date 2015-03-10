package org.dave.example.server;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.dave.example.shared.Task;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by David on 15/02/2015.
 */
public class TodoistJSONTaskList implements TaskList {
  private final TaskSource inputSource;
  private String streamEncoding = "UTF-8";

  private Set<Task> taskSet = new HashSet<Task>();

  public TodoistJSONTaskList(TaskSource inputSource) {
    this.inputSource = inputSource;
  }

//    @Override
//    public Task getTask(String name) {
//        return null;
//    }

  @Override
  public Set<Task> getAllTasks() throws IOException {
    if (taskSet.isEmpty()) {
      resetTaskSetFromSource();
    }
    return taskSet;
  }

  public void resetTaskSetFromSource() throws IOException {
    taskSet.clear();
    InputStream stream = inputSource.getInputStream();
    Set<TaskTransmissionRepresentation> transmissionsSet = tokenizeJSONInputStreamToPOJOSet(stream);
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

  public Set<TaskTransmissionRepresentation> tokenizeJSONInputStreamToPOJOSet(InputStream stream) throws IOException {
    String jsonString = IOUtils.toString(stream, streamEncoding);
    Gson gson = new Gson();
    TodoistDownloadPOJO dlPOJO = gson.fromJson(jsonString, TodoistDownloadPOJO.class);
    Set<TaskTransmissionRepresentation> pojoSet = new HashSet<TaskTransmissionRepresentation>(Arrays.asList(dlPOJO.getTasks()));
    return pojoSet;
  }

}

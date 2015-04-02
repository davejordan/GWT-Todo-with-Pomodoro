package org.dave.example.TaskSource;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.dave.example.shared.Task;
import org.dave.example.shared.TaskList;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by David on 12/03/2015.
 */
public class TaskListLoader {

  private final TaskSource inputSource;
  //  private final TaskList taskList;
  private String streamEncoding = "UTF-8";


  public TaskListLoader(TaskSource inputSource) {
    this.inputSource = inputSource;
  }

  public TaskList loadTaskList(TaskList taskList) {
    return resetTaskSetFromSource(taskList);
  }

  private TaskList resetTaskSetFromSource(TaskList taskList) {
    taskList.clear();
    Set<TaskTransmissionRepresentation> transmissionsSet = tokenizeJSONInputStreamToPOJOSet();
    for (TaskTransmissionRepresentation transmissionTask : transmissionsSet) {
      Task task = convertTransmissionToTask(transmissionTask);
      taskList.add(task);
    }
    return taskList;
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

}

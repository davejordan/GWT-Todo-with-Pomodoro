package org.dave.example.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.dave.example.client.TaskListService;
import org.dave.example.shared.Task;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Set;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class TaskListServiceImpl extends RemoteServiceServlet implements TaskListService {



  private Set<Task> taskSet;
  private TaskList todoistTaskList;


   @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
     TaskSource simpleSampleTodoistSource = new SampleFileTaskSource("JSONSample_TodoistFormattedTasks.txt");
     this.todoistTaskList = new TodoistJSONTaskList(simpleSampleTodoistSource);
     try {
       taskSet = todoistTaskList.getAllTasks();
     } catch (IOException e) {
       e.printStackTrace();
     }
   }

  public Set<Task> getTaskList() throws IllegalArgumentException {
    return taskSet;
  }
}

package org.dave.example.TaskSource;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.dave.example.client.TaskListService;
import org.dave.example.shared.SimpleTaskList;
import org.dave.example.shared.Task;
import org.dave.example.shared.TaskList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.util.HashSet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class TaskListServiceImpl extends RemoteServiceServlet implements TaskListService {


  //  private Set<Task> taskSet;
//  private TaskList todoistTaskList;
//  TaskSource taskSource;
  TaskListLoader taskListLoader;


   @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
     TaskSource taskSource = new SampleFileTaskSource("JSONSample_TodoistFormattedTasks.txt");
     taskListLoader = new TaskListLoader(taskSource);
     //this.todoistTaskList = new TodoistJSONTaskList(simpleSampleTodoistSource);
   }

  public HashSet<Task> getTaskList() throws IllegalArgumentException {
    TaskList taskList = taskListLoader.loadTaskList(new SimpleTaskList());
    HashSet<Task> set = new HashSet<>(taskList.getCollection());
    return set;
  }

}

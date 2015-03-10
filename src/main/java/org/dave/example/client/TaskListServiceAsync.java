package org.dave.example.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import org.dave.example.shared.Task;

import java.util.Set;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface TaskListServiceAsync {
  void getTaskList(AsyncCallback<Set<Task>> callback) throws IllegalArgumentException;
}

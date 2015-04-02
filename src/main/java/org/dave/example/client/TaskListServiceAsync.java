package org.dave.example.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import org.dave.example.shared.Task;

import java.util.HashSet;

public interface TaskListServiceAsync {
  void getTaskList(AsyncCallback<HashSet<Task>> callback) throws IllegalArgumentException;
}

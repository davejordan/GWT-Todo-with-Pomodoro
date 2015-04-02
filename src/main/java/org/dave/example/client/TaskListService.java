package org.dave.example.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import org.dave.example.shared.Task;

import java.util.HashSet;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("taskService")
public interface TaskListService extends RemoteService {
  HashSet<Task> getTaskList() throws IllegalArgumentException;
}

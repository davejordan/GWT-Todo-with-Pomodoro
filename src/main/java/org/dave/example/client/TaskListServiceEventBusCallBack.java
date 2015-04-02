package org.dave.example.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import org.dave.example.events.TaskListUpdateFailedEvent;
import org.dave.example.events.TaskListUpdatedEvent;
import org.dave.example.shared.SimpleTaskList;
import org.dave.example.shared.Task;
import org.dave.example.shared.TaskList;

import java.util.HashSet;

/**
* Created by David on 22/03/2015.
*/
public class TaskListServiceEventBusCallBack implements AsyncCallback<HashSet<Task>> {

  private EventBus eventBus;

  public TaskListServiceEventBusCallBack(EventBus eventBus){
    this.eventBus = eventBus;
  }

  @Override
  public void onFailure(Throwable caught) {
    this.eventBus.fireEvent(new TaskListUpdateFailedEvent());
  }

  @Override
  public void onSuccess(HashSet<Task> result) {
    TaskList list = new SimpleTaskList(result);
    this.eventBus.fireEvent(new TaskListUpdatedEvent(list));
  }
}

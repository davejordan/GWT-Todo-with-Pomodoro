package org.dave.example.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import org.dave.example.shared.Task;

import java.util.Set;

/**
 * Created by David on 28/02/2015.
 */
public class TaskListUpdatedEvent extends GwtEvent<TaskListUpdatedEvent.TaskListUpdatedEventHandler> {

  public interface TaskListUpdatedEventHandler extends EventHandler {
    public void updateTaskList(TaskListUpdatedEvent event);
  }

  public static Type<TaskListUpdatedEventHandler> TYPE = new Type<>();

  private Set<Task> updatedTaskSet;

  public TaskListUpdatedEvent(Set<Task> updatedTaskSet) {
    this.updatedTaskSet = updatedTaskSet;
  }

  public Set<Task> getUpdatedTaskSet() {
    return updatedTaskSet;
  }

  @Override
  public Type<TaskListUpdatedEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(TaskListUpdatedEventHandler handler) {
    handler.updateTaskList(this);
  }
}

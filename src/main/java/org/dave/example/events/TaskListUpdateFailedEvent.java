package org.dave.example.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class TaskListUpdateFailedEvent extends GwtEvent<TaskListUpdateFailedEvent.TaskListUpdateFailedEventHandler> {

  public static Type<TaskListUpdateFailedEventHandler> TYPE = new Type<>();

  public interface TaskListUpdateFailedEventHandler extends EventHandler {
    //Example method call passing this event
    public void failUpdate(TaskListUpdateFailedEvent event);
  }

  @Override
  public Type<TaskListUpdateFailedEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(TaskListUpdateFailedEventHandler handler) {
    //handler calls the method being implemented in the eventhander
    handler.failUpdate(this);
  }
}
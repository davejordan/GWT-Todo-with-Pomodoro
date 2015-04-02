package org.dave.example.client;

import org.dave.example.events.TaskListUpdateFailedEvent;
import org.dave.example.events.TaskListUpdatedEvent;

/**
 * Created by David on 23/03/2015.
 */
public class TaskSelectPresenterEventHandler implements TaskListUpdateFailedEvent.TaskListUpdateFailedEventHandler, TaskListUpdatedEvent.TaskListUpdatedEventHandler {

  private TaskSelectPresenter presenter;

  public TaskSelectPresenterEventHandler(TaskSelectPresenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void failUpdate(TaskListUpdateFailedEvent event) {
    presenter.failUpdate();
  }

  @Override
  public void updateTaskList(TaskListUpdatedEvent event) {
    presenter.updateTaskList(event.getUpdatedTaskSet());
  }
}

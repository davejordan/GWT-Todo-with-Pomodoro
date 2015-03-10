package org.dave.example.client;


import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import org.dave.example.events.TaskListUpdatedEvent;
import org.dave.example.shared.Task;

import java.util.Set;

/**
 * Created by David on 27/02/2015.
 */
public class TaskSelectPresenter implements Presenter {

  private final TaskListServiceAsync taskListService;
  private final Display view;
  private final EventBus eventBus;


  public interface Display {
    public void clear();

    public void showError(String name);

    public void setList(Set<Task> taskList);

    public Widget asWidget();

    public void setPresenter(TaskSelectPresenter presenter);
  }

  public TaskSelectPresenter(EventBus eventBus, TaskListServiceAsync taskListServiceAsync, Display view) {
    this.taskListService = taskListServiceAsync;
    this.view = view;
    this.eventBus = eventBus;
    bind();
  }

  @Override
  public void bind() {
    eventBus.addHandler(TaskListUpdatedEvent.TYPE,
        new TaskListUpdatedEvent.TaskListUpdatedEventHandler() {
          @Override
          public void updateTaskList(TaskListUpdatedEvent event) {
            view.setList(event.getUpdatedTaskSet());
          }
        });

    eventBus.addHandler(TaskListUpdateFailedEvent.TYPE,
        new TaskListUpdateFailedEvent.TaskListUpdateFailedEventHandler() {
          @Override
          public void failUpdate(TaskListUpdateFailedEvent event) {
            view.showError("Failed to update list");
          }
        }
    );
  }

  @Override
  public void go(Panel panel) {
    panel.add(view.asWidget());
  }

  public void refreshFullTaskList() {
    taskListService.getTaskList(new AsyncCallback<Set<Task>>() {
      @Override
      public void onFailure(Throwable caught) {
        eventBus.fireEvent(new TaskListUpdateFailedEvent());
      }

      @Override
      public void onSuccess(Set<Task> result) {
        eventBus.fireEvent(new TaskListUpdatedEvent(result));
      }
    });

 }

}

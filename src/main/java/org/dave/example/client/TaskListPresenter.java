package org.dave.example.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import org.dave.example.shared.Task;

import java.util.Set;

/**
 * Created by David on 01/03/2015.
 */
public class TaskListPresenter implements Presenter {

  private final TaskListServiceAsync taskListService;
  private final Display view;
  private final EventBus eventBus;

  interface Display {
    public void addTaskSet(Set<Task> taskSet);

    public void setPresenter(TaskListPresenter presenter);

    public Widget asWidget();

    public void clear();

  }

  public TaskListPresenter(EventBus eventBus, TaskListServiceAsync taskListServiceAsync, Display view) {
    this.taskListService = taskListServiceAsync;
    this.view = view;
    this.eventBus = eventBus;
    bind();
  }


  @Override
  public void bind() {
//    eventBus.addHandler(TaskListUpdatedEvent.TYPE,
//        new TaskListUpdatedEvent.TaskListUpdatedEventHandler() {
//          @Override
//          public void updateTaskList(TaskListUpdatedEvent event) {
//          }
//
//          @Override
//          public GwtEvent.Type<TaskListUpdatedEvent.TaskListUpdatedEventHandler> TYPE() {
//            return null;
//          }
//        });
  }

  @Override
  public void go(Panel panel) {

  }


}

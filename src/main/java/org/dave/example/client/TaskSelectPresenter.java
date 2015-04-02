package org.dave.example.client;


import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import org.dave.example.shared.TaskList;

public class TaskSelectPresenter implements Presenter {

  private final TaskListServiceAsync taskListService;
  private final Display view;
  private final EventBus eventBus;


  public interface Display {
    public void clear();

    public void showError(String name);

    public void setList(TaskList taskList);

    public Widget asWidget();

    public void setPresenter(TaskSelectPresenter presenter);
  }

  public TaskSelectPresenter(EventBus eventBus, TaskListServiceAsync taskListServiceAsync, Display view) {
    this.taskListService = taskListServiceAsync;
    this.view = view;
    this.eventBus = eventBus;
  }

  @Override
  public void bind() {
    view.setPresenter(this);
  }

  public void failUpdate() {
    view.showError("Failed to update list");
  }

  public void updateTaskList(TaskList taskList) {
    view.setList(taskList);
  }

  @Override
  public void go(Panel panel) {
    panel.add(view.asWidget());
  }

  //TODO: Pull out call-back from Presenter? Should it know about this behaviour?
  public void refreshFullTaskList() {
    AsyncCallback callBack = new TaskListServiceEventBusCallBack(this.eventBus);
    taskListService.getTaskList(callBack);
 }
}

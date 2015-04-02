package org.dave.example.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Panel;
import org.dave.example.events.TaskListUpdateFailedEvent;
import org.dave.example.events.TaskListUpdatedEvent;

public class AppController implements ValueChangeHandler {

  private EventBus eventBus;
  private TaskListServiceAsync taskListService;
  private CallbackFactory factory;
  private TaskSelectView taskSelectView;
  private TaskSelectPresenter taskSelectPresenter;

  public AppController(TaskListServiceAsync taskListService, EventBus eventBus, CallbackFactory factory) {
    this.eventBus = eventBus;
    this.taskListService = taskListService;
    this.factory = factory;
  }

  public void build() {
    buildPresenters();
    TaskSelectPresenterEventHandler eventHandler = buildTaskSelectPresenterEventHandler();
    bindTaskListSelectPresenter(eventHandler);
  }

  private TaskSelectPresenterEventHandler buildTaskSelectPresenterEventHandler() {
    return new TaskSelectPresenterEventHandler(taskSelectPresenter);
  }

  private void buildPresenters() {
    taskSelectView = new TaskSelectView();
    taskSelectPresenter = new TaskSelectPresenter(eventBus, taskListService, taskSelectView);
  }

  public void bindTaskListSelectPresenter(TaskSelectPresenterEventHandler eventHandler) {
    eventBus.addHandler(TaskListUpdateFailedEvent.TYPE, eventHandler);
    eventBus.addHandler(TaskListUpdatedEvent.TYPE, eventHandler);
  }


  @Override
  public void onValueChange(ValueChangeEvent event) {
//    Fill this in for history management
  }

  public void go(Panel panel){
    panel.add(taskSelectView.asWidget());
  }

}

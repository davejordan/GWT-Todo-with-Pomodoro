package org.dave.example.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Panel;

public class AppController implements ValueChangeHandler {

  private EventBus eventBus;
  private TaskListServiceAsync taskListService;

  public AppController(TaskListServiceAsync taskListService, EventBus eventBus) {
    this.eventBus = eventBus;
    this.taskListService = taskListService;
    bind();
  }

  private void bind() {
  }

  @Override
  public void onValueChange(ValueChangeEvent event) {
//    Fill this in for history management
  }

  public void go(Panel panel){
    TaskSelectView taskSelectView = new TaskSelectView();
    TaskSelectPresenter taskSelectPresenter = new TaskSelectPresenter(eventBus,taskListService, taskSelectView);
    taskSelectView.setPresenter(taskSelectPresenter);

    panel.add(taskSelectView.asWidget());
  }

}

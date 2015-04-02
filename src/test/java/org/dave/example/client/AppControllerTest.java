package org.dave.example.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.testing.CountingEventBus;
import org.dave.example.events.TaskListUpdateFailedEvent;
import org.dave.example.events.TaskListUpdatedEvent;
import org.dave.example.shared.TaskList;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AppControllerTest {

  private EventBus eventBus;
  private TaskListServiceAsync asyncService;
  private AppController controller;
  private TaskSelectPresenter.Display view;
  private TaskSelectPresenter presenter;
  private TaskSelectPresenterEventHandler handler;
  private CallbackFactory factory;

  @Before
  public void setUp() throws Exception {
    eventBus = new CountingEventBus();
    asyncService = null;
    factory = null;

    controller = new AppController(asyncService, eventBus, factory);
    view = mock(TaskSelectPresenter.Display.class);
    presenter = new TaskSelectPresenter(eventBus, asyncService, view);
    presenter.bind();
    handler = new TaskSelectPresenterEventHandler(presenter);
    controller.bindTaskListSelectPresenter(handler);
  }

  @Test
  public void testBind() throws Exception {

  }

  @Test
  public void testBindTaskListSelectPresenter_fireFail() throws Exception {
    eventBus.fireEvent(new TaskListUpdateFailedEvent());
    verify(view).showError("Failed to update list");
  }

  @Test
  public void testBindTaskListSelectPresenter_fireUpdate() throws Exception {
    TaskList taskList = mock(TaskList.class);
    eventBus.fireEvent(new TaskListUpdatedEvent(taskList));
    verify(view).setList(taskList);
  }

  @Test
  public void testOnValueChange() throws Exception {

  }

  @Test
  public void testGo() throws Exception {

  }
}
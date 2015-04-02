package org.dave.example.client;

import com.google.gwt.event.shared.testing.CountingEventBus;
import org.dave.example.shared.TaskList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.dave.example.client.TaskSelectPresenter.Display;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TaskSelectPresenterTest {

  private TaskSelectPresenter presenter;
  private Display view;
  private TaskListServiceAsync taskListServiceAsync;
  private CountingEventBus countingBus;


  @Before
  public void setUp() throws Exception {
    view = mock(Display.class);
    taskListServiceAsync = mock(TaskListServiceAsync.class);
    countingBus = new CountingEventBus();
    presenter = new TaskSelectPresenter(countingBus, taskListServiceAsync, view);
  }

  @After
  public void tearDown() throws Exception {

  }

//  @Test
//  public void testBind_withFailEvent() throws Exception {
//    presenter.bind();
//    countingBus.fireEvent(new TaskListUpdateFailedEvent());
//    verify(view).showError("Failed to update list");
//  }
//
//
//  @Test
//  public void testBind_withUpdateEvent() throws Exception {
//    presenter.bind();
//    TaskList taskList = mock(TaskList.class);
//    countingBus.fireEvent(new TaskListUpdatedEvent(taskList));
//    verify(view).setList(taskList);
//  }
//
//  @Test
//  public void testBind_withUpdateEventThenFailEvent() throws Exception {
//    presenter.bind();
//    TaskList taskList = mock(TaskList.class);
//    countingBus.fireEvent(new TaskListUpdatedEvent(taskList));
//    countingBus.fireEvent(new TaskListUpdateFailedEvent());
//    verify(view).setList(taskList);
//    verify(view).showError("Failed to update list");
//  }

  @Test
  public void testFailUpdate() throws Exception {
    presenter.failUpdate();
    verify(view).showError("Failed to update list");
  }

  @Test
  public void testUpdateTaskList() throws Exception {
    TaskList taskList = mock(TaskList.class);
    presenter.updateTaskList(taskList);
    verify(view).setList(taskList);
  }

  @Test
  public void testGo() throws Exception {

  }

  @Test
  public void testRefreshFullTaskList() throws Exception {
    presenter.refreshFullTaskList();
    verify(taskListServiceAsync).getTaskList(any(TaskListServiceEventBusCallBack.class));
  }

}
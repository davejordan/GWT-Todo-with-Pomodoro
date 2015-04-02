package org.dave.example.client;

import com.google.gwt.event.shared.testing.CountingEventBus;
import org.dave.example.events.TaskListUpdateFailedEvent;
import org.dave.example.events.TaskListUpdatedEvent;
import org.dave.example.shared.Task;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class TaskListServiceEventBusCallBackTest {

  private TaskListServiceEventBusCallBack callBack;
  private CountingEventBus countingBus;

  @Before
  public void setUp() throws Exception {
    countingBus = new CountingEventBus();
    callBack = new TaskListServiceEventBusCallBack(countingBus);
  }

  @Test
  public void testOnFailure() throws Exception {
    callBack.onFailure(null);
    assertEquals(1, countingBus.getFiredCount(TaskListUpdateFailedEvent.TYPE));
  }

  @Test
  public void testOnSuccess() throws Exception {
    HashSet<Task> taskSet = new HashSet<>();
    taskSet.add(new Task());
    callBack.onSuccess(taskSet);
    assertEquals(1, countingBus.getFiredCount(TaskListUpdatedEvent.TYPE));
  }
}
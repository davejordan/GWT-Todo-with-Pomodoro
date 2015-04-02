package org.dave.example.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by David on 25/03/2015.
 */
public class CallbackFactory {

  private final EventBus eventBus;

  public CallbackFactory(EventBus eventBus) {
    this.eventBus = eventBus;
  }

  public AsyncCallback getNewTaskListServiceEventBusCallBack() {
    return new TaskListServiceEventBusCallBack(eventBus);
  }

}

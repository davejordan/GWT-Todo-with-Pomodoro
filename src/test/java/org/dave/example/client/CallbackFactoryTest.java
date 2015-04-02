package org.dave.example.client;

import com.google.gwt.event.shared.testing.CountingEventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CallbackFactoryTest {

  private CountingEventBus eventBus;
  private CallbackFactory factory;

  @Before
  public void setUp() throws Exception {
    eventBus = new CountingEventBus();
    factory = new CallbackFactory(eventBus);
  }

  @Test
  public void testGetNewCallback() throws Exception {
    AsyncCallback callback = factory.getNewTaskListServiceEventBusCallBack();
    assertNotNull(callback);
  }
}
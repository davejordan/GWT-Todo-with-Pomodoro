package org.dave.example.server;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by David on 17/02/2015.
 */
public class TodoistAPITaskSource implements TaskSource {

  protected String accessToken;
  private AuthenticationModule authenticationModule;

  public TodoistAPITaskSource(AuthenticationModule authenticationModule) throws JSONException {
    this.authenticationModule = authenticationModule;
    try {
      this.accessToken = authenticationModule.getAuthenticationToken();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public TaskList getTaskList() {
    return null;
  }

  @Override
  public InputStream getInputStream() {
    TodoistRESTCommand command = new TodoistGetAllUncompleteItems(accessToken);
    URL url = command.getCommandURL();
    InputStream stream = null;
    try {
      stream = url.openStream();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return stream;
  }

  @Override
  public void authenticate() {
    try {
      accessToken = authenticationModule.getAuthenticationToken();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }


}

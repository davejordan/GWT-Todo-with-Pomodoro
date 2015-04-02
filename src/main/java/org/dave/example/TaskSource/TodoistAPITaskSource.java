package org.dave.example.TaskSource;

import org.dave.example.TaskSource.Authentication.OAuthAuthenticationNegotiator;
import org.dave.example.shared.TaskList;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by David on 17/02/2015.
 */
public class TodoistAPITaskSource implements TaskSource {

  protected String accessToken;
  private OAuthAuthenticationNegotiator OAuthAuthenticationNegotiator;

  public TodoistAPITaskSource(OAuthAuthenticationNegotiator OAuthAuthenticationNegotiator) throws JSONException {
    this.OAuthAuthenticationNegotiator = OAuthAuthenticationNegotiator;
    try {
      this.accessToken = OAuthAuthenticationNegotiator.getAuthenticationToken();
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
      accessToken = OAuthAuthenticationNegotiator.getAuthenticationToken();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }


}

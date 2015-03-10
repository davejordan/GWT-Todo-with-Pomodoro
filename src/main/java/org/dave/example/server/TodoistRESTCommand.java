package org.dave.example.server;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by David on 17/02/2015.
 */
public abstract class TodoistRESTCommand {
  protected final String TODOIST_API_URL = "https://todoist.com/API/";
  protected String command;
  protected String token;

  protected Map<String, String> parameters = new HashMap<String, String>();

  public URL getCommandURL() {
    StringBuilder sb = new StringBuilder(TODOIST_API_URL + command + "?token=" + token);
    for (String key : parameters.keySet()) {
      sb.append("&" + key + "=" + parameters.get(key));
    }
    URL url = null;
    try {
      url = new URL(sb.toString());
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return url;
  }

}

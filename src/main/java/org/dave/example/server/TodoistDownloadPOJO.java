package org.dave.example.server;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by David on 17/02/2015.
 */
public class TodoistDownloadPOJO {
  public TodoistTaskPOJO[] getTasks() {
    return tasks;
  }

  @SerializedName("items")
  @Expose
  private TodoistTaskPOJO[] tasks;
}

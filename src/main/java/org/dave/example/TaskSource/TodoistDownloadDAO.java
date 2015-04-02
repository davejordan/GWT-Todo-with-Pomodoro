package org.dave.example.TaskSource;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by David on 17/02/2015.
 */
public class TodoistDownloadDAO {
  public TodoistTaskDAO[] getTasks() {
    return tasks;
  }

  @SerializedName("items")
  @Expose
  private TodoistTaskDAO[] tasks;
}

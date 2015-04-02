package org.dave.example.TaskSource;

/**
 * Created by David on 17/02/2015.
 */
public class TodoistGetAllUncompleteItems extends TodoistRESTCommand {


  public TodoistGetAllUncompleteItems(String token) {
    this.token = token;
    command = "getAllCompletedItems";
  }


}

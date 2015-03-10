package org.dave.example.server;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test_TodoistRESTCommand {

    @Test
    public void test_getCommandURL_simplestURL() throws Exception {
        TodoistRESTCommand command = new TodoistGetAllUncompleteItems("blah");
        assertEquals("https://todoist.com/API/getAllCompletedItems?token=blah", command.getCommandURL().toString());
    }


}
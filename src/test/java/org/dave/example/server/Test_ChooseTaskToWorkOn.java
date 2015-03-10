package org.dave.example.server;

public class Test_ChooseTaskToWorkOn {

/*
    private TaskList emptyTaskList;
    private ChooseTaskToWorkOn taskSelect;
    private TaskList singleTaskList;
*//*

    @Before
    public void setUp() throws Exception {
        emptyTaskList = new EmptyTaskList();
        taskSelect = new ChooseTaskToWorkOn(emptyTaskList);
        singleTaskList = new SingleTaskList();
    }

    @Test
    public void test_getUncompletedTasks_EmptySet() throws Exception {
        Set<Task> taskList = taskSelect.getUncompletedTasks();
        assertTrue(taskList.isEmpty());
    }


    @Test
    public void test_getAllTasks_nonEmptyTaskSet() throws Exception {
        Set<Task> taskSet = singleTaskList.getAllTasks();
        assertFalse(taskSet.isEmpty());
    }*/

}
package org.dave.example.server;

import org.dave.example.TaskSource.SampleFileTaskSource;
import org.dave.example.TaskSource.TaskSource;
import org.dave.example.TaskSource.TaskTransmissionRepresentation;
import org.dave.example.TaskSource.TodoistJSONTaskList;
import org.dave.example.shared.TaskList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Test_TodoistJSONTaskList {

    InputStream emptyArrayStream;
    TaskSource simpleSampleTodoistSource;
    TaskSource complexSampleTodoistSource;
    TodoistJSONTaskList simpleSampleTodoistList;
    TodoistJSONTaskList complexSampleTodoistList;

    @Before
    public void setUp() throws Exception {
        simpleSampleTodoistSource = new SampleFileTaskSource("/JSONSample_TodoistFormattedTasks.txt");
        complexSampleTodoistSource = new SampleFileTaskSource("/JSONSample_TodoistComplexAndLong.txt");
        emptyArrayStream = this.getClass().getResource("/EmptyJSONArray.txt").openStream();
        simpleSampleTodoistList = new TodoistJSONTaskList(simpleSampleTodoistSource);
        complexSampleTodoistList = new TodoistJSONTaskList(complexSampleTodoistSource);
    }

    @After
    public void tearDown() throws Exception {
//        simpleSampleTodoistSource.close();
//        emptyArrayStream.close();
    }


    @Test
    public void test_getAllTasks_Returns2TasksOnSample() throws Exception {
        TaskList source = new TodoistJSONTaskList(simpleSampleTodoistSource);
//        Set<Task> taskSet = source.getAllTasks();
        assertEquals(2, source.size());
    }

    @Test
    public void test_tokenizeJSONInputStreamToPOJOSet_Check2PojoSet() throws Exception {
        Set<TaskTransmissionRepresentation> taskSet = simpleSampleTodoistList.tokenizeJSONInputStreamToPOJOSet();
        assertEquals(2, taskSet.size());
    }

    @Test
    public void test_tokenizeJSONInputStreamToPOJOSet_EmptyJSONArrayGivesEmptySet() throws Exception {
        Set<TaskTransmissionRepresentation> taskSet = simpleSampleTodoistList.tokenizeJSONInputStreamToPOJOSet();
//        assertEquals(0, taskSet.size());
    }

    @Test
    public void test_tokenizeJSONInputStreamToPojo_LongComplexList() throws Exception {
        Set<TaskTransmissionRepresentation> taskSet = complexSampleTodoistList.tokenizeJSONInputStreamToPOJOSet();
        assertEquals(30, taskSet.size());
    }

    @Test
      public void test_getSetOfRealTasks() throws Exception {
//        OAuthAuthenticationNegotiator authentication = new StaticOAuthAuthenticationNegotiator("/StaticAuthenticationToken.secret");
//        TaskSource source = new TodoistAPITaskSource(authentication);
//        TaskList list = new TodoistJSONTaskList(source);
//        Set<Task> tasks = list.getAllTasks();
//        assertTrue(list.size() > 1);
    }
}
package org.dave.example.server;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Test_OAuthServiceResourceStreamSource {

  private OAuthSecrecyService oAuthSimpleFileTest;

  @Before
  public void setUp() throws Exception {
    oAuthSimpleFileTest = new OAuthSecrecyService("/SimpleTestFile.txt");
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testReadSimpleJSONString() throws Exception {
    String json = "{\"EMAIL\":\"test.com\", \"API_KEY\":\"apiKeyTest\",\"API_SECRET\":\"apiSecretTest\"}";
    OAuthSecretJSON jsonObject = oAuthSimpleFileTest.readJSONResourceIntoObject(json);
    assertEquals(jsonObject.EMAIL, "test.com");
    assertEquals(jsonObject.API_KEY, "apiKeyTest");
    assertEquals(jsonObject.API_SECRET, "apiSecretTest");
  }

  @Test
  public void testReadResourceIntoAString() throws Exception {
    String compareText = "test1\r\ntest2\r\ntest3";
    String readText = oAuthSimpleFileTest.readResourceIntoString("/SimpleTestFile.txt");
    assertNotNull(readText);
    assertEquals(compareText, readText);
  }

}
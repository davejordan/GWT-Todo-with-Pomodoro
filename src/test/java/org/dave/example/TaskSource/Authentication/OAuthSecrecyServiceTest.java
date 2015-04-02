package org.dave.example.TaskSource.Authentication;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

public class OAuthSecrecyServiceTest extends TestCase {

  private OAuthSecrecyService oAuthSimpleFileTest;

  @Before
  public void setUp() throws Exception {
    oAuthSimpleFileTest = new OAuthSecrecyService("/TestAuthenticationFile.secret");
  }

  @After
  public void tearDown() throws Exception {

  }

  public void testApi_Key() throws Exception {
    assertEquals("12345a", oAuthSimpleFileTest.apiKey());
  }

  public void testApi_secret() throws Exception {
    assertEquals("abcd", oAuthSimpleFileTest.apiSecret());
  }

  public void testEmail() throws Exception {
    assertEquals("bob@test.com", oAuthSimpleFileTest.email());
  }
}
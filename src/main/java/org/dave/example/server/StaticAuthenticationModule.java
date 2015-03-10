package org.dave.example.server;

import org.apache.commons.io.IOUtils;

import java.io.IOException;

/**
 * Created by David on 17/02/2015.
 */
public class StaticAuthenticationModule extends AuthenticationModule {

  private String resourceName;

  public StaticAuthenticationModule(String resourceName) {
    this.resourceName = resourceName;
  }


  @Override
  public String getAuthenticationToken() throws IOException {
    String token = IOUtils.toString(this.getClass().getResource(this.resourceName), "UTF-8");
    return token;
  }


}

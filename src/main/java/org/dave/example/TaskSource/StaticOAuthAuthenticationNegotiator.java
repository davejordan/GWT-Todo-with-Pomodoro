package org.dave.example.TaskSource;

import org.apache.commons.io.IOUtils;
import org.dave.example.TaskSource.Authentication.OAuthAuthenticationNegotiator;

import java.io.IOException;

/**
 * Created by David on 17/02/2015.
 */
public class StaticOAuthAuthenticationNegotiator extends OAuthAuthenticationNegotiator {

  private String resourceName;

  public StaticOAuthAuthenticationNegotiator(String resourceName) {
    this.resourceName = resourceName;
  }


  @Override
  public String getAuthenticationToken() throws IOException {
    String token = IOUtils.toString(this.getClass().getResource(this.resourceName), "UTF-8");
    return token;
  }


}

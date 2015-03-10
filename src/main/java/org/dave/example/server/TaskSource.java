package org.dave.example.server;

import java.io.InputStream;

/**
 * Created by David on 17/02/2015.
 */
public interface TaskSource {


  public InputStream getInputStream();

  public void authenticate();
}

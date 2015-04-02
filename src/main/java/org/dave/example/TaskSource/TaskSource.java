package org.dave.example.TaskSource;

import java.io.InputStream;

/**
 * Created by David on 17/02/2015.
 */
public interface TaskSource {


  public InputStream getInputStream();

  public void authenticate();
}

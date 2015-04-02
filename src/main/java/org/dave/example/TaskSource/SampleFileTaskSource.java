package org.dave.example.TaskSource;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by David on 17/02/2015.
 */
public class SampleFileTaskSource implements TaskSource {

  private String fileName;

  public SampleFileTaskSource(String fileName) {
    this.fileName = fileName;
  }


  @Override
  public InputStream getInputStream() {
    InputStream stream = null;
    try {
      stream = this.getClass().getResource(fileName).openStream();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return stream;
  }

  @Override
  public void authenticate() {

  }
}

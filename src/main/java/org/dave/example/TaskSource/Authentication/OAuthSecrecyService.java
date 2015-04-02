package org.dave.example.TaskSource.Authentication;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

/**
 * Created by David on 09/03/2015.
 */
public class OAuthSecrecyService {

  private String resourceName;
  private OAuthSecretDAO secretInformation;

  public OAuthSecrecyService(String resourceName) {
    this.resourceName = resourceName;
  }

  public String apiKey() {
    return readSecretJSONObject().API_KEY;
  }

  public String apiSecret() {
    return readSecretJSONObject().API_SECRET;
  }

  public String email() {
    return readSecretJSONObject().EMAIL;
  }

  private OAuthSecretDAO readSecretJSONObject() {
    initaliseSecretJSONObject();
    return secretInformation;
  }

  private void initaliseSecretJSONObject() {
    if (this.secretInformation==null) {
      String jsonString = readResourceIntoString(resourceName);
      secretInformation = readJSONResourceIntoObject(jsonString);
    }
  }

  private String readResourceIntoString(String resourceName) {
    String json = null;
    try {
      json = IOUtils.toString(this.getClass().getResource(resourceName), "UTF-8");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return json;
  }

  private OAuthSecretDAO readJSONResourceIntoObject(String json) {
    Gson gson = new Gson();
    OAuthSecretDAO oAuthSecretDAO = gson.fromJson(json, OAuthSecretDAO.class);
    return oAuthSecretDAO;
  }


}

package org.dave.example.server;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

/**
 * Created by David on 09/03/2015.
 */
public class OAuthSecrecyService {

  private String resourceName;
  private OAuthSecretJSON secretInformation;

  public OAuthSecrecyService(String resourceName) {
    this.resourceName = resourceName;
  }

  public String readResourceIntoString(String resourceName) {
    String json = null;
    try {
      json = IOUtils.toString(this.getClass().getResource(resourceName), "UTF-8");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return json;
  }

  public OAuthSecretJSON readJSONResourceIntoObject(String json) {
    Gson gson = new Gson();
    OAuthSecretJSON oAuthSecretJSON = gson.fromJson(json, OAuthSecretJSON.class);
    return oAuthSecretJSON;
  }

  public OAuthSecretJSON readSecretJSONObject(){
    initaliseSecretJSONObject();
    return secretInformation;
  }

  public void initaliseSecretJSONObject(){
    if (this.secretInformation==null) {
      String jsonString = readResourceIntoString(resourceName);
      secretInformation = readJSONResourceIntoObject(jsonString);
    }
  }

  public String api_Key(){
    return readSecretJSONObject().API_KEY;
  }

  public String api_secret(){
    return readSecretJSONObject().API_SECRET;
  }

  public String email(){
    return readSecretJSONObject().EMAIL;
  }

}

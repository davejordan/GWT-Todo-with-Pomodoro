package org.dave.example.server;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.Google2Api;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by David on 15/02/2015.
 */
public class AuthenticationModule {

  private String secretResourceName;

  private String todoistSite;
  private String todoistLoginGoogle;
  private String todoistGetProjects;

  public String EMAIL;
  public String API_KEY;
  public String API_SECRET;
  public String OPENID_EMAIL = "openid email";

  public AuthenticationModule() {
  }

  public AuthenticationModule(String secretResourceName) {
    this.secretResourceName = secretResourceName;
    initialiseConnectionStrings();
  }

  public void getSecretInformation(String secrecyFile){
    OAuthSecrecyService oAuthSecrecyService = new OAuthSecrecyService(secrecyFile);
    API_KEY = oAuthSecrecyService.api_Key();
    API_SECRET = oAuthSecrecyService.api_secret();
    EMAIL = oAuthSecrecyService.email();
  }

  public void initialiseConnectionStrings() {
    getSecretInformation(secretResourceName);
    todoistSite = "https://todoist.com/API/";
    todoistLoginGoogle = todoistSite + "loginWithGoogle?" + EMAIL+"&oauth2_token=";
    todoistGetProjects = todoistSite + "getProjects?" + "token=";
  }

  public String getAuthenticationToken() throws IOException, JSONException {
    OAuthService service = buildOAuthService();
//    getUserApprovalAndShowOAuthVerifierCode(service);
    String usersVerifierCode = readUserVerifierCode();
    Token accessToken = exchangeUserVerifierCodeForAccessToken(service, usersVerifierCode);
    return getTodoistToken(accessToken);
  }

  private String getTodoistToken(Token accessToken) throws IOException, JSONException {
    String todoistLoginConnectionString = todoistLoginGoogle + accessToken.getToken();
    String out = connectToURLAndReadResponse(todoistLoginConnectionString);
    return extractTodoistTokenFromResponse(out);
  }

  private String extractTodoistTokenFromResponse(String todoistReturnJSON) throws JSONException {
    JSONObject jObject = new JSONObject(todoistReturnJSON);
    return jObject.get("api_token").toString();
  }

  private String connectToURLAndReadResponse(String todoistLoginConnectionString) throws IOException {
    URL url = new URL(todoistLoginConnectionString);
    return IOUtils.toString(url.openStream());
  }

  private Token exchangeUserVerifierCodeForAccessToken(OAuthService service, String usersApprovalCode) {
    Verifier v = new Verifier(usersApprovalCode);
    return service.getAccessToken(null, v);
  }

  private OAuthService buildOAuthService() {
    return new ServiceBuilder()
        .provider(Google2Api.class)
        .apiKey(API_KEY)
        .apiSecret(API_SECRET)
        .scope(OPENID_EMAIL)
        .build();
  }

  private String readUserVerifierCode() {
    String line;
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    try {
      line = buffer.readLine();
    } catch (IOException e) {
      line = null;
      e.printStackTrace();
    }
    return line;
  }

  private void getUserApprovalAndShowOAuthVerifierCode(OAuthService service) {
//        String authUrl= service.getAuthorizationUrl(null);
//        Desktop desktop = Desktop.getDesktop();
//        try {
//            desktop.browse(URI.create(authUrl));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
  }

}

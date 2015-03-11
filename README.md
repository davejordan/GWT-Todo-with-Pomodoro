# GWT-Todo-with-Pomodoro
Todo application that takes tasks from Todoist and adds Pomodoro feature. Uses GWT for front end.

## Setting up
Create .secret files for the tests and application (the project exlcudes these).
Put the following files:
* resource/StaticAuthentication.secret
  * This holds a Todoist token string. Something like ce89xxxx... etc
* resrouce/TestAuthenticationFile.secret
```
{
  "EMAIL": "bob@test.com",
  "API_KEY": "12345a",
  "API_SECRET": "abcd"
}
```
* src/main/java/org.dave.example.server/AuthenticationSecret.secret
```
{
  "EMAIL": "your email",
  "API_KEY": "your api key - can get this from google, etc",
  "API_SECRET": "you api secret - again from google, etc"
}
```

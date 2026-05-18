Feature: Cura Healthcare Login Testing

@Smoke
Scenario: Successful login with valid credentials
  Given user is on application page
  When user enters valid username "John Doe" and password "ThisIsNotAPassword"
  And user clicks on login button
  Then user should be logged in successfully

@Regression
Scenario: Login with invalid credentials
  Given user is on application page
  When user enters invalid username "wrongUser" and password "wrongPass"
  And user clicks on login button
  Then user should see error message

@Sanity
Scenario: Navigate to appointment page
  Given user is on application page
  When user clicks on book appointment
  Then appointment page should be displayed
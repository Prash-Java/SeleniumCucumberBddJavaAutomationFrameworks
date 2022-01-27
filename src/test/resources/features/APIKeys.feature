  @APIKEYS001
  Feature: API Key test cases
    @APIKEYS
    Scenario Outline:To verify user is able to add a new api key
      Given User lauches the Application in "<Environment>" Environment as "<Username>" and "<Password>"
      When User clicks API Keys
      And  User Creates an New API Key
      Then User Verifies the created API Keys

      Examples:
      | Environment                    | Username                          | Password  |
      | https://qatportal.dimebox.com/ | qaams.verifone.admin@verifone.com | Veri1234@ |
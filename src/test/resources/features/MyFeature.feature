@Verifone_Common_Portal
Feature: Test Verifone Common Portal Launch

  @TestCase_0001
  Scenario: Launch Common Portal In Custom Environment
    Given Launch url which is expected to be hit on custom browser
    When User launches url and verifies header text presence
    Then User verifies login and password fields are present on screen
    And User Closes the instance of browser and comes out of application
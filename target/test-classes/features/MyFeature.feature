@Verifone_Common_Portal
Feature: Test Verifone Common Portal Launch

  Background:
    Given Launch url which is expected to be hit on custom browser
    When User launches url and verifies header text presence

  @TestCase_0001
  Scenario: Launch Common Portal In Custom Environment With No Parameters
    Then User verifies login and password fields are present on screen
    And User Closes the instance of browser and comes out of application

  @TestCase_0002
  Scenario: Launch Common Portal In Custom Environment With Parameters Without Examples
    Then User will need verify "login" and "password" fields are present on screen
    And User Closes the instance of browser and comes out of application

  @TestCase_0003
  Scenario Outline: Launch Common Portal In Custom Environment With Parameters In Examples
    Then User will verify "<login>" and "<password>" fields are present on screen
    And User Closes the instance of browser and comes out of application

    Examples:
      |login|password|
      |Veri1|Veri@123|
      |Veri2|Veri@123|

  @TestCase_0004
  Scenario: Launch Common Portal In Custom Environment With Parameters DataTable As Lists
    Then User will verify credentials fields are present on screen
      |Veri3|Veri@123|
    And User Closes the instance of browser and comes out of application

  @TestCase_0005
  Scenario: Launch Common Portal In Custom Environment With Parameters DataTable As Maps
    Then User will verify credentials fields are present on screen navigation
      |login|password|
      |Veri4|Veri@123|
      |Veri5|Veri@123|
    And User Closes the instance of browser and comes out of application


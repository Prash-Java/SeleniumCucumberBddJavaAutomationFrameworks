@PaginationAppTest
Feature: Create Pagination App functionality tests

  Background:
    Given User will navigate to pagination app "http://java-angular-react-pagination-app-deploy.s3-website-us-east-1.amazonaws.com"


  @TestCaseUI_PaginationAppLaunch1  @UI_Test
  Scenario Outline: Launch Pagination App Feature
    When User Validates On pagination app page header in screen "<headerText>"
    And User validates the page title with text containing "<pageTitleText>"
    And User Validated the navbar for pagination app page as "<NavBarValue>"
    Then User closes the browser instance

    Examples:
      |headerText|pageTitleText |NavBarValue|
      |Users List|Pagination App|NavBar     |



#  @TestCaseAPI_PaginationAppLaunch @API_Test
#  Scenario Outline: Test GET Http request in Pagination App as Response for validations
#    Given User will assert params after hitting base uri for pagination app "<paginationAppURL>"
#
#    Examples:
#      |paginationAppURL                                       |
#      |http://userpaginationapp.us-east-1.elasticbeanstalk.com|
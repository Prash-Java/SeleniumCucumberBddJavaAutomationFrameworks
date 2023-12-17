@PaginationAppTest
Feature: Create Pagination App functionality tests

  @TestCaseUI_PaginationAppLaunch
  Scenario Outline: Launch Pagination App Feature
    Given User will navigate to pagination app "<paginationAppURL>"
    When User Validates On pagination app page header in screen "<headerText>"
    And User validates the page title with text containing "<pageTitleText>"
    Then User closes the browser instance

    Examples:
      |paginationAppURL                                                                  |headerText|pageTitleText |
      |http://java-angular-react-pagination-app-deploy.s3-website-us-east-1.amazonaws.com|Users List|Pagination App|

  @TestCaseAPI_PaginationAppLaunch
  Scenario Outline: Test GET Http request in Pagination App
    Given User will assert params after hitting base uri for pagination app "<paginationAppURL>"

    Examples:
      |paginationAppURL                                       |
      |http://userpaginationapp.us-east-1.elasticbeanstalk.com|
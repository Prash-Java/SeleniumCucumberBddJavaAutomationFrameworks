@PaginationAppTest
Feature: Create Pagination App functionality tests

  @TestCase_PaginationAppLaunch
  Scenario Outline: Launch Pagination App Feature
    Given User will navigate to pagination app "<paginationAppURL>"
    When User Validates On pagination app page header in screen "<headerText>"
    And User validates the page title with text containing "<pageTitleText>"
    Then User closes the browser instance

    Examples:
      |paginationAppURL                                                                  |headerText|pageTitleText |
      |http://java-angular-react-pagination-app-deploy.s3-website-us-east-1.amazonaws.com|Users List|Pagination App|
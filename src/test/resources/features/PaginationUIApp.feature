@PaginationAppUiTest
Feature: Create Pagination App functionality tests

  Background:
    Given User will navigate on pagination app "http://java-angular-react-pagination-app-deploy.s3-website-us-east-1.amazonaws.com"


  @TestCaseUI_PaginationApp  @UI_Test
  Scenario Outline: Launch Pagination App Feature
    When User Validates at pagination app page header in screen "<headerText>"

    Examples:
      |headerText|
      |Users List|
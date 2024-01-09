@PaginationAppUiTest
Feature: Create Pagination App functionality tests

  Background:
    Given User will navigate on pagination app "http://java-angular-react-pagination-app-deploy.s3-website-us-east-1.amazonaws.com"

  @TestCaseUI_PaginationApp  @UI_Test
  Scenario Outline: Launch Pagination App Feature
    When User Validates at pagination app page header in screen "<headerText>"
    And User Validates the pagination app navigation tile is screen "<NavBarValue>"
    And User Validates the pagination app home header title "<HomeColumnValue>"

    Examples:
      |headerText|NavBarValue|HomeColumnValue|
      |Users List|Navbar     |Home           |

  @TestCaseUI_PaginationAppBodyArea  @UI_Test
  Scenario Outline: Launch Pagination App body container area
    When User Validated the pagination app id for users in body area "<IdColumnValue>"
    And User Validated the column name for pagination page as "<NameColumnValue>"
    And User Validates the column title for pagination page as "<PhotoColumnValue>"
    And User Validates the table title as address for pagination page as "<AddressColumnValue>"
    And User Validated the table title for Email for pagination page "<EmailColumnValue>"

    Examples:
      |IdColumnValue|NameColumnValue|PhotoColumnValue|AddressColumnValue|EmailColumnValue|
      |ID           |Name           |Photo           |Address           |Email           |

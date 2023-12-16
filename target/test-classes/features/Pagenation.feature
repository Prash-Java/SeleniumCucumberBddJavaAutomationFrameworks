@Pagenation
Feature: Launch Pagenation app

  @TestCase_Pagenation
  Scenario Outline: Launch Pagenation App
    Given User will navigate to pagenation app screen "<usersUrl>"
#     When User Validates the page title "<expectedText>"
#     And User clicks on Create Account Button

    Examples:
      |usersUrl                                                                           |expectedText  |
      |http://java-angular-react-pagination-app-deploy.s3-website-us-east-1.amazonaws.com/|Pagination App|
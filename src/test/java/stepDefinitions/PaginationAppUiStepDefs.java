package stepDefinitions;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pages.PaginationAppUiPage;

public class PaginationAppUiStepDefs {
    @Inject
    private PaginationAppUiPage paginationAppUiPage;

    @Given("^User will navigate on pagination app \"([^\"]*)\"$")
    public void userWillNavigateOnPaginationApp(String baseUrl) throws InterruptedException {
        paginationAppUiPage.launchPaginationAppBaseUrl(baseUrl);
    }

    @When("^User Validates at pagination app page header in screen \"([^\"]*)\"$")
    public void userValidatesAtPaginationAppPageHeaderInScreen(String expectedText) throws InterruptedException {
        paginationAppUiPage.assertPageHeaderText(expectedText);
    }

    @And("^User Validates the pagination app navigation tile is screen \"([^\"]*)\"$")
    public void userValidatesThePaginationAppNavigationTileIsScreen(String navbar) throws InterruptedException {
        paginationAppUiPage.assertNavigationColumnName(navbar);
    }

    @And("User Validates the pagination app home header title \"([^\"]*)\"$")
    public void userValidatesThePaginationAppHomeHeaderTitle() throws InterruptedException {
        paginationAppUiPage.assertNavHomeTitle();
    }

    @When("User Validated the pagination app id for users in body area \"([^\"]*)\"$")
    public void userValidatedThePaginationAppIdForUsersInBodyArea(String id)  {
        paginationAppUiPage.assertIdColumnValue(id);
    }

    @And("^User Validated the column name for pagination page as \"([^\"]*)\"$")
    public void userValidatedTheColumnNameForPaginationPageAs(String name ){
        paginationAppUiPage.assertNameColumnValue(name);
    }


    @And("^User Validates the column title for pagination page as \"([^\"]*)\"$")
    public void userValidatesTheColumnTitleForPaginationPageAs(String photo){
        paginationAppUiPage.assertPhotoColumnValue(photo);
    }

    @And("^User Validates the table title as address for pagination page as \"([^\"]*)\"$")
    public void userValidatesTheTableTitleAsAddressForPaginationPageAs(String address) {
        paginationAppUiPage.assertTableTileAddress(address);
    }

    @And("^User Validated the table title for Email for pagination page \"([^\"]*)\"$")
    public void userValidatedTheTableTitleForEmailForPaginationPage(String email) {
        paginationAppUiPage.assertEmailDetailColumnValue(email);
    }

    @Given("^User will assert params after hitting base uri for pagination app \"([^\"]*)\"$")
    public void userWillAssertParamsAfterHittingBaseUriForPaginationApp(String baseUrl) {
        RestAssured.baseURI = baseUrl;
        request = RestAssured.given();
        response = request.get("/users?name=&page=0&size=10");

        jsonString = response.asString();

        // Assert on Status Code
        theStatusCode = JsonPath.from(jsonString).get("statusCode");
        Assert.assertTrue(theStatusCode == 200);

        // Assert On Status Message
        theStatus = JsonPath.from(jsonString).get("status");
        Assert.assertEquals(theStatus, "200 OK");

        // Assert On Total Elements On Http.GET request
        theTotalUsersCount = JsonPath.from(jsonString).get("data.page.totalElements");
        Assert.assertEquals(theTotalUsersCount, 100);

        // Assert On Total Pages On Http.GET request
        theTotalPages = JsonPath.from(jsonString).get("data.page.totalPages");
        Assert.assertEquals(theTotalPages, 10);

        // Assert On Size On Http.GET request
        theSize = JsonPath.from(jsonString).get("data.page.size");
        Assert.assertEquals(theSize, 10);

        // Assert On Number Of Elements On Http.GET request
        theNumberOfElements = JsonPath.from(jsonString).get("data.page.numberOfElements");
        Assert.assertEquals(theNumberOfElements, 10);

        // Assert On Any UserName On Http.GET request
        String userName = JsonPath.from(jsonString).get("data.page.content[0].name");
        Assert.assertTrue(userName.contains("Royce".trim()));

        // Assert On Any Email On Http.GET request
        String userEmail = JsonPath.from(jsonString).get("data.page.content[5].email");
        Assert.assertTrue(userEmail.contains("mbaildon5@census.gov".trim()));
    }
}



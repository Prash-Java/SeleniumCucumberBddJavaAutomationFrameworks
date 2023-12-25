package stepDefinitions;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pages.PaginationAppPage;

public class PaginationAppStepDefs {

    @Inject
    public PaginationAppPage paginationAppPage;

    public Response response;
    public RequestSpecification request;
    public String jsonString;
    public int theStatusCode;
    public String theStatus;
    public int theTotalUsersCount;
    public int theTotalPages;
    public int theSize;
    public int theNumberOfElements;

    @Given("^User will navigate to pagination app \"([^\"]*)\"$")
    public void userWillNavigateToPaginationApp(String baseUrl) throws InterruptedException {
        paginationAppPage.launchPaginationAppBaseUrl(baseUrl);
    }

    @When("^User Validates On pagination app page header in screen \"([^\"]*)\"$")
    public void userValidatesOnPaginationAppPageHeaderInScreen(String headerText) throws InterruptedException {
        paginationAppPage.assertPageHeaderText(headerText);
    }

    @And("^User validates the page title with text containing \"([^\"]*)\"$")
    public void userValidatesThePageTitleWithTextContaining(String pageTitleText) throws InterruptedException {
        paginationAppPage.assertPageTitleText(pageTitleText);
    }

    @Then("^User closes the browser instance$")
    public void userClosesTheBrowserInstance() {
        paginationAppPage.quitBrowserInstance();
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

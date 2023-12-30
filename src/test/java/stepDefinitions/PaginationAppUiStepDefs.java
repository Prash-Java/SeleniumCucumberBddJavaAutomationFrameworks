package stepDefinitions;

import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
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
}
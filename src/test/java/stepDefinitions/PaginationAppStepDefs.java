package stepDefinitions;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PaginationAppPage;

public class PaginationAppStepDefs {

    @Inject
    public PaginationAppPage paginationAppPage;

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
}

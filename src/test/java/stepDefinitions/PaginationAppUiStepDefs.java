package stepDefinitions;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
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

    @And("^User Validates the pagination app navigation tile is screen \"([^\"]*)\"$")
    public void userValidatesThePaginationAppNavigationTileIsScreen(String navbar) throws InterruptedException {
        paginationAppUiPage.assertNavigationColumnName(navbar);
    }

    @And("User Validates the pagination app home header title {string}")
    public void userValidatesThePaginationAppHomeHeaderTitle(String home){
        paginationAppUiPage.assertHomeHeaderTitle(home);
    }

    @When("User Validated the pagination app id for users in body area {string}")
    public void userValidatedThePaginationAppIdForUsersInBodyArea(String id) {
        paginationAppUiPage.assertIdColumnValue(id);
    }
}


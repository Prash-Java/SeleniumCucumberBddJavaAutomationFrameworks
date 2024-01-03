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
}



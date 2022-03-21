package stepDefinitions;


import com.google.inject.Inject;
import com.utilities.SeleniumUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import pages.ApiKeysPage;
import pages.LoginPage;

public class ApiKeysServiceUI extends SeleniumUtil {

    @Inject
    ApiKeysPage apiKeysPage;

    @Inject
    LoginPage loginPage;

    public static int tableRowSize;

    public void wait_until_page_is_loaded() {
        waitForElementVisibility(apiKeysPage.getDataLoader());
    }


    @Given("^User lauches the Application in \"(.*)\" Environment as \"(.*)\" and \"(.*)\"$")
    public void userLauchesTheApplicationInEnvironmentAsAnd(String url, String userName, String password) throws InterruptedException {
        getDriver();
        launchURL(url);
        waitForPageToLoad();
//        if (!loginPage.getButtonSignIn().isDisplayed()) {
//            System.exit(1);
//        }
//        try {
//            loginPage.getAcceptCookieButton().click();
//        } catch (NoSuchElementException e) {
//            System.out.println("Cookie already accepted or pop up not display");
//        } catch (Exception e) {
//            System.out.println("Continue to next step-Generic");
//        }
//        waitForPageToLoad();

        log_in_with(userName,password);

    }

    public void log_in_with(String email, String password) throws InterruptedException {
        enter(loginPage.getButtonSignIn());
        Thread.sleep(10000);
        enterText(loginPage.getFieldUserName(),email);
        enterText(loginPage.getFieldPassword(),password);
        enter(loginPage.getButtonLogin());
        try {
            enter(loginPage.getCookiePopUpOkButton());
            enter(loginPage.getKeepDefaultLanguageButton());
        } catch (ElementNotVisibleException e) {
            System.out.println("Continue to next step");
        } catch (Exception e) {
            System.out.println("Continue to next step-Generic");
        }
}

    @When("^User clicks API Keys$")
    public void userClicksAPIKeys() throws InterruptedException {
        enter(apiKeysPage.getNavbarItemDropdownLink());
        enter(apiKeysPage.getNavbarApiKeysLink());
        Thread.sleep(2000);
    }

    @And("User Creates an New API Key")
    public void userCreatesAnNewAPIKey() throws InterruptedException {
//        wait_until_page_is_loaded();
        Thread.sleep(10000);
        tableRowSize = apiKeysPage.getTableRowList().size();
        if(tableRowSize == 5){
            enter(apiKeysPage.getTableFirstRow());
            enter(apiKeysPage.getButtonRevokeAccess());
//            wait_until_page_is_loaded();
            refreshPage();
            Thread.sleep(10000);
        }
//        wait_until_page_is_loaded();
//        Thread.sleep(10000);
        enter(apiKeysPage.getButtonCreateApiKeys());
        enter(apiKeysPage.getButtonCopyPublicKey());
        waitForElementVisibility(apiKeysPage.getNotifySuccessCopiedMessage());
        enter(apiKeysPage.getButtonDiscard());
//        wait_until_page_is_loaded();
        Thread.sleep(10000);
    }

    @Then("User Verifies the created API Keys")
    public void userVerifiesTheCreatedAPIKeys() throws InterruptedException {
//        wait_until_page_is_loaded();
        Thread.sleep(10000);
        int TotalRowSize = apiKeysPage.getTableRowList().size();
        if (TotalRowSize > 0) {
            enter(apiKeysPage.getTableFirstRow());
//            wait_until_page_is_loaded();
            Thread.sleep(10000);
            enter(apiKeysPage.getButtonRevokeAccess());
        } else {
            Assert.assertFalse(true,"There is no api keys present in the table to delete ");
        }
    }
}


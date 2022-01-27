package stepDefinitions;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MyPage;

import java.util.List;
import java.util.Map;

//@RunWith(Cucumber.class)    //optional automation
public class HomeStepDefs {
    @Inject
    public MyPage myPage;

    @Given("^Launch url which is expected to be hit on custom browser$")
    public void launchUrlWhichIsExpectedToBeHitOnCustomBrowser() {
        System.out.println("Cucumber BDD Frameworks");
    }

    @When("^User launches url and verifies header text presence$")
    public void userLaunchesUrlAndVerifiesHeaderTextPresence() {
        System.out.println("Cucumber BDD Frameworks");
    }

    @Then("^User verifies login and password fields are present on screen$")
    public void userVerifiesLoginAndPasswordFieldsArePresentOnScreen() throws InterruptedException {
        System.out.println("Cucumber BDD Frameworks");
    }
    @And("^User Closes the instance of browser and comes out of application$")
    public void userClosesTheInstanceOfBrowserAndComesOutOfApplication() {
        System.out.println("Cucumber BDD Frameworks");
        myPage.testMethod();
    }

    @Then("^User will verify \"([^\"]*)\" and \"([^\"]*)\" fields are present on screen$")
    public void userVerifiesLoginAndPasswordFieldsArePresentOnScreen(String login, String password) {
        System.out.println("Login: " + login);
        System.out.println("Password: " + password);
    }

    @Then("^User will need verify \"(.*)\" and \"(.*)\" fields are present on screen$")
    public void userWillNeedVerifyAndFieldsArePresentOnScreen(String login, String password) {
        System.out.println("Login: " + login);
        System.out.println("Password: " + password);
    }

    @Then("^User will verify credentials fields are present on screen$")
    public void userWillVerifyCredentialsFieldsArePresentOnScreen(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        for(int i=0;i<data.size();i++){
            System.out.println("Value: " + data.get(i));
        }
    }

    @Then("^User will verify credentials fields are present on screen navigation$")
    public void userWillVerifyCredentialsFieldsArePresentOnScreenNavigation(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
        for(int i=0;i< data.size();i++){
            System.out.println("Keys: " + data.get(i).get("login"));
            System.out.println("Values: " + data.get(i).get("password"));
        }
    }


}

package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)    //optional automation
public class HomeStepDefs {
    @Given("^Launch url which is expected to be hit on custom browser$")
    public void launchUrlWhichIsExpectedToBeHitOnCustomBrowser() {
        System.out.println("Cucumber BDD Frameworks");
    }

    @When("^User launches url and verifies header text presence$")
    public void userLaunchesUrlAndVerifiesHeaderTextPresence() {
        System.out.println("Cucumber BDD Frameworks");
    }

    @Then("^User verifies login and password fields are present on screen$")
    public void userVerifiesLoginAndPasswordFieldsArePresentOnScreen() {
        System.out.println("Cucumber BDD Frameworks");
    }

    @And("^User Closes the instance of browser and comes out of application$")
    public void userClosesTheInstanceOfBrowserAndComesOutOfApplication() {
        System.out.println("Cucumber BDD Frameworks");
    }
}

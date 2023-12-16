package stepDefinitions;

import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import pages.GoogleRegistrationPage;
import pages.PagenationPage;

public class PagenationStepDefs {
    @Inject
    public PagenationPage pagenationPage;

    @Given("^User will navigate to pagenation app screen \"([^\"]*)\"$")
    public void userwillnavigatetopagenationappscreen(String baseUrl) throws InterruptedException {
        pagenationPage.launchPaginationPage(baseUrl);
    }
}

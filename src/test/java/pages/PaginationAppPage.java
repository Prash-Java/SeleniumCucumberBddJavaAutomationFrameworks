package pages;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.SeleniumHelper;

import java.time.Duration;

public class PaginationAppPage {

    public static WebDriver driver;
    public Select select;

    @Inject
    public SeleniumHelper seleniumHelper;

    public void waitForPageToLoad(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")));
    }

    public void launchPaginationAppBaseUrl(String baseUrl) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/browserdrivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(options);
        waitForPageToLoad();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.get(baseUrl);
        waitForPageToLoad();
    }

    public void assertPageHeaderText(String expectedText) throws InterruptedException {
        Thread.sleep(5000);
        String actualText = driver.findElement(By.xpath("//h3[text()='Users List']")).getText();
        seleniumHelper.assertCurrentText(expectedText.trim(), actualText.trim());
    }

    public void assertPageTitleText(String expectedText) {
        String actualText = driver.getTitle().trim();
        Assert.assertTrue(actualText.contains(expectedText));
    }

    public void quitBrowserInstance() {
        driver.quit();
    }

    public void assertNavBarHeaderTile(String navbar) {
        WebElement nav = driver.findElement(By.xpath("//nav/div/a[text()='Navbar'"));
        nav.getText();
    }
}

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
import java.util.concurrent.TimeUnit;

public class PaginationAppUiPage {
    public static WebDriver driver;
    public Select select;

    @Inject
    public static SeleniumHelper seleniumHelper;

    public void waitForPageToLoad () {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState")));
        }
        public void launchPaginationAppBaseUrl(String baseUrl) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/browserdrivers/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            waitForPageToLoad(); // waits (2)
            driver.manage().window().maximize();
            Thread.sleep(3000);
            driver.get(baseUrl);
            waitForPageToLoad();
        }

    public void assertPageHeaderText(String expectedText) throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(expectedText,driver.findElement(By.xpath("//h3[text()='Users List']")).getText());

    }

    public void assertNavigationColumnName(String navbar) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(navbar,driver.findElement(By.xpath("//a[@class='navbar-brand']")).getText());
    }

    public void assertHomeHeaderTitle(String home) {
        waitForPageToLoad();
        String  expectedText ="Home";
        WebElement  actualText = driver.findElement(By.xpath("//li[1]/a[@class='nav-link active']"));
        if(actualText.equals("expectedText")) {
            actualText.getText();
        }
    }

    public void assertIdColumnValue(String id) {
        waitForPageToLoad();
        Assert.assertEquals(id,driver.findElement(By.xpath("//table/thead/tr/th[1]")).getText());
    }
}



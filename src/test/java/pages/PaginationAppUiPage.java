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

          // UserList Table title
    public void assertPageHeaderText(String expectedText) throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(expectedText,driver.findElement(By.xpath("//h3[text()='Users List']")).getText());

    }
      // NavBar
    public void assertNavigationColumnName(String navbar) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(navbar,driver.findElement(By.xpath("//a[@class='navbar-brand']")).getText());
    }

     // Home Nav bar
    public void assertNavHomeTitle() throws InterruptedException {
        Thread.sleep(1500);
        WebElement home = driver.findElement(By.xpath("//ul/li/a[text()='Home']"));
        home.getText();
    }

    // ID Column Value
    public void assertIdColumnValue(String id){
        Assert.assertEquals(id,driver.findElement(By.xpath("//*[text()='ID']")).getText());

    }

   // Name Column value
    public void assertNameColumnValue(String name)  {
        Assert.assertEquals(name, driver.findElement(By.xpath("//*[text()='Name']")).getText());
    }

     // Photo Column Value
    public void assertPhotoColumnValue(String photo){
        Assert.assertEquals(photo, driver.findElement(By.xpath("//*[text()='Photo']")).getText());
    }

     // Address Table Column name
    public void assertTableTileAddress(String address) {
        Assert.assertEquals(address, driver.findElement(By.xpath("//*[text()='Address']")).getText());
    }

    public void assertEmailDetailColumnValue(String email) {
        Assert.assertEquals(email, driver.findElement(By.xpath("//*[text()='Email']")).getText());
    }
}



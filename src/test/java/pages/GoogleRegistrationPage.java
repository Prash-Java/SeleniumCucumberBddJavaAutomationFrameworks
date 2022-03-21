package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.security.SecureRandom;

import static com.utilities.SeleniumUtil.driver;

public class GoogleRegistrationPage {
    public static WebDriver driver;
    public Select select;

    public void launchGmailBaseURLForRegistration(String baseUrl) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/browserdrivers/chromedriver.exe");
        driver=new ChromeDriver();
        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.get(baseUrl);
        Thread.sleep(5000);
    }

    public void userClicksOnCreateAccountButton() throws InterruptedException {
        WebElement createAccountButton= driver.findElement(By.xpath("//span[text()='Create account']"));
        createAccountButton.click();
        Thread.sleep(2000);
    }

    public void userSelectsForMySelfOption() throws InterruptedException {
        WebElement forMyselfOption= driver.findElement(By.xpath("//span[text()='For myself']"));
        forMyselfOption.click();
        Thread.sleep(2000);
    }

    public void userEntersFirstName(String firstName) {
        WebElement firstNameField= driver.findElement(By.id("firstName"));
        firstNameField.sendKeys(firstName);
    }

    public void userEntersLastName(String lastName) {
        WebElement lastNameField= driver.findElement(By.id("lastName"));
        lastNameField.sendKeys(lastName);
    }

    public void userValidatesGmailPage(String expectedText) {
        WebElement validatorSubHeader=driver.findElement(By.xpath("//span[text()='to continue to Gmail']"));
        String actualText= validatorSubHeader.getText();
        Assert.assertEquals(expectedText,actualText);
    }

    public void userEntersUserName(String userName) {
        WebElement userNameField= driver.findElement(By.id("username"));
        userNameField.click();
        userNameField.clear();
        userNameField.sendKeys(userName);
    }

    public void userEntersPassword(String password) {
        WebElement passwordField= driver.findElement(By.name("Passwd"));
        passwordField.sendKeys(password);
    }

    public void userConfirmsPassword(String confirmPassword) {
        WebElement confirmPasswordField= driver.findElement(By.name("ConfirmPasswd"));
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public void userClicksOnNextButton() throws InterruptedException {
        WebElement nextButton=driver.findElement(By.xpath("//span[text()='Next']"));
        nextButton.click();
        Thread.sleep(3000);
    }

    public void userEntersPhoneNumber(String phoneNumber) {
        WebElement phoneNumberField= driver.findElement(By.id("phoneNumberId"));
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void userEntersOtpFromMobile(String phoneOTP) {
        WebElement otpField= driver.findElement(By.id("code"));
//        otpField.sendKeys(phoneOTP);
    }

    public void userClicksOnVerifyButton() throws InterruptedException {
        WebElement verifyButton= driver.findElement(By.xpath("//span[text()='Verify']"));
        verifyButton.click();
        Thread.sleep(5000);
    }

    public void userEntersItsBirthDay(String birthDay) {
        WebElement dayField=driver.findElement(By.id("day"));
        dayField.sendKeys(birthDay);
    }

    public void userEntersBirthMonth(String birthMonth) {
        WebElement monthDropdown=driver.findElement(By.id("month"));
        select=new Select(monthDropdown);
        select.selectByVisibleText(birthMonth);
    }

    public void userEntersItsBirthYear(String birthYear) {
        WebElement birthYearField=driver.findElement(By.id("year"));
        birthYearField.sendKeys(birthYear);
    }

    public void userEntersItsGender(String gender) {
        WebElement genderField= driver.findElement(By.id("gender"));
        select=new Select(genderField);
        select.selectByVisibleText(gender);
    }

    public void userVerifiesPresenceOfButton() {
        WebElement buttonElement= driver.findElement(By.xpath("//span[text()='Yes, I’m in']"));
        Assert.assertTrue(buttonElement.isDisplayed());
    }
}

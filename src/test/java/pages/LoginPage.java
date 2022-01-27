package pages;


import com.utilities.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends SeleniumUtil {

    @FindBy(css = "button[data-e2e=app-button-login]")
    private WebElement buttonSignIn;

    @FindBy(css = "input[id='idToken1']")
    private WebElement fieldUserName;

    @FindBy(css = "input[id='idToken2']")
    private WebElement fieldPassword;

    @FindBy(css = "input[id='loginButton_0']")
    private WebElement buttonLogin;

    @FindBy(css = "button[name='decision'][value='allow']")
    private WebElement buttonAllow;

    @FindBy(css = "[data-e2e=menu-item-logout]")
    private WebElement buttonLogout;

    @FindBy(css = "div[class='navbar-item has-dropdown has-circle']")
    private WebElement navbarItemDropdownLink;

    @FindBy(xpath = "//a[@id='CybotCookiebotDialogBodyLevelButtonAccept']")
    private WebElement cookiePopUpOkButton;

    @FindBy(xpath = "//a[contains(text(),'OK')]")
    private WebElement acceptCookieButton;

    @FindBy(xpath = "//input[@data-e2e='textControl-input']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSignIn;

    @FindBy(xpath = "//button[@data-e2e='keep-default-language-button']")
    private WebElement keepDefaultLanguageButton;

    public WebElement getKeepDefaultLanguageButton() {
        return keepDefaultLanguageButton;
    }

    public WebElement getButtonSignIn() {
        WebElement element=driver.findElement(By.cssSelector("button[data-e2e=app-button-login]"));
        return element;
//        return buttonSignIn;
    }

    public WebElement getFieldUserName() {
        WebElement element=driver.findElement(By.cssSelector("input[id='idToken1']"));
        return element;
//        return fieldUserName;
    }

    public WebElement getFieldPassword() {
        WebElement element=driver.findElement(By.cssSelector("input[id='idToken2']"));
        return element;
//        return fieldPassword;
    }

    public WebElement getButtonLogin() {
        WebElement element=driver.findElement(By.cssSelector("input[id='loginButton_0']"));
        return element;
//        return buttonLogin;
    }

    public WebElement getButtonAllow() {
        return buttonAllow;
    }

    public WebElement getButtonLogout() {
        return buttonLogout;
    }

    public WebElement getNavbarItemDropdownLink() {
        return navbarItemDropdownLink;
    }

    public WebElement getCookiePopUpOkButton() {
        return cookiePopUpOkButton;
    }

    public WebElement getAcceptCookieButton() {
        return acceptCookieButton;
    }

    public WebElement getInputEmail() {
        return inputEmail;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getBtnSignIn() {
        return btnSignIn;
    }

}

package pages;
import com.utilities.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ApiKeysPage extends SeleniumUtil {

        @FindBy(css = "[data-e2e=delete-key-button]")
        private WebElement buttonRevokeAccess;

        @FindBy(css = "[data-e2e=modal-discard-button]")
        private WebElement buttonDiscard;

        @FindBy(css = "div.level portal-copy-to-clipboard:nth-child(2) > button.level-right.button.is-primary")
        private WebElement buttonCopyPublicKey;

        @FindBy(css = "[data-e2e=link-new]")
        private WebElement buttonCreateApiKeys;

        @FindBy(css = "[data-e2e=table-row]")
        private List<WebElement> tableRowList;

        @FindBy(css = "tbody:nth-child(2) tr:nth-child(1)")
        private WebElement tableFirstRow;

        @FindBy(css = "span.icon.loader")
        private WebElement dataLoader;

        @FindBy(css = "[data-e2e=notifier-toast]")
        private WebElement notifySuccessMessage;

        @FindBy(css = "[data-e2e=notifier-toast]")
        private WebElement notifySuccessCopiedMessage;

        @FindBy(css = "div[class='navbar-item has-dropdown has-circle']")
        private WebElement navbarItemDropdownLink;

        @FindBy(css = "[data-e2e=menu-item-api-keys]")
        private WebElement navbarApiKeysLink;

        @FindBy(xpath = "//div[contains(text(),'API Key Created')]")
        private WebElement textApiKeyCreated;

        public WebElement getButtonRevokeAccess() {
                WebElement element=driver.findElement(By.cssSelector("[data-e2e=delete-key-button]"));
                return element;
//                return buttonRevokeAccess;
        }

        public WebElement getButtonDiscard() {
                WebElement element=driver.findElement(By.cssSelector("[data-e2e=modal-discard-button]"));
                return element;
//                return buttonDiscard;
        }

        public WebElement getButtonCopyPublicKey() {
                WebElement element=driver.findElement(By.cssSelector("div.level portal-copy-to-clipboard:nth-child(2) > button.level-right.button.is-primary"));
                return element;
//                return buttonCopyPublicKey;
        }

        public WebElement getButtonCreateApiKeys() {
                WebElement element=driver.findElement(By.cssSelector("[data-e2e=link-new]"));
                return element;
//                return buttonCreateApiKeys;
        }

        public List<WebElement> getTableRowList() {
                List<WebElement> elements=driver.findElements(By.cssSelector("[data-e2e=table-row]"));
                return elements;
//                return tableRowList;
        }

        public WebElement getTableFirstRow() {
                WebElement element=driver.findElement(By.cssSelector("tbody:nth-child(2) tr:nth-child(1)"));
                return element;
//                return tableFirstRow;
        }

        public WebElement getDataLoader() {
                WebElement element=driver.findElement(By.cssSelector("span.icon.loader"));
                return element;
//                return dataLoader;
        }

        public WebElement getNotifySuccessMessage() {
                return notifySuccessMessage;
        }

        public WebElement getNotifySuccessCopiedMessage() {
                WebElement element= driver.findElement(By.cssSelector("[data-e2e=notifier-toast]"));
                return element;
//                return notifySuccessCopiedMessage;
        }

        public WebElement getNavbarItemDropdownLink() {
                WebElement element= driver.findElement(By.cssSelector("div[class='navbar-item has-dropdown has-circle']"));
                return element;
//                return navbarItemDropdownLink;
        }

        public WebElement getNavbarApiKeysLink() {
                WebElement element=driver.findElement(By.cssSelector("[data-e2e=menu-item-api-keys]"));
                return element;
//                return navbarApiKeysLink;
        }

        public WebElement getTextApiKeyCreated() {
                return textApiKeyCreated;
        }




}

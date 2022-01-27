package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ApiKeysPage {

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
                return buttonRevokeAccess;
        }

        public WebElement getButtonDiscard() {
                return buttonDiscard;
        }

        public WebElement getButtonCopyPublicKey() {
                return buttonCopyPublicKey;
        }

        public WebElement getButtonCreateApiKeys() {
                return buttonCreateApiKeys;
        }

        public List<WebElement> getTableRowList() {
                return tableRowList;
        }

        public WebElement getTableFirstRow() {
                return tableFirstRow;
        }

        public WebElement getDataLoader() {
                return dataLoader;
        }

        public WebElement getNotifySuccessMessage() {
                return notifySuccessMessage;
        }

        public WebElement getNotifySuccessCopiedMessage() {
                return notifySuccessCopiedMessage;
        }

        public WebElement getNavbarItemDropdownLink() {
                return navbarItemDropdownLink;
        }

        public WebElement getNavbarApiKeysLink() {
                return navbarApiKeysLink;
        }

        public WebElement getTextApiKeyCreated() {
                return textApiKeyCreated;
        }




}

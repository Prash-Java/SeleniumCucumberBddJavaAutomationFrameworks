package stepDefinitions;


import com.google.inject.Inject;
import com.utilities.SeleniumUtil;
import org.testng.Assert;
import pages.ApiKeysPage;

public class ApiKeysServiceUI extends SeleniumUtil {

    @Inject
    ApiKeysPage apiKeysPage;

    public static int tableRowSize;

    public void wait_until_page_is_loaded() {
        waitForElementVisibility(apiKeysPage.getDataLoader());
    }

    public void click_add_api_keys_test() {
        enter(apiKeysPage.getNavbarItemDropdownLink());
        enter(apiKeysPage.getNavbarApiKeysLink());
    }

    public void perform_add_api_keys_test() {
        wait_until_page_is_loaded();
        tableRowSize = apiKeysPage.getTableRowList().size();
        if(tableRowSize == 5){
            enter(apiKeysPage.getTableFirstRow());
            enter(apiKeysPage.getButtonRevokeAccess());
            wait_until_page_is_loaded();
            refreshPage();
        }
        wait_until_page_is_loaded();
        enter(apiKeysPage.getButtonCreateApiKeys());
        enter(apiKeysPage.getButtonCopyPublicKey());
        waitForElementVisibility(apiKeysPage.getNotifySuccessCopiedMessage());
        enter(apiKeysPage.getButtonDiscard());
        wait_until_page_is_loaded();
    }

    public void perform_revoke_access_api_keys_test() {
        wait_until_page_is_loaded();
        int TotalRowSize = apiKeysPage.getTableRowList().size();
        if (TotalRowSize > 0) {
            enter(apiKeysPage.getTableFirstRow());
            wait_until_page_is_loaded();
            enter(apiKeysPage.getButtonRevokeAccess());
        } else {
            Assert.assertFalse(true,"There is no api keys present in the table to delete ");
        }
    }
}


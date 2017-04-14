package WebpageMethods.EPC_Methods.Account_Methods;

/**
 * Created by cad6025 on 3/17/2017.
 */
public class Account_File_Summary extends EPC_Account_Methods
{
    public static Account_File_Summary instance = new Account_File_Summary();

    public void clickDocumentsInToolsMenu() {
        waitForElementToBeDisplayedAndClickableThenClick("//span[@class='x-tree-node-text '][text()='Documents']");
        waitForPageToLoad(5);
    }

    public void clickPolicyTransactionsInToolsMenu() {
        waitForElementToBeDisplayedAndClickableThenClick("//span[@class='x-tree-node-text '][text()='Policy Transactions']");
    }
}

package WebpageMethods.EPC_Methods.Account_Methods;

/**
 * Created by cad6025 on 3/17/2017.
 */
public class Account_File_Policy_Transactions extends EPC_Account_Methods
{
    public static Account_File_Policy_Transactions instance = new Account_File_Policy_Transactions();

    public void clickFirstPolicyInTransactionMenu() {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@id = 'AccountFile_WorkOrders:AccountFile_WorkOrdersScreen:AccountWorkOrdersLV-body']//tr[1]//td[2]//a");
    }
}

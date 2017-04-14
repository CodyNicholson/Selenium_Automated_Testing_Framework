package WebpageMethods.EPC_Methods;

import WebpageMethods.EPC_Methods.Account_Methods.*;
import WebpageMethods.EPC_Methods.Desktop_Methods.EPC_Desktop_Methods;
import WebpageMethods.EPC_Methods.Desktop_Methods.My_Activities;
import WebpageMethods.EPC_Methods.Search_Methods.EPC_Search_Methods;
import WebpageMethods.EPC_Methods.Search_Methods.Search_Accounts;
import WebpageMethods.EPC_Methods.Search_Methods.Search_EPC_Policies;
import WebpageMethods.Methods_Overlord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;

/**
 * Created by cad6025 on 2/9/2017.
 */
public class _EPC_Master_Methods extends Methods_Overlord
{
    public EPC_Desktop_Methods Desktop = EPC_Desktop_Methods.instance;
    public EPC_Account_Methods Account = EPC_Account_Methods.instance;
    public EPC_Search_Methods Search = EPC_Search_Methods.instance;
    public My_Activities My_Activities_Page = My_Activities.instance;
    public Account_File_Documents Account_File_Documents_Page = Account_File_Documents.instance;
    public Search_Accounts Search_Accounts_Page = Search_Accounts.instance;
    public Search_EPC_Policies Search_EPC_Policies_Page = Search_EPC_Policies.instance;
    public Account_File_Summary Account_File_Summary_Page = Account_File_Summary.instance;
    public Account_File_Policy_Transactions Account_File_Policy_Transactions_Page = Account_File_Policy_Transactions.instance;
    public PreQualification_Questions PreQualification_Questions_Page = PreQualification_Questions.instance;

    public void clickSearchTab()
    {
        user.waitForElement("//span[@id='TabBar:SearchTab-btnInnerEl']");

        try {
            driver.findElement(By.xpath("//span[@id='TabBar:SearchTab-btnInnerEl']")).click();
        }
        catch (WebDriverException e)
        {
            user.waitFor(2);
            clickSearchTab();
        }
    }
}

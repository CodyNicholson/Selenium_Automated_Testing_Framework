package WebpageMethods.EPC_Methods.Search_Methods;

/**
 * Created by cad6025 on 2/6/2017.
 */

import WebpageMethods.EPC_Methods.Policy_Methods.Policies_Methods;
import WebpageMethods.EPC_Methods._EPC_Master_Methods;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class EPC_Search_Methods extends _EPC_Master_Methods
{
    public static EPC_Search_Methods instance = new EPC_Search_Methods();
    public Policies_Methods Policies = Policies_Methods.instance;

    public void clickSearchTabDropDown()
    {
        user.waitForElement("//a[@id='TabBar:SearchTab']");
        try {
            driver.findElement(By.xpath("//a[@id='TabBar:SearchTab']")).click();
        }
        catch (WebDriverException e)
        {
            waitFor(1);
            driver.findElement(By.xpath("//a[@id='TabBar:SearchTab']")).click();
        }
    }

    public void clickSearchTab()
    {
        user.waitForElement("//span[@id='TabBar:SearchTab-btnInnerEl']");
        try {
            user.driver.findElement(By.xpath("//span[@id='TabBar:SearchTab-btnInnerEl']")).click();
        }
        catch (WebDriverException e)
        {
            user.waitFor(2);
            clickSearchTab();
        }
    }

    public void clickFirstPolicyOnSearchResults()
    {
        user.waitForElement("//*[@id='PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:CNAPolicySearch_ResultsLV:0:PolicyNumber']");
        user.driver.findElement(By.xpath("//*[@id='PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:CNAPolicySearch_ResultsLV:0:PolicyNumber']")).click();
    }

    public void clickPolicyInfoOnPolicyContractMenu()
    {
        user.waitForElement("//td[@id='PolicyFile:PolicyFileAcceleratedMenuActions:PolicyMenuItemSet:PolicyMenuItemSet_PolicyInfo']//span[text()='Policy Info']");
        user.driver.findElement(By.xpath("//td[@id='PolicyFile:PolicyFileAcceleratedMenuActions:PolicyMenuItemSet:PolicyMenuItemSet_PolicyInfo']//span[text()='Policy Info']")).click();
    }

    public void setAccountNumAndSearchInPolicySearch(String accountNum)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//input[@id='PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearchDV:AccountNumber-inputEl']");
        user.driver.findElement(By.xpath("//input[@id='PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearchDV:AccountNumber-inputEl']")).sendKeys(accountNum);
        waitForElementToBeDisplayedAndClickableThenClick("//a[@class='bigButton'][@id='PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search']");
    }

    public void setAccountNumAndSearchInAccountSearch(String accountNum)
    {
        // Enter account number in search criteria
        user.waitForElement("//input[@id = 'AccountSearch:AccountSearchScreen:CNAAccountSearchDV:AccountNumber-inputEl']");
        driver.findElement(By.xpath("//input[@id = 'AccountSearch:AccountSearchScreen:CNAAccountSearchDV:AccountNumber-inputEl']")).click();
        driver.findElement(By.xpath("//input[@id = 'AccountSearch:AccountSearchScreen:CNAAccountSearchDV:AccountNumber-inputEl']")).clear();
        driver.findElement(By.xpath("//input[@id = 'AccountSearch:AccountSearchScreen:CNAAccountSearchDV:AccountNumber-inputEl']")).sendKeys(accountNum);

        // Search
        waitForElement("//a[@class = 'bigButton'][@id = 'AccountSearch:AccountSearchScreen:CNAAccountSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search']");
        driver.findElement(By.xpath("//a[@class = 'bigButton'][@id = 'AccountSearch:AccountSearchScreen:CNAAccountSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search']")).click();

    }

    public void clickAccountsInSearch()
    {
        driver.findElement(By.xpath("//tbody//tr//td//span[text()='Accounts']")).click();
    }

    public void clickAccountNumberForPolicyInSearchResults(String accountNum)
    {
        user.waitForElement("//tbody[starts-with(@id,'gridview')]//a[text()='" + accountNum + "']");
        driver.findElement(By.xpath("//tbody[starts-with(@id,'gridview')]//a[text()='" + accountNum + "']")).click();
        user.waitForElement("//span[@id='AccountFile_Summary:AccountFile_SummaryScreen:ttlBar']");
    }

    public void setPolicyNumAndSearchInAccountsSearch(String policyNum)
    {
        driver.findElement(By.xpath("//tr[@role='presentation']//input[@name='AccountSearch:AccountSearchScreen:CNAAccountSearchDV:cnaPolicyNumber']")).sendKeys(policyNum);
        waitForElementToBeDisplayedAndClickableThenClick("//tr[@role='presentation']//a[@class='bigButton'][@id='AccountSearch:AccountSearchScreen:CNAAccountSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search']");
    }

    public String getUSDotNumberPolicyInfoEPC()
    {
        user.isElementPresent("//div[@id = 'PolicyFile_PolicyInfo:PolicyFile_PolicyInfoScreen:PolicyFile_PolicyInfoDV:AccountInfoInputSet:CNAOfficialIDInputSet:USDOTNumberID-inputEl']");
        return user.driver.findElement(By.xpath("//div[@id = 'PolicyFile_PolicyInfo:PolicyFile_PolicyInfoScreen:PolicyFile_PolicyInfoDV:AccountInfoInputSet:CNAOfficialIDInputSet:USDOTNumberID-inputEl']")).getText();
    }

    public void clickSearchInAccountsSearch()
    {
        try
        {
            driver.findElement(By.xpath("//tbody[@role='presentation']//tr//td//a[@id='AccountSearch:AccountSearchScreen:CNAAccountSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search']")).click();
        }
        catch (WebDriverException e){}
    }

    public void clickFirstAccountNumberInAccountsPageSearchResults()
    {
        driver.findElement(By.xpath("//table[starts-with(@id,'gridview')]//tbody//tr[1]//td[2]//a")).click();
    }

    public void clickFirstAccountNumberOnSearchPolicyPageResults()
    {
        waitForElement("//table[starts-with(@id,'gridview')]//tbody//tr[1]//td[3]//a");
        driver.findElement(By.xpath("//table[starts-with(@id,'gridview')]//tbody//tr[1]//td[3]//a")).click();
    }

    public void clickFirstAccountNumberOnSearchAccountPageResults()
    {
        waitForElement("//table[starts-with(@id, 'gridview')]//tbody//tr[1]//td[2]//a");
        driver.findElement(By.xpath("//table[starts-with(@id, 'gridview')]//tbody//tr[1]//td[2]//a")).click();
    }

    public void setAccountNumAndSearchInAccountsSearch(String accountNum)
    {
        waitForElement("//input[@id='AccountSearch:AccountSearchScreen:CNAAccountSearchDV:AccountNumber-inputEl']");
        try {
            driver.findElement(By.xpath("//input[@id='AccountSearch:AccountSearchScreen:CNAAccountSearchDV:AccountNumber-inputEl']")).sendKeys(accountNum);
            driver.findElement(By.xpath("//tr[@role='presentation']//a[@class='bigButton'][@id='AccountSearch:AccountSearchScreen:CNAAccountSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search']")).click();
        }catch(Exception e){
            waitForElement("//input[@id='AccountSearch:AccountSearchScreen:CNAAccountSearchDV:AccountNumber-inputEl']");
            driver.findElement(By.xpath("//input[@id='AccountSearch:AccountSearchScreen:CNAAccountSearchDV:AccountNumber-inputEl']")).sendKeys(accountNum);
            driver.findElement(By.xpath("//tr[@role='presentation']//a[@class='bigButton'][@id='AccountSearch:AccountSearchScreen:CNAAccountSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search']")).click();
        }
    }

    public boolean isPolicyPresentInSearchResults(String policyNum)
    {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        try
        {
            driver.findElement(By.xpath("//tbody[starts-with(@id,'gridview')]//a[text()='" + policyNum + "']"));
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
        return true;
    }

    public void clickAccountsTabOnSearchSidePanel()
    {
        waitForElement("//div[@id = 'Search:MenuLinks-body']//tr[2]");
        driver.findElement(By.xpath("//div[@id = 'Search:MenuLinks-body']//tr[2]")).click();
    }
}

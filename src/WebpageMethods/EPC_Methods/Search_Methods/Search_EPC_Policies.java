package WebpageMethods.EPC_Methods.Search_Methods;

import WebpageMethods.EPC_Methods._EPC_Master_Methods;
import org.openqa.selenium.By;

/**
 * Created by CAD5124 on 3/31/2017.
 */
public class Search_EPC_Policies extends _EPC_Master_Methods
{
    public static Search_EPC_Policies instance = new Search_EPC_Policies();

    public void clickSearchButton() {
        waitForElementToBeDisplayedAndClickableThenClick("//a[@class = 'bigButton'][text() = 'earch']");
    }

    public void clickAccountsInSearch()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//tbody//tr//td//span[text()='Accounts']");
    }

    public void setPolicyNumAndSearchInAccountsSearch(String policyNum)
    {
        driver.findElement(By.xpath("//tr[@role='presentation']//input[@name='AccountSearch:AccountSearchScreen:CNAAccountSearchDV:cnaPolicyNumber']")).sendKeys(policyNum);
        waitForElementToBeDisplayedAndClickableThenClick("//tr[@role='presentation']//a[@class='bigButton'][@id='AccountSearch:AccountSearchScreen:CNAAccountSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search']");
    }

    public void clickAccountNumberForPolicyInSearchResults(String accountNum)
    {
        user.waitForElement("//tbody[starts-with(@id,'gridview')]//a[text()='" + accountNum + "']");
        driver.findElement(By.xpath("//tbody[starts-with(@id,'gridview')]//a[text()='" + accountNum + "']")).click();
        user.waitForElement("//span[@id='AccountFile_Summary:AccountFile_SummaryScreen:ttlBar']");
    }

    public void clickAccountInResults(String accountNumber) {
        waitForElementToBeDisplayedAndClickableThenClick("//tbody[starts-with(@id,'gridview')] //a[text()= '" + accountNumber+ "']");
    }

    public void enterPolicyNumber(String policyNumber) {
        driver.findElement(By.xpath("//input[@id = 'PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearchDV:PolicyNumberCriterion-inputEl']")).sendKeys(policyNumber);
    }

    public void enterAccountNumber(String accountNumber)
    {
        driver.findElement(By.xpath("//input[@id = 'AccountSearch:AccountSearchScreen:CNAAccountSearchDV:AccountNumber-inputEl']")).sendKeys(accountNumber);
    }

    public void clickResetButton()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//a[@class = 'bigButton'][text() = 'eset']");
    }
}

package WebpageMethods.EPC_Methods.Policy_Methods;

import WebpageMethods.EPC_Methods.Search_Methods.EPC_Search_Methods;
import org.openqa.selenium.By;

/**
 * Created by cad6025 on 3/17/2017.
 */
public class Policies_Methods extends EPC_Search_Methods {
    public static Policies_Methods instance = new Policies_Methods();

    public void enterAccountNumber(String accountNumber)
    {
        driver.findElement(By.xpath("//input[@id = 'AccountSearch:AccountSearchScreen:CNAAccountSearchDV:AccountNumber-inputEl']")).sendKeys(accountNumber);
    }

    public void enterPolicyNumber(String policyNumber)
    {
        driver.findElement(By.xpath("//input[@id = 'PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearchDV:PolicyNumberCriterion-inputEl']")).sendKeys(policyNumber);
    }

    public void clickSearchButton()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//a[@class = 'bigButton'][text() = 'earch']");
    }

    public void clickResetButton()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//a[@class = 'bigButton'][text() = 'eset']");
    }

    public void clickAccountInResults(String accountNumber)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//tbody[starts-with(@id,'gridview')] //a[text()= '" + accountNumber+ "']");
    }
}

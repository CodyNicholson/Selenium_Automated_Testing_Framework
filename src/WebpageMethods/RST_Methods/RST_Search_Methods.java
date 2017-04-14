package WebpageMethods.RST_Methods;

/**
 * Created by cad6025 on 2/6/2017.
 */

import org.openqa.selenium.*;

public class RST_Search_Methods extends _RST_Master_Methods{

    public static RST_Search_Methods instance = new RST_Search_Methods();

    public void setAccountNumAndSearchInPolicyAndAccount(String accountNumber)
    {
        waitForElement("//table[@id='basicTable']//tbody//tr[1]//td[2]//input[@name='ACCOUNT_NUMBER']", 5);
        driver.findElement(By.xpath("//table[@id='basicTable']//tbody//tr[1]//td[2]//input[@name='ACCOUNT_NUMBER']")).sendKeys(accountNumber);
        driver.findElement(By.xpath("//table[@id='basicTable']//img[@alt='Find']")).click();
    }

    public void clickFirstAccountNumInPolicyAccountSearchResults()
    {
        waitForElement("//*[@id='TABLE_11']/tbody/tr[2]/td[1]");
        driver.findElement(By.xpath("//*[@id='TABLE_11']/tbody/tr[2]/td[1]")).click();
    }

    public void clickAutoUnderLobSideNav()
    {
        waitForElement("//*[@id='Nav3']/a");
        driver.findElement(By.xpath("//*[@id='Nav3']/a")).click();
    }

    public String getUSDotNumberPolicyInfoRST()
    {
        isElementPresent("/*//*[@id='TABLE_59']/tbody/tr[1]/td");
        return driver.findElement(By.xpath("/*//*[@id='TABLE_59']/tbody/tr[1]/td")).getText();
    }
}

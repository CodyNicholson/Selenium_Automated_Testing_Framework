package Webpage_Methods.Portfolio_Website.Pages;

/**
 * Created by cad6025 on 2/6/2017.
 */

import Webpage_Methods.Portfolio_Website.Portfolio_Master;
import Webpage_Methods.Selenium_Master;
import org.openqa.selenium.By;

public class Resume extends Portfolio_Master {

    public static Resume instance = new Resume();

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

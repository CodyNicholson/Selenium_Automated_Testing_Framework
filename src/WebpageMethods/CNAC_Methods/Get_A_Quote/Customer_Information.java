package WebpageMethods.CNAC_Methods.Get_A_Quote;

import WebpageMethods.CNAC_Methods._CNAC_Master_Methods;
import org.openqa.selenium.By;

/**
 * Created by cad5124 on 3/30/2017.
 */
public class Customer_Information extends _CNAC_Master_Methods
{
    public static Customer_Information instance = new Customer_Information();

    public void setCustomerName(String customerName)
    {
        driver.findElement(By.xpath("//div[@id='mainformcontainer']//section[@ui-view='content']//form[@name='pageForm']//input[@name='customerName']")).sendKeys(customerName);
    }

    public void setMailingAddress(String mailingAddress)
    {
        driver.findElement(By.xpath("//div[@id='mainformcontainer']//section[@ui-view='content']//form[@name='pageForm']//input[@name='mailingAddress']")).sendKeys(mailingAddress);
    }

    public void setAddressLine2(String addressLine2)
    {
        driver.findElement(By.xpath("//div[@id='mainformcontainer']//section[@ui-view='content']//form[@name='pageForm']//input[@name='addressLine2']")).sendKeys(addressLine2);
    }

    public void setZipCode(String zipCode)
    {
        driver.findElement(By.xpath("//div[@id='mainformcontainer']//section[@ui-view='content']//form[@name='pageForm']//input[@name='zipCode']")).sendKeys(zipCode);
    }

    public void setCity(String city)
    {
        driver.findElement(By.xpath("//div[@id='mainformcontainer']//section[@ui-view='content']//form[@name='pageForm']//input[@name='city']")).sendKeys(city);
    }

    public void setPhoneNumber(String phoneNumber)
    {
        driver.findElement(By.xpath("//div[@id='mainformcontainer']//section[@ui-view='content']//form[@name='pageForm']//input[@name='phone']")).sendKeys(phoneNumber);
    }

    public void setEmailAddress(String emailAddress)
    {
        driver.findElement(By.xpath("//div[@id='mainformcontainer']//section[@ui-view='content']//form[@name='pageForm']//input[@name='emailaddress']")).sendKeys(emailAddress);
    }

    public void setFEIN(String FEIN)
    {
        driver.findElement(By.xpath("//div[@id='mainformcontainer']//section[@ui-view='content']//form[@name='pageForm']//input[@name='fein']")).sendKeys(FEIN);
    }

    public void selectState(String state)
    {
        driver.findElement(By.xpath("//div[@id='mainformcontainer']//section[@ui-view='content']//form[@name='pageForm']//select[@name='state']//option[@label='"+state+"']")).click();
    }

    public void clickNext()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//button[@id='submit']");
        if(isElementPresent("//form[@name='pageForm']//h3[text()='Matching Customer']"))
        {
            waitForElementToBeDisplayedAndClickableThenClick("//input[@data-ng-change='newCustomerFlg()']");
            waitForElementToBeDisplayedAndClickableThenClick("//button[@id='next']");
            waitFor(2);
        }
    }
}

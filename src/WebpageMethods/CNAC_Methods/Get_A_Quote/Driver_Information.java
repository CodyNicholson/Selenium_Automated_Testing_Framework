package WebpageMethods.CNAC_Methods.Get_A_Quote;

import WebpageMethods.CNAC_Methods._CNAC_Master_Methods;
import org.openqa.selenium.By;

/**
 * Created by cad5124 on 3/30/2017.
 */
public class Driver_Information extends _CNAC_Master_Methods
{
    public static Driver_Information instance = new Driver_Information();

    public void setFirstName(String firstName)
    {
        waitForElement("//input[@name='firstName']");
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);
    }

    public void setLastName(String lastName)
    {
        waitForElement("//input[@name='lastName']");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);
    }

    public void setDateOfBirth(String dateOfBirth)
    {
        waitForElement("//input[@name='date']");
        driver.findElement(By.xpath("//input[@name='date']")).sendKeys(dateOfBirth);
    }

    public void setGenderToMale()
    {
        driver.findElement(By.xpath("//input[@id='gender_Male']")).click();
    }

    public void setGenderToFemale()
    {
        driver.findElement(By.xpath("//input[@id='gender_Female']")).click();
    }

    public void setDriversLicenseNumber(String driversLicenseNumber)
    {
        waitForElement("//input[@name='drivingLicense']");
        driver.findElement(By.xpath("//input[@name='drivingLicense']")).sendKeys(driversLicenseNumber);
    }

    public void selectState(String state)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//select[@name='state']");
        driver.findElement(By.xpath("//select[@name='state']")).sendKeys(state);
    }

    public void clickNext()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//button[@id='gotoNext']");
    }
}

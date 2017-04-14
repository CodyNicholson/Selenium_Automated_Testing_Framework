package WebpageMethods.CNAC_Methods.Get_A_Quote;

import WebpageMethods.CNAC_Methods._CNAC_Master_Methods;
import org.openqa.selenium.By;

/**
 * Created by cad5124 on 3/30/2017.
 */
public class Vehicle_Information extends _CNAC_Master_Methods
{
    public static Vehicle_Information instance = new Vehicle_Information();

    public void setClass(String vehicleClass)
    {
        waitForElement("//input[@name='classCode']");
        sendTextToElement("//input[@name='classCode']", vehicleClass);
    }

    public void setVIN(String vin)
    {
        waitForElement("//input[@name='vin']");
        sendTextToElement("//input[@name='vin']", vin);
    }

    public void clickSearchVin()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//button[@data-ng-click='searchVIN()']");
        waitFor(4);
    }

    public void setMake(String vehicleClass)
    {
        waitForElement("//input[@name='classCode']");
        sendTextToElement("//input[@name='classCode']", vehicleClass);
    }

    public void setYear(String vehicleClass)
    {
        waitForElement("//input[@name='classCode']");
        sendTextToElement("//input[@name='classCode']", vehicleClass);
    }

    public void setCostNew(String vehicleClass)
    {
        waitForElement("//input[@name='classCode']");
        sendTextToElement("//input[@name='classCode']", vehicleClass);
    }

    public void setWhoIsVehicleTitledTo(String whoIsVehicleTitledTo)
    {
        waitForElement("//input[@name='vehicleOwner']");
        sendTextToElement("//input[@name='vehicleOwner']", whoIsVehicleTitledTo);
    }

    public void setYesVehicleTitledToNamedInsured()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//input[@id='namedInsured_yes']");
    }

    public void setNoVehicleTitledToNamedInsured()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//input[@id='namedInsured_No']");
    }

    public void setYesVehicleIsHiredAuto()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//input[@id='hiredAutoType_yes']");
    }

    public void setNoVehicleIsNotHiredAuto()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//input[@id='hiredAutoType_No']");
    }

    public void clickNext()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//button[@id='gotoNext']");
    }
}

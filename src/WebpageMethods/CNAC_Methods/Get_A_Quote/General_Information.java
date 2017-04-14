package WebpageMethods.CNAC_Methods.Get_A_Quote;

import WebpageMethods.CNAC_Methods._CNAC_Master_Methods;
import org.openqa.selenium.By;

/**
 * Created by cad5124 on 3/30/2017.
 */
public class General_Information extends _CNAC_Master_Methods
{
    public static General_Information instance = new General_Information();

    public void selectLegalEntity(String legalEntity)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//select[@name='legalEntity']");
        sendTextToElement("//select[@name='legalEntity']",legalEntity);
    }

    public void setYearBusinessWasEstabilished(String year)
    {
        sendTextToElement("//input[@name='yearBusinessWasEst']", year);
    }

    public void setTotalNumberOfEmployees(String numberOfEmployees)
    {
        sendTextToElement("//input[@name='totalNoOfEmp']", numberOfEmployees);
    }

    public void setEffectiveDate(String effectiveDate)
    {
        sendTextToElement("//input[@name='effectiveDate']", effectiveDate);
    }

    public void setExpirationDate(String expirationDate)
    {
        sendTextToElement("//input[@name='expirationDate']", expirationDate);
    }

    public void clickYesLossesHaveOccuredThisYear()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//input[@name='haveLossesOccuredSince'][@value='yesLosses']");
    }

    public void clickNoLossesHaveNotOccuredThisYear()
    {
        waitFor(2);
        waitForElementToBeDisplayedAndClickableThenClick("//input[@name='haveLossesOccuredSince'][@value='noLosses']");
    }

    public void setLossValidationDate(String lossValidationDate)
    {
        sendTextToElement("//input[@name='lossValuatedDate']", lossValidationDate);
    }

    public void clickYesOwnedVehiclesNotInsured()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//input[@name='ownedVehUnInsured'][@value='true']");
    }

    public void clickNoOwnedVehiclesNotInsured()
    {
        waitFor(2);
        waitForElementToBeDisplayedAndClickableThenClick("//input[@name='ownedVehUnInsured'][@value='false']");
    }

    public void clickYesHiredAndNonOwnedOnlyPolicy()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//input[@name='hiredNonOwned'][@value='true']");
    }

    public void clickNoHiredAndNonOwnedOnlyPolicy()
    {
        waitFor(2);
        waitForElementToBeDisplayedAndClickableThenClick("//input[@name='hiredNonOwned'][@value='false']");
    }

    public void clickNext()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//button[@id='gotoNext']");
    }
}

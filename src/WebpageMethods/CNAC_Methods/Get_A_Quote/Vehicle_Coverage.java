package WebpageMethods.CNAC_Methods.Get_A_Quote;

import WebpageMethods.CNAC_Methods._CNAC_Master_Methods;
import org.openqa.selenium.By;

/**
 * Created by cad5124 on 3/30/2017.
 */
public class Vehicle_Coverage extends _CNAC_Master_Methods
{
    public static Vehicle_Coverage instance = new Vehicle_Coverage();

    public void selectUninsuredMotoristCoverageType(String coverageType)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//select[@name='covType']");
        sendTextToElement("//select[@name='covType']",coverageType);
        waitForElementToBeDisplayedAndClickableThenClick("//form[@name='vehCoverageFrm']");
    }

    public void selectSingleLimitUninsuredMotorist(String singleLimit)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//select[@name='uninsmotsingleLimit']");
        sendTextToElement("//select[@name='uninsmotsingleLimit']", singleLimit);
        waitForElementToBeDisplayedAndClickableThenClick("//form[@name='vehCoverageFrm']");
    }

    public void selectUnderinsuredMotoristCoverageType(String coverageType)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//select[@name='UIMCovType']");
        sendTextToElement("//select[@name='UIMCovType']", coverageType);
        waitForElementToBeDisplayedAndClickableThenClick("//form[@name='vehCoverageFrm']");
    }

    public void selectSingleLimitUnderinsuredMotorist(String singleLimit)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//select[@name='uimSingleLimit']");
        sendTextToElement("//select[@name='uimSingleLimit']", singleLimit);
        waitForElementToBeDisplayedAndClickableThenClick("//form[@name='vehCoverageFrm']");
    }

    public void clickNext()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//button[@id='submit']");
    }
}

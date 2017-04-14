package WebpageMethods.CNAC_Methods.Get_A_Quote;

import WebpageMethods.CNAC_Methods._CNAC_Master_Methods;

/**
 * Created by cad5124 on 3/30/2017.
 */
public class Policy_Coverage extends _CNAC_Master_Methods
{
    public static Policy_Coverage instance = new Policy_Coverage();

    public void selectLiabilityCoverage(String liabilityCoverage)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//select[@name='selectLiability']");
        sendTextToElement("//select[@name='selectLiability']",liabilityCoverage);
        waitForElementToBeDisplayedAndClickableThenClick("//form[@name='pageForm']");
    }

    public void selectSingleLimitForLiabilityCoverage(String singleLimit)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//select[@name='singleLimit']");
        sendTextToElement("//select[@name='singleLimit']",singleLimit);
        waitForElementToBeDisplayedAndClickableThenClick("//form[@name='pageForm']");
    }

    public void toggleHiredAutoCoverage()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//input[@name='hiredAuto']");
    }

    public void selectStateForHiredAutoCoverage(String state)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//select[@name='selectState']");
        sendTextToElement("//select[@name='selectState']",state);
        waitForElementToBeDisplayedAndClickableThenClick("//form[@name='pageForm']");
    }

    public void selectUninsuredMotoristCoverageForHiredAuto(String coverage)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//select[@name='uninsuredHired']");
        sendTextToElement("//select[@name='uninsuredHired']",coverage);
        waitForElementToBeDisplayedAndClickableThenClick("//form[@name='pageForm']");
    }

    public void selectUnderinsuredMotoristCoverageForHiredAuto(String coverage)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//select[@name='underinsuredHired']");
        sendTextToElement("//select[@name='underinsuredHired']",coverage);
        waitForElementToBeDisplayedAndClickableThenClick("//form[@name='pageForm']");
    }

    public void selectSingleLimitUnderinsuredMotoristForHiredAuto(String coverage)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//select[@name='underinsuredHiredSingleLimit']");
        sendTextToElement("//select[@name='underinsuredHiredSingleLimit']",coverage);
        waitForElementToBeDisplayedAndClickableThenClick("//form[@name='pageForm']");
    }

    public void selectSingleLimitUninsuredMotoristForHiredAuto(String coverage)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//select[@name='uninsuredHiredSingleLimit']");
        sendTextToElement("//select[@name='uninsuredHiredSingleLimit']",coverage);
        waitForElementToBeDisplayedAndClickableThenClick("//form[@name='pageForm']");
    }

    public void toggleIfAnyForHiredAutoCoverage()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//input[@id='stateLiable_ifany']");
    }

    public void toggleCostOfHireForHiredAutoCoverage()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//input[@id='stateLiable_costhire']");
    }

    public void clickSaveForHiredAutoCoverage()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//button[@id='saveHiredAuto']");
    }

    public void toggleNonOwnedAutoCoverage()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//input[@name='nonOwnedAuto']");
    }

    public void selectUnderinsuredMotoristNonOwnedAutoCoverage(String coverage)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//select[@name='uninsured']");
        sendTextToElement("//select[@name='uninsured']",coverage);
        waitForElementToBeDisplayedAndClickableThenClick("//form[@name='pageForm']");
    }

    public void selectSingleLimitForUninsuredMotoristNonOwnedAutoCoverage(String singleLimit)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//select[@name='uninsuredSingleLimit']");
        sendTextToElement("//select[@name='uninsuredSingleLimit']",singleLimit);
        waitForElementToBeDisplayedAndClickableThenClick("//form[@name='pageForm']");
    }

    public void selectSingleLimitForUnderinsuredMotoristNonOwnedAutoCoverage(String singleLimit)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//select[@name='underinsuredSingleLimit']");
        sendTextToElement("//select[@name='underinsuredSingleLimit']",singleLimit);
        waitForElementToBeDisplayedAndClickableThenClick("//form[@name='pageForm']");
    }

    public void toggleBroadFormEndorsementPlus()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//input[@name='broadForm']");
    }

    public void toggleDriveOtherCar()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//input[@name='doc']");
    }

    public void clickNext()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//button[@id='gotoNext']");
    }
}

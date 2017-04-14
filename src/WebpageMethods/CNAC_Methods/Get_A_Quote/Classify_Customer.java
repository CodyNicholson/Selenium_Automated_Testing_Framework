package WebpageMethods.CNAC_Methods.Get_A_Quote;

import WebpageMethods.CNAC_Methods._CNAC_Master_Methods;

/**
 * Created by cad5124 on 3/30/2017.
 */
public class Classify_Customer extends _CNAC_Master_Methods
{
    public static Classify_Customer instance = new Classify_Customer();

    public void setSicCodeOrDescription(String sicCodeOrDescription)
    {
        sendTextToElement("//form[@name='pageForm']//input[@name='sic']", sicCodeOrDescription);
    }

    public void selectPrimaryRiskState(String state)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//form[@name='pageForm']//select[@name='state']//option[@label='"+state+"']");
    }

    public void clickSearch()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//form[@name='pageForm']//div//img[@class='hand_cur'][@ng-click='Search_clicked()']");
    }

    public boolean isCommercialAutomobileChecked()
    {
        return isSelected("//input[@id='id_autoStatus']");
    }

    public void toggleCommercialAutomobile()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//input[@id='id_autoStatus']");
    }

    public void clickQuoteButtonAtTopOfList()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//form[@name='pageForm']//div[@id='tbody']//div[1]//div[@class='divElementVertAlign']//img");
    }
}

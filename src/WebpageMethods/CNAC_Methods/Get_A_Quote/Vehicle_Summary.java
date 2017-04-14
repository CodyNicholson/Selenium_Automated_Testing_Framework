package WebpageMethods.CNAC_Methods.Get_A_Quote;

import WebpageMethods.CNAC_Methods._CNAC_Master_Methods;

/**
 * Created by cad5124 on 3/30/2017.
 */
public class Vehicle_Summary extends _CNAC_Master_Methods
{
    public static Vehicle_Summary instance = new Vehicle_Summary();

    public void waitForPremium()
    {
        waitForElementToBeDisplayed("//div[@ng-show='showpremium']//label[@class='control-label premium2 ng-binding']", 60);
        waitFor(2);
    }

    public void clickNext()
    {
        waitFor(2); // sometimes button displays but is not enabled for a small amount of time
        waitForElementToBeDisplayedAndClickableThenClick("//button[@id='gotoNext']");
    }
}

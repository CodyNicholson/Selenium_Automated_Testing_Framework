package WebpageMethods.CNAC_Methods.Get_A_Quote;

import WebpageMethods.CNAC_Methods._CNAC_Master_Methods;
import org.openqa.selenium.By;

/**
 * Created by cad5124 on 3/30/2017.
 */
public class Premium extends _CNAC_Master_Methods
{
    public static Premium instance = new Premium();

    public String getPremium()
    {
        String premium = getTextFromElement("//div[@ng-show='showpremium']//label[@class='control-label premium2 ng-binding']").trim();
        printLogMessage("Premium: "+premium);
        return premium;
    }

    public void clickNext()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//button[@id='gotoNext']");
    }
}

package WebpageMethods.CNAC_Methods.Get_A_Quote;

import WebpageMethods.CNAC_Methods._CNAC_Master_Methods;

/**
 * Created by cad5124 on 3/30/2017.
 */
public class Product_Selection extends _CNAC_Master_Methods
{
    public static Product_Selection instance = new Product_Selection();

    public void toggleCommercialAutomobile()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//form[@name='pageForm']//input[@id='autoStatus']");
    }

    public void clickNext()
    {
        waitFor(2); // wait for Commercial Automobile to be checked automatically
        waitForElementToBeDisplayedAndClickableThenClick("//form[@name='pageForm']//button[@id='submit']");
    }
}

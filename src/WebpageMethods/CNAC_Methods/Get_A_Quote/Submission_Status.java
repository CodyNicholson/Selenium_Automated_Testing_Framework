package WebpageMethods.CNAC_Methods.Get_A_Quote;

import WebpageMethods.CNAC_Methods._CNAC_Master_Methods;
import org.openqa.selenium.By;

/**
 * Created by cad5124 on 3/30/2017.
 */
public class Submission_Status extends _CNAC_Master_Methods
{
    public static Submission_Status instance = new Submission_Status();

    public boolean isPremiumCorrectOnSubmissionStatus(String oldPremium)
    {
        waitForElementToBeDisplayed("//table[@id='product']//div[@align='right']");
        String premium = getTextFromElement("//table[@id='product']//div[@align='right']").trim();
        printLogMessage("Submission Status Premium: "+premium+", Old Premium: "+oldPremium);
        return premium.equals(oldPremium);
    }

    public String getQuoteStatus()
    {
        String quoteStatus = getTextFromElement("//span[@id='desc_Auto']");
        printLogMessage("Quote Status: "+quoteStatus);
        return quoteStatus;
    }

    public void switchToMainIFrame() {
        switchToDefaultContext();
        waitForElement("//frameset//frameset//frame[@name='main']"); //ASDFASDFASFSDF
        switchToIFrame("//frameset//frameset//frame[@name='main']");
    }

    public void clickGo()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//img[@src='../images/buttons/streamline/Go.png']/..");
    }
}

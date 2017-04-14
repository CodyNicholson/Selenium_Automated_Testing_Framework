package WebpageMethods.CNAC_Methods.Get_A_Quote;

import WebpageMethods.CNAC_Methods._CNAC_Master_Methods;
import org.openqa.selenium.By;

/**
 * Created by cad5124 on 3/30/2017.
 */
public class General_UW_Statements extends _CNAC_Master_Methods
{
    public static General_UW_Statements instance = new General_UW_Statements();

    public void switchToBannerFrame()
    {
        switchToDefaultContext();
        waitForElement("//frame[@name='banner']");
        switchToDefaultContext();
    }

    public void switchToMainFrame()
    {
        switchToDefaultContext();
        waitForElement("//frame[@name='main']");
        switchToIFrame("main");
    }

    public String getSubmissionNumberFromBanner()
    {
        String submissionNumber = getTextFromElement("//div[@id='main']//span[@id='right_top_banner']").substring(14);
        printLogMessage("Submission num: " + submissionNumber);
        return submissionNumber;
    }

    public String getQuoteNumberFromBanner()
    {
        String quoteNumber = getTextFromElement("//div[@id='main']//span[@id='right_middle_banner']").substring(9);
        printLogMessage("Quote num: " + quoteNumber);
        return quoteNumber;
    }

    public void clickAccept()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//table[@id='uwstmt1']//table[@width='800']//img[@src='../images/buttons/streamline/Accept.png']");
    }
}

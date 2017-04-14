package WebpageMethods.CNAC_Methods;

import WebpageMethods.CNAC_Methods.Get_A_Quote.*;
import WebpageMethods.Methods_Overlord;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by CAD5124 on 3/9/2017.
 */
public class _CNAC_Master_Methods extends Methods_Overlord
{
    public General_Information General_Information_Page = General_Information.instance;
    public Driver_Information Driver_Information_Page = Driver_Information.instance;
    public Classify_Customer Classify_Customer_Page = Classify_Customer.instance;
    public Customer_Information Customer_Information_Page = Customer_Information.instance;
    public Policy_Coverage Policy_Coverage_Page = Policy_Coverage.instance;
    public Vehicle_Information Vehicle_Information_Page = Vehicle_Information.instance;
    public Vehicle_Coverage Vehicle_Coverage_Page = Vehicle_Coverage.instance;
    public Vehicle_Summary Vehicle_Summary_Page = Vehicle_Summary.instance;
    public Premium Premium_Page = Premium.instance;
    public Submission_Status Submission_Status_Page = Submission_Status.instance;
    public Product_Selection Product_Selection_Page = Product_Selection.instance;
    public General_UW_Statements General_UW_Statements_Page = General_UW_Statements.instance;

    public void clickHome()
    {
        waitForPageToLoad(6);
        try
        {
            waitForElementToBeDisplayedAndClickableThenClick("//a//span[@class='sitetools-old'][text()='Home']");
        }
        catch(NoSuchElementException e)
        {
            waitForElementToBeDisplayedAndClickableThenClick("//a//span[@class='sitetools-new'][text()='Home']");
        }
        waitForPageToLoad(6);
    }

    public void clickFeedback()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//a//span[starts-with(@class,'sitetools')][text()='Feedback']");
    }

    public void clickLogout()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//a//span[starts-with(@class,'sitetools')][text()='Logout']");
    }

    public void clickGetAQuote()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@id='streamlineQuoting']");
        if (isElementPresent("//form[@name='loginForm']"))
        {
            loginEPC("Epc02");
            waitForPageToLoad(10);
        }
        waitForElement("//form[@name='pageForm']");
    }

    public void clickEndorsePolicy()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[text()='Work In Process']");
    }

    public void clickWorkInProgress()
    {
        waitForPageToLoad(6);
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@id='endpol']");
    }

    public void clickServiceMyAccounts()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@id='one']");
    }

    public void clickReferenceCenter()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@id='one1']");
    }

    public void clickSupportTools()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@id='one2']");
    }

    public void clickMyProfile()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@id='one3']");
    }

    public void clickContactUs()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@id='one4']");
    }

    public void clickPolicyInquiryInServiceMyAccounts()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@id='policy']");
    }

    public void clickElectronicDocumentDeliveryInServiceMyAccounts()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@id='electronic']");
    }

    public void clickBillingInformationInServiceMyAccounts()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@id='billing']");
    }

    public void clickSmallBusinessAppetiteInReferenceCenter()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@class='Option'][text()='Small Business Appetite']");
    }

    public void clickFormnetLibraryInReferenceCenter()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@class='Option'][text()='Formnet Library']");
    }

    public void clickAutomationSolutionsInReferenceCenter()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@class='Option'][text()='Automation Solutions']");
    }

    public void clickSupplementalApplicationsInReferenceCenter()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@class='Option'][text()='Supplemental Applications']");
    }

    public void clickAgentCenterInReferenceCenter()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@class='Option'][text()='Agent Center']");
    }

    public void clickTutorialsInReferenceCenter()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@class='Option'][text()='Tutorials']");
    }

    public void clickCnaInternationalInReferenceCenter()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@class='Option'][text()='CNA International']");
    }

    public void clickOceanCargoInReferenceCenter()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@class='Option'][text()='Ocean Cargo']");
    }

    public void clickProfessionalServicesInReferenceCenter()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@class='Option'][text()='Professional Services']");
    }

    public void clickRiskControlInReferenceCenter()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@class='Option'][text()='Risk Control']");
    }

    public void clickMoreInfoAboutCnaSmallBusinessServiceCenterInReferenceCenter()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@class='OptionS'][text()='More about the CNA Small Business Service Center']");
    }

    public void clickEnrollInCnaSmallBusinesServiceCenterInReferenceCenter()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@class='OptionS'][text()='Enroll in the CNA Small Business Service Center']");
    }

    public void clickUmUimStateFormsInReferenceCenter()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@class='Option'][text()='UM/UIM State Forms']");
    }

    public void clickCoveragePlaybookInSupportTools()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@id='playbook']");
    }

    public void clickItvCalculatorInSupportTools()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@id='itv']");
    }

    public void clickVinLookupSupportTools()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@id='vin']");
    }

    public void clickExposureBasedDefinitionInSupportTools()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@id='exposure']");
    }

    public void clickProfileGuideInSupportTools()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@id='profileguide']");
    }

    public void clickProfileGuideUpdatesInSupportTools()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@id='update']");
    }

    public void clickWhoIsMyAdminInMyProfile()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[text()='Who is My Administrator ?']");
    }

    public void clickViewProfileInMyProfile()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[text()='View Profile']");
    }

    public void clickEditProgileInMyProfile()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[text()='Edit Profile']");
    }

    public void clickChangePasswordInMyProfile()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[text()='Change Password']");
    }

    public void clickSecurityAdminInMyProfile()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[text()='Security Admin']");
    }

    public void clickContactListInContactUs()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@id='clist']");
    }

    public void clickCustomerSupportInContactUs()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@title='Navigation']//a[@id='custSprt']");
    }
}

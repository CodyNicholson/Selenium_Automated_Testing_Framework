package Applications;

import Applications.TestResultsGenerator.ExcelSpreadsheetCreator;
import Users.strategyContext;
import WebpageMethods.CNAC_Methods._CNAC_Master_Methods;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Cody on 4/13/2017.
 */
public class Portfolio_Website_Smoke_Test
{
  /********************************
    ***   Excel Sheet Variables   ***
    ********************************/

    private ExcelSpreadsheetCreator excelCreator = new ExcelSpreadsheetCreator();
    private String parentName = "CNAC_Smoke_Test";
    private String testName = "";
    private String failureDetails;
    private long runTime;
    private long totalRuntime;

    /****************************
    ***   Private variables   ***
    ****************************/

    private final _CNAC_Master_Methods CNAC_User = new _CNAC_Master_Methods();
    private final strategyContext strategy = new strategyContext();

    /****************
    ***   Tests   ***
    ****************/

    @Test
    public void testCnacSmokeTest()
    {
        String environmentUrl = "https://ete1-www.cnacentral.com/cnac/servlet/LoginServlet?html_page=%2F%2Fhtml%2F%2Fpublic_home.html";
        String userName = "qatest";
        String password = "changeme123";

        String sicCode = "34310";
        String state = "Illinois";
        String customerName = "Test42";
        String customerAddress = "525 South State Street";
        String customerAddressLine2 = "Mailbox #1125";
        String customerZipCode = "60605";
        String customerCity = "Chicago";
        String customerState = "Illinois";
        String customerPhoneNumber = "2243456789";
        String customerEmailAddress = "cody.nicholson@cna.com";

        String submissionNumber;
        String quoteNumber;
        String premium;
        String quoteStatus;

        String legalEntity = "Association";
        String yearBusinessWasEstablished = "1996";
        String totalNumberOfEmployees = "100";
        String effectiveDate = "03312017";
        String expirationDate = "03312018";
        String driverFirstName = "Cody";
        String driverLastName = "Nicholson";
        String driverBirthDate = "7281996";
        String driverLicenseNumber = "A23456789098";
        String driverState = "IL";
        String liabilityCoverage = "Combined Single Limit";
        String singleLimit = "1,000,000";
        String vehicleClass = "03199";
        String vehicleVIN = "1N6DD26S6WC369217";
        String vehicleOwner = "Cody Nicholson";

        String uninsuredMotoristCoverage = "Combined Single Limit";
        String uninsuredMotoristSingleLimit = "1,000,000";
        String underinsuredMotoristCoverage = "Combined Single Limit";
        String underinsuredMotoristSingleLimit = "1,000,000";

        // CNAC Home
        CNAC_User.goToCnacEnvAndLogin(environmentUrl, userName, password);
        CNAC_User.clickGetAQuote();

        // Classify Customer
        CNAC_User.Classify_Customer_Page.setSicCodeOrDescription(sicCode);
        CNAC_User.Classify_Customer_Page.selectPrimaryRiskState(state);
        CNAC_User.Classify_Customer_Page.toggleCommercialAutomobile();
        CNAC_User.Classify_Customer_Page.clickSearch();
        CNAC_User.Classify_Customer_Page.clickQuoteButtonAtTopOfList();

        // Customer info
        CNAC_User.Customer_Information_Page.setCustomerName(customerName);
        CNAC_User.Customer_Information_Page.setMailingAddress(customerAddress);
        CNAC_User.Customer_Information_Page.setAddressLine2(customerAddressLine2);
        CNAC_User.Customer_Information_Page.setZipCode(customerZipCode);
        CNAC_User.Customer_Information_Page.setCity(customerCity);
        CNAC_User.Customer_Information_Page.selectState(customerState);
        CNAC_User.Customer_Information_Page.setPhoneNumber(customerPhoneNumber);
        CNAC_User.Customer_Information_Page.setEmailAddress(customerEmailAddress);
        CNAC_User.Customer_Information_Page.clickNext();

        // Product selection
        CNAC_User.Product_Selection_Page.clickNext();
        CNAC_User.Product_Selection_Page.clickNext();
        CNAC_User.General_UW_Statements_Page.switchToBannerFrame();

        // Get Submission Number and Quote Number
        submissionNumber = CNAC_User.General_UW_Statements_Page.getSubmissionNumberFromBanner();
        quoteNumber = CNAC_User.General_UW_Statements_Page.getQuoteNumberFromBanner();

        CNAC_User.General_UW_Statements_Page.switchToMainFrame();
        CNAC_User.General_UW_Statements_Page.clickAccept();

        // General info page
        CNAC_User.General_Information_Page.selectLegalEntity(legalEntity);
        CNAC_User.General_Information_Page.setYearBusinessWasEstabilished(yearBusinessWasEstablished);
        CNAC_User.General_Information_Page.setTotalNumberOfEmployees(totalNumberOfEmployees);
        CNAC_User.General_Information_Page.setEffectiveDate(effectiveDate);
        CNAC_User.General_Information_Page.setExpirationDate(expirationDate);
        CNAC_User.General_Information_Page.clickNoLossesHaveNotOccuredThisYear();
        CNAC_User.General_Information_Page.clickNoOwnedVehiclesNotInsured();
        CNAC_User.General_Information_Page.clickNoHiredAndNonOwnedOnlyPolicy();
        CNAC_User.General_Information_Page.clickNext();

        // driver info page
        CNAC_User.Driver_Information_Page.setFirstName(driverFirstName);
        CNAC_User.Driver_Information_Page.setLastName(driverLastName);
        CNAC_User.Driver_Information_Page.setDateOfBirth(driverBirthDate);
        CNAC_User.Driver_Information_Page.setGenderToMale();
        CNAC_User.Driver_Information_Page.setDriversLicenseNumber(driverLicenseNumber);
        CNAC_User.Driver_Information_Page.selectState(driverState);
        CNAC_User.Driver_Information_Page.clickNext();

        // policy coverage page
        CNAC_User.Policy_Coverage_Page.selectLiabilityCoverage(liabilityCoverage);
        CNAC_User.Policy_Coverage_Page.selectSingleLimitForLiabilityCoverage(singleLimit);
        CNAC_User.Policy_Coverage_Page.;
        CNAC_User.Policy_Coverage_Page.clickNext();

        // vehicle info page
        CNAC_User.Vehicle_Information_Page.setClass(vehicleClass);
        CNAC_User.Vehicle_Information_Page.setVIN(vehicleVIN);
        CNAC_User.Vehicle_Information_Page.clickSearchVin();
        CNAC_User.Vehicle_Information_Page.setNoVehicleTitledToNamedInsured();
        CNAC_User.Vehicle_Information_Page.setNoVehicleIsNotHiredAuto();
        CNAC_User.Vehicle_Information_Page.setWhoIsVehicleTitledTo(vehicleOwner);
        CNAC_User.Vehicle_Information_Page.clickNext();

        // vehicle coverage page
        CNAC_User.Vehicle_Coverage_Page.selectUninsuredMotoristCoverageType(uninsuredMotoristCoverage);
        CNAC_User.Vehicle_Coverage_Page.selectSingleLimitUninsuredMotorist(uninsuredMotoristSingleLimit);
        CNAC_User.Vehicle_Coverage_Page.selectUnderinsuredMotoristCoverageType(underinsuredMotoristCoverage);
        CNAC_User.Vehicle_Coverage_Page.selectSingleLimitUnderinsuredMotorist(underinsuredMotoristSingleLimit);
        CNAC_User.Vehicle_Coverage_Page.clickNext();

        // vehicle summary page
        CNAC_User.Vehicle_Summary_Page.clickNext();
        CNAC_User.Vehicle_Summary_Page.waitForPremium();

        // Premium page
        premium = CNAC_User.Premium_Page.getPremium(); // Get Premium
        CNAC_User.Premium_Page.clickNext();

        // Submission status page
        // ER1
        failureDetails = "ER1: The premium displayed in the submission status page was not the same as the premium displayed on the premium page";
        Assert.assertTrue(CNAC_User.Submission_Status_Page.isPremiumCorrectOnSubmissionStatus(premium), failureDetails);

        quoteStatus = CNAC_User.Submission_Status_Page.getQuoteStatus();


    }

    /*******************************
     ***   Before / After setup   ***
     *******************************/

    @AfterTest void writeToExcelFile()
    {
        excelCreator.setTotalRuntime(Long.toString(totalRuntime));
        excelCreator.setClassName(getClass().getName());
        excelCreator.createTestResultsSpreadsheet();
	}

    @BeforeMethod public void message(Method method)
    {
        testName = method.getName();
    }

    @AfterMethod(alwaysRun = true) public void doThisAfter(ITestResult result) {
        runTime = ((result.getEndMillis() - result.getStartMillis()) / 1000);
        totalRuntime += runTime;
        excelCreator.getTestCaseRuntimes().add(Long.toString(runTime));
        excelCreator.getTestCaseNames().add(testName);
        excelCreator.getTestCaseParents().add(parentName);
        if(ITestResult.FAILURE == result.getStatus())
        {
            CNAC_User.takeScreenshot(testName);
            if (failureDetails.equals("")){
                excelCreator.getTestCaseResults().add("ER0: Never reached first check");
            }
            else{
                excelCreator.getTestCaseResults().add(failureDetails);
            }
        }
        else
        {
            excelCreator.getTestCaseResults().add("N/A");
        }
        failureDetails = "";
        //CNAC_User.closeBrowser();
    }
}

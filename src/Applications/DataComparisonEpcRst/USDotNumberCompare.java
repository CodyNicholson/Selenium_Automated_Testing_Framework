/*
 * Refactored by Joseph Walker (CAD6025), 2017
 */

package Applications.DataComparisonEpcRst;

/************************************
***       Import Statements       ***
************************************/

import Applications.TestResultsGenerator.ExcelSpreadsheetCreator;
import WebpageMethods.EPC_Methods._EPC_Master_Methods;

import WebpageMethods.RST_Methods._RST_Master_Methods;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class USDotNumberCompare //extends DmfTestCaseRunner
{

    /********************************
    ***   Excel Sheet Variables   ***
    ********************************/

    private static USDotNumberCompare usDot = new USDotNumberCompare();
    private String parentName;
    private long runTime;
    private long totalRuntime;
    private ExcelSpreadsheetCreator excelCreator = new ExcelSpreadsheetCreator();
    private String failureDetails;
    private String testName = "";
    /*******************************
    ***       Method Setup       ***
    *******************************/

    private final _EPC_Master_Methods EPC_User = new _EPC_Master_Methods();
    private final _RST_Master_Methods RST_User = new _RST_Master_Methods();

    /************************************
    ***       Private Variables       ***
    ************************************/

    /***************
    ***   Test   ***
    ***************/

    @Test
    void testCompareEteAndRstPolicies()
    {
        parentName = "B-30875";

        /**********************************
         ***       Moving into ETE       ***
         **********************************/

        // Login to Ete
        EPC_User.goToEpcEnvAndLogin("https://ete6-papc.cna.com/pc/PolicyCenter.do", "Epc02");

        // Use search tab
        EPC_User.Search.clickSearchTabDropDown();
        EPC_User.Search.setAccountNumAndSearchInPolicySearch("5600890400");

        // Click policy
        EPC_User.Search.clickFirstPolicyOnSearchResults();
        EPC_User.Search.clickPolicyInfoOnPolicyContractMenu();

        //ER_1
        String expectedValue = "1649992";
        String actualValue = EPC_User.Search.getUSDotNumberPolicyInfoEPC();
        failureDetails = "ER1: The USDOT number was incorrect on the policy information page for ETE. The expected value was " + expectedValue + ". The actual value was " + actualValue +".";
        Assert.assertTrue(actualValue.equals(expectedValue), failureDetails);

        /**********************************
         ***       Moving into RST_User       ***
         **********************************/

        // Login to Rst
        EPC_User.goToUrl("http://rstsu:rst123@ete4-app-node1-farm-was61.cna.com:30114/RSTWeb/rstAccount/accountSearch.jsp");

        //Search for account information
        RST_User.Search.setAccountNumAndSearchInPolicyAndAccount("5600890400");
        RST_User.Search.clickFirstAccountNumInPolicyAccountSearchResults();
        RST_User.Search.clickAutoUnderLobSideNav();

        //ER_2

        actualValue = RST_User.Search.getUSDotNumberPolicyInfoRST();
        failureDetails = "ER2: The USDot Number was Incorrect on the policy information page for RST_User. The expected value was " + expectedValue + ". The actual value was " + actualValue + ".";
        Assert.assertTrue(actualValue.contains(expectedValue), failureDetails);
    }

    /******************************************
     ***   EPC -> RST USDot Number Compare   ***
     ******************************************/

//    @Test(priority = 45)
//    public void testCompareEteAndRstPolicies()
//    {
//        parentName = "B-30875";
//
//        /**********************************
//         ***       Moving into ETE       ***
//         **********************************/
//
//        // Login to Ete
//        EPC_User.goToEpcEnvAndLogin("https://ete6-papc.cna.com/pc/PolicyCenter.do", "Epc02");
//
//        // Use search tab
//        EPC_User.Search.clickSearchTabDropDown();
//        EPC_User.Search.setAccountNumAndSearchInPolicySearch("5600890400");
//
//        // Click policy
//        EPC_User.Search.clickFirstPolicyOnSearchResults();
//        EPC_User.Search.clickPolicyInfoOnPolicyContractMenu();
//
//        //ER_1
//        String expectedValue = "1649992";
//        String actualValue = EPC_User.Search.getUSDotNumberPolicyInfoEPC();
//        failureDetails = "ER1: The USDOT number was incorrect on the policy information page for ETE. The expected value was " + expectedValue + ". The actual value was " + actualValue +".";
//        Assert.assertTrue(actualValue.equals(expectedValue), failureDetails);
//
//        /**********************************
//         ***       Moving into RST_User       ***
//         **********************************/
//
//        // Login to Rst
//        EPC_User.goToUrl("http://rstsu:rst123@ete4-app-node1-farm-was61.cna.com:30114/RSTWeb/rstAccount/accountSearch.jsp");
//
//        //Search for account information
//        RST_User.Search.setAccountNumAndSearchInPolicyAndAccount("5600890400");
//        RST_User.Search.clickFirstAccountNumInPolicyAccountSearchResults();
//        RST_User.Search.clickAutoUnderLobSideNav();
//
//        //ER_2
//
//        actualValue = RST_User.Search.getUSDotNumberPolicyInfoRST();
//        failureDetails = "ER2: The USDot Number was Incorrect on the policy information page for RST_User. The expected value was " + expectedValue + ". The actual value was " + actualValue + ".";
//        Assert.assertTrue(actualValue.contains(expectedValue), failureDetails);
//    }

    /*******************************
     ***   Before / After setup   ***
     *******************************/

    @AfterTest void writeToExcelFile()
    {
        excelCreator.setTotalRuntime(Long.toString(totalRuntime));
        excelCreator.setClassName(this.getClass().getName());
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
        if (ITestResult.FAILURE == result.getStatus())
        {
            EPC_User.takeScreenshot(testName);
            excelCreator.getTestCaseResults().add(failureDetails);
        }
        else
        {
            excelCreator.getTestCaseResults().add("N/A");
        }
        EPC_User.closeBrowser();
    }
}

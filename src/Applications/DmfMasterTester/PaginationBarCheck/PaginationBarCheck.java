package Applications.DmfMasterTester.PaginationBarCheck;

/**
 * Created by cad6025 on 2/3/2017.
 */

/*
ID: B-36688
 */

// Strategy imports
import Applications.DmfMasterTester.PaginationBarCheck.Strategy.PaginationTabContext;
import Applications.DmfMasterTester.PaginationBarCheck.Strategy.TabStrategies.*;

// Testng imports
import Applications.TestResultsGenerator.ExcelSpreadsheetCreator;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import WebpageMethods.EPC_Methods._EPC_Master_Methods;

import java.lang.reflect.Method;

public class PaginationBarCheck //extends TestCaseRunner
{

    /********************************
    ***   Excel Sheet Variables   ***
    ********************************/

    private final String parentName = "B-36688";
    private String failureDetails;
    private String testName = "";
    private long runTime;
    private long totalRuntime;

    /************************************
    ***       Preliminary Setup       ***
    ************************************/

    private ExcelSpreadsheetCreator excelCreator = new ExcelSpreadsheetCreator();
    private static PaginationBarCheck paginationBarCheck = new PaginationBarCheck();
    private final PaginationTabContext context  = PaginationTabContext.getInstance();
    private final _EPC_Master_Methods user      = new _EPC_Master_Methods();

    /************************************
    ***       Private Variables       ***
    ************************************/

    private static final Integer pageNumber = 2;
    private static final String websiteURL  = "https://ete5-papc.cna.com/pc/PolicyCenter.do";
    private static final String userName    = "Epc02";

    /**********************
    ***       Test      ***
    **********************/

    // My Accounts Tab:
    @Test
    public void testCheckPaginationBarAccounts()
    {
        context.setStrategy(new MyAccountsStrategy());
        String tabName = "Error on My Accounts Tab: ";

        // Login to Ete
        user.goToEpcEnvAndLogin(websiteURL, userName);

        // Click desired tab
        user.Desktop.clickDesiredTab();

        // Go to desired page
        failureDetails = tabName + "ER1: Could not jump to specified page";
        Assert.assertTrue(user.Desktop.gotoPageNumberDesktop(pageNumber), failureDetails);

        // Go to next page
        failureDetails = tabName + "ER2: Could not go to next page";
        Assert.assertTrue(user.Desktop.gotoNextPageDesktop(), failureDetails);

        // Go to final page
        failureDetails = tabName + "ER3: Could not go to final page";
        Assert.assertTrue(user.Desktop.gotoFinalPageDesktop(), failureDetails);

        // Go to previous page
        failureDetails = tabName + "ER4: Could not go to previous page";
        Assert.assertTrue(user.Desktop.gotoPreviousPageDesktop(), failureDetails);

        // Go to first page
        failureDetails = tabName + "ER5: Could not go to first page";
        Assert.assertTrue(user.Desktop.gotoFirstPageDesktop(), failureDetails);
    }

    // My Activities Tab:
    @Test
    public void testCheckPaginationBarActivities()
    {
        context.setStrategy(new MyActivitiesStrategy());
        String tabName = "Error on My Activities Tab: ";

        // Login to Ete
        user.goToEpcEnvAndLogin(websiteURL, userName);

        // Click desired tab
        user.Desktop.clickDesiredTab();

        // Go to desired page
        failureDetails = tabName + "ER1: Could not jump to specified page";
        Assert.assertTrue(user.Desktop.gotoPageNumberDesktop(pageNumber), failureDetails);

        // Go to next page
        failureDetails = tabName + "ER2: Could not go to next page";
        Assert.assertTrue(user.Desktop.gotoNextPageDesktop(), failureDetails);

        // Go to final page
        failureDetails = tabName + "ER3: Could not go to final page";
        Assert.assertTrue(user.Desktop.gotoFinalPageDesktop(), failureDetails);

        // Go to previous page
        failureDetails = tabName + "ER4: Could not go to previous page";
        Assert.assertTrue(user.Desktop.gotoPreviousPageDesktop(), failureDetails);

        // Go to first page
        failureDetails = tabName + "ER5: Could not go to first page";
        Assert.assertTrue(user.Desktop.gotoFirstPageDesktop(), failureDetails);
    }

    // My Submissions Tab:
    @Test
    public void testCheckPaginationBarSubmissions()
    {
        context.setStrategy(new MySubmissionsStrategy());
        String tabName = "Error on My Submissions Tab: ";

        // Login to Ete
        user.goToEpcEnvAndLogin(websiteURL, userName);

        // Click desired tab
        user.Desktop.clickDesiredTab();

        // Go to desired page
        failureDetails = tabName + "ER1: Could not jump to specified page";
        Assert.assertTrue(user.Desktop.gotoPageNumberDesktop(pageNumber), failureDetails);

        // Go to next page
        failureDetails = tabName + "ER2: Could not go to next page";
        Assert.assertTrue(user.Desktop.gotoNextPageDesktop(), failureDetails);

        // Go to final page
        failureDetails = tabName + "ER3: Could not go to final page";
        Assert.assertTrue(user.Desktop.gotoFinalPageDesktop(), failureDetails);

        // Go to previous page
        failureDetails = tabName + "ER4: Could not go to previous page";
        Assert.assertTrue(user.Desktop.gotoPreviousPageDesktop(), failureDetails);

        // Go to first page
        failureDetails = tabName + "ER5: Could not go to first page";
        Assert.assertTrue(user.Desktop.gotoFirstPageDesktop(), failureDetails);
    }

    // My Renewals Tab:
    @Test
    public void testCheckPaginationBarRenewals()
    {
        context.setStrategy(new MyRenewalsStrategy());
        String tabName = "Error on My Renewals Tab: ";

        // Login to Ete
        user.goToEpcEnvAndLogin(websiteURL, userName);

        // Click desired tab
        user.Desktop.clickDesiredTab();

        // Go to desired page
        failureDetails = tabName + "ER1: Could not jump to specified page";
        Assert.assertTrue(user.Desktop.gotoPageNumberDesktop(pageNumber), failureDetails);

        // Go to next page
        failureDetails = tabName + "ER2: Could not go to next page";
        Assert.assertTrue(user.Desktop.gotoNextPageDesktop(), failureDetails);

        // Go to final page
        failureDetails = tabName + "ER3: Could not go to final page";
        Assert.assertTrue(user.Desktop.gotoFinalPageDesktop(), failureDetails);

        // Go to previous page
        failureDetails = tabName + "ER4: Could not go to previous page";
        Assert.assertTrue(user.Desktop.gotoPreviousPageDesktop(), failureDetails);

        // Go to first page
        failureDetails = tabName + "ER5: Could not go to first page";
        Assert.assertTrue(user.Desktop.gotoFirstPageDesktop(), failureDetails);
    }

    // My Other Policy Transactions Tab:
    @Test
    public void testCheckPaginationBarTransactions()
    {
        context.setStrategy(new MyOtherPolicyTransactionsStrategy());
        String tabName = "Error on My Other Policy Transactions Tab: ";

        // Login to Ete
        user.goToEpcEnvAndLogin(websiteURL, userName);

        // Click desired tab
        user.Desktop.clickDesiredTab();

        // Go to desired page
        failureDetails = tabName + "ER1: Could not jump to specified page";
        Assert.assertTrue(user.Desktop.gotoPageNumberDesktop(pageNumber), failureDetails);

        // Go to next page
        failureDetails = tabName + "ER2: Could not go to next page";
        Assert.assertTrue(user.Desktop.gotoNextPageDesktop(), failureDetails);

        // Go to final page
        failureDetails = tabName + "ER3: Could not go to final page";
        Assert.assertTrue(user.Desktop.gotoFinalPageDesktop(), failureDetails);

        // Go to previous page
        failureDetails = tabName + "ER4: Could not go to previous page";
        Assert.assertTrue(user.Desktop.gotoPreviousPageDesktop(), failureDetails);

        // Go to first page
        failureDetails = tabName + "ER5: Could not go to first page";
        Assert.assertTrue(user.Desktop.gotoFirstPageDesktop(), failureDetails);
    }

    // My Queues Tab:
/*    @Test
    public void testCheckPaginationBarQueues()
    {
        context.setStrategy(new MyQueuesStrategy());
        String tabName = "Error on My Queues Tab: ";

        // Login to Ete
        user.goToEpcEnvAndLogin(websiteURL, userName);

        // Click desired tab
        user.Desktop.clickDesiredTab();

        // Go to desired page
        failureDetails = tabName + "ER1: Could not jump to specified page";
        Assert.assertTrue(user.Desktop.gotoPageNumberDesktop(pageNumber), failureDetails);

        // Go to next page
        failureDetails = tabName + "ER2: Could not go to next page";
        Assert.assertTrue(user.Desktop.gotoNextPageDesktop(), failureDetails);

        // Go to final page
        failureDetails = tabName + "ER3: Could not go to final page";
        Assert.assertTrue(user.Desktop.gotoFinalPageDesktop(), failureDetails);

        // Go to previous page
        failureDetails = tabName + "ER4: Could not go to previous page";
        Assert.assertTrue(user.Desktop.gotoPreviousPageDesktop(), failureDetails);

        // Go to first page
        failureDetails = tabName + "ER5: Could not go to first page";
        Assert.assertTrue(user.Desktop.gotoFirstPageDesktop(), failureDetails);
    }*/

    // New Account Setup Work Item Queue Tab:
    @Test
    public void testCheckPaginationBarAccountSetupItem()
    {
        context.setStrategy(new NewAccountSetupWorkItemQueueStrategy());
        String tabName = "Error on New Account Setup Work Item Queue Tab: ";

        // Login to Ete
        user.goToEpcEnvAndLogin(websiteURL, userName);

        // Click desired tab
        user.Desktop.clickDesiredTab();

        // Go to desired page
        failureDetails = tabName + "ER1: Could not jump to specified page";
        Assert.assertTrue(user.Desktop.gotoPageNumberDesktop(pageNumber), failureDetails);

        // Go to next page
        failureDetails = tabName + "ER2: Could not go to next page";
        Assert.assertTrue(user.Desktop.gotoNextPageDesktop(), failureDetails);

        // Go to final page
        failureDetails = tabName + "ER3: Could not go to final page";
        Assert.assertTrue(user.Desktop.gotoFinalPageDesktop(), failureDetails);

        // Go to previous page
        failureDetails = tabName + "ER4: Could not go to previous page";
        Assert.assertTrue(user.Desktop.gotoPreviousPageDesktop(), failureDetails);

        // Go to first page
        failureDetails = tabName + "ER5: Could not go to first page";
        Assert.assertTrue(user.Desktop.gotoFirstPageDesktop(), failureDetails);
    }

    // NAS Submission Status Tab:
    @Test
    public void testCheckPaginationBarNAS()
    {
        context.setStrategy(new NASSubmissionStatusStrategy());
        String tabName = "Error on NAS Submission Status Tab: ";

        // Login to Ete
        user.goToEpcEnvAndLogin(websiteURL, userName);

        // Click desired tab
        user.Desktop.clickDesiredTab();

        // Go to desired page
        failureDetails = tabName + "ER1: Could not jump to specified page";
        Assert.assertTrue(user.Desktop.gotoPageNumberDesktop(pageNumber), failureDetails);

        // Go to next page
        failureDetails = tabName + "ER2: Could not go to next page";
        Assert.assertTrue(user.Desktop.gotoNextPageDesktop(), failureDetails);

        // Go to final page
        failureDetails = tabName + "ER3: Could not go to final page";
        Assert.assertTrue(user.Desktop.gotoFinalPageDesktop(), failureDetails);

        // Go to previous page
        failureDetails = tabName + "ER4: Could not go to previous page";
        Assert.assertTrue(user.Desktop.gotoPreviousPageDesktop(), failureDetails);

        // Go to first page
        failureDetails = tabName + "ER5: Could not go to first page";
        Assert.assertTrue(user.Desktop.gotoFirstPageDesktop(), failureDetails);
    }

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
//        System.out.println("DOES THIS HAPPEN?!?!?!?");
    }

    @AfterMethod(alwaysRun = true) public void doThisAfter(ITestResult result) {
//        System.out.println("DOES THIS HAPPEN?!?!?!?");
        runTime = ((result.getEndMillis() - result.getStartMillis()) / 1000);
        totalRuntime += runTime;
        excelCreator.getTestCaseRuntimes().add(Long.toString(runTime));
        excelCreator.getTestCaseNames().add(testName);
        excelCreator.getTestCaseParents().add(parentName);
        if (ITestResult.FAILURE == result.getStatus())
        {
            user.takeScreenshot(testName);
            excelCreator.getTestCaseResults().add(failureDetails);
        }
        else
        {
            excelCreator.getTestCaseResults().add("N/A");
        }
        user.closeBrowser();
    }
}

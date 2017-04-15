package Applications.Portfolio_Website;

import Results.Results_Generator.*;
import Users.strategyContext;
import Webpage_Methods.Portfolio_Website.Portfolio_Master;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.Assert;
import org.testng.ITestResult;
import java.lang.reflect.Method;
import org.testng.annotations.*;
import org.testng.annotations.Test;

/**
 * Created by CAD5124 on 3/2/2017.
 */
public class Portfolio_Website_Smoke_Test
{
    private final Portfolio_Master user      = new Portfolio_Master();
    private final strategyContext strategy   = new strategyContext();
    private Results_Generator excelCreator   = new Results_Generator();

    // Excel strings
    private String testName         = "";
    private String failureDetails   = "";
    private String parentName       = "";

    // Environment variables
    private String environmentURL   = "https://ete6-papc.cna.com/pc/policycenter.do";

    // Runtime
    private long runTime;
    private long totalRuntime;

    /**************************
     ***     Smoke Tests     ***
     **************************/

    @Test
    public void testViewDocument_1() {
        parentName = "Portfolio_Smoke_Test";

    }

    /**********************
     ***   Annotations   ***
     **********************/

    @AfterTest
    void writeToExcelFile() {
        excelCreator.setTotalRuntime(Long.toString(totalRuntime));
        excelCreator.setClassName(this.getClass().getName());
        excelCreator.createTestResultsSpreadsheet();
    }

    @BeforeMethod
    public void message(Method method)
    {
        testName = method.getName();
    }

    @AfterMethod(alwaysRun = true) public void doThisAfter(ITestResult result) {
        runTime = ((result.getEndMillis() - result.getStartMillis()) / 1000);
        totalRuntime += runTime;
        excelCreator.getTestCaseRuntimes().add(Long.toString(runTime));
        excelCreator.getTestCaseNames().add(testName);
        excelCreator.getTestCaseParents().add(this.parentName);
        if(ITestResult.FAILURE == result.getStatus())
        {
            try{
                user.takeScreenshot(testName);}
            catch(UnhandledAlertException e){e.printStackTrace();}
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
        user.closeBrowser();
    }
}

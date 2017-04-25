package Selenium_Applications;

import Results.Results_Generator.Results_Generator;
import Test_Docs.File_Paths;
import Webpage_Methods.Portfolio_Website.Portfolio_Master;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class Selenium_Application_Master
{
    // Private Variables
    public final Portfolio_Master user          = new Portfolio_Master();
    public final Results_Generator excelCreator = new Results_Generator();
    public final File_Paths filePaths           = new File_Paths();

    // Excel strings
    public String testName         = "";
    public String parentName       = "";
    public String expectedResult   = "";
    public String actualResult     = "";
    public String failureDetails   = "";

    // Runtime
    public long runTime;
    public long totalRuntime;

    // TestNG Annotations
    @BeforeMethod
    public void doThisBeforeEachTestStarts(Method method)
    {
        testName = method.getName();
        user.setupWebDriverForChromeTesting();
    }

    @AfterMethod(alwaysRun = true) public void doThisAfterEachTestFinishes(ITestResult result)
    {
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

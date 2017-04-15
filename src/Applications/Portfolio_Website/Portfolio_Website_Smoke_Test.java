package Applications.Portfolio_Website;

import Results.Results_Generator.*;
import Users.strategyContext;
import Webpage_Methods.Portfolio_Website.Portfolio_Master;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.Assert;
import org.testng.ITestResult;
import java.lang.reflect.Method;
import org.testng.annotations.*;

public class Portfolio_Website_Smoke_Test
{
    private final Portfolio_Master user      = new Portfolio_Master();
    private final strategyContext strategy   = new strategyContext();
    private Results_Generator excelCreator   = new Results_Generator();

    // Excel strings
    private String testName         = "";
    private String parentName       = "";
    private String expectedResult   = "";
    private String actualResult     = "";
    private String failureDetails   = "";


    // Runtime
    private long runTime;
    private long totalRuntime;

    /*************************
    ***     Smoke Test     ***
    *************************/

    String envUrl = "https://codynicholson.github.io/";

    @Test
    public void testIndexPageButtons() {
        parentName = "Portfolio_Smoke_Test";

        user.goToPortfolioWebsite();

        //ER1
        expectedResult = "https://codynicholson.github.io/";
        actualResult = user.getCurrentUrl();
        failureDetails = "ER1: Did not go to the correct url after starting the test case. Expected: " + expectedResult + ", Actual: " + actualResult;
        Assert.assertTrue(expectedResult.equals(actualResult), failureDetails);

        //ER2
        expectedResult = "Welcome";
        actualResult = user.Index_Page.getWelcomeMessage();
        failureDetails = "ER2: The index page welcome message was incorrect. Expected: " + expectedResult + ", Actual: " + actualResult;
        Assert.assertTrue(expectedResult.equals(actualResult), failureDetails);

        user.Index_Page.clickResumeButton();

        //ER3
        expectedResult = "https://codynicholson.github.io/views/resume.html";
        actualResult = user.getCurrentUrl();
        failureDetails = "ER3: The url address was incorrect after clicking the 'Resume' button. Expected: " + expectedResult + ", Actual: " + actualResult;
        Assert.assertTrue(expectedResult.equals(actualResult), failureDetails);

        //ER4
        expectedResult = "Cody Nicholson";
        actualResult = user.Resume_Page.getTitleHeader();
        failureDetails = "ER4: The resume page title text was incorrect. Expected: " + expectedResult + ", Actual: " + actualResult;
        Assert.assertTrue(expectedResult.equals(actualResult),failureDetails);

        user.goToPortfolioWebsite();
        user.Index_Page.clickGithubButton();

        //ER5
        expectedResult = "https://github.com/CodyNicholson";
        actualResult = user.getCurrentUrl();
        failureDetails = "ER5: The url address was incorrect after clicking the 'Github' button. Expected: " + expectedResult + ", Actual: " + actualResult;
        Assert.assertTrue(expectedResult.equals(actualResult), failureDetails);

        user.closeTab();
        user.Index_Page.clickLinkedInButton();

        //ER6
        expectedResult = "https://www.linkedin.com/in/codynicholson/";
        actualResult = user.getCurrentUrl();
        failureDetails = "ER6: The url address was incorrect after clicking the 'LinkedIn' button. Expected: " + expectedResult + ", Actual: " + actualResult;
        Assert.assertTrue(expectedResult.contains(actualResult), failureDetails);

        user.closeTab();

        //ER7
        failureDetails = "ER7: The 'Contact Me' model was displayed before clicking the 'Contact Me' button";
        Assert.assertFalse(user.Index_Page.isContactMeModelDisplayed(), failureDetails);

        user.Index_Page.clickContactMeButton();

        //ER8
        failureDetails = "ER8: The 'Contact Me' model did not display after clicking the 'Contact Me' button";
        Assert.assertTrue(user.Index_Page.isContactMeModelDisplayed(), failureDetails);
    }

    @Test
    public void testIndexPageContactMe() {
        parentName = "Portfolio_Smoke_Test";

        user.goToPortfolioWebsite();
        user.Index_Page.clickContactMeButton();

        //ER8
        failureDetails = "ER8: The 'Contact Me' model did not display after clicking the 'Contact Me' button";
        Assert.assertTrue(user.Index_Page.isContactMeModelDisplayed(), failureDetails);
    }

    /**********************
     ***   Annotations   ***
     **********************/

    @BeforeTest
    void doThisBeforeRunningAnyTests()
    {
        user.setupWebDriverForChromeTesting();
    }

    @AfterTest
    void doThisAfterAllTestsFinish()
    {
        excelCreator.setTotalRuntime(Long.toString(totalRuntime));
        excelCreator.setClassName(this.getClass().getName());
        excelCreator.createTestResultsSpreadsheet();
    }

    @BeforeMethod
    public void doThisBeforeEachTestStarts(Method method)
    {
        testName = method.getName();
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
        //user.closeBrowser();
    }
}

package Selenium_Applications.Portfolio_Website;

import Selenium_Applications.Selenium_Application_Master;
import org.testng.Assert;
import org.testng.annotations.*;

public class Portfolio_Website_Smoke_Test extends Selenium_Application_Master
{
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
        expectedResult = "www.linkedin.com";
        actualResult = user.getCurrentUrl();
        failureDetails = "ER6: The url address was incorrect after clicking the 'LinkedIn' button. Expected: " + expectedResult + ", Actual: " + actualResult;
        Assert.assertTrue(actualResult.contains(expectedResult), failureDetails);

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
        String name = "Automated Test";
        String message = "This message was sent by a selenium automated test case";
        String email = "automatedTest@codynicholson.github.io";
        String feedback = "This website looks nice";

        user.goToPortfolioWebsite();

        //ER1
        failureDetails = "ER1: The 'Contact Me' model was displayed before clicking the 'Contact Me' button";
        Assert.assertFalse(user.Index_Page.isContactMeModelDisplayed(), failureDetails);

        user.Index_Page.clickContactMeButton();

        //ER2
        failureDetails = "ER2: The 'Contact Me' model did not display after clicking the 'Contact Me' button";
        Assert.assertTrue(user.Index_Page.isContactMeModelDisplayed(), failureDetails);

        user.Index_Page.setNameInContactMe(name);
        user.Index_Page.setMessageInContactMe(message);
        user.Index_Page.setEmailInContactMe(email);
        user.Index_Page.setFeedbackInContactMe(feedback);
        user.Index_Page.clickSubmit();

        //ER3
        expectedResult = "https://formspree.io/codynicholson96@gmail.com";
        actualResult = user.getCurrentUrl();
        failureDetails = "ER3: The formspree 'Im not a robot' page did not display after clicking the 'Submit' button on the form. Expected: " + expectedResult + ", Actual: " + actualResult;
        Assert.assertTrue(expectedResult.equals(actualResult), failureDetails);
    }

    @AfterTest
    void doThisAfterAllTestsFinish()
    {
        excelCreator.setTotalRuntime(Long.toString(totalRuntime));
        excelCreator.setClassName(this.getClass().getName());
        excelCreator.createTestResultsSpreadsheet();
    }
}

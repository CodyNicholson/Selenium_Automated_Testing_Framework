package Applications.EpcSmokeTest;

/**
 * Created by CAD5124 on 3/22/2017.
 */

import Applications.TestResultsGenerator.ExcelSpreadsheetCreator;
import java.lang.reflect.Method;
import Users.strategyContext;
import WebpageMethods.EPC_Methods._EPC_Master_Methods;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Test;

/**
 * Created by cad5124 on 12/8/2016.
 */

public class EpcSmokeTest {
    /********************************
     ***   Excel Sheet Variables   ***
     ********************************/

    private ExcelSpreadsheetCreator excelCreator = new ExcelSpreadsheetCreator();
    private String parentName = "";
    private String testName = "";
    private String failureDetails = "";
    private long runTime;
    private long totalRuntime;

    /****************************
     ***   Private variables   ***
     ****************************/

    private final _EPC_Master_Methods user = new _EPC_Master_Methods();
    private final strategyContext strategy = new strategyContext();

    /****************
     ***   Tests   ***
     ****************/

    @Test
    public void testCreateNewAccountAndNewSubmissionSmallBusinessBUA()
    {
        String environmentURL = "https://ete5-papc.cna.com/pc/policycenter.do";
        String userName = "Epc02";
        String accountName = "EPC Smoke Test 3";
        String street = "525 South State Street";
        String city = "Chicago";
        String state = "Illinois";
        String zipCode = "60605";
        String sicCode = "20510-001";
        String distributorCode = "010-994899";
        String businessArea = "Small Business";
        String policyPrefix = "BUA";
        String underwriterCID = "cac5312";
        String underwritingCompany = "National Fire";
        String writtenDate = "11/01/2018";
        String effectiveDate = "11/01/2018";
        String expirationDate = "11/02/2019"; // ETE6 Policy 6048418211 account 5601976081

        user.goToEpcEnvAndLogin(environmentURL, userName);
        user.clickActionsDropDownMenuFromDesktop();
        user.clickNewSubmissionInActionsDropDownMenuOnDesktop();
        user.Account.clickSearchOnEnterAccountInfoPage();
        user.Account.clickCreateNewAccountMenuOnAccountInfoPage();
        user.Account.clickCompanyInCreateNewAccountMenuOnEnterAccountIntoPage();
        user.Account.setAccountHolderNameInCreateAccount(accountName);
        user.Account.setAddressLine1InCreateAccount(street);
        user.Account.setCityInCreateAccount(city);
        user.Account.selectStateInCreateAccount(state);
        user.Account.setZipCodeOnCreateAccount(zipCode);
        user.Account.clickStandardizeAddressBtnOnCreateAccount();
        user.Account.clickSicCodeSearchIconOnCreateAccount();
        user.Account.setSicCodeInSicCodeSearch(sicCode);
        user.Account.clickSearchButtonInSicCodeSearch();
        user.Account.clickFirstSelectButtonOnSicCodeSearchTable();
        user.Account.clickDistributorNameSearchIconOnCreateAccount();
        user.Account.setDistributorCodeInSicCodeSearch(distributorCode);
        user.Account.clickSearchButtonInDistributorSearch();
        user.Account.clickFirstSelectButtonOnDistributorSearchTable();
        user.Account.clickUpdateButtonOnCreateAccount();
        user.Account.selectBusinessAreaInNewSubmissions(businessArea);
        user.Account.setCNAReceivedDateOnNewSubmissions(user.getCurrentDate());
        user.Account.setDefaultEffectiveDateOnNewSubmissions(effectiveDate);
        user.Account.setExpirationDateOnNewSubmissions(expirationDate);
        user.Account.clickUnderwriterSearchIcon();
        user.Account.setCIDInSearchUsers(underwriterCID);
        user.Account.clickSearchButtonInSearchUsers();
        user.Account.clickSelectBtnFirstUserOnSearchUsersTable();
        //user.Account.toggleOverridePolicyOnNewSubmissions(policyPrefix); //
        user.Account.setComplexityForPolicyPrefix(policyPrefix);
        user.Account.clickAddForPolicyPrefix(policyPrefix);
        user.Account.clickSubmitOnNewSubmissions();
        user.Account.clickPolicyNumberLinkOnSubmissionConfirmation();
        user.Account.clickNextOnPolicyInfoPage();
        user.Account.clickWorkPlanInLeftMenuOnPolicyInfo();
        user.Account.toggleCheckboxForRowOnWorkplan(1);
        user.Account.clickAssignButtonOnWorkplan();
        user.Account.clickAssignButtonOnAssignActivities();
        user.Account.clickPolicyInfoOnLeftToolbar();
        user.Account.clickLockOnPolicyInfo();
        user.Account.setUnderwritingCompanyOnPolicyInfo(underwritingCompany);
//        user.Account.setWrittenDate
    }

    /**********************
     ***   Annotations   ***
     **********************/

    @AfterTest
    void writeToExcelFile()
    {
        excelCreator.setTotalRuntime(Long.toString(totalRuntime));
        excelCreator.setClassName(this.getClass().getName());
        excelCreator.createTestResultsSpreadsheet();
    }

    @BeforeTest
    void prepareToTest() {

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
        //user.closeBrowser();
    }
}
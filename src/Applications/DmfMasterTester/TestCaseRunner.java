package Applications.DmfMasterTester;

import Applications.TestResultsGenerator.ExcelSpreadsheetCreator;
import Users.strategyContext;
import WebpageMethods.EPC_Methods._EPC_Master_Methods;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.Assert;
import org.testng.ITestResult;
import java.lang.reflect.Method;
import org.testng.annotations.*;
import org.testng.annotations.Test;

/**
 * Created by CAD5124 on 3/2/2017.
 */
public class TestCaseRunner
{
    private final _EPC_Master_Methods EPC_User      = new _EPC_Master_Methods();
    private final strategyContext strategy          = new strategyContext();
    private ExcelSpreadsheetCreator excelCreator    = new ExcelSpreadsheetCreator();

    // Excel strings
    private String testName         = "";
    private String failureDetails   = "";
    private String parentName       = "";

    // Environment variables
    private String environmentURL   = "https://ete6-papc.cna.com/pc/policycenter.do";
    private String userName         = "Epc02";
    private String policyNumber     = "6046425713";
    private String accountNumber    = "5601028451";

    // Runtime
    private long runTime;
    private long totalRuntime;

    /**************************
    ***   DMF Smoke Tests   ***
    **************************/

    @Test(priority = 5)
    public void testViewDocument_1() {
        parentName = "DMF Smoke Test";

        EPC_User.goToEpcEnvAndLogin(environmentURL, userName);
        EPC_User.clickSearchTab();
        EPC_User.Search_EPC_Policies_Page.clickAccountsInSearch();
        EPC_User.Search_EPC_Policies_Page.setPolicyNumAndSearchInAccountsSearch(policyNumber);
        EPC_User.Search_EPC_Policies_Page.clickAccountNumberForPolicyInSearchResults(accountNumber);
        EPC_User.Account_File_Summary_Page.clickDocumentsInToolsMenu();
        EPC_User.Account_File_Documents_Page.switchDriverFrameToDocumentsIframe();

        //ER1_1
        String expectedValue = "testText";
        failureDetails = "ER1: The document, " + expectedValue + ", was not found on the Documents Page.";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentPresent(expectedValue), failureDetails);

        //ER1_2
        expectedValue = "testPowerpoint";
        failureDetails = "ER2: The document, " + expectedValue + " was not found on the Document Page.";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentPresent(expectedValue), failureDetails);

        //ER1_3
        expectedValue = "testExcel";
        failureDetails = "ER3: The document, " + expectedValue + " was not found on the Document Page.";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentPresent(expectedValue), failureDetails);

        //ER1_4
        expectedValue = "testPdf";
        failureDetails = "ER4: The document, " + expectedValue + " was not found on the Document Page.";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentPresent(expectedValue), failureDetails);

        //ER1_5
        expectedValue = "testWord";
        failureDetails = "ER5: The document, " + expectedValue + " was not found on the Document Page.";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentPresent(expectedValue), failureDetails);
    }

    @Test(priority = 10)
    public void testViewDocumentProperties_2() {
        parentName = "DMF Smoke Test";

        EPC_User.goToEpcEnvAndLogin(environmentURL, userName);
        EPC_User.clickSearchTab();
        EPC_User.Search_EPC_Policies_Page.clickAccountsInSearch();
        EPC_User.Search_EPC_Policies_Page.setPolicyNumAndSearchInAccountsSearch(policyNumber);
        EPC_User.Search_EPC_Policies_Page.clickAccountNumberForPolicyInSearchResults(accountNumber);
        EPC_User.Account_File_Summary_Page.clickDocumentsInToolsMenu();
        EPC_User.Account_File_Documents_Page.switchDriverFrameToDocumentsIframe();
        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage("2.8.5");
        EPC_User.Account_File_Documents_Page.clickPropertiesButtonOnDmfPage();

        //ER1_1
        String expectedValue = "testText";
        failureDetails = "ER1_1: The properties for the " + expectedValue + " document did not display correctly";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentNameCorrectInDocProperties(expectedValue), failureDetails);

        EPC_User.Account_File_Documents_Page.clickBackOnDocumentPropertiesPage();
        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage(  "2.8.4");
        EPC_User.Account_File_Documents_Page.clickPropertiesButtonOnDmfPage();

        //ER1_2
        expectedValue = "testPowerpoint";
        failureDetails = "ER1_2: The properties for the " + expectedValue + " document did not display correctly";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentNameCorrectInDocProperties(expectedValue), failureDetails);

        EPC_User.Account_File_Documents_Page.clickBackOnDocumentPropertiesPage();
        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage("2.8.3");
        EPC_User.Account_File_Documents_Page.clickPropertiesButtonOnDmfPage();

        //ER1_3
        expectedValue = "testExcel";
        failureDetails = "ER1_3: The properties for the " + expectedValue + " document did not display correctly";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentNameCorrectInDocProperties(expectedValue), failureDetails);

        EPC_User.Account_File_Documents_Page.clickBackOnDocumentPropertiesPage();
        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage("2.8.2");
        EPC_User.Account_File_Documents_Page.clickPropertiesButtonOnDmfPage();

        //ER1_4
        expectedValue = "testPdf";
        failureDetails = "ER1_4: The properties for the " + expectedValue + " document did not display correctly";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentNameCorrectInDocProperties(expectedValue), failureDetails);

        EPC_User.Account_File_Documents_Page.clickBackOnDocumentPropertiesPage();
        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage("2.8.1");
        EPC_User.Account_File_Documents_Page.clickPropertiesButtonOnDmfPage();

        //ER1_5
        expectedValue = "testWord";
        failureDetails = "ER1_5: The properties for the " + expectedValue + " document did not display correctly";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentNameCorrectInDocProperties(expectedValue), failureDetails);
    }

    @Test(priority = 15)
    public void testAddDocument_3() {
        parentName = "DMF Smoke Test";

        EPC_User.goToEpcEnvAndLogin(environmentURL, userName);
        EPC_User.clickSearchTab();
        EPC_User.Search_EPC_Policies_Page.clickAccountsInSearch();
        EPC_User.Search_EPC_Policies_Page.setPolicyNumAndSearchInAccountsSearch(policyNumber);
        EPC_User.Search_EPC_Policies_Page.clickAccountNumberForPolicyInSearchResults(accountNumber);
        EPC_User.Account_File_Summary_Page.clickDocumentsInToolsMenu();
        EPC_User.Account_File_Documents_Page.switchDriverFrameToDocumentsIframe();

        // ER1
        String treeLocation = "1.1";
        failureDetails = "ER1: There was already a document added under the 'Account' leaf of the DMF tree";
        Assert.assertFalse(EPC_User.Account_File_Documents_Page.isDocumentPresentAtTreeLocation(treeLocation), failureDetails);

        // Add the document
        EPC_User.Account_File_Documents_Page.clickAddDocumentsButtonAndAddDocumentOnDMF(strategy.addDocumentPath());
        EPC_User.Account_File_Documents_Page.clickAddInAddDocPropertiesPopUpOnDMF();

        // ER2
        String expectedValue = "testAddDoc";
        failureDetails = "ER2: The document did not appear on the DMF document table after it was added using the Add Document Button";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentPresentAtTreeLocation(expectedValue, treeLocation), failureDetails);

        // Cleanup
        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage("1.1");
        EPC_User.Account_File_Documents_Page.clickDeleteButtonOnDMF();
        EPC_User.Account_File_Documents_Page.clickRadioButtonInPleaseSelectReasonToDeleteAndClickOkOnDmf(1);
        EPC_User.Account_File_Documents_Page.clickYesButtonForSecondDeleteConfirmationPopUpOnDMF();
    }

    @Test(priority = 20)
    public void testMoveDocument_4() {
        parentName = "DMF Smoke Test";

        EPC_User.goToEpcEnvAndLogin(environmentURL, userName);
        EPC_User.clickSearchTab();
        EPC_User.Search_EPC_Policies_Page.clickAccountsInSearch();
        EPC_User.Search_EPC_Policies_Page.setPolicyNumAndSearchInAccountsSearch(policyNumber);
        EPC_User.Search_EPC_Policies_Page.clickAccountNumberForPolicyInSearchResults(accountNumber);
        EPC_User.Account_File_Summary_Page.clickDocumentsInToolsMenu();
        EPC_User.Account_File_Documents_Page.switchDriverFrameToDocumentsIframe();

        //ER1
        String treeLocation = "2.2.2";
        String documentName = "testMove";
        failureDetails = "ER1: The document '" + documentName + "' was not found on the Document Page.";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentPresentAtTreeLocation(documentName, treeLocation), failureDetails);

        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage("2.2.2");
        EPC_User.Account_File_Documents_Page.clickMoveButtonOnDmfPage();
        EPC_User.Account_File_Documents_Page.selectAccountOrPolicyToMoveOnMoveDocumentPage("Account");
        EPC_User.Account_File_Documents_Page.clickUpdateButtonOnMoveDocumentPage();

        //ER2
        treeLocation = "1.1";
        documentName = "testMove";
        failureDetails = "ER2: The document, " + documentName + " was not found on the Document Page.";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentPresentAtTreeLocation(documentName, treeLocation), failureDetails);

        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage("1.1");
        EPC_User.Account_File_Documents_Page.clickMoveButtonOnDmfPage();
        EPC_User.Account_File_Documents_Page.selectAccountOrPolicyToMoveOnMoveDocumentPage("ADT - 6046426165 - 03/11/2018");
        EPC_User.Account_File_Documents_Page.clickUpdateButtonOnMoveDocumentPage();

        //ER2
        treeLocation = "2.2.2";
        documentName = "testMove";
        failureDetails = "ER2: The document, " + documentName + " was not found on the Document Page.";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentPresentAtTreeLocation(documentName, treeLocation), failureDetails);
    }

    @Test(priority = 25)
    public void testViewConfidentialDocument_5() {
        parentName = "DMF Smoke Test";

        EPC_User.goToEpcEnvAndLogin(environmentURL, userName);
        EPC_User.clickSearchTab();
        EPC_User.Search_EPC_Policies_Page.clickAccountsInSearch();
        EPC_User.Search_EPC_Policies_Page.setPolicyNumAndSearchInAccountsSearch(policyNumber);
        EPC_User.Search_EPC_Policies_Page.clickAccountNumberForPolicyInSearchResults(accountNumber);
        EPC_User.Account_File_Summary_Page.clickDocumentsInToolsMenu();
        EPC_User.Account_File_Documents_Page.switchDriverFrameToDocumentsIframe();

        //ER2
        String expectedValue = "2.5.1";
        failureDetails = "ER1: The document at tree location " + expectedValue + " was not found on the Document Page.";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isConfidentialDocumentPresentAtTreeLocation(expectedValue), failureDetails);
    }

    @Test(priority = 30, enabled = false)
    public void testCheckInDocument_6() {
        parentName = "DMF Smoke Test";

        EPC_User.goToEpcEnvAndLogin(environmentURL, userName);
        EPC_User.clickSearchTab();
        EPC_User.Search_EPC_Policies_Page.clickAccountsInSearch();
        EPC_User.Search_EPC_Policies_Page.setPolicyNumAndSearchInAccountsSearch(policyNumber);
        EPC_User.Search_EPC_Policies_Page.clickAccountNumberForPolicyInSearchResults(accountNumber);
        EPC_User.Account_File_Summary_Page.clickDocumentsInToolsMenu();
        EPC_User.Account_File_Documents_Page.switchDriverFrameToDocumentsIframe();
        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage("2.4.1");
        EPC_User.Account_File_Documents_Page.clickCheckOutButtonOnDMF();

        //ER1
        failureDetails = "ER1: The document did not display as checked out on the DMF page after toggling the document and clicking 'Check Out'.";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentCheckedOut("testCheckOutCheckIn", "2.4.1"), failureDetails);

        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage("2.4.1");
        EPC_User.Account_File_Documents_Page.clickCheckInButtonAndCheckInFile(strategy.TestCheckInCheckOutPath_DMF_Smoke_Test());

        //ER2
        failureDetails = "ER2: The document was not checked in correctly";
        Assert.assertFalse(EPC_User.Account_File_Documents_Page.isDocumentCheckedOut("testCheckOutCheckIn", "2.4.1"), failureDetails);
    }

    @Test(priority = 31, enabled = false)
    public void testCheckOutDocument_7() {
        parentName = "DMF Smoke Test";

        EPC_User.goToEpcEnvAndLogin(environmentURL, userName);
        EPC_User.clickSearchTab();
        EPC_User.Search_EPC_Policies_Page.clickAccountsInSearch();
        EPC_User.Search_EPC_Policies_Page.setPolicyNumAndSearchInAccountsSearch(policyNumber);
        EPC_User.Search_EPC_Policies_Page.clickAccountNumberForPolicyInSearchResults(accountNumber);
        EPC_User.Account_File_Summary_Page.clickDocumentsInToolsMenu();
        EPC_User.Account_File_Documents_Page.switchDriverFrameToDocumentsIframe();
        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage("2.4.1");
        EPC_User.Account_File_Documents_Page.clickCheckOutButtonOnDMF();

        //ER1
        failureDetails = "ER1: The document did not display as checked out on the DMF page after toggling the document and clicking 'Check Out'.";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentCheckedOut("testCheckOutCheckIn", "2.4.1"), failureDetails);

        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage("2.4.1");
        EPC_User.Account_File_Documents_Page.clickCheckInButtonAndCheckInFile(strategy.TestCheckInCheckOutPath_DMF_Smoke_Test());

        //ER2
        failureDetails = "ER2: The document was not checked in correctly";
        Assert.assertFalse(EPC_User.Account_File_Documents_Page.isDocumentCheckedOut("testCheckOutCheckIn", "2.4.1"), failureDetails);
    }

    @Test(priority = 32, enabled = false)
    public void testCancelCheckout_8() {
        parentName = "DMF Smoke Test";

        EPC_User.goToEpcEnvAndLogin(environmentURL, userName);
        EPC_User.clickSearchTab();
        EPC_User.Search_EPC_Policies_Page.clickAccountsInSearch();
        EPC_User.Search_EPC_Policies_Page.setPolicyNumAndSearchInAccountsSearch(policyNumber);
        EPC_User.Search_EPC_Policies_Page.clickAccountNumberForPolicyInSearchResults(accountNumber);
        EPC_User.Account_File_Summary_Page.clickDocumentsInToolsMenu();
        EPC_User.Account_File_Documents_Page.switchDriverFrameToDocumentsIframe();
        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage("2.4.1");
        EPC_User.Account_File_Documents_Page.clickCheckOutButtonOnDMF();

        //ER1
        failureDetails = "ER1: The document did not display as checked out on the DMF page after toggling the document and clicking 'Check Out'.";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentCheckedOut("testCheckOutCheckIn", "2.4.1"), failureDetails);

        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage("2.4.1");
        EPC_User.Account_File_Documents_Page.clickCheckInButtonAndCheckInFile(strategy.TestCheckInCheckOutPath_DMF_Smoke_Test());

        //ER2
        failureDetails = "ER2: The document was not checked in correctly";
        Assert.assertFalse(EPC_User.Account_File_Documents_Page.isDocumentCheckedOut("testCheckOutCheckIn", "2.4.1"), failureDetails);

        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage("2.4.1");
        EPC_User.Account_File_Documents_Page.clickCheckOutButtonOnDMF();

        //ER3
        failureDetails = "ER3: The document did not display as checked out on the DMF page after toggling the document and clicking 'Check Out'.";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentCheckedOut("testCheckOutCheckIn", "2.4.1"), failureDetails);

        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage("2.4.1");
        EPC_User.Account_File_Documents_Page.clickCancelCheckoutButtonOnDMF();

        //ER4
        failureDetails = "ER4: The document was not checked in correctly after canceling the check out";
        Assert.assertFalse(EPC_User.Account_File_Documents_Page.isDocumentCheckedOut("testCheckOutCheckIn", "2.4.1"), failureDetails);
    }

    @Test(priority = 45)
    public void testDistributeDocsViaEmail_9(){
        parentName = "DMF Smoke Test";

        String emailSender = "Joseph.Walker@cna.com";
        String emailReciever = "Joseph.Walker@cna.com";
        String emailSubject = "Testing Distribute";

        // Preliminary steps
        EPC_User.goToEpcEnvAndLogin(environmentURL, userName);
        EPC_User.clickSearchTab();
        EPC_User.Search_EPC_Policies_Page.clickAccountsInSearch();
        EPC_User.Search_EPC_Policies_Page.setPolicyNumAndSearchInAccountsSearch(policyNumber);
        EPC_User.Search_EPC_Policies_Page.clickAccountNumberForPolicyInSearchResults(accountNumber);
        EPC_User.Account_File_Summary_Page.clickDocumentsInToolsMenu();
        EPC_User.Account_File_Documents_Page.switchDriverFrameToDocumentsIframe();

        /****************
         ***   SNO 9   ***
         ****************/

        // Add distribute document
        String treeLocation = "2.3.1";
        EPC_User.Account_File_Documents_Page.clickAddDocumentsButtonAndAddDocumentOnDMF(strategy.TestDistributePath_DMF_Smoke_Test());
        EPC_User.Account_File_Documents_Page.clickAddInAddDocPropertiesPopUpOnDMF();
        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage("1.1");
        EPC_User.Account_File_Documents_Page.clickMoveButtonOnDmfPage();
        EPC_User.Account_File_Documents_Page.selectAccountOrPolicyToMoveOnMoveDocumentPage("ADT - 6046426120 - 03/11/2018");
        EPC_User.Account_File_Documents_Page.clickUpdateButtonOnMoveDocumentPage();

        // ER1
        String expectedValue = "testDistribute";
        failureDetails = "ER1: The document did not appear on the DMF document table after it was added using the Add Document button";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentPresentAtTreeLocation(expectedValue, treeLocation), failureDetails);

        // Setup distribution page
        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage(treeLocation);
        EPC_User.Account_File_Documents_Page.clickDistributeButtonOnDMF();
        EPC_User.Account_File_Documents_Page.setSenderOnDmfDistribute(emailSender);
        EPC_User.Account_File_Documents_Page.setRecipientOnDmfDistribute(emailReciever);
        EPC_User.Account_File_Documents_Page.setSubjectOnDmfDistribute(emailSubject);
        //EPC_User.Account_File_Documents_Page.setMessageOnDmfDistribute("Testing Distribute for DMF smoke test");

        // ER2
        EPC_User.Account_File_Documents_Page.clickSendButtonOnDmfDistribute();
        EPC_User.Account_File_Documents_Page.clickOkButtonOnDmfDistribute();
        failureDetails = "ER2: The document failed to be sent";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.checkIsDocumentDistributed(treeLocation), failureDetails);

        // Clean up
        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage(treeLocation);
        EPC_User.Account_File_Documents_Page.clickDeleteButtonOnDMF();
        EPC_User.Account_File_Documents_Page.clickRadioButtonInPleaseSelectReasonToDeleteAndClickOkOnDmf(1);
        EPC_User.Account_File_Documents_Page.clickYesButtonForSecondDeleteConfirmationPopUpOnDMF();
    }

    @Test (priority = 55)
    public void testViewDistributionHistory_11() {
        parentName = "DMF Smoke Test";
        String emailSender = "Joseph.Walker@cna.com";
        String emailReciever = "Joseph.Walker@cna.com";
        String emailSubject = "Testing Distribute";

        // Preliminary steps
        EPC_User.goToEpcEnvAndLogin(environmentURL, userName);
        EPC_User.clickSearchTab();
        EPC_User.Search_EPC_Policies_Page.clickAccountsInSearch();
        EPC_User.Search_EPC_Policies_Page.setPolicyNumAndSearchInAccountsSearch(policyNumber);
        EPC_User.Search_EPC_Policies_Page.clickAccountNumberForPolicyInSearchResults(accountNumber);
        EPC_User.Account_File_Summary_Page.clickDocumentsInToolsMenu();
        EPC_User.Account_File_Documents_Page.switchDriverFrameToDocumentsIframe();

        /****************
         ***   SNO 9   ***
         ****************/

        // Add distribute document
        String treeLocation = "2.3.1";
        //EPC_User.Account_File_Documents_Page.clickAddDocumentsButtonAndAddDocumentOnDMF("C:\\Users\\cad6025\\Desktop\\svn_automation\\DMF_Automation_Framework\\src\\Applications\\DmfMasterTester\\DmfSmokeTest\\docsToAdd\\testDistribute.txt");
        EPC_User.Account_File_Documents_Page.clickAddDocumentsButtonAndAddDocumentOnDMF(strategy.TestDistributePath_DMF_Smoke_Test());
        EPC_User.Account_File_Documents_Page.clickAddInAddDocPropertiesPopUpOnDMF();
        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage("1.1");
        EPC_User.Account_File_Documents_Page.clickMoveButtonOnDmfPage();
        EPC_User.Account_File_Documents_Page.selectAccountOrPolicyToMoveOnMoveDocumentPage("ADT - 6046426120 - 03/11/2018");
        EPC_User.Account_File_Documents_Page.clickUpdateButtonOnMoveDocumentPage();

        // Setup distribution page
        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage(treeLocation);
        EPC_User.Account_File_Documents_Page.clickDistributeButtonOnDMF();
        EPC_User.Account_File_Documents_Page.setSenderOnDmfDistribute(emailSender);
        EPC_User.Account_File_Documents_Page.setRecipientOnDmfDistribute(emailReciever);
        EPC_User.Account_File_Documents_Page.setSubjectOnDmfDistribute(emailSubject);
        //EPC_User.Account_File_Documents_Page.setMessageOnDmfDistribute("Testing Distribute for DMF smoke test");

        // Send email
        EPC_User.Account_File_Documents_Page.clickSendButtonOnDmfDistribute();
        EPC_User.Account_File_Documents_Page.clickOkButtonOnDmfDistribute();

        // Check history
        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage(treeLocation);
        EPC_User.Account_File_Documents_Page.clickDistributionHistoryButtonOnDMF();

        // ER1
        String expectedValue = "Distribution History";
        failureDetails = "ER1: Failed to visit the Distribution History page";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDistributionHistoryPage(expectedValue), failureDetails);

        // ER2
        expectedValue = "Joseph.Walker@cna.com";
        failureDetails = "ER2: Distribution History failed to populate";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDistributionHistoryPopulated(expectedValue), failureDetails);

        // Clean up
        EPC_User.Account_File_Documents_Page.clickBackButtonOnDistributionHistoryPage();
        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage(treeLocation);
        EPC_User.Account_File_Documents_Page.clickDeleteButtonOnDMF();
        EPC_User.Account_File_Documents_Page.clickRadioButtonInPleaseSelectReasonToDeleteAndClickOkOnDmf(1);
        EPC_User.Account_File_Documents_Page.clickYesButtonForSecondDeleteConfirmationPopUpOnDMF();
    }

    @Test(priority = 60)
    public void testLaunchDocumentsFromTransactions_12() {
        parentName = "DMF Smoke Test";

        // Preliminary steps
        EPC_User.goToEpcEnvAndLogin(environmentURL, userName);
        EPC_User.clickSearchTab();
        EPC_User.Search_EPC_Policies_Page.clickAccountsInSearch();
        EPC_User.Search_EPC_Policies_Page.setPolicyNumAndSearchInAccountsSearch(policyNumber);
        EPC_User.Search_EPC_Policies_Page.clickAccountNumberForPolicyInSearchResults(accountNumber);

        // Navigate to Policy Transaction
        EPC_User.Account_File_Summary_Page.clickPolicyTransactionsInToolsMenu();
        EPC_User.Account_File_Policy_Transactions_Page.clickFirstPolicyInTransactionMenu();

        // ER1
        String expectedResult = "Account File Documents";
        failureDetails = "ER1: Document Manager failed to load";
        EPC_User.PreQualification_Questions_Page.clickActionsDropDownFromPolicyTransaction();
        EPC_User.PreQualification_Questions_Page.clickLaunchDocumentManagementInActionsDropDown();
        EPC_User.Account_File_Documents_Page.switchDriverFrameToDocumentsIframe();
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentManagementOpen(expectedResult));

        // Cleanup
        EPC_User.Account_File_Documents_Page.switchToDefaultContext();
        EPC_User.Account_File_Documents_Page.closeDocumentManagementPopup();
    }

    @Test(priority = 65)
    public void testDeleteDocument_13(){
        parentName = "DMF Smoke Test";

        EPC_User.goToEpcEnvAndLogin(environmentURL, userName);
        EPC_User.clickSearchTab();
        EPC_User.Search_EPC_Policies_Page.clickAccountsInSearch();
        EPC_User.Search_EPC_Policies_Page.setPolicyNumAndSearchInAccountsSearch(policyNumber);
        EPC_User.Search_EPC_Policies_Page.clickAccountNumberForPolicyInSearchResults(accountNumber);
        EPC_User.Account_File_Summary_Page.clickDocumentsInToolsMenu();
        EPC_User.Account_File_Documents_Page.switchDriverFrameToDocumentsIframe();

        // Add the document
        EPC_User.Account_File_Documents_Page.clickAddDocumentsButtonAndAddDocumentOnDMF(strategy.addDocumentPath());
        EPC_User.Account_File_Documents_Page.clickAddInAddDocPropertiesPopUpOnDMF();

        // ER1
        String expectedValue = "testAddDoc";
        String treeLocation = "1.1";
        failureDetails = "ER1: The document did not appear on the DMF document table after it was added using the Add Document Button";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentPresentAtTreeLocation(expectedValue, treeLocation), failureDetails);

        // Delete the document
        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage("1.1");
        EPC_User.Account_File_Documents_Page.clickDeleteButtonOnDMF();
        EPC_User.Account_File_Documents_Page.clickRadioButtonInPleaseSelectReasonToDeleteAndClickOkOnDmf(1);
        EPC_User.Account_File_Documents_Page.clickYesButtonForSecondDeleteConfirmationPopUpOnDMF();

        // ER2
        failureDetails = "ER2: The document appeared on the DMF document table after it was deleted using the 'Delete' button";
        Assert.assertFalse(EPC_User.Account_File_Documents_Page.isDocumentPresentAtTreeLocation(expectedValue, treeLocation), failureDetails);
    }

    @Test (priority = 75)
    public void testDisplayDeletedDocuments_15(){
        parentName = "DMF Smoke Test";

        EPC_User.goToEpcEnvAndLogin(environmentURL, userName);
        EPC_User.clickSearchTab();
        EPC_User.Search_EPC_Policies_Page.clickAccountsInSearch();
        EPC_User.Search_EPC_Policies_Page.setPolicyNumAndSearchInAccountsSearch(policyNumber);
        EPC_User.Search_EPC_Policies_Page.clickAccountNumberForPolicyInSearchResults(accountNumber);
        EPC_User.Account_File_Summary_Page.clickDocumentsInToolsMenu();
        EPC_User.Account_File_Documents_Page.switchDriverFrameToDocumentsIframe();

        // Add the document
        EPC_User.Account_File_Documents_Page.clickAddDocumentsButtonAndAddDocumentOnDMF(strategy.addDocumentPath());
        EPC_User.Account_File_Documents_Page.clickAddInAddDocPropertiesPopUpOnDMF();

        // Delete the document
        EPC_User.Account_File_Documents_Page.toggleDocumentCheckboxOnDmfPage("1.1");
        EPC_User.Account_File_Documents_Page.clickDeleteButtonOnDMF();
        EPC_User.Account_File_Documents_Page.clickRadioButtonInPleaseSelectReasonToDeleteAndClickOkOnDmf(1);
        EPC_User.Account_File_Documents_Page.clickYesButtonForSecondDeleteConfirmationPopUpOnDMF();

        // View deleted documents
        EPC_User.Account_File_Documents_Page.clickDeletedDocumentsButtonOnDMF();

        //ER1
        String expectedValue = "testAddDoc";
        failureDetails = "ER1: The document did not appear on the DMF Deleted Documents table after it was deleted using the Delete Button";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.isDocumentPresentOnDeletedDocumentPageInDMF(expectedValue), failureDetails);
    }

    @Test(priority = 200)
    public void testAddFromTemplate_18() {
        parentName = "DMF Smoke Test";

        // Preliminary steps
        EPC_User.goToEpcEnvAndLogin(environmentURL, userName);
        EPC_User.clickSearchTab();
        EPC_User.Search_EPC_Policies_Page.clickAccountsInSearch();
        EPC_User.Search_EPC_Policies_Page.setPolicyNumAndSearchInAccountsSearch(policyNumber);
        EPC_User.Search_EPC_Policies_Page.clickAccountNumberForPolicyInSearchResults(accountNumber);

        // Navigate to add from template page
        EPC_User.Account_File_Summary_Page.clickDocumentsInToolsMenu();
        EPC_User.Account_File_Documents_Page.switchDriverFrameToDocumentsIframe();
        EPC_User.Account_File_Documents_Page.clickAddFromTemplateButton();
        //EPC_User.Account_File_Documents_Page.switchDriverFrameToDocumentsIframe();

        // Test adding template
        failureDetails = "ER1: Moved to next page without choosing template";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.checkErrorMessageOnTemplateAdd(), failureDetails);

        // Click radio and hit next
        failureDetails = "ER2: Couldn't progress to next page with New Submission POR Letter - Old Agent template";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.clickRadioButtonOnTemplateAdd(1), failureDetails);

        // Choose Account Policy and hit next
        failureDetails = "ER3: Information failed to automatically fill out form";
        EPC_User.Account_File_Documents_Page.setPolicyOnTemplateAdd(0);
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.checkInformationFilledOnTemplateAdd(0));

        // Generate Template
        failureDetails = "ER4: Failed to generate a template";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.clickGenerateTemplateOnTemplateAdd());

        /****************************
         ***   Robot work on PDF   ***
         ****************************/

        failureDetails = "ER5: Couldn't click 'Save Final' button on PDF";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.clickSaveFinalOnPDF());
    }

    /*********************
     ***  Radio Button ****
     *********************/

    @Test(priority = 50, enabled = false)
    public void testRadioButtonTemplateCheck() {
        parentName = "B-37514";

        // Login to Ete
        EPC_User.goToEpcEnvAndLogin(environmentURL, userName);

        // Search for account
        EPC_User.clickSearchTab();
        EPC_User.Search_EPC_Policies_Page.clickAccountsInSearch();
        EPC_User.Search_EPC_Policies_Page.setPolicyNumAndSearchInAccountsSearch(policyNumber);
        EPC_User.Search_EPC_Policies_Page.clickAccountNumberForPolicyInSearchResults(accountNumber);

        // Click documents
        EPC_User.Account_File_Summary_Page.clickDocumentsInToolsMenu();
        EPC_User.Account_File_Documents_Page.switchDriverFrameToDocumentsIframe();
        EPC_User.Account_File_Documents_Page.clickAddFromTemplateButton();
        //EPC_User.Account_File_Documents_Page.switchDriverFrameToDocumentsIframe();

        // Test adding template
        failureDetails = "ER1: Moved to next page without choosing template";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.checkErrorMessageOnTemplateAdd(), failureDetails);

        //Click radio and hit next
        failureDetails = "ER2: Couldn't progress to next page with New Submission POR Letter - Old Agent template";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.clickRadioButtonOnTemplateAdd(1), failureDetails);
        EPC_User.Account_File_Documents_Page.clickBackOnTemplateAdd();

        //Click radio and hit next
        failureDetails = "ER3: Couldn't progress to next page with New Submission POR Letter - New Agent template";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.clickRadioButtonOnTemplateAdd(2), failureDetails);
        EPC_User.Account_File_Documents_Page.clickBackOnTemplateAdd();

        //Click radio and hit next
        failureDetails = "ER4: Couldn't progress to next page with Existing POR Letter - Old Agent template";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.clickRadioButtonOnTemplateAdd(3), failureDetails);
        EPC_User.Account_File_Documents_Page.clickBackOnTemplateAdd();

        //Click radio and hit next
        failureDetails = "ER5: Couldn't progress to next page with Existing POR Letter - New Agent template";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.clickRadioButtonOnTemplateAdd(4), failureDetails);
        EPC_User.Account_File_Documents_Page.clickBackOnTemplateAdd();

        //Click radio and hit next
        failureDetails = "ER6: Couldn't progress to next page with Completion Letter - Old Agent template";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.clickRadioButtonOnTemplateAdd(5), failureDetails);
        EPC_User.Account_File_Documents_Page.clickBackOnTemplateAdd();

        //Click radio and hit next
        failureDetails = "ER7: Couldn't progress to next page with Completion Letter - New Agent template";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.clickRadioButtonOnTemplateAdd(6), failureDetails);
        EPC_User.Account_File_Documents_Page.clickBackOnTemplateAdd();

        //Click radio and hit next
        failureDetails = "ER8: Couldn't progress to next page with POR Declination Letter template";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.clickRadioButtonOnTemplateAdd(7), failureDetails);
        EPC_User.Account_File_Documents_Page.clickBackOnTemplateAdd();

        //Click radio and hit next
        failureDetails = "ER9: Couldn't progress to next page with Declination Letter template";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.clickRadioButtonOnTemplateAdd(8), failureDetails);
        EPC_User.Account_File_Documents_Page.clickBackOnTemplateAdd();

        //Click radio and hit next
        failureDetails = "ER10: Couldn't progress to next page with Solicitation Letter template";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.clickRadioButtonOnTemplateAdd(9), failureDetails);
        EPC_User.Account_File_Documents_Page.clickBackOnTemplateAdd();

        //Click radio and hit next
        failureDetails = "ER11: Couldn't progress to next page with Submission Confirmation Letter template";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.clickRadioButtonOnTemplateAdd(10), failureDetails);
        EPC_User.Account_File_Documents_Page.clickBackOnTemplateAdd();

        //Click radio and hit next
        failureDetails = "ER12: Couldn't progress to next page with No Loss Letter template";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.clickRadioButtonOnTemplateAdd(11), failureDetails);
        EPC_User.Account_File_Documents_Page.clickBackOnTemplateAdd();

        //Click radio and hit next
        failureDetails = "ER13: Couldn't progress to next page with Renewal Solicitation Letter - Non - Oregon Physicians template";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.clickRadioButtonOnTemplateAdd(12), failureDetails);
        EPC_User.Account_File_Documents_Page.clickBackOnTemplateAdd();

        //Click radio and hit next
        failureDetails = "ER14: Couldn't progress to next page with Renewal Solicitation Letter - Oregon Physicians template";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.clickRadioButtonOnTemplateAdd(13), failureDetails);
        EPC_User.Account_File_Documents_Page.clickBackOnTemplateAdd();

        //Click radio and hit next
        failureDetails = "ER15: Couldn't progress to next page with Endt - Waiver of Subrogation Request template";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.clickRadioButtonOnTemplateAdd(14), failureDetails);
        EPC_User.Account_File_Documents_Page.clickBackOnTemplateAdd();

        //Click radio and hit next
        failureDetails = "ER16: Couldn't progress to next page with No Loss Letter - Small Business template";
        Assert.assertTrue(EPC_User.Account_File_Documents_Page.clickRadioButtonOnTemplateAdd(15), failureDetails);
        EPC_User.Account_File_Documents_Page.clickBackOnTemplateAdd();
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
            try{EPC_User.takeScreenshot(testName);}
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
        EPC_User.closeBrowser();
    }
}

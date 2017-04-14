package WebpageMethods.EPC_Methods.Account_Methods;

/**
 * Created by cad6025 on 2/6/2017.
 */

import WebpageMethods.EPC_Methods._EPC_Master_Methods;
import org.openqa.selenium.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class EPC_Account_Methods extends _EPC_Master_Methods
{
    public static EPC_Account_Methods instance = new EPC_Account_Methods();
    public Account_File_Documents Documents = Account_File_Documents.instance;

    /***************************
    ***   Tools Menu Links   ***
    ***************************/

    public void clickSummaryInToolsMenu() {
        waitForElementToBeDisplayedAndClickableThenClick("//span[@class='x-tree-node-text '][text()='Summary']");
    }

    public void clickRelatedAccountsInToolsMenu() {
        waitForElementToBeDisplayedAndClickableThenClick("//span[@class='x-tree-node-text '][text()='Related Accounts']");
    }

    public void clickTriageAndEnterpriseSellInToolsMenu() {
        waitForElementToBeDisplayedAndClickableThenClick("//span[@class='x-tree-node-text '][text()='Triage & Enterprise Sell']");
    }

    public void clickRiskDocumentationInToolsMenu() {
        waitForElementToBeDisplayedAndClickableThenClick("//span[@class='x-tree-node-text '][text()='Risk Documentation']");
    }

    public void clickInformationNeededInToolsMenu() {
        waitForElementToBeDisplayedAndClickableThenClick("//span[@class='x-tree-node-text '][text()='Information Needed']");
    }

    public void clickContactsInToolsMenu() {
        waitForElementToBeDisplayedAndClickableThenClick("//span[@class='x-tree-node-text '][text()='Contacts']");
    }

    public void clickLocationsInToolsMenu() {
        waitForElementToBeDisplayedAndClickableThenClick("//span[@class='x-tree-node-text '][text()='Locations']");
    }

    public void clickCNATeamInToolsMenu() {
        waitForElementToBeDisplayedAndClickableThenClick("//span[@class='x-tree-node-text '][text()='CNA Team']");
    }

    public void clickPolicyTransactionsInToolsMenu() {
        waitForElementToBeDisplayedAndClickableThenClick("//span[@class='x-tree-node-text '][text()='Policy Transactions']");
    }

    public void clickRiskControlInToolsMenu() {
        waitForElementToBeDisplayedAndClickableThenClick("//span[@class='x-tree-node-text '][text()='Risk Control']");
    }

    // Submission Manager

    public void clickDocumentsInToolsMenu() {
        waitForElementToBeDisplayedAndClickableThenClick("//span[@class='x-tree-node-text '][text()='Documents']");
        waitForPageToLoad(5);
    }

    // Quote Proposal Letter

    // Notes

    // Billing

    // History

    // Underwriting Tools

    // Premium and Loss Reports

    // Workplan

    // Premium Calculator

    // Participating Plans

    /***********************************
     ***   Policy Transactions Tool   ***
     ***********************************/

    public void clickFirstPolicyInTransactionMenu() {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@id = 'AccountFile_WorkOrders:AccountFile_WorkOrdersScreen:AccountWorkOrdersLV-body']//tr[1]//td[2]//a");
    }

    public void clickActionsDropDownFromPolicyTransaction() {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@id = 'westPanel']//span[@id = 'SubmissionWizard:WizardMenuActions-btnInnerEl']");
    }

    public void clickLaunchDocumentManagementInActionsDropDown(){
        waitForElementToBeDisplayedAndClickableThenClick("//div[@class = 'x-box-inner x-vertical-box-overflow-body']//a[@id = 'SubmissionWizard:WizardMenuActions:WizardMenuActions_Goto:DocumentManagement-itemEl']");
    }

    public void closeDocumentManagementPopup()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@id = 'southPanel-body'] //span[@id = 'CNADocumentManagementWorksheet:CNADocumentManagementFacilityScreen:ToolbarButton-btnInnerEl']");
        waitFor(2);
    }

    public boolean isDocumentManagementOpen(String expectedResult) {
        return super.isCorrectText(expectedResult, "//form//h2");
    }

    /****************
    ***   Other   ***
    ****************/

    public void clickAddFromTemplateButton() {
        waitForElementToBeDisplayedAndClickableThenClick("//a[@id='addFromTemplate']", 10);
    }

    public void switchDriverFrameToDocumentsIframe() {
        waitForElement("//iframe[@id = 'dmflinkframe']");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id = 'dmflinkframe']")));
    }

    public boolean clickNextOnTemplateAdd() {
        waitForElement("//input[@id = 'next'][@value = 'Next']");
        driver.findElement(By.xpath("//input[@id = 'next'][@value = 'Next']")).click();
        // Takes a long time.
        if (isElementPresent("//input[@type = 'button'][@value = 'Generate Template']")) return true;
        else return false;
    }

    public boolean checkErrorMessageOnTemplateAdd() {
        if (isElementPresent("//span[@id = 'errorMsg']")) return true;
        else return false;
    }

    public boolean isPolicyOnDocumentPagePresent(String policyNum) {
        return isElementPresent("//table[@id='document_view']//tr//td[contains(text(),'" + policyNum + "')]");
    }

    public boolean isDocumentPresent(String docName) {
        return isElementPresent("//table[@id='document_view']//tr//td//a[contains(text(),'" + docName + "')]");
    }

    public boolean isConfidentialDocumentPresentAtTreeLocation(String treeLocation) {
        return isElementPresent("//table[@id='document_view']//tr[@id='" + treeLocation + "']//td[@id='" + treeLocation + "']//img[@src='./resources/images/confidential.png']");
    }

    public boolean isDocumentDisplayed(String docName) {
        return driver.findElement(By.xpath("//table[@id='document_view']//tr//td//a[contains(text(),'" + docName + "')]")).isDisplayed();
    }

    public void toggleDropdownMenuInDocumentsTable(int row) {
        driver.findElement(By.xpath("(//span[@class='indenter']//a)[" + row + "]")).click();
    }

    public int getNumberOfDropdownMenusFromDocumentsTable() {
        int numDropDownMenus = 0;
        for (int i = 1; true; i++) {
            try {
                driver.findElement(By.xpath("(//span[@class='indenter']//a)[" + i + "]"));
                numDropDownMenus++;
            } catch (NoSuchElementException e) {
                break;
            }
        }
        return numDropDownMenus;
    }

    public boolean isDocumentDropdownMenusCollapsible() {
        int numDDMenus = getNumberOfDropdownMenusFromDocumentsTable();
        for (int i = 1; i <= numDDMenus; i++) {
            toggleDropdownMenuInDocumentsTable(i);
            waitFor(1);
            toggleDropdownMenuInDocumentsTable(i);
            waitFor(1);
        }
        return true;
    }

    public ArrayList<String> getPolicyHeaderFromDocumentsTable(String policyAbbreviation) {
        ArrayList<String> policyHeaders = new ArrayList<String>();
        for (int i = 1; true; i++) {
            try {
                String date = driver.findElement(By.xpath("(//table[@id='document_view']//td[starts-with(text(),'" + policyAbbreviation + "')])[" + i + "]")).getText();
                date = date.substring(date.length() - 10, date.length());
                policyHeaders.add(date);
            } catch (NoSuchElementException e) {
                break;
            }
        }
        return policyHeaders;
    }

    public boolean isPoliciesOnDocumentsPageInChronologicalOrder(String policyAbbreviation) {
        ArrayList<String> policyDatesInOrder = getPolicyHeaderFromDocumentsTable(policyAbbreviation);
        for (int i = 1; i < policyDatesInOrder.size(); i++) {
            for (int j = 0; j < i; j++) {
                if ((Integer.parseInt(policyDatesInOrder.get(j).substring(6))) < (Integer.parseInt(policyDatesInOrder.get(i).substring(6)))) {
                    return false;
                } else if ((Integer.parseInt(policyDatesInOrder.get(j).substring(6))) == (Integer.parseInt(policyDatesInOrder.get(i).substring(6)))) {
                    if ((Integer.parseInt(policyDatesInOrder.get(j).substring(0, 2))) < (Integer.parseInt(policyDatesInOrder.get(i).substring(0, 2)))) {
                        return false;
                    } else if ((Integer.parseInt(policyDatesInOrder.get(j).substring(0, 2))) == (Integer.parseInt(policyDatesInOrder.get(i).substring(0, 2)))) {
                        if ((Integer.parseInt(policyDatesInOrder.get(j).substring(3, 5))) < (Integer.parseInt(policyDatesInOrder.get(i).substring(3, 5)))) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public void toggleDocumentCheckboxOnDmfPage(String locationInTreeNum) {
        waitForElementToBeDisplayedAndClickableThenClick("//tr[@id='" + locationInTreeNum + "']//input[@type='checkbox']");
    }

    public void clickPropertiesButtonOnDmfPage() {
        waitForElementToBeDisplayedAndClickableThenClick("//a[@id='properties']");
    }

    public boolean isDocumentNameCorrectInDocProperties(String docName) {
        waitForElement("//input[@name='documentName'][@value='" + docName + "']");
        return isElementPresent("//input[@name='documentName'][@value='" + docName + "']");
    }

    public void clickBackOnDocumentPropertiesPage() {
        waitForElementToBeDisplayedAndClickableThenClick("//input[@type='button'][@value='Back'][@id='back']");
    }

    public void clickMoveButtonOnDmfPage() {
        driver.findElement(By.xpath("//a[@class='button'][@id='move']")).click();
    }

    public void selectAccountOrPolicyToMoveOnMoveDocumentPage(String policyOrAccountName) {
        driver.findElement(By.xpath("//select[@id='moveDocument_folders']")).click();
        driver.findElement(By.xpath("//select[@id='moveDocument_folders']//option[text()='" + policyOrAccountName + "']")).click();
    }

    public void clickUpdateButtonOnMoveDocumentPage() {
        driver.findElement(By.id("movUpdate")).click();
    }

    public boolean isDocumentPresentAtTreeLocation(String documentName, String treeLocationNumber) {
        waitFor(2);
        try {
            return driver.findElement(By.xpath("//table[@id='document_view']//tr[@id='" + treeLocationNumber + "']//td//a[contains(text(),'" + documentName + "')]")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isDocumentPresentAtTreeLocation(String treeLocationNumber) {
        waitFor(2);
        try {
            return driver.findElement(By.xpath("//table[@id='document_view']//tr[@id='" + treeLocationNumber + "']//td//a")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isCheckoutImageDisplayedForTreeLocation(String treeLocation) {
        return isElementPresent("");
    }

    public void clickActionsDropDownMenuFromAccount() {
        waitForElement("//*[@id='AccountFile:AccountFileMenuActions-btnInnerEl']");
        driver.findElement(By.xpath("//*[@id='AccountFile:AccountFileMenuActions-btnInnerEl']")).click();
    }

    public void clickNewSubmissionInActionsDropDownMenuOnAccount() {
        driver.findElement(By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_Create:AccountFileMenuActions_NewSubmission-textEl")).click();
    }

    public void setAccountNumberOnEnterAccountInfo(String accountNum) {
        driver.findElement(By.id("NewAccount:NewAccountScreen:CNAAccountSearchDV:AccountNumber-inputEl")).sendKeys(accountNum);
    }

    public void clickSearchOnEnterAccountInfoPage() {
        driver.findElement(By.id("NewAccount:NewAccountScreen:CNAAccountSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search")).click();
    }

    public void clickFirstSelectInSearchResultsTableOnEnterAccountInfoPage() {
        driver.findElement(By.xpath("//table[starts-with(@id,'gridview')]//tbody//tr[1]//td[2]//a")).click();
    }

    public void clickFirstAccountNumInSearchResultsTableOnEnterAccountInfoPage() {
        driver.findElement(By.xpath("//table[starts-with(@id,'gridview')]//tbody//tr[1]//td[3]//a")).click();
    }

    public void clickCreateNewAccountMenuOnAccountInfoPage() {
        driver.findElement(By.id("NewAccount:NewAccountScreen:NewAccountButton-btnInnerEl")).click();
    }

    public void clickCompanyInCreateNewAccountMenuOnEnterAccountIntoPage() {
        driver.findElement(By.id("NewAccount:NewAccountScreen:NewAccountButton:NewAccount_Company-textEl")).click();
        waitForElement("//input[@id='CNACreateAccount:CNACreateAccountScreen:CNACreateAccountDV:AccountNumber-inputEl']");
    }

    public void setAccountHolderNameInCreateAccount(String accountHolder) {
        driver.findElement(By.xpath("//input[@id='CNACreateAccount:CNACreateAccountScreen:CNACreateAccountDV:AccountNumber-inputEl']")).click();
        waitFor(2);
        driver.findElement(By.xpath("//input[@id='CNACreateAccount:CNACreateAccountScreen:CNACreateAccountDV:AccountNumber-inputEl']")).sendKeys(accountHolder);
        waitFor(2);
    }

    public void setAddressLine1InCreateAccount(String address) {
        driver.findElement(By.xpath("//input[@id='CNACreateAccount:CNACreateAccountScreen:CNACreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl']")).click();
        waitFor(2);
        driver.findElement(By.xpath("//input[@id='CNACreateAccount:CNACreateAccountScreen:CNACreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl']")).sendKeys(address);
        waitFor(2);
    }

    public void setCityInCreateAccount(String city) {
        driver.findElement(By.xpath("//input[@id='CNACreateAccount:CNACreateAccountScreen:CNACreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl']")).click();
        waitFor(2);
        driver.findElement(By.xpath("//input[@id='CNACreateAccount:CNACreateAccountScreen:CNACreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl']")).sendKeys(city);
        waitFor(2);
    }

    public void selectStateInCreateAccount(String state) {
        driver.findElement(By.xpath("//input[@id='CNACreateAccount:CNACreateAccountScreen:CNACreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl']")).clear();
        waitFor(2);
        driver.findElement(By.xpath("//input[@id='CNACreateAccount:CNACreateAccountScreen:CNACreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl']")).sendKeys(state);
        waitFor(2);
        driver.findElement(By.xpath("//input[@id='CNACreateAccount:CNACreateAccountScreen:CNACreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl']")).sendKeys(Keys.ENTER);
        waitFor(2);
    }

    public void setZipCodeOnCreateAccount(String zipcode) {
        driver.findElement(By.xpath("//input[@id='CNACreateAccount:CNACreateAccountScreen:CNACreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl']")).click();
        waitFor(2);
        driver.findElement(By.xpath("//input[@id='CNACreateAccount:CNACreateAccountScreen:CNACreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl']")).sendKeys(zipcode);
        waitFor(2);
    }

    public void clickStandardizeAddressBtnOnCreateAccount() {
        driver.findElement(By.xpath("//a[@id='CNACreateAccount:CNACreateAccountScreen:CNACreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:StandardizeAddress']")).click();
        waitFor(2);
    }

    public void clickSicCodeSearchIconOnCreateAccount() {
        //waitForElement("//div[@id='CNACreateAccount:CNACreateAccountScreen:CNACreateAccountDV:IndustryCode:SelectIndustryCode']/..");
        //waitFor(4);
        waitForElementToBeDisplayedAndClickableThenClick("//div[@id='CNACreateAccount:CNACreateAccountScreen:CNACreateAccountDV:IndustryCode:SelectIndustryCode']/..");
        //driver.findElement(By.xpath("//div[@id='CNACreateAccount:CNACreateAccountScreen:CNACreateAccountDV:IndustryCode:SelectIndustryCode']/..")).click();
        waitFor(2);
    }

    public void clickSicCodeSearchIconOnNewSubmissions() {
        waitFor(1);
        driver.findElement(By.xpath("//div[@id='NewSubmission:NewSubmissionScreen:SelectAccountAndProducerDV:IndustryCode:SelectIndustryCode']")).click();
        waitFor(2);
    }

    public void setSicCodeInSicCodeSearch(String sicCode) {
        driver.findElement(By.xpath("//input[@id='IndustryCodeSearchPopup:IndustryCodeSearchScreen:IndustryCodeSearchDV:Code-inputEl']")).sendKeys(sicCode);
        waitFor(2);
    }

    public void setSicCodeDescriptionInSicCodeSearch(String sicCodeDescription) {
        driver.findElement(By.xpath("//input[@id='IndustryCodeSearchPopup:IndustryCodeSearchScreen:IndustryCodeSearchDV:Classification-inputEl']")).sendKeys(sicCodeDescription);
        waitFor(2);
    }

    public void clickSearchButtonInSicCodeSearch() {
        driver.findElement(By.xpath("//a[@id='IndustryCodeSearchPopup:IndustryCodeSearchScreen:IndustryCodeSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search']")).click();
    }

    public void clickFirstSelectButtonOnSicCodeSearchTable() {
        driver.findElement(By.xpath("//tbody[starts-with(@id,'gridview')]//tr[1]//td[1]//a[@id='IndustryCodeSearchPopup:IndustryCodeSearchScreen:IndustryCodeSearchResultsLV:0:_Select']")).click();
    }

    public void clickDistributorNameSearchIconOnCreateAccount() {
        driver.findElement(By.xpath("//td[@id='CNACreateAccount:CNACreateAccountScreen:CNACreateAccountDV:ProducerSelectionInputSet:ProducerCode-inputCell']//following-sibling::td[1]")).click();
        waitFor(2);
    }

    public void clickDistributorNameSearchIconOnNewSubmissions() {
        driver.findElement(By.xpath("//div[@id='NewSubmission:NewSubmissionScreen:SelectAccountAndProducerDV:ProducerSelectionInputSet:CNADistributorCode:SelectCNADistributorCode']")).click();
        waitFor(2);
    }

    public void setDistributorCodeInSicCodeSearch(String policyType) {
        if (policyType.equals("DBA")) {
            policyType = "884-013";
        }
        if (policyType.equals("LS") || policyType.equals("ADT") || policyType.equals("Life Science") || policyType.equals("Life Sciences")) {
            policyType = "978-013";
        }
        if (policyType.equals("HAP")) {
            policyType = "970-010";
        }
        if (policyType.equals("BUA"))
        {
            policyType = "010-994899";
        }
        driver.findElement(By.xpath("//input[@id='CNADistributorSearchPopup:OrganizationSearchDV:DistributorCode-inputEl']")).sendKeys(policyType);
        waitFor(2);
    }

    public void clickSearchButtonInDistributorSearch() {
        driver.findElement(By.xpath("//a[@id='CNADistributorSearchPopup:OrganizationSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search']")).click();
    }

    public void clickFirstSelectButtonOnDistributorSearchTable() {
        waitForElement("//tbody[starts-with(@id,'gridview')]//tr[1]//td[1]//a[@id='CNADistributorSearchPopup:CNADistributorCodeSearchLV:0:_Select']");
        driver.findElement(By.xpath("//tbody[starts-with(@id,'gridview')]//tr[1]//td[1]//a[@id='CNADistributorSearchPopup:CNADistributorCodeSearchLV:0:_Select']")).click();
    }

    public void clickUpdateButtonOnCreateAccount() {
        driver.findElement(By.xpath("//span[@id='CNACreateAccount:CNACreateAccountScreen:Update-btnInnerEl']")).click();
        waitForPageToLoad(10);
    }

    public void selectBusinessAreaInNewSubmissions(String businessArea) {
        if (businessArea.equals("DBA")) {
            businessArea = "Home Foreign Outward - DBA & Worldpass";
        }
        if (businessArea.equals("LS")) {
            businessArea = "Life Sciences";
        }
        if (businessArea.equals("BUA")) {
            businessArea = "Middle Market";
        }
        waitFor(6);
        driver.findElement(By.xpath("//input[@id='NewSubmission:NewSubmissionScreen:SelectAccountAndProducerDV:BusinessArea-inputEl']")).clear();
        waitFor(2);
        driver.findElement(By.xpath("//input[@id='NewSubmission:NewSubmissionScreen:SelectAccountAndProducerDV:BusinessArea-inputEl']")).sendKeys(businessArea);
        waitFor(2);
        driver.findElement(By.xpath("//input[@id='NewSubmission:NewSubmissionScreen:SelectAccountAndProducerDV:BusinessArea-inputEl']")).sendKeys(Keys.ENTER);
        waitFor(2);
    }

    public void setCNAReceivedDateOnNewSubmissions(String cnaReceivedDate) {
        driver.findElement(By.xpath("//input[@id='NewSubmission:NewSubmissionScreen:ProductSettingsDV:CNAReceivedDate-inputEl']")).sendKeys(cnaReceivedDate);
        waitFor(2);
    }

    public void setDefaultEffectiveDateOnNewSubmissions(String defaultEffectiveDate) {
        driver.findElement(By.xpath("//input[@id='NewSubmission:NewSubmissionScreen:ProductSettingsDV:DefaultPPEffDate-inputEl']")).sendKeys(defaultEffectiveDate);
        waitFor(2);
    }

    public void setExpirationDateOnNewSubmissions(String expirationDate) {
        driver.findElement(By.xpath("//input[@id='NewSubmission:NewSubmissionScreen:ProductSettingsDV:ExpirationDate-inputEl']")).sendKeys(expirationDate);
        waitFor(2);
    }

    public void clickAddForPolicyPrefix(String policyPrefix) {
        waitFor(2);
        waitForElementToBeDisplayedAndClickableThenClick("//div[@id='NewSubmission:NewSubmissionScreen:ProductOffersDV:CNAProductSelectionLV-body']//table[starts-with(@id,'gridview')]//tbody//tr//td[1]//div[text()='"+policyPrefix+"']/../../td[6]//a[text()='Add']", 30);
        waitFor(2);
    }

    public void setComplexityForPolicyPrefix(String policyPrefix, String complexity) {
        driver.findElement(By.xpath("//div[@id='NewSubmission:NewSubmissionScreen:ProductOffersDV:CNAProductSelectionLV-body']//table[starts-with(@id,'gridview')]//tbody//tr//td[1]//div[text()='" + policyPrefix + "']/../../td[8]//div")).click();
        waitFor(2);
        driver.findElement(By.xpath("//input[starts-with(@id,'textfield')]")).sendKeys(complexity);
    }

    public void setComplexityForPolicyPrefix(String policyPrefix) {
        driver.findElement(By.xpath("//div[@id='NewSubmission:NewSubmissionScreen:ProductOffersDV:CNAProductSelectionLV-body']//table[starts-with(@id,'gridview')]//tbody//tr//td[1]//div[text()='" + policyPrefix + "']/../../td[8]//div")).click();
        waitFor(10);
        driver.findElement(By.xpath("//input[starts-with(@id,'textfield')][@name='MaxCreate']")).sendKeys("0");
        //tryToSetTextField("//input[starts-with(@id,'textfield')][@name='MaxCreate']", "0");
    }

    public void clickUnderwriterSearchIcon() {
        driver.findElement(By.xpath("//div[@id='NewSubmission:NewSubmissionScreen:ProductOffersDV:AssignedUnderWriter:SelectAssignedUnderWriter']")).click();
        waitFor(2);
    }

    public void setCIDInSearchUsers(String cid) {
        waitForElement("//input[@id='UserSearchNewSubmissionPopup:UserSearchPopupScreen:UserSearchNewSubmissionDV:Username-inputEl']");
        try {
            driver.findElement(By.xpath("//input[@id='UserSearchNewSubmissionPopup:UserSearchPopupScreen:UserSearchNewSubmissionDV:Username-inputEl']")).click();
            driver.findElement(By.xpath("//input[@id='UserSearchNewSubmissionPopup:UserSearchPopupScreen:UserSearchNewSubmissionDV:Username-inputEl']")).sendKeys(cid);
        } catch (Exception e) {
            //System.out.println("Exception in finding element: //input[@id='UserSearchNewSubmissionPopup:UserSearchPopupScreen:UserSearchNewSubmissionDV:Username-inputEl']");
            waitFor(3);
            driver.findElement(By.xpath("//input[@id='UserSearchNewSubmissionPopup:UserSearchPopupScreen:UserSearchNewSubmissionDV:Username-inputEl']")).click();
            driver.findElement(By.xpath("//input[@id='UserSearchNewSubmissionPopup:UserSearchPopupScreen:UserSearchNewSubmissionDV:Username-inputEl']")).sendKeys(cid);
        }
        waitFor(2);
    }

    public void clickSearchButtonInSearchUsers() {
        driver.findElement(By.xpath("//a[@id='UserSearchNewSubmissionPopup:UserSearchPopupScreen:UserSearchNewSubmissionDV:SearchAndResetInputSet:SearchLinksInputSet:Search']")).click();
        waitFor(2);
    }

    public void clickSelectBtnFirstUserOnSearchUsersTable() {
        driver.findElement(By.xpath("//table[starts-with(@id,'gridview')]//tbody//tr[1]//td[1]//a")).click();
        waitFor(2);
    }

    public void clickSubmitOnNewSubmissions() {
        driver.findElement(By.xpath("//span[@id='NewSubmission:NewSubmissionScreen:SelectedProductOffersDV:CNAExternalSubmissionLV_tb:MakeSubmissions-btnInnerEl']")).click();
        waitForElement("//div[@id='CNADesktopSubmissionConfirmation:CNADesktopSubmissionConfirmationScreen:CNADesktopSubmissionConfirmationDV:subConAcctName-inputEl']", 30);
        getAccountAndPolicyNumberFromSubmissionsConfirmation();
    }

    public void getAccountAndPolicyNumberFromSubmissionsConfirmation() {
        String accountNumber = driver.findElement(By.xpath("//div[@id='CNADesktopSubmissionConfirmation:CNADesktopSubmissionConfirmationScreen:CNADesktopSubmissionConfirmationDV:subConAcctName-inputEl']")).getText();
        String policyNumber = driver.findElement(By.xpath("//table[starts-with(@id,'gridview')]//tbody//tr[1]//td[1]//div[1]")).getText();
        String policyPrefix = driver.findElement(By.xpath("//table[starts-with(@id,'gridview')]//tbody//tr[1]//td[2]//div[1]")).getText();
        setAccountNumber(accountNumber);
        System.out.println("The account number is: " + accountNumber + ", the Policy Prefix is: " + policyPrefix + ", and the Policy Number is: " + policyNumber);
    }

    public void clickAccountNumberOnSubmissionConfirmation() {
        waitForElement("//div[@id='CNADesktopSubmissionConfirmation:CNADesktopSubmissionConfirmationScreen:CNADesktopSubmissionConfirmationDV:subConAcctName-inputEl']");
        driver.findElement(By.xpath("//div[@id='CNADesktopSubmissionConfirmation:CNADesktopSubmissionConfirmationScreen:CNADesktopSubmissionConfirmationDV:subConAcctName-inputEl']")).click();
        waitFor(2);
    }

    public void clickCheckInButtonAndCheckInFile(String filePath) {
        driver.findElement(By.xpath("//table[@id='treeButtons']//a[@id='checkin']")).click();
        waitFor(2);
        try {
            Robot robot = new Robot(); // Declare robot
            StringSelection stringSelect = new StringSelection(filePath); // Holds the string - placeholder
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelect, null); // Sets the system clipboard to your string
            robot.keyPress(KeyEvent.VK_CONTROL); // VK is virtual keyboard
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        waitFor(4);
    }

    public void clickCheckOutButtonOnDMF() {
        driver.findElement(By.xpath("//table[@id='treeButtons']//a[@id='checkout']")).click();
        waitFor(8);
    }

    public boolean isDocumentCheckedOut(String documentName, String treeLocation) {
        return isElementPresent("//table[@id='document_view']//tr[@id='" + treeLocation + "']//td//span//a[text()='" + documentName + "']")
                && isElementPresent("//table[@id='document_view']//td[@id='" + treeLocation + "']//img[@src='./resources/images/checkout.png']");
    }

    public void clickAddDocumentsButtonAndAddDocumentOnDMF(String filePath) {
        waitFor(3);
        driver.findElement(By.xpath("//table[@id='upperButtons']//a[@id='addDocBtn']")).sendKeys(Keys.ENTER);
        waitFor(6);
        try {
            Robot robot = new Robot(); // Declare robot
            StringSelection stringSelect = new StringSelection(filePath); // Holds the string - placeholder
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelect, null); // Sets the system clipboard to your string
            robot.keyPress(KeyEvent.VK_CONTROL); // VK is virtual keyboard
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        waitFor(4);
    }

    public void clickAddInAddDocPropertiesPopUpOnDMF() {
        //waitForElement("//table[@id='tableprops2']//input[@id='addDocButton']");
        //driver.findElement(By.xpath("//table[@id='tableprops2']//input[@id='addDocButton']")).click();
        waitForElementToBeDisplayedAndClickableThenClick("//table[@id='tableprops2']//input[@id='addDocButton']");
        waitForPageToLoad(5);
    }

    public void clickDeleteButtonOnDMF() {
        waitForElementToBeDisplayedAndClickableThenClick("//table[@id='treeButtons']//a[@id='delete']");
        waitForElementToBeDisplayedAndClickableThenClick("//div[@id='deleteUnder2HoursDialog']//following-sibling::div//button//span[text()='Yes']");
    }

    public void clickRadioButtonInPleaseSelectReasonToDeleteAndClickOkOnDmf(int indexStartingAt1) {
        driver.findElement(By.xpath("//form//table//tr[" + (indexStartingAt1 + 1) + "]//input[@type='radio']")).click();
        waitFor(1);
        driver.findElement(By.xpath("//form[starts-with(@style, 'padding-top:')]//table//tr//td//input[@id='ok']")).click();
        waitFor(2);
    }

    public void clickYesButtonForSecondDeleteConfirmationPopUpOnDMF() {
        waitFor(5);
        try {
            Robot robot = new Robot(); // Declare robot
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        waitFor(2);
    }

    public void clickDeletedDocumentsButtonOnDMF() {
        driver.findElement(By.xpath("//table[@id='treeButtons']//a[@id='deletedDocuments']")).click();
        waitFor(1);
    }

    public boolean isDocumentPresentOnDeletedDocumentPageInDMF(String docName) {
        try {
            driver.findElement(By.xpath("//table[@id='tableProps']/following::table//tbody//tr[2]//td[1][text()='" + docName + "']")).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void clickCancelCheckoutButtonOnDMF() {
        driver.findElement(By.xpath("//table[@id='treeButtons']//a[@id='cancelcheckout']")).click();
        waitFor(1);
    }

    public void clickDistributeButtonOnDMF() {
        driver.findElement(By.xpath("//table[@id='upperButtons']//a[@id='distribute']")).click();
        waitFor(1);
    }

    public void clickAddFromTemplateButtonOnDMF() {
        driver.findElement(By.xpath("//table[@id='upperButtons']//a[@id='addFromTemplate']")).click();
        waitFor(1);
    }

    public void clickDistributionHistoryButtonOnDMF() {
        driver.findElement(By.xpath("//table[@id='treeButtons']//a[@id='disthistory']")).click();
        waitFor(1);
    }

    public void clickVersionHistoryButtonOnDMF() {
        driver.findElement(By.xpath("//table[@id='treeButtons']//a[@id='vershistory']")).click();
        waitFor(1);
    }

    public void setSenderOnDmfDistribute(String sender) {
        driver.findElement(By.xpath("//table[@id='tableDetails']//tr//td//input[@id='sender']")).sendKeys(sender);
    }

    public void setSubjectOnDmfDistribute(String subject) {
        driver.findElement(By.xpath("//table[@id='tableDetails']//tr//td//input[@id='subject']")).sendKeys(subject);
    }

    public void setMessageOnDmfDistribute(String message) {
        driver.findElement(By.xpath("//table[@id='tableDetails']//tr//td//input[@id='mailDescription']")).sendKeys(message);
    }

    public void setRecipientOnDmfDistribute(String recipient) {
        driver.findElement(By.xpath("//table[@id='tableDetails']//tr//td//input[@id='to']")).sendKeys(recipient);
    }

    public void clickSendButtonOnDmfDistribute() {
        waitForElementToBeDisplayedAndClickableThenClick("//table [@id = 'tableProps']//input[@id = 'send']");
    }

    public void clickOkButtonOnDmfDistribute() {
        waitForElementToBeDisplayedAndClickableThenClick("//form//input [@id = 'addDocBtn']");
    }

    public boolean checkIsDocumentDistributed(String treeLocation) {
        toggleDocumentCheckboxOnDmfPage(treeLocation);
        clickPropertiesButtonOnDmfPage();
        waitForElement("//form[@id = 'cvdocumentProp']//input[@name = 'distribution']", 3);

        if (isElementPresent("//form[@id = 'cvdocumentProp']//input[@name = 'distribution'][@value = 'Sent']"))
        {
            clickBackOnDocumentPropertiesPage();
            return true;
        }

        clickBackOnDocumentPropertiesPage();
        return false;

    }

    public boolean isDistributionHistoryPage(String expectedResult) {
        waitForElement("//form [@name = 'cvdistHistory']//td[@style = 'font-weight: bold; font-family: Open Sans, helvetica, sans-serif;']");
        String pageName = driver.findElement(By.xpath("//form [@name = 'cvdistHistory']//td[@style = 'font-weight: bold; font-family: Open Sans, helvetica, sans-serif;']")).getText();
        if (pageName.equals(expectedResult))
        {
            return true;
        }
        return false;
    }

    public boolean isDistributionHistoryPopulated(String email) {
        waitForElement("//table//td");
        if (isElementPresent("//table//td[@title = '" + email + "; ']"))
        {
            return true;
        }
        return false;
    }

    public void clickBackButtonOnDistributionHistoryPage() {
        waitForElementToBeDisplayedAndClickableThenClick("//input[@type='button'][@value='Back']");
    }

    public void clickAccountsTabOnEPCDesktop() {
        driver.findElement(By.xpath("//div[@id='Desktop:MenuLinks-body']//tr//td//span[text()='My Accounts']")).click();
    }

    public void clickFirstAccountNumberInMyAccountsTable() {
        driver.findElement(By.xpath("//table[starts-with(@id,'gridview')]//tr[1]//td[1]//a")).click();
    }

    public void toggleOverridePolicyOnNewSubmissions(String policyPrefix)
    {
        driver.findElement(By.xpath("//div[@id='NewSubmission:NewSubmissionScreen:ProductOffersDV:CNAProductSelectionLV-body']//table[starts-with(@id,'gridview')]//tr//td//div[text()='BUA']/../../td[5]//img")).click();
        waitFor(3);
    }

    public void clickPolicyNumberLinkOnSubmissionConfirmation()
    {
        waitForElement("//div[@id='CNADesktopSubmissionConfirmation:CNADesktopSubmissionConfirmationScreen:subConPolicyShellLV-body']//a[@id='CNADesktopSubmissionConfirmation:CNADesktopSubmissionConfirmationScreen:subConPolicyShellLV:0:subConPolicyNo'][1]");
        driver.findElement(By.xpath("//div[@id='CNADesktopSubmissionConfirmation:CNADesktopSubmissionConfirmationScreen:subConPolicyShellLV-body']//a[@id='CNADesktopSubmissionConfirmation:CNADesktopSubmissionConfirmationScreen:subConPolicyShellLV:0:subConPolicyNo'][1]")).click();
    }

    public void clickNextOnPolicyInfoPage()
    {
        waitForElement("//span[@id='SubmissionWizard:Next-btnInnerEl']");
        driver.findElement(By.xpath("//span[@id='SubmissionWizard:Next-btnInnerEl']")).click();
    }

    public void clickWorkPlanInLeftMenuOnPolicyInfo()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//div[@id='SubmissionWizard:1-body']//table[starts-with(@id,'treeview')]//tr[3]//td//div");
    }

    public void toggleCheckboxForRowOnWorkplan(int row)
    {
        waitForElement("//div[@id='SubmissionWizard:JobWizardToolsMenuWizardStepSet:WorkplanScreen:JobWizardWorkplanPanelSet:JobWizardWorkplanLV-body']//tr["+row+"]//td[1]//img");
        driver.findElement(By.xpath("//div[@id='SubmissionWizard:JobWizardToolsMenuWizardStepSet:WorkplanScreen:JobWizardWorkplanPanelSet:JobWizardWorkplanLV-body']//tr["+row+"]//td[1]//img")).click();
    }

    public void clickAssignButtonOnWorkplan()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//span[@id='SubmissionWizard:JobWizardToolsMenuWizardStepSet:WorkplanScreen:JobWizardWorkplanPanelSet:JobWizardWorkplanLV_tb:JobWizardWorkplanPanelSet_AssignButton-btnInnerEl']");
    }

    public void clickAssignButtonOnAssignActivities()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//span[@id='AssignActivitiesPopup:AssignmentPopupScreen:AssignmentPopupDV:AssignmentByGroupPopupScreen_ButtonButton-btnInnerEl']");
    }

    public void clickPolicyInfoOnLeftToolbar()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//td[@id='SubmissionWizard:LOBWizardStepGroup:PolicyInfo']//span");
    }

    public void clickLockOnPolicyInfo()
    {
        waitForElementToBeDisplayedAndClickableThenClick("//span[@id='SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:JobWizardToolbarButtonSet:Unlockbutton-btnInnerEl']");
    }

    public void setUnderwritingCompanyOnPolicyInfo(String company)
    {
        String xpath = "//input[@id='SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:CNAUnderwritingInputSet:CNAUnderwritingDetailInputSet:UWCompany-inputEl']";
        waitForElementToBeDisplayedAndClickableThenClick(xpath);
        driver.findElement(By.xpath(xpath)).sendKeys(company);
        driver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
    }

    public void setWrittenDateWithin270DaysOfEffectiveDate()
    {
        String effectiveDate = driver.findElement(By.xpath("//input[@id='SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:EffectiveDate-inputEl']")).getAttribute("value");
        System.out.println(effectiveDate);
        String writtenDate = effectiveDate.substring(0,2).equals("10") || effectiveDate.substring(0,2).equals("11") || effectiveDate.substring(0,2).equals("12") ? "01/01/" + effectiveDate.substring(6) : "0" + (Integer.parseInt(effectiveDate.substring(0,2)) + 1) + "/01" + effectiveDate.substring(5);
        System.out.println(writtenDate);
        String writtenDateXpath = "//input[@id='SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:WrittenDate-inputEl']";
        waitForElementToBeDisplayedAndClickableThenClick(writtenDateXpath);
        driver.findElement(By.xpath(writtenDateXpath)).clear();
        driver.findElement(By.xpath(writtenDateXpath)).sendKeys(writtenDate);
    }
}

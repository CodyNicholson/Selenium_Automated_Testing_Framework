package WebpageMethods.EPC_Methods.Account_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cad6025 on 3/17/2017.
 */
public class Account_File_Documents extends EPC_Account_Methods
{
    public static Account_File_Documents instance = new Account_File_Documents();

    /**********************
    ***   Main Screen   ***
    **********************/

    public void clickClearFilterButton() {
        waitForElementToBeDisplayedAndClickableThenClick("//table[@id = 'filter'] //input[@id = 'clearFilterBtn']");
    }

    public void clickFilterButton() {
        waitForElementToBeDisplayedAndClickableThenClick("//table[@id = 'filter'] //input[@id = 'filterBtn']");
        waitFor(1);
    }

    public boolean isFilterErrorMessagePresent() {
        if (isElementPresent("//tr[@id = 'errorMsg'] //span[text() = ' No results found.']"))
        {
            return true;
        }
        return false;
    }

    public boolean isMatchingFilePresent(String ... filter) {
        /**
         * Joe's optional variable hack:
         *
         * Use ellipses.
         *
         * If the filter length is greater than "",
         * then assign it the correct filter string,
         * other wise assign it to null string
         */

        String sectionFilter        = filter.length >= 0 ? filter[0] : "";
        String typeFilter           = filter.length >= 0 ? filter[1] : "";
        String documentNameFilter   = filter.length >= 0 ? filter[2] : "";
        String userAddedFilter      = filter.length >= 0 ? filter[3] : "";
        String fromFilter           = filter.length >= 0 ? filter[4] : "";
        String toFilter             = filter.length >= 0 ? filter[5] : "";

        // Number of files (note: using findElements instead of findElement)
        List<WebElement> rowsList = driver.findElements(By.xpath("//table[@id = 'document_view']//tbody//tr[@class = 'leaf expanded']"));

        // Check each document and see if set filters match it
        for (int i = 0; i <= rowsList.size() - 1; i++)
        {
            // Grab an element from the list
            WebElement element = rowsList.get(i);

            // Grab element attributes
            String section = element.findElement(By.xpath("//td[@class = 'section']")).getText();
            String type = element.findElement(By.xpath("//td[@class = 'typeDesc']")).getText();
            String documentName = element.findElement(By.xpath("//td[@class = 'docName ui-draggable']")).getText();
            String userAdded = element.findElement(By.xpath("//td[@class = 'usradd']")).getText();
            String from = element.findElement(By.xpath("//td[@class = 'dateAdd']")).getText();
            String to = element.findElement(By.xpath("//td[@class = 'lastDtMod']")).getText();

            // If the sectionFilter equals the desired filter, element match
            if (section.equals(sectionFilter) || type.equals(typeFilter) || documentName.equals(documentNameFilter)
                    ||userAdded.equals(userAddedFilter) || from.equals(fromFilter) || to.equals(toFilter))
            {
                return true;
            }
        }

        return false;
    }

    public void clickEnter() {
        try{
            // Initialize robot
            Robot GLaDOS = new Robot();

            // Hit enter
            GLaDOS.keyPress(KeyEvent.VK_ENTER);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**********************
    ***   Set Filters   ***
    **********************/

    public void setSectionFilter(String filterName)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//table[@id = 'filter'] //select[@id = 'filter_sectionDD'] //option[text() = '" + filterName + "']");
    }

    public void setTypeFilter(String filterName)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//table[@id = 'filter'] //select[@id = 'filter_type'] //option[text() = '" + filterName + "']");
    }

    public void setDocumentNameFilter(String fileName)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//table[@id = 'filter'] //input[@id = 'filter_docnm']");
        driver.findElement(By.xpath("//table[@id = 'filter'] //input[@id = 'filter_docnm']")).sendKeys(fileName);
    }

    public void setSourceFilter()
    {

    }

    public void setUserAddedFilter(String userName)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//table[@id = 'filter'] //input[@id = 'filter_user']");
        driver.findElement(By.xpath("//table[@id = 'filter'] //input[@id = 'filter_user']")).sendKeys(userName);
    }

    public void setFromFilter(String fromDate)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//table[@id = 'filter'] //input[@id = 'filter_fromdate']");
        driver.findElement(By.xpath("//table[@id = 'filter'] //input[@id = 'filter_fromdate']")).sendKeys(fromDate);
    }

    public void setToFilter(String toDate)
    {
        waitForElementToBeDisplayedAndClickableThenClick("//table[@id = 'filter'] //input[@id = 'filter_todate']");
        driver.findElement(By.xpath("//table[@id = 'filter'] //input[@id = 'filter_todate']")).sendKeys(toDate);
    }

    /***********************
    ***   Template Add   ***
    ***********************/

    public boolean clickRadioButtonOnTemplateAdd(Integer index) {
        waitForElementToBeDisplayedAndClickableThenClick("//table[@id='template']//tr[" + index + "]//input");
        return clickNextOnTemplateAdd();
    }

    public void clickBackOnTemplateAdd() {
        waitForElement("//input[@type = 'button'][@value = 'Back']");
        driver.findElement(By.xpath("//input[@type = 'button'][@value = 'Back']")).click();
    }

    public void setPolicyOnTemplateAdd(int policyIndex) {
        policyIndex += 2;
        waitForElementToBeDisplayedAndClickableThenClick("//table[@id = 'policy_Select']//tr[" + policyIndex + "]//input[@type = 'checkbox']");
    }

    public boolean checkInformationFilledOnTemplateAdd(int policyIndex) {
        policyIndex += 2;
        String policyName = driver.findElement(By.xpath("//table[@id = 'policy_Select']//tr[" + policyIndex + "]")).getText().trim();
        String accountPolicyProperty = driver.findElement(By.xpath("//table//select[@id = 'add_document_accPolicy']")).getText();

        if (accountPolicyProperty.endsWith(policyName))
        {
            return true;
        }
        return false;
    }

    public boolean clickGenerateTemplateOnTemplateAdd() {
        waitForElementToBeDisplayedAndClickableThenClick("//input[@id = 'generateTemplate']");
        return true;
    }

    /**********************
    ***   PDF Actions   ***
    **********************/

    public boolean clickSaveFinalOnPDF() {
        waitFor(3);
        try{

            // Initialize robot
            Robot robot = new Robot();

            // Loop to save final button
            for (int i = 0; i < 27; i++)
            {

                System.out.println(i);
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
            }

            // Save final
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            waitFor(2);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            waitFor(2);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void clickAddFromTemplateButton() {
        waitForElementToBeDisplayedAndClickableThenClick("//a[@id='addFromTemplate']", 10);
    }

    public void switchDriverFrameToDocumentsIframe() {
        waitForElement("//iframe[@id = 'dmflinkframe']");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id = 'dmflinkframe']")));
        waitFor(1);
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
}

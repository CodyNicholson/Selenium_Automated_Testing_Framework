package WebpageMethods.EPC_Methods.Desktop_Methods;

/**
 * Created by cad6025 on 2/2/2017.
 */

// Imports
import WebpageMethods.EPC_Methods._EPC_Master_Methods;
import org.openqa.selenium.*;
import Applications.DmfMasterTester.PaginationBarCheck.Strategy.PaginationTabContext;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class EPC_Desktop_Methods extends _EPC_Master_Methods
{
    private PaginationTabContext strategy = new PaginationTabContext();

    public static EPC_Desktop_Methods instance = new EPC_Desktop_Methods();

    String firstElementValue;
    String secondElementValue;

    public boolean gotoPageNumberDesktop(Integer pageNumber)
    {
        // Grab first elements' values
        firstElementValue = user.driver.findElement(By.xpath(strategy.getFirstElementEntry())).getText();
        secondElementValue = user.driver.findElement(By.xpath(strategy.getSecondElementEntry())).getText();

        // Enter in desired page number
        user.waitForElement(strategy.getPageNumber());
        user.driver.findElement(By.xpath(strategy.getPageNumber())).clear();
        user.driver.findElement(By.xpath(strategy.getPageNumber())).sendKeys(pageNumber.toString());
        user.driver.findElement(By.xpath(strategy.getPageNumber())).sendKeys(Keys.ENTER);

        // Wait for elements to change
        waitForElementChange(15, firstElementValue, secondElementValue);

        // Check newly updated page with desired page
        Integer updatedPageNumber = Integer.parseInt(user.driver.findElement(By.xpath(strategy.getPageNumber())).getAttribute("value"));
        return updatedPageNumber == pageNumber;
    }

    public boolean gotoNextPageDesktop()
    {
        // Get current page number
        user.waitForElement(strategy.getPageNumber());
        Integer currentPageNumber = Integer.parseInt(user.driver.findElement(By.xpath(strategy.getPageNumber())).getAttribute("value"));

        // Grab first and second elements' values
        firstElementValue = user.driver.findElement(By.xpath(strategy.getFirstElementEntry())).getText();
        secondElementValue = user.driver.findElement(By.xpath(strategy.getSecondElementEntry())).getText();

        // Click next page button
        user.waitForElementToBeDisplayedAndClickableThenClick(strategy.getNextPage());

        // Wait for elements to change
        waitForElementChange(15, firstElementValue, secondElementValue);

        // Get updated page number
        user.waitForElement(strategy.getPageNumber());
        Integer updatedPageNumber = Integer.parseInt(user.driver.findElement(By.xpath(strategy.getPageNumber())).getAttribute("value"));

        // Check updated page number vs previous page number
        return ((currentPageNumber + 1) == (updatedPageNumber + 0));
    }

    public boolean gotoPreviousPageDesktop()
    {
        // Get current page number
        user.waitForElement(strategy.getPageNumber());
        Integer currentPageNumber = Integer.parseInt(user.driver.findElement(By.xpath(strategy.getPageNumber())).getAttribute("value"));

        // Grab first and second element's values
        firstElementValue = user.driver.findElement(By.xpath(strategy.getFirstElementEntry())).getText();
        secondElementValue = user.driver.findElement(By.xpath(strategy.getSecondElementEntry())).getText();

        // Click previous page button
        user.waitForElementToBeDisplayedAndClickableThenClick(strategy.getPreviousPage());

        // Wait for elements to change
        waitForElementChange(10, firstElementValue, secondElementValue);

        user.waitFor(1);
        // Get updated page number
        user.waitForElement(strategy.getPageNumber());
        Integer updatedPageNumber = Integer.parseInt(user.driver.findElement(By.xpath(strategy.getPageNumber())).getAttribute("value"));

        // Check updated page number vs previous page number
        return ((currentPageNumber - 1) == (updatedPageNumber + 0));
    }

    public boolean gotoFinalPageDesktop()
    {
        // Grab first elements' values
        firstElementValue = user.driver.findElement(By.xpath(strategy.getFirstElementEntry())).getText();
        secondElementValue = user.driver.findElement(By.xpath(strategy.getSecondElementEntry())).getText();

        // Click last page button
        waitForElementToBeDisplayedAndClickableThenClick(strategy.getFinalPageButton());

        // Page doesn't load fast enough
        waitForElementChange(10, firstElementValue, secondElementValue);

        // Check page
        int pageNumber = Integer.parseInt(user.driver.findElement(By.xpath(strategy.getPageNumber())).getAttribute("value"));
        String finalPageNumberText = user.driver.findElement(By.xpath(strategy.getFinalPageText())).getText();

        // Cut off the first 3 characters of string
        finalPageNumberText = finalPageNumberText.substring(3);

        int finalPageNumber = Integer.parseInt(finalPageNumberText);
        return pageNumber == finalPageNumber;
    }

    public boolean gotoFirstPageDesktop()
    {
        // Grab first elements' values
        firstElementValue = user.driver.findElement(By.xpath(strategy.getFirstElementEntry())).getText();
        secondElementValue = user.driver.findElement(By.xpath(strategy.getSecondElementEntry())).getText();

        // Click first page button
        waitForElementToBeDisplayedAndClickableThenClick(strategy.getFirstPage());

        // Check that values are different
        waitForElementChange(15, firstElementValue, secondElementValue);
        user.waitFor(1);

        // Check page
        user.waitForElement(strategy.getPageNumber());
        Integer pageNumber = Integer.parseInt(user.driver.findElement(By.xpath(strategy.getPageNumber())).getAttribute("value"));
        return pageNumber == 1;
    }

    public void clickDesiredTab()
    {
        String currentElementValue = user.driver.findElement(By.xpath("//span[starts-with(@id, 'header-')]//span[@class = 'g-title']")).getText();
        waitForElementToBeDisplayedAndClickableThenClick(strategy.getDesiredTab());
        waitForElementChange(5, currentElementValue);
    }

    public void waitForElementChange(int seconds, String firstElementValue, String secondElementValue)
    {

        // For time up to seconds given
        for (int i = 0; i <= seconds; i++)
        {
            // Set updated elements to check against previously given elements
            String updatedFirstElementValue = (user.driver.findElement(By.xpath(strategy.getFirstElementEntry()))).getText();
            String updatedSecondElementValue = (user.driver.findElement(By.xpath(strategy.getSecondElementEntry()))).getText();

            // Try to see if they're different
            try
            {
                // If element is different
                if (updatedFirstElementValue != firstElementValue || updatedSecondElementValue != secondElementValue)
                {
                    // Element has changed
                    user.waitFor(4);
                    return;
                }
            }
            // Elements haven't changed yet
            catch (NoSuchElementException e)
            {
                // Elements haven't changed in given time
                if (i == seconds)
                {
                    System.out.println("The elements haven't changed");
                    Assert.fail();
                }
                driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            }
        }

    }

    public void waitForElementChange(int seconds, String elementValue)
    {
        for (int i = 0; i <= seconds; i++)
        {
            // Set updated element to check against previously given element
            String updatedElementValue = (user.driver.findElement(By.xpath("//span[starts-with(@id, 'header-')]//span[@class = 'g-title']"))).getText();

            // Try to see if the two elements are different
            try
            {
                // If element is different
                if (updatedElementValue != elementValue)
                {
                    // Element has changed
                    user.waitFor(1);
                    return;
                }
            }
            // Elements haven't changed yet
            catch (NoSuchElementException e)
            {
                if (i == seconds)
                {
                    System.out.println("The element hasn't changed");
                    Assert.fail();
                }
                driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            }
        }
    }

}

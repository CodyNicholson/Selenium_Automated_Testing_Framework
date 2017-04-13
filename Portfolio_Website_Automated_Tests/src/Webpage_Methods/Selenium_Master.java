package Webpage_Methods;

import Webpage_Methods.codynicholson.github.io.Resume;
import org.testng.Assert;

// Java imports
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Org.openqa imports
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

// Org.apache imports
import org.apache.commons.io.FileUtils;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.DataFormatter;

/**
 * Created by Cody on 4/13/2017.
 */
public class Selenium_Master
{
    public Selenium_Master user = this;
    private static Selenium_Master instance = null;
    protected Selenium_Master(){}
    public static Selenium_Master getInstance()
    {
        if (instance == null)
        {
            instance = new Selenium_Master();
        }
        return instance;
    }
    
    public static WebDriver driver;

    public WebDriver getWebDriver()
    {
        return driver;
    }

    public void webDriver(String getURL)
    {
        this.setWebDriver(driver);
        this.getWebDriver().get(getURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void setWebDriver(WebDriver webDriver)
    {
        System.setProperty("webdriver.chrome.driver", "jars/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        // Set the binary for chrome, refactor this in the future to allow different browsers
        chromeOptions.setBinary(context.chromeApplicationPath());
        WebDriver driver = new ChromeDriver(chromeOptions);
        //driver.manage().window().maximize();
        webDriver = driver;

        //Set driver to webDriver and pass into this class public Webdriver driver;
        this.driver = webDriver;
    }
    
    public void goToUrl(String envURL)
    {
        driver.get(envURL);
        try
        {
            Alert alt = driver.switchTo().alert();
            alt.accept();
        }
        catch (Exception e) {}
        waitFor(2)
    }
    
    public void closeBrowser()
    {
        driver.quit();
    }

    public void closeTab()
    {
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.close();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
    
    public void waitFor(int numSeconds)
    {
        try{
            Thread.sleep(numSeconds*1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void waitForPageToLoad(int waitTime)
    {
        driver.manage().timeouts().pageLoadTimeout(waitTime, TimeUnit.SECONDS);
    }
    
    public void takeScreenshot(String name)
    {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File targetFile = new File("Results/failureScreenshots/"+name+".jpg");

        try
        {
            FileUtils.copyFile(srcFile, targetFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void waitForElement(String xpath)
    {
        for(int i = 0; i <= 10; i++)
        {
            try
            {
                driver.findElement(By.xpath(xpath));
                return;
            }
            catch (NoSuchElementException e)
            {
                waitFor(1);
            }
        }
        System.out.println("The element did not appear");
        Assert.fail();
    }

    public void waitForElement(String xpath, Integer waitTime)
    {
        for(int i = 0; i <= waitTime; i++)
        {
            try
            {
                driver.findElement(By.xpath(xpath));
                return;
            }
            catch (NoSuchElementException e)
            {
                waitFor(1);
            }
        }
        System.out.println("The element did not appear");
        Assert.fail();
    }

    public void waitForElementToBeDisplayed(String xpath, Integer waitTime)
    {
        for(int i = 0; i <= waitTime; i++)
        {
            try
            {
                if(driver.findElement(By.xpath(xpath)).isDisplayed())
                    return;
            }
            catch (NoSuchElementException e)
            {
                waitFor(1);
            }
        }
        System.out.println("The element was not displayed");
        Assert.fail();
    }

    public void waitForElementToBeDisplayed(String xpath)
    {
        for(int i = 0; i < 10; i++)
        {
            try
            {
                if(driver.findElement(By.xpath(xpath)).isDisplayed())
                    return;
            }
            catch (NoSuchElementException e)
            {
                waitFor(1);
            }
        }
        System.out.println("The element was not displayed");
        Assert.fail();
    }

    public void waitForElementToDisappear(String xpath, Integer waitTime)
    {
        for(int i = 0; i <= waitTime; i++)
        {
            if(driver.findElement(By.xpath(xpath)).isDisplayed()){waitFor(1);}
            else{return;}
        }
    }
    
    public ArrayList<List<String>> readExcelFileRows(String file)
    {
        try
        {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;
            HSSFCell cell;
            DataFormatter formatter = new DataFormatter();

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = 0; // No of columns
            int tmp;
            ArrayList<List<String>> rowList = new ArrayList<>();
            setNumAccountsToCreateFromExcelDoc(rows - 1);

            // This trick ensures that we get the data properly even if it doesn't start from first few rows
            for(int i = 0; i < 10 || i < rows; i++)
            {
                row = sheet.getRow(i);
                if(row != null)
                {
                    tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                    if(tmp > cols) cols = tmp;
                }
            }

            for(int r = 1; r < rows; r++)
            {
                List<String> rowContent = new ArrayList<>();
                row = sheet.getRow(r);
                if(row != null)
                {
                    for(int c = 0; c < cols; c++)
                    {
                        cell = row.getCell((short)c);
                        if(cell != null)
                        {
                            rowContent.add(formatter.formatCellValue(cell));
                        }
                    }
                }
                rowList.add(rowContent);
            }
            System.out.println(rowList.toString());
            return rowList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Could not find Excel doc");
        }
        return null;
    }
    
    public void switchToDefaultContext()
    {
        driver.switchTo().defaultContent();
    }

    /**
     * Will try to click element every second for however many seconds you input, default is 10
     * @param xpath
     * @param seconds
     */
    public void waitForElementToBeDisplayedAndClickableThenClick(String xpath, int seconds)
    {
        waitForElementToBeDisplayed(xpath);
        for(int i = 0; i < seconds; i++) {
            try {
                driver.findElement(By.xpath(xpath)).click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
            System.out.println("Element did not appear: " + xpath);
        }
    }

    /**
     * Will try to click element every second for 10 seconds
     * @param xpath
     */
    public void waitForElementToBeDisplayedAndClickableThenClick(String xpath)
    {
        waitForElementToBeDisplayed(xpath);
        for(int i = 0; i < 10; i++) {
            try {
                driver.findElement(By.xpath(xpath)).click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
        System.out.println("Element did not appear: " + xpath);
    }
    
    public boolean isSelected(String xpath)
    {
        return driver.findElement(By.xpath(xpath)).isSelected();
    }

    public boolean isEnabled(String xpath)
    {
        return driver.findElement(By.xpath(xpath)).isEnabled();
    }

    public boolean isDisplayed(String xpath)
    {
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    public void sendTextToElement(String xpath, String text)
    {
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    public String getText(String xpath)
    {
        return driver.findElement(By.xpath(xpath)).getText();
    }
    
    public Resume Resume_Page = Resume.instance;
    public Index = Index_Page = Index.instance;
}

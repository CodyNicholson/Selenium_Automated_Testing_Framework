package Webpage_Methods;

// Java imports
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

// Org.apache imports
import org.apache.commons.io.FileUtils;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.DataFormatter;

// User imports
import Users.strategyContext;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;

public class Selenium_Master
{
    // Singleton setup

    protected Selenium_Master(){}

    public Selenium_Master user = this;

    private static Webpage_Methods.Selenium_Master instance = null;

    public static Webpage_Methods.Selenium_Master getInstance()
    {
        if (instance == null)
        {
            instance = new Webpage_Methods.Selenium_Master();
        }
        return instance;
    }



    // Setting up WebDriver

    public static WebDriver driver;

    private strategyContext context = new strategyContext();

    public WebDriver getWebDriver()
    {
        return driver;
    }

    public void setupWebDriverForChromeTesting()
    {
        System.setProperty("webdriver.chrome.driver", "jars/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.setBinary(context.chromeApplicationPath());
        driver = new ChromeDriver(chromeOptions);
    }

    public void setupWebDriverForIETesting()
    {

    }

    public void setupWebDriverForFirefoxTesting()
    {
        /* Does not work yet */
        //ProfilesIni profile = new ProfilesIni();
        //FirefoxProfile myProfile = profile.getProfile("Automated_Testing_Profile");
        //driver = new FirefoxDriver(myProfile);
        //driver.manage().window().maximize();
    }

    public void closeBrowser()
    {
        driver.quit();
    }

    public void closeTab()
    {
        driver.close();
        switchToTab(0);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }



    // Wait for elements to load or to be displayed

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

    public void waitForElementCode(String xpath)
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

    public void waitForElementCode(String xpath, Integer waitTime)
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
        for(int i = 0; i <= waitTime/4; i++)
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
            catch (Exception e)
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



    // Handling frame elements

    public void switchToDefaultContext()
    {
        driver.switchTo().defaultContent();
    }

    public void switchToIFrame(String nameOrXpath)
    {
        driver.switchTo().frame(nameOrXpath);
    }



    // Working with elements

    public void clickElement(String xpath, int searchTime)
    {
        waitForElementToBeDisplayed(xpath);
        for(int i = 0; i < searchTime; i++) {
            try {
                driver.findElement(By.xpath(xpath)).click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
            System.out.println("Element did not appear: " + xpath);
        }
    }

    public void clickElement(String xpath)
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

    public static boolean isPresent(String xpath)
    {
        try
        {
            driver.findElement(By.xpath(xpath));
            return true;
        }
        catch (NoSuchElementException e)
        {
            //e.printStackTrace();
            return false;
        }
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
        waitFor(2);
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    public void sendTextToElement(String xpath, String text)
    {
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    public String getTextFromElement(String xpath)
    {
        return driver.findElement(By.xpath(xpath)).getText();
    }



    // Utilities

    public void printLogMessage(String message)
    {
        System.out.println(message);
    }

    public void goToUrl(String envURL)
    {
        driver.get(envURL);
    }

    public void takeScreenshot(String name)
    {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File targetFile = new File("src/Results/Failure_Screenshots/" +name+".jpg");

        try
        {
            FileUtils.copyFile(srcFile, targetFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public String getCurrentUrl()
    {
        return driver.getCurrentUrl();
    }

    public void switchToTab(int i)
    {
        waitFor(2);
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(i));
    }



    // Read data from excel sheet to use in test cases

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
}

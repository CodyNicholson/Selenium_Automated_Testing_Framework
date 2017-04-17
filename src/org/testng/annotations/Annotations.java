//package org.testng.annotations;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.io.File;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//public class Annotations
//{
//    public WebDriver driver = null;
//
//    @BeforeClass
//    public void testSetup(WebDriver webDriver)
//    {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\cad5124\\Documents\\selenium jars\\chromedriver.exe");
//        ChromeOptions chromeOptions = new ChromeOptions();
//
//        //set the binary for chrome, refactor this in the future to allow different browsers
//        chromeOptions.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
//
//        WebDriver driver = new ChromeDriver(chromeOptions);
//        driver.manage().window().maximize();
//        webDriver = driver;
//    }
//
//    @AfterTest
//    public void closeBrowser()
//    {
//
//    }
//
//    public void takeScreenshot()
//    {
//        String name = getCurrentDate();
//        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        File targetFile = new File("U:\\IdeaProjects\\Automation_Framework\\failureScreenshots\\"+name+".jpg");
//
//        try
//        {
//            FileUtils.copyFile(srcFile, targetFile);
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    public String getCurrentDate()
//    {
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YYYY");
//        LocalDate localDate = LocalDate.now();
//        return dtf.format(localDate);
//    }
//}

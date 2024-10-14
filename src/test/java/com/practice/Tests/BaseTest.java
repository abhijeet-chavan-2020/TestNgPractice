package com.practice.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeTest
    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    @AfterMethod
    public void takeScreenshotAfterFailure(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE){
            Utils.ScreenShotHelper.takeScreenShot(driver, result.getMethod().getMethodName()+ "_"+ System.currentTimeMillis());
        }
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

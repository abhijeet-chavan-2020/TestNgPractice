package com.practice.Tests.CaptureSSFailedTestCases;

import com.practice.Tests.BaseTest;
import com.practice.Tests.ListenersPractice.ITestListenerPractice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ScreenShotFailedTCUsingTestNgListeners  extends BaseTest {

    @BeforeClass
    public void launchWebPage(){
        driver.get("https://www.phoenixmarketcity.com/pune");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("logo-black"))));
    }

    @Test(testName = "This is test1")
    public void test1(){
        WebElement logo= driver.findElement(By.className("logo-black"));
        Assert.assertTrue(!logo.isDisplayed(), "Logo is not displayed");
    }

    @Test(testName = "This is test2")
    public void test2(){
        WebElement phone= driver.findElement(By.id("ctl00_primaryPhone"));
        Assert.assertEquals(phone.getText(),"02066890086" );
    }

    @Test(testName = "This is test3")
    public void test3(){
        WebElement brandMenuLink= driver.findElement(By.id("brands"));
        brandMenuLink.click();
        wait.until(ExpectedConditions.urlToBe("https://www.phoenixmarketcity.com/pune/brands"));
        Utils.ScreenShotHelper.saveScreenshotPNG();
    }


}

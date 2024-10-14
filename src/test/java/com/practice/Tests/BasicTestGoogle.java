package com.practice.Tests;

import Utils.ScreenShotHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

public class BasicTestGoogle {
    @Test
    public  void TestGoogle() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        WebElement ele= driver.findElement(By.name("q"));
        WebElement eleNew= driver.findElement(By.xpath("//div[@data-hveid=\"CCUQAA\"]"));
        ScreenShotHelper.takeElementScreenshot(eleNew);
        ScreenShotHelper.printPageInPDF(driver, "MyFile");
        driver.findElement(By.name("q")).sendKeys("OrangeHRM", Keys.ENTER);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@href=\"https://www.orangehrm.com/\"]"))));
        System.out.println("driver.getTitle() = " + driver.getTitle());
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        driver.close();
        driver.quit();
    }


}

package com.practice.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TimeoutTests {
    //Timeout is an attribute present inside @Test annotations. Accepting the time in milliseconds format. Ex. for 5 seconds, pass value=5000
    // This is applicable to test method. @Test(timeout=5000)
    // If the method is not completed within the given time, then TestNg will mark this test case as failed. And TestNg will throw ThreadTimeoutException
    //ExpectedExceptions is an attribute present inside @Test annotations.
    //We may have some test cases where we click on something and some element disappears from the web page and the DOM is also updated.
    // If we want to validate that the element is now not present on the web page then we can expect this exception to NoSuchElementException.
    //Similarly, there will be some other negative testing we will be doing. During that time we may need this exceptions.

    @Test(timeOut = 2000)
    public void testmethod1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/");
        driver.quit();
    }

    @Test(expectedExceptions = {NoSuchElementException.class})
    public void testmethod2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/");
        driver.findElement(By.id("abcd")).click();
        driver.quit();
    }
}

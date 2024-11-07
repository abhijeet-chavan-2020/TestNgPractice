package com.practice.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class MyTest {
    int i=10;
    static int j=15;
    MyTest(){
        System.out.println("I am from constructor");
    }

    {
        System.out.println("I am from blank curly braces");
    }

    static{
        System.out.println("I am form Static block");
    }

    public static void main(String[] args) throws InterruptedException {
        MyTest t= new MyTest();
        MyTest t1= new MyTest();
        String s= "new";
        s.concat("name");
        System.out.println(s);
        System.out.println("t.i = " + t.i);
        System.out.println("t1.i = " + t1.i);
        System.out.println("t.j = " + t.j);
        System.out.println("t1.j = " + t1.j);
        t.i=12;
        t1.i=20;
        t.j=40;
        System.out.println("After t updating the static variable t1.j = " + t1.j);
        System.out.println("after updating using object t.i = " + t.i);
        System.out.println("after updating using object  t1.i = " + t1.i);

        //    seleniumTest();
    }

    public static void seleniumTest() throws InterruptedException {
        // Set up WebDriver (Assuming you have added the path to your chromedriver)
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Open multiple tabs (this part will vary depending on your specific use case)
        driver.get("https://google.com");
        driver.get("https://stackoverflow.com");

        // Get the window handles of all open tabs
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();

        // Close each tab one by one
        while (iterator.hasNext()) {
            String windowHandle = iterator.next();
            // Switch to the tab
            driver.switchTo().window(windowHandle);
            // Close the current tab
            driver.close();
            // Pause for a moment to see the tabs closing one by one (optional)
            Thread.sleep(1000);
        }

        // Quit the driver after all tabs are closed
        driver.quit();
    }
}

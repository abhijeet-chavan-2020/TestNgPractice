package com.practice.Tests;

import org.testng.annotations.*;

@Ignore
public class IgnoreTests2 {

//1. What is Ignore ? why we need to use the Ignore?
//            2. Ignore the specific test methods
//3. Ignore all the test methods in a testng class
//4. Ignore all the test methods in a package
// We can ignore/disable tests in multiple ways, @Test(enable=false), in testng.xml we can add attribute on test level enabled="false"
    // @Ignore annotation above @Test annotation, this annotation will take precedence even if @Test(enabled=true) - by defaults enabled=true for all @Test.
// then we can add @Ignore annotation on Class level above class name. This will Ignore all the test cases in that class.
// and then we can ignore test cases in a package as well. For this we need to create package-info.java file by simply creating a simple file and naming it package-info.java.
// in this file, add @Ignore annotation and then list the package <package-name> , all the packages in which tests you want to ignore.
// When we run such tests where in package-info.java the package names are mentioned, then @BeforeSuite and @AfterSuite annotations are getting executed. No other annotations gets executed in this case.
    @BeforeSuite
    public void setup() {
        System.out.println("@BeforeSuite --- Setup Environment parameters - " + IgnoreTests2.class);
    }

    @BeforeClass
    public void setupBeforeClass() {
        System.out.println("@BeforeClass --- Setting up Class level details - " + IgnoreTests2.class);
    }

    @Test(enabled = true)
    public void setupTestData() {
        System.out.println("No Priority Present - --- Setup TestData");
    }


    @Test (priority = 0)
    public void setupBrowserOptions() {
        System.out.println("priority = 0 - --- setup Browser Options");
    }

    @Test(priority=-1)
    public void init() {
        System.out.println("priority=-1  ---- Initialize WebBrowser");
    }

    @Ignore
    @Test(priority=1)
    public void Signup() {
        System.out.println("priority=1 ----- Signup");
    }

    @Test(priority=2)
    public void Login() {
        System.out.println("priority=2  ---- -Login");
    }

    @Test(priority=3)
    public void SearchForTheFlight() {
        System.out.println("priority=3   ------ SearchForTheFlight");
    }

    @Test(priority=4)
    public void BookTheFlight() {
        System.out.println("priority=4  ------- BookTheFlight");
    }

    @Test(priority=5)
    public void SaveTheTicket() {
        System.out.println("priority=5 ------SaveTheTicket");
    }

    @Test(priority=6)
    public void Logout() {
        System.out.println("priority=6  ------- Logout");
    }

    @AfterSuite
    public void tearDown(){
        System.out.println("@AfterSuite   --- Closing the browser and driver" +  IgnoreTests2.class);
    }
}

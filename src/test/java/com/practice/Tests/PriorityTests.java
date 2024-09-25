package com.practice.Tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PriorityTests {
//            1. What is priority? why we need to use the priority?
//            2. How to define the priority?
//            3. What is the default value of priority? = 0
//            4. Can we pass negative values to priority? yes, negative priority will execute first, then priority 0, then no priority etc
//            5. What happens when same priority is provided to multiple methods? ASCII order will follow

    @BeforeSuite
    public void setup() {
        System.out.println("@BeforeSuite --- Setup Environment parameters - ");
    }

    @Test
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
        System.out.println("@AfterSuite   --- Closing the browser and driver");
    }
}

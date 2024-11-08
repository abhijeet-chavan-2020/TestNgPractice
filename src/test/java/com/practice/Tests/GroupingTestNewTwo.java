package com.practice.Tests;

import org.testng.annotations.Test;

@Test(groups = {"GroupingTest"})

public class GroupingTestNewTwo {

    @Test(groups= {"smoke"})
    public void test4() {
        System.out.println("test4");
    }

    @Test(groups= {"smoke","functional","sanity", "ios.smoke"})
    public void test5() {
        System.out.println("test5");
    }

    @Test(groups= {"functional", "regression","windows.functional","ios.functional"})
    public void test6() {
        System.out.println("test6");
    }

    @Test
    public void test7() {
        System.out.println("test7");
    }

    @Test(groups= {"windows.regression","ios.functional"})
    public void test8() {
        System.out.println("test8");
    }
}

package com.practice.Tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DependencyTest {
    // We can create test dependency on test groups and on test methods.
    // 01:15 What is a test dependency?
    //06:25 Why we need test dependencies? - Even if after providing priority, if any test case fails which is dependent on subsequent test cases, then still those test cases will be executed and those will be failed.
    //16:55 How to create a test dependency on other test(s)? We can create dependency on one or multiple test methods. dependsOnMethods={"method1","method2"}
    //26:39 What happens when priority is set to the test methods?
    //29:42 What happens when dependent test is failed? Subsequent test cases will be skipped.
    //32:56 What happens when dependent test is ignored/skipped/deleted?
// If the dependent test case is failed, then the subsequent test cases will be skipped and thus the time will be saved.
    // when we use priority on top of dependOnMethods, then priority is simply ignored.
    //when dependent test case is failed and even then you want to run any subsequent test case, then add a parameter to that test case - alwaysRun=true
    // what if we add alwaysRun=true and add @Ignore to that test method?
    // If we add @Ignore to the test method which is dependent test method, then the dependent method won't run and subsequent method will be executed. Because the dependent test method should be not Ignored, it should be enabled.
    //If dependent method is made disabled with parameter enabled=false, then it won't get executed and subsequent method will be executed.
    //if we add both enabled=false and alwaysRun=true, still that test case will not be executed rather it will be disabled.
    //@Ignore, enabled=false and alwaysRun=true -> test case will be ignored.
    //What is dependent method is removed/ deleted/skipped/ignored - we will get an exception.
    // If we want to run a test method even when the dependent method is ignored/ skipped/ deleted and an exception might be thrown, but still we want to execute a test method, then add
    //a parameter- ignoreMissingDependencies= true
    static String trackingNumber = null;

    @Test( alwaysRun = true)
    public void CreateShipment() throws Exception
    {
        //System.out.println(5/0);
        System.out.println("CreateShipment");
        trackingNumber = "ABC12YH";
    }

    @Test( priority=3,dependsOnMethods = {"CreateShipment","TrackShipment"},ignoreMissingDependencies = true )
    public void CancelShipment() throws Exception
    {
        if(trackingNumber !=null)
            System.out.println("CancelShipment");
        else
            throw new Exception("invalid tracking number");
    }

    @Test( dependsOnMethods = {"CreateShipment"},ignoreMissingDependencies = true )
    public void TrackShipment() throws Exception
    {
        if(trackingNumber !=null)
            System.out.println("TrackShipment");
        else
            throw new Exception("invalid tracking number");
    }
}

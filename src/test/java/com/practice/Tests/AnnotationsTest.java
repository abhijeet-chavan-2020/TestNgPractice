package com.practice.Tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationsTest {

    @BeforeSuite
    public void beforeSuiteTest(){
        System.out.println("I am in beforeSuiteTest in "+ AnnotationsTest.class);
    }

    @AfterSuite
    public void afterSuiteTest(){
        System.out.println("I am in afterSuiteTest in "+ AnnotationsTest.class);
    }

    @AfterClass
    public void afterClassTest(){
        System.out.println("I am in afterClassTest in "+ AnnotationsTest.class);
    }

    @BeforeClass
    public void beforeClassTest(){
        System.out.println("I am in beforeClassTest in "+ AnnotationsTest.class);
    }

    @BeforeTest
    public void beforeTestTest(){
        System.out.println("I am in beforeTestTest in "+ AnnotationsTest.class);
    }

    @AfterTest
    public void afterTestTest(){
        System.out.println("I am in afterTestTest in "+ AnnotationsTest.class);
    }

    @BeforeMethod
    public void beforeMethodTest(){
        System.out.println("I am in beforeMethodTest in "+ AnnotationsTest.class);
    }

    @AfterMethod
    public void afterMethodTest(){
        System.out.println("I am in afterMethodTest in "+ AnnotationsTest.class);
    }

    @BeforeGroups
    public void beforeGroupsTest(){
        System.out.println("I am in beforeGroupsTest in "+ AnnotationsTest.class);
    }

    @AfterGroups
    public void afterGroupsTest(){
        System.out.println("I am in afterGroupsTest in "+ AnnotationsTest.class);
    }

    @Test (groups = "Easy", description = "Easy Addition Test")
    public void additionTest(){
        int i=10;
        int j=20;
        System.out.println("Addition of i="+i+" and j="+j+" is= "+ (i+j));
        Assert.assertEquals((i+j), 35);
    }

    @Test (groups = "Easy", description = "Easy Subtraction Test")
    public void subtractionTest(){
        int i=10;
        int j=20;
        System.out.println("Subtraction of i="+i+" and j="+j+" is= "+ (j-i));
    }

    @Test (groups = "Difficult", description = "Difficult multiplication Test")
    public void multiplicationTest(){
        int i=10;
        int j=20;
        System.out.println("Multiplication of i="+i+" and j="+j+" is= "+ (i*j));
    }

    @Test (groups = "Difficult", description = "Difficult division Test")
    public void divisionTest(){
        int i=10;
        int j=20;
        System.out.println("Division of i="+i+" and j="+j+" is= "+ (j/i));
    }
}

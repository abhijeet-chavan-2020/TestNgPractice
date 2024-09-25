package com.practice.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

public class AssertionsTest {

    SoftAssert softAssert= new SoftAssert();
    @Test
    public void assertEqualsTest(){
        int i=10;
        String s="India";
        boolean flag=true;
        double d=15.15;
        assertEquals(10, i, "Integer Value is mismatched");
        assertEquals("India", s, "String Value is mismatched");
        assertEquals(true, flag, "Boolean Value is mismatched");
        assertEquals(15.10, d, "Double Value is mismatched");
    }

    @Test
    public void assertNotEqualsTest(){
        int i=10;
        String s="India";
        boolean flag=true;
        double d=15.15;
        assertNotEquals("", null,"Value should not be null");
        assertNotEquals(11, i, "Integer Value is matched");
        assertNotEquals("India", s, "String Value is matched");
        assertNotEquals(true, flag, "Boolean Value is matched");
        assertNotEquals(15.15, d, "Double Value is matched");
    }

    @Test
    public void assertTrueTest(){
        int i=10;
        String s="India";
        boolean flag=true;
        double d=15.15;
        assertTrue(s.contains("Ind"),"String does not contain character Ind");
        assertTrue((i<=15),"Value is greater than 15");
        assertTrue(d!=15.12,"Value is not equal to 15.12");
        assertTrue(flag==false,"Flag is false");
    }

    @Test
    public void assertFalseTest(){
        int i=10;
        String s="India";
        boolean flag=true;
        double d=15.15;
        assertFalse(s.contains("Aus"),"String does not contain character Aus");
        assertFalse((i>=15),"Value is greater than 15");
        assertFalse(d==15.12,"Value is not equal to 15.12");
        assertFalse(flag!=false,"Flag is false");
    }

    @Test
    public void softAssertTest(){
        int i=10;
        String s="India";
        boolean flag=true;
        double d=15.15;
        softAssert.assertEquals(15, i, "Integer Value is mismatched");
        softAssert.assertEquals("Australia", s, "String Value is mismatched");
        softAssert.assertEquals(false, flag, "Boolean Value is mismatched");
        softAssert.assertEquals(15.15, d, "Double Value is mismatched");

        softAssert.assertNotEquals("", null,"Value should not be null");
        softAssert.assertNotEquals(11, i, "Integer Value is matched");
        softAssert.assertNotEquals("India", s, "String Value is matched");
        softAssert.assertNotEquals(true, flag, "Boolean Value is matched");
        softAssert.assertNotEquals(15.15, d, "Double Value is matched");

        softAssert.assertAll("The combined effect of all the Assertion is: \n If all the assertions are passed then test is passed. \n if any assertion is failed then effective test case is failed.");
    }

}

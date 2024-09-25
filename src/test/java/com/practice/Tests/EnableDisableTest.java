package com.practice.Tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EnableDisableTest {

    SoftAssert softAssert= new SoftAssert();

    @Parameters({"num1", "num2"})
    @Test
    public void additionTest(int i, int j){
        System.out.println("Addition of i="+i+" and j="+j+" is= "+ (i+j));
    }

    @Parameters({"num1", "num2"})
    @Test
    public void subtractionTest(int i, int j){

        System.out.println("Subtraction of i="+i+" and j="+j+" is= "+ (j-i));
    }

    @Parameters({"num1", "num2"})
    @Test
    public void multiplicationTest(int i, int j){
        System.out.println("Multiplication of i="+i+" and j="+j+" is= "+ (i*j));
    }

    @Parameters({"num1", "num2"})
    @Test
    public void divisionTest(int i, int j){
        System.out.println("Division of i="+i+" and j="+j+" is= "+ (j/i));
    }

    @Parameters("num1")
    @Test
    public void squareTestOptionalParameter( @Optional("35")  String i){
        System.out.println("Square of value "+ i +" is = "+(Integer.parseInt(i)*Integer.parseInt(i)));
    }
}

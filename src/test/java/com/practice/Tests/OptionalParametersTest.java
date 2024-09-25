package com.practice.Tests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OptionalParametersTest {

    @Parameters("num1")
    @Test
    public void squareTestOptionalParameter( @Optional("35")  String i){
        System.out.println("Square of value "+ i +" is = "+(Integer.parseInt(i)*Integer.parseInt(i)));
    }
}

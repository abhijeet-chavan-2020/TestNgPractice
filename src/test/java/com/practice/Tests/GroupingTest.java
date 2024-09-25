package com.practice.Tests;

import org.testng.annotations.*;

public class GroupingTest {

    @Test (groups = "Easy")
    public void additionTest(){
        int i=10;
        int j=20;
        System.out.println("Addition of i="+i+" and j="+j+" is= "+ (i+j));
    }

    @Test (groups = "Easy")
    public void subtractionTest(){
        int i=10;
        int j=20;
        System.out.println("Subtraction of i="+i+" and j="+j+" is= "+ (j-i));
    }

    @Test (groups = "Difficult")
    public void multiplicationTest(){
        int i=10;
        int j=20;
        System.out.println("Multiplication of i="+i+" and j="+j+" is= "+ (i*j));
    }

    @Test (groups = "Difficult")
    public void divisionTest(){
        int i=10;
        int j=20;
        System.out.println("Division of i="+i+" and j="+j+" is= "+ (j/i));
    }
}

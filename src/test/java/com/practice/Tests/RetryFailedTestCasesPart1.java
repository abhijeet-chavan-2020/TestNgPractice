package com.practice.Tests;

import com.practice.Tests.ListenersPractice.IRetryAnalyzerPractice;
import com.practice.Tests.ListenersPractice.ITestListenerPractice;
import org.testng.Assert;
import org.testng.annotations.*;

public class RetryFailedTestCasesPart1 {

    @Test (groups = "Easy", description = "Easy Addition Test", retryAnalyzer = IRetryAnalyzerPractice.class)
    public void additionTest(){
        int i=10;
        int j=20;
        System.out.println("Addition of i="+i+" and j="+j+" is= "+ (i+j));
        Assert.assertEquals((i+j), 35);
    }

    @Test (groups = "Easy", description = "Easy Subtraction Test" , retryAnalyzer = IRetryAnalyzerPractice.class)
    public void subtractionTest(){
        int i=10;
        int j=20;
        System.out.println("Subtraction of i="+i+" and j="+j+" is= "+ (j-i));
        Assert.assertEquals((i+j), 35);

    }

    @Test (groups = "Difficult", description = "Difficult multiplication Test" , retryAnalyzer = IRetryAnalyzerPractice.class)
    public void multiplicationTest(){
        int i=10;
        int j=20;
        System.out.println("Multiplication of i="+i+" and j="+j+" is= "+ (i*j));
        Assert.assertEquals((i+j), 35);

    }

    @Test (groups = "Difficult", description = "Difficult division Test" , retryAnalyzer = IRetryAnalyzerPractice.class)
    public void divisionTest(){
        int i=10;
        int j=20;
        System.out.println("Division of i="+i+" and j="+j+" is= "+ (j/i));
    }
}

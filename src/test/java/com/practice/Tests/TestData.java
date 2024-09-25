package com.practice.Tests;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "PrintNumberTableTestData")
    public Integer[] numberTableTestData(){
        return new Integer[]{
             4,
             8,
             12,
             24,
             29
        };
    }
}

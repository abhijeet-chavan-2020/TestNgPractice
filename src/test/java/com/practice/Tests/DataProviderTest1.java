package com.practice.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataProviderTest1 {



    @Test(dataProvider = "AdditionData")
    public void additionTest(int i, int j) {
        System.out.println("Addition of i=" + i + " and j=" + j + " is= " + (i + j));
    }

    @Test(dataProvider = "SubtractionData")
    public void subtractionTest(int i, int j) {

        System.out.println("Subtraction of i=" + i + " and j=" + j + " is= " + (j - i));
    }

    @Test
    public void multiplicationTest(int i, int j) {
        System.out.println("Multiplication of i=" + i + " and j=" + j + " is= " + (i * j));
    }

    @Test
    public void divisionTest(int i, int j) {
        System.out.println("Division of i=" + i + " and j=" + j + " is= " + (i / j));
    }

    //Passed test data from Data Provider with optional value using @Optional parameter.
    //In case the test data is not present or accidentally deleted, then this optional test data will be used and test failure won't happen.
    @Test(dataProvider = "squareTestData")
    public void squareTestOptionalParameter(@Optional("35") Integer i) {
        System.out.println("Square of value " + i + " is = " + i * i);
    }

    @Test(dataProvider = "squareRootTestData")
    public void squareRootTestOptionalParameter(@Optional("225") Integer i) {
        System.out.println("Square root of number " + i + " is = " + Math.sqrt(i));
    }

    @Test(dataProvider = "shareStringValues")
    public void printDetails(@Optional("This is a new string") String s) {
        System.out.println("String value is :" + s);
    }

    @Test(dataProvider = "friendsList")
    //Always try to use Array of objects in the Test method parameter to fetch the data from DataProvider.
    //It may happen that any test data is deleted , or some test data has 3 values, some has 4  values etc, I mean the size of the test data is not fixed.
    // In this case it will  throw an exception ArrayIndexOutOfBound if we use direct value. So its always better to use Array in the test method parameter to fetch the data from dataprovider.
    public void friendNames(String[] s) {
        System.out.println("\n Friend names are: ");
        for (int i = 0; i < s.length; i++) {
            System.out.print("\t " + s[i]);
        }
    }

    //It may happen that test data will not always be only in the form of String, or only in the form of integers.
    //Test data can be in the mixed form like - String, Integer, Double , Object of a class etc.  So its always better to use Object[] in the parameter of the test method.
    //This will surely block the exceptions related to data types. Although, TestNg internally converts the values in the given data type in the test method.
    @Test(dataProvider = "employeeDetailsTestData")
    public void employeeDetails(Object[] s) {
        System.out.println("\n Employee details are: ");
        System.out.println("Name is: " + s[0]);
        System.out.println("Id is: " + s[1]);
        System.out.println("Department is: " + s[2]);
        System.out.println("Performance rating is: " + s[3]);
    }

    //We can have 100 sets of data, in some cases some of the test data set are failing, and now if we need to debug why those set of data are failing
    // then I should be using only the failed test data instead of executing the test cases with all test sets.
    //So instead of commenting or deleting non-required data, we use indices of those required ones and passing to the DataProvider attribute.
    @Test(dataProvider = "printIndicesTest")
    public void printIndices(String[] s) {
        System.out.println("Printing the indices: "+ Arrays.toString(s));
    }


    //When we want to maintain test data in separate class and use in the test methods, then we can use this attribute dataProviderClass and provide
    //the class name to this using ClassName.class. So the TestNg will check the provided dataProvider name in the given class file.
    @Test(dataProvider = "PrintNumberTableTestData", dataProviderClass = TestData.class)
    public void printTableOfGivenNumber(int num){
        for(int i=1; i<=10; i++){
            System.out.println("\t "+num +" * "+i+ " ="+ num*i);
        }
    }

    //In this test, we will read the test data from Excel file. The code to read data from Excel file is placed in different class.
    //So we need to add a test attribute dataProviderClass to tell TestNg that find the dataProvider method in the given class.
    @Test(dataProvider = "EmployeeDataExcelFile", dataProviderClass = ExcelFileReaderUtility.class)
    public void employeeDetailsFromExcelFile(Object[] s) {
        System.out.println("\n Employee details are: ");
        System.out.println("Name is: " + s[0]);
        System.out.println("Id is: " + s[1]);
        System.out.println("Department is: " + s[2]);
        System.out.println("Performance rating is: " + s[3]);
    }
    //===============================================================
    @DataProvider
    public String[] shareStringValues() {
        String[] s = {"Abhijeet", "Rahul", "Rajiv", " Pankaj"};
        return s;
    }


    @DataProvider(name = "AdditionData")
    public Integer[][] additionDataSet() {
        Integer[][] values = {
                {50, 5},
                {40, 4},
                {100, 20},
                {500, 25},
        };
        return values;
    }

    @DataProvider(name = "SubtractionData")
    public Iterator<Object[]> subtractionDataFail() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{50, 5});
        list.add(new Object[]{40, 4});
        list.add(new Object[]{100, 20});
        list.add(new Object[]{500, 25});
        Iterator<Object[]> it = list.iterator();
        return it;
    }

    @DataProvider(name = "squareTestData")
    public Object[] squareTestData() {
        return new Object[]{15, 12, 19};
    }

    @DataProvider
    private Iterator<Object> squareRootTestData() {
        List<Object> list = new ArrayList<>();
        list.add(25);
        list.add(225);
        list.add(2144);
        Iterator<Object> it = list.iterator();
        return it;
    }

    @DataProvider(name = "friendsList")
    public String[][] listOfFriends() {
        String[][] s = new String[][]{
                {"Abhijeet", "Rahul", "Swapnil"},
                {"Ramesh", "Pankaj", "Sushant"},
                {"Naved", "Javed", "Sachin"}
        };
        return s;
    }

    @DataProvider(name = "employeeDetailsTestData")
    public static Object[][] employeeDetailsTestData() {
        Object[][] obj= new Object[][]{
                {"Abhijeet", "001", "TECH","8.99"},
                {"Rahul", "002", "Non-TECH","7.99"},
                {"Ramesh", "003", "HR","7.99",}
        };
        return obj;
    }

    @DataProvider(name = "printIndicesTest", indices = {0,3})
    public String[][] printIndicesTestData(){
        return new String[] [] {
                {"00","01","02"},
                {"10","11","12"},
                {"20","21","22"},
                {"30","31","32"}
        };
    }
}

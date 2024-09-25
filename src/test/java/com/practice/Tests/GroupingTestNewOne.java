package com.practice.Tests;

import org.testng.annotations.Test;

@Test(groups = {"GroupingTest"})
public class GroupingTestNewOne {

//    1. What is grouping? why we need grouping?
//    2. How to define grouping?
//    3. Types of groups and how to use them?
//     4. How to execute the groups at suite level
//5. How to execute the groups at suite + test level
//6. How to use regular expressions?
    // Groups has scope at Test level and Suite level as well. We need to define them at respective levels.
    // We can define group of groups and then run the defined group from run section.
    //When we run groups on test level then we get breakdown of group execution in the test reports.
    // when we define groups at suite level and run it, then that group will be applicable to use inside each test level. That means if Group Sanity is defined at suite level then at test level
    // all Sanity grouped test cases will be executed from the given test classes.
    //we can define the groups at suite as well as at test level. So common groups will go at suite level. So the execution will be Suite level group + test level group.
    // example - suite level group= sanity, test1 level group= smoke, test2 level group = functional, then test1 will execute sanity+smoke and test2 will execute sanity+functional
    // we can also define groups using regular expression. Consider there are 3 groups-windows.sanity, windows.smoke, windows.functional. So we can use windows.* which will run all windows. groups.
        @Test(groups = {"smoke", "sanity", "windows.smoke"})
        public void test1() {
            System.out.println("test1");
        }

        @Test(groups = {"regression", "sanity", "windows.sanity", "ios.sanity"})
        public void test2() {
            System.out.println("test2");
        }

        @Test
        public void test3() {
            System.out.println("test3");
        }
    }


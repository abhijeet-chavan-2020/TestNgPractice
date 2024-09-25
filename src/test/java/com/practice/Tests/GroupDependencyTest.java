package com.practice.Tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class GroupDependencyTest {

    //These are the tests which are dependent on groups. We can add test parameter with @Test(dependsOnGroups={"smoke","sanity"}) like this.
    // The meaning of this, the given test case will be executed only after all the test cases having Group name= Smoke and sanity are executed.
    //If any test case failure on the given groups, then the given test will not be executed and it will be skipped.
    //If we add parameter alwaysRun=true, then the given test case will always run even when there are failures in any test case of the given groups.
    // Here we are achieving test method dependency on test groups. We can also configure test group dependency on another test group.
    // Example- I want to execute regression group test cases only after smoke group test cases are executed.
    //For this, we can add groups on test level in testng.xml file and within the groups, we can add dependencies parameter.
    // For this parameter, we can add group with attributes name="sanity", depends-on="smoke" and so on. This means you want to run tests in the group sanity, but those are dependent on
    //test in the group smoke. So smoke tests will be executed first and then sanity tests will be executed.
    //And we can add more such groups and dependencies here. And the output remains the same as previous on failures like if any smoke test is failed, then sanity tests will not be executed and skipped
    //
    @Test(groups = "smoke")
    public void test1() {
        System.out.println("smoke");
    }

    @Test(groups = "smoke")
    public void test2() {
        System.out.println("smoke");
    }

    @Test(groups = "smoke")
    public void test3() {
        System.out.println("smoke");
        System.out.println(5/0);
    }

    @Test(groups = "sanity")
    public void test4() {
        System.out.println("sanity");
    }

    @Test(groups = "sanity")
    public void test5() {
        System.out.println("sanity");
    }

    @Test(groups = "regression")
    public void test6() {
        System.out.println("regression");
    }

    @Test(groups = "regression")
    public void test7() {
        System.out.println("regression");
    }

    @Test
    public void test8() {
        System.out.println("No group");
    }

    @Ignore
    @Test
    public void test9() {
        System.out.println("Ignored Test case");
    }

    @Test(enabled = false)
    public void test10() {
        System.out.println(" NO group- Enabled=false test case");
    }

    @Test(alwaysRun = true)
    public void test01() {
        System.out.println(" NO group- alwaysRun = true");
    }

    @Test(groups = "smoke", ignoreMissingDependencies = true)
    public void test12() {
        System.out.println(" groups = smoke ignoreMissingDependencies = true");
    }

    @Test(dependsOnGroups = { "smoke", "sanity", "regression"})
    public void test0() {
        System.out.println("main test");
    }
}

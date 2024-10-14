package com.practice.Tests.ListenersPractice;

import com.practice.Tests.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerPractice extends BaseTest implements ITestListener {
    //Every Listener is an IInterface.
    //So you need to implement that interface implementing unimplemented methods. Listeners will listen to the events.
    //
    //ITestListener:
    //In the interface we can provide implementations of the methods using default, static and private keywords. Its' in java 8 feature.
    //So for the ITestListener interface, all the methods are implemented within interface using default keyword. So we do not get by default suggestion to implement those methods.
    //TestNg uses java features internally. Before TestNg 7, Java 8 features were not used in TestNg. After testNg 7, java 8 Features are bing used in TestNg. So earlier 7 versions of TestNg, suggestions to implement unimplemented methods were appearing. But after testNg 7, these suggestions are not appearing.
    //Although the methods are implemented within ITestListener Interface, but implementation logic is not provided. So we need to implement these methods manually.
    //We need to implement only those methods which are required. Right click on class, Generate -> Override methods.
    //Listeners on class level:
    //Now in the @Test class where the test cases are written, we need to provide the Listeners on class level using the annotations @Listeners.
    //@Listeners({TestClass1.class,TestClass2.class}).
    //Listeners on Suite level:
    //Whenever listeners are mentioned on the suite level, it will be applicable to all the classes mentioned in the suite file.
    //We have listener tag only in Suite level as following-
    //<listeners>
    //	<listener class-name=<ClassName of Listener class which was implemented> >
    //	</listener class-name="">
    //</listeners>

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test name is "+ result.getTestContext().getName()+ "_"+ result.getTestClass().getTestName());
        Utils.ScreenShotHelper.takeScreenShot(driver, result.getTestContext().getName()+ "_"+ result.getMethod().getMethodName());
        Utils.ScreenShotHelper.printPageInPDF(driver, result.getTestContext().getName()+ "_"+ result.getMethod().getMethodName() );
        Utils.ScreenShotHelper.saveScreenshotPNG(); // using this method to attach the screenshot after the test method is failed.
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

    @Override
    public boolean isEnabled() {
        return ITestListener.super.isEnabled();
    }

    //@Attachment is an annotation in Allure. This will attach the screenshot at the given step.
//    @Attachment
//    public static byte[] saveScreenshotPNG(){
//        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//    }
//Listener is an Interface in TesNg
}

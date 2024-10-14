package Utils;

import com.practice.Tests.BaseTest;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.print.PrintOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenShotHelper extends BaseTest {

    // We can take screenshot of the whole page, screenshot of the element specified or we can print the whole page.
    // There are 2 ways using which we can take the screenshots - one using Listeners interface and other by using Dependency Injection
    // Using Interface: We need to Implement ITestListener Interface to use ITestResult object and extend BaseTest Class to provide Driver object.
    // In this, there is a  method OnTestFailure, we need to override this method and provide logic to capture screenshot. We can call our own Screenshot helper form Utils class.
    // and provide the file name. We can make use of Test name and Test method name from the ITestResult object and provide a unique file name by appending with System.currentTimeMillis().
    //We also need to make changes to testng.xml file. We need to provide Listeners to this file at suite level.
    // By using this, whenever any test case is failed, the event of onTestFailure will be triggered and the ITestResult object will provide the results data and by making use of the takeScreenshot method, we can capture the screenshot.
    // Dependency Injection - By using this method, we do not need to implement any Listener or provide that Listener into testng.xml file. Here, we will make use of Dependency Injection mechanism.
    // TestNg generates some events during execution of the test case like onTestStart, onTestSuccess, onTestFailure, onTestSkipped, onStart, onFinish etc.
    // Whenever a single test case is finished its execution by success or by failure or by exception, @AfterMethod annotation can be called. We can make use of the method using this annotation.
    //That means we can implement our code using this annotation and inject ITestResult object into this method. By applying a condition ITestResult.getStatus()=ITestResult.FAILURE,
    // we can call takeScreenshot method form the BaseTest class. So whenever a test case is failed, this method will be called with the help of @AfterMethod annotation and we can save the screenshot.

    public static void takeElementScreenshot(WebElement ele) throws IOException {
        String s = String.valueOf(System.currentTimeMillis());
        String pathname = "./target/screenshots/image_" + s + ".png";
        File file = ele.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(pathname));
    }

    public static void printPageInPDF(WebDriver driver, String fileName)  {
        Pdf pdf = ((RemoteWebDriver) driver).print(new PrintOptions());
        String s = String.valueOf(System.currentTimeMillis());
        try{
            Files.write(Paths.get("./target/screenshots/image_" + fileName+ "_"+s + ".pdf"), OutputType.BYTES.convertFromBase64Png(pdf.getContent()));
        } catch (Exception e){
            System.out.println("Error printing page and saving.");
        }
    }

    public static void takeScreenShot(WebDriver driver, String fileName) {
        String s = String.valueOf(System.currentTimeMillis());
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        if (file.exists()) {
            try {
                FileUtils.copyFile(file, new File("./target/screenshots/image_" + fileName+ "_"+s + ".png"));
                System.out.println("Screenshot saved at location" + "./target/screenshots/image_" + fileName +"_"+ s + ".png");
            } catch (Exception e) {
                System.out.println("Error saving the screenshot");
            }
        }
    }

    @Attachment
    public static byte[] saveScreenshotPNG(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}

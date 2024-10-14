package com.practice.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FindBrokenURLsOnWebPage {

    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.get("https://www.phoenixmarketcity.com/pune");
        Set<String> urlSet= new HashSet<>();
        Set<String> urlErrorSet= new HashSet<>();

        List<WebElement> linkElements = driver.findElements(By.tagName("a"));
        System.out.println("Total number of URLs are = "+ linkElements.size());
        for (WebElement ele : linkElements) {
            String link = "";
            link = ele.getAttribute("href");
            if (link != null && (link.startsWith("http://") || link.startsWith("https://"))) {
                try {
                    URL url = new URL(link);
                    URLConnection urlConnection = url.openConnection();
                    urlConnection.setConnectTimeout(8000);
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlConnection;
                    httpsURLConnection.connect();
                    if (httpsURLConnection.getResponseCode() != 200) {
                        System.out.println(" URL is not working:" + link + " and Status code :"+ httpsURLConnection.getResponseCode() +" and error message is = "+ httpsURLConnection.getResponseMessage());
                        urlErrorSet.add(link);
                    } else {
                        System.out.println(" URL is working fine");
                        urlSet.add(link);
                    }
                } catch (Exception e) {
                    System.out.println("Error processing URL-" + link );
                }
            }
        }
        driver.quit();
        Iterator<String> it= urlSet.iterator();
        Iterator<String> itError= urlErrorSet.iterator();
        System.out.println("URLs working fine are: \n");
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("URLs not working fine are: \n");

        while(itError.hasNext()){
            System.out.println(itError.next());
        }
    }
}

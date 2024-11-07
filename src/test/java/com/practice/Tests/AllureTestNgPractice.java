package com.practice.Tests;

import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.*;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.restassured.RestAssured.given;

public class AllureTestNgPractice {

    @Description("This is Addition Test- Allure")
    @Test (groups = "Easy", description = "Easy Addition Test")
    public void additionTest(){
        int i=10;
        int j=20;
        System.out.println("Addition of i="+i+" and j="+j+" is= "+ (i+j));
    }

    @Description("This is Subtraction Test- Allure")
    @Test (groups = "Easy", description = "Easy Subtraction Test")
    public void subtractionTest(){
        int i=10;
        int j=20;
        System.out.println("Subtraction of i="+i+" and j="+j+" is= "+ (j-i));
    }

    @Description("This is Multiplication Test- Allure")
    @Test (groups = "Difficult", description = "Difficult multiplication Test")
    public void multiplicationTest(){
        int i=10;
        int j=20;
        System.out.println("Multiplication of i="+i+" and j="+j+" is= "+ (i*j));
    }

    @Description("This is Division Test- Allure")
    @Test (groups = "Difficult", description = "Difficult division Test")
    public void divisionTest(){
        int i=10;
        int j=20;
        System.out.println("Division of i="+i+" and j="+j+" is= "+ (j/i));
    }

    @Severity(CRITICAL)
    @Owner("Abhijeet Chavan")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    @Epic("Web interface")
    @Feature("Essential features")
    //We can also add @Epic and @Feature on class level. And we should add @Story at Test level.
    @Story("Authentication")
    @Test
    public void allureAnnotationsTest(){
        System.out.println("Printing different annotations");
        cleanYourRoom();
        printDetails("My house is the best");
    }

    @Step("This is a print job with string")
    public static void printDetails(String details){
        System.out.println("Printing job is completed. Your printing is: "+details);
    }

    @Step("This is clear room job")
    public static void cleanYourRoom(){
        System.out.println("Room cleaning in progress");
    }

    @Test
    public void requestResponseLoggingAllureReports() {
        //to add path parameter, we use pathParam() and supply key and value. And then in the get() method, we can use the key of the pathParam that we have added within {} braces.
        // It will internally convert the variable and get the value which is 2 in this case.
        //Effective URL will be - https://reqres.in/api/users/2

        RequestSpecBuilder reqSpecBldr = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                //.setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .log(LogDetail.ALL);
        RequestSpecification reqSpec =  reqSpecBldr.build().log().all();

        System.out.println("Printing Response Specification");

        ResponseSpecBuilder responseSpecBuilder= new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .log(LogDetail.ALL);
        ResponseSpecification resSpec =  responseSpecBuilder.build();

        given().
                spec(reqSpec).
               // queryParam("page","2").
               // pathParam("userId","2").
        when().
               // filter(new AllureRestAssured()).
                get("/api/users/2").
        then().
                spec(resSpec).
                assertThat().
                statusCode(200);
    }
}

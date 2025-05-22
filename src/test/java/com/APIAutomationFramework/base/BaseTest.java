package com.APIAutomationFramework.base;

import org.testng.annotations.BeforeMethod;

import com.APIAutomationFramework.actions.AssertActions;
import com.APIAutomationFramework.endpoints.APIConstants;
import com.APIAutomationFramework.modules.PayloadManager;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
//  Before Running a Method -
    //  Rest Assured . given with the Base URI. PATH
    public static RequestSpecification requestSpecification = RestAssured.given();
    public static AssertActions actions;
    public static PayloadManager payloadManager;
    public static JsonPath jsonPath;
    public static Response response;

    public static ValidatableResponse validatableResponse;


    @BeforeMethod(alwaysRun = true)
    public void setConfig() {
        // Reset the Rest Assured Base URLs
        // Base URL
        // Content Type - ALL

        System.out.println("I am able to run");
        payloadManager = new PayloadManager();
        actions = new AssertActions();
        requestSpecification = RestAssured.given()
                .baseUri(APIConstants.BASE_URL)
                .contentType(ContentType.JSON);

//        requestSpecification = new RequestSpecBuilder()
//                .setBaseUri(APIConstants.BASE_URL)
//                .addHeader("Content-Type", "application/json")
//                .build().log().all();

    }
 

    


}

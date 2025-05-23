package com.APIAutomationFramework.misc.create;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.testng.annotations.Test;

import com.APIAutomationFramework.actions.AssertActions;
import com.APIAutomationFramework.endpoints.APIConstants;
import com.APIAutomationFramework.modules.PayloadManager;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class TC_CreateBookingWithResult  {
	
	public static RequestSpecification req;

    // Setup method to build request spec once
    public static RequestSpecification getRequestSpec() throws FileNotFoundException {
        if (req == null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            req = new RequestSpecBuilder()
                    .setBaseUri(APIConstants.BASE_URL)
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON)
                    .build();
        }
        return req;
    }

    @Test(groups = {"stage","P0"})
    @Owner("Kumar Gaurav")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC#1 - Verify that Create Booking works and ID is generated!")
    public void testCreateBooking() throws JsonProcessingException {
        // Call the Request Block
        // Call the Payload
        // Call the Assertion Block
        PayloadManager payloadManager = new PayloadManager();
        AssertActions actions = new AssertActions();
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri(APIConstants.BASE_URL)
                .contentType(ContentType.JSON);
        requestSpecification.basePath(APIConstants.CREATE_BOOKING);
        Response response = requestSpecification.when().body(payloadManager.createPayload()).post();
        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        
        
        
    }

}

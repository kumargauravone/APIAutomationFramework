package com.APIAutomationFramework.misc.create;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.APIAutomationFramework.actions.AssertActions;
import com.APIAutomationFramework.base.BaseTest;
import com.APIAutomationFramework.endpoints.APIConstants;
import com.APIAutomationFramework.modules.PayloadManager;
import com.APIAutomationFramework.payloads.response.BookingRespons;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TC_CreateBooking extends BaseTest {
	
	@Test(groups = {"stage","P0"})
    @Owner("Kumar Gaurav")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC#1 - Verify that Create Booking works and ID is generated!")
    public void testCreateBooking() throws JsonProcessingException {
        // Call the Request Block
        // Call the Payload
        // Call the Assertion Block
        payloadManager = new PayloadManager();
        actions = new AssertActions();
        requestSpecification = RestAssured.given()
                .baseUri(APIConstants.BASE_URL)
                .contentType(ContentType.JSON);
        requestSpecification.basePath(APIConstants.CREATE_BOOKING);
        response = requestSpecification.when().body(payloadManager.createPayload()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        BookingRespons bookingRespons = payloadManager.JsonToObject(response.asString());
        assertThat(bookingRespons.getBookingid().toString()).isNotEmpty().isNotNull();
        
        
    }

}

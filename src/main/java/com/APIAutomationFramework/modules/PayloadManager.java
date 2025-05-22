package com.APIAutomationFramework.modules;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.APIAutomationFramework.payloads.request.Auth;
import com.APIAutomationFramework.payloads.request.Booking;
import com.APIAutomationFramework.payloads.request.Bookingdates;
import com.APIAutomationFramework.payloads.response.BookingRespons;
//import com.APIAutomationFramework.utils.FakerUtil;

public class PayloadManager {
	 // JAVA -> JSON to that when give it to the .body()?

    // Jr QA - All the payload we will keep it here


    ObjectMapper objectMapper;

    // Serialization
    public String createPayload() throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        Booking booking = new Booking();
//      booking.setFirstname(FakerUtil.getUserName());
        booking.setFirstname("John Herry");
        booking.setLastname("Dutta");
        booking.setTotalprice(123);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("BreakFast");

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2022-01-01");
        bookingdates.setCheckout("2022-01-10");
        booking.setBookingdates(bookingdates);

        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        return payload;

    }
    // De-Serialization
    public BookingRespons JsonToObject(String jsonString) throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        BookingRespons bookingRespons = objectMapper.readValue(jsonString, BookingRespons.class);
        return bookingRespons;
    }

   

}

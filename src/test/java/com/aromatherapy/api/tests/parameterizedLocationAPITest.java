package com.aromatherapy.api.tests;

import com.aromatherapy.api.tests.DTO.Shop;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static io.restassured.RestAssured.given;

    @RunWith(Parameterized.class)
    public class parameterizedLocationAPITest extends FunctionalAPITest {
        private String id;
        private Integer statusCode;

        public parameterizedLocationAPITest(String id, Integer statusCode) {
            this.id = id;
            this.statusCode = statusCode;
        }

        @Parameterized.Parameters
        public static Collection<Object[]> createData() {
            return Arrays.asList(new Object[][]{
                    {"2000",400},   // invalid data type
                    {"@brs",400},  // special characters
                    {"fsfdsfsdfsdfsdfsdfsdfsdfsdfsdfdsfsdfsdfsdfsdfsdfsdfdsfsdfsdfsdfsdfsdfsdfsdfsdfdsfsdf",400}, // long values
                    {"",400},  // empty
                    {null,400},  // special keywords
                    {true,400},   // boolean
                    {"200.9",400},   // invalid data type
                    {"Oxley",400},   // duplicate value check
                    {"Gold coast",201}, // happy scenario

            });
        }


        @Test
        public void parameterizedTestToVerifyLocationId() {
            Shop pshop = new Shop();
            pshop.setId(id);  // parameterized
            pshop.setContact("some one");
            pshop.setAddress("some address");
            pshop.setPhone("343434");
            pshop.setEmail("some@cleanwaters.com");
            ArrayList<String> timeslots = new ArrayList<String>();
            timeslots.add(0,"9:00");
            timeslots.add(1,"10:00");
            timeslots.add(2,"11:00");
            pshop.setTimeslots(timeslots);

            given()
                    .contentType("application/json")
                    .body(pshop)
                    .when().post().then()
                    .statusCode(statusCode);

        }

    }

package com.aromatherapy.api.tests;

import com.aromatherapy.api.tests.DTO.Shop;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.hamcrest.*;


import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class LocationAPITest extends FunctionalAPITest {

    @Test
    public void getAllLocations() {
        given().when().get().then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);
    }

    @Test
    public void getLocationById() {
        given().when().get("/Brisbane").then().statusCode(200).body("address", equalTo("23 Lanchester street, Croydon"));
    }

    @Test
    public void getLocationByContactPerson() {
        given().when().get("?contact=Mrs Lee Wonder").then()
                .statusCode(200)
                .body("",Matchers.hasSize(1))
                .body(containsString("(07)-2380002"));
    }

    @Test
    public void getCountOfAllLocations() {
        given().when().get().then()
                .contentType(ContentType.JSON)
                .body("size()",is(20));
    }

    @Test
    public void throwErrorOnBadUrl() {
        given().when().get("/warner").then().statusCode(404);
    }

    @Test
    public void createNewLocationAndDeleteIt() {
        Shop shop = new Shop();
        shop.setId("Milton");
        shop.setAddress("123 pringles road, Milton");
        shop.setContact("Mrs Chanelle Fern");
        shop.setEmail("milton@cleanwater.com");
        shop.setPhone("07 3434332");
        ArrayList<String> timeslots = new ArrayList<String>();
        timeslots.add(0,"9:00");
        timeslots.add(1,"10:00");
        timeslots.add(2,"11:00");
        shop.setTimeslots(timeslots);

        String newShop = given()
                .contentType("application/json")
                .body(shop)
                .when().post().then()
                .statusCode(201)
                .body("phone",equalTo("07 3434332"))
                .body("size()", is(6))
                .extract().path("id");

                given().pathParam("id",newShop)
                .when().delete("/{id}").then()
                .statusCode(200)
                .body("size()", is(0));

    }

}



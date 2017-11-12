package pl.szarawara.checkout.integrationTests;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.equalTo;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.jayway.restassured.response.Response;

public class IntegrationTests {

	@Test
	public void simpleInputTest() {
		expect().statusCode(201).body("name", equalTo("A"), "unit", equalTo("2")).when()
				.post("/CheckoutComponent/main/checkout/post");

	}
	
	@Test
	public void nullInputTest() {
		expect().statusCode(201).body("name", null, "unit", null).when()
				.post("/CheckoutComponent/main/checkout/post");

	}
	
	@Test
	public void wrongNameInputTest() {
		expect().statusCode(201).body("name", equalTo("wrongName"), "unit", equalTo("2")).when()
				.post("/CheckoutComponent/main/checkout/post");

	}
	
	@Test
	public void wrongUnitInputTest() {
		expect().statusCode(201).body("name", equalTo("A"), "unit", equalTo("wrongUnit")).when()
				.post("/CheckoutComponent/main/checkout/post");

	}

}

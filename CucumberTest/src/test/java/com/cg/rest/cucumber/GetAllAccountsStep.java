package com.cg.rest.cucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Before;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllAccountsStep {
	
	private  final String statusCode = "200";
	private final String url = "http://localhost:8080/bankapp/accounts";
	private Response respone;
	private Scenario scenario;
	
	@Before
	public void before(Scenario scenario) {
		this.scenario=scenario;
	}
	
	@Given("Get call to \\/bankapp\\/accounts")
	public void get_call_to_bankapp_accounts() throws URISyntaxException {
		RestAssured.baseURI=url;
		RequestSpecification requestSpecification = RestAssured.given();
		respone=requestSpecification.when().get(new URI(url));
	}
	
	@Then("Response is 200")
	public void responseStatusCode() {
		int actualResponseCode = respone.then().extract().statusCode();
		assertEquals(statusCode, actualResponseCode+"");
	}
}

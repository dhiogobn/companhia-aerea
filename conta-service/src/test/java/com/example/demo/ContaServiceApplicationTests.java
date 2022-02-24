package com.example.demo;
import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

@SpringBootTest
class ContaServiceApplicationTests {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
	
	@Test
	void testListarContas() {
		Response response = given()
							.when().log().all()
								.get("http://localhost:8000/conta")
							.then()
								.extract()
									.response();
		Assertions.assertEquals(200, response);
	}

}

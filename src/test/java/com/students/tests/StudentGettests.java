package com.students.tests;

import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StudentGettests {
	
	@BeforeClass
	public static void init()
	{
		
		RestAssured.baseURI="http://localhost:8899/student";
	}
	
	@Test
	public void getStuentsdetails()
	{
    Response res=  given()
      .when()
      .get("/list");
    System.out.println(res.body().prettyPrint());
		
		
	}
	
	@Test
	public void getStudentInfo()
	{
		Response res= given()
		.when()
		.get("/1");
		
		System.out.println(res.body().prettyPrint());
		
		given()
		.when()
		.get("/1")
		.then()
		.statusCode(200);
		
	}

}

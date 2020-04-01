package com.students.loggingexamples;

import org.junit.Test;

import com.student.base.TestBase;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class LoggingRequestValues extends TestBase {

	@Test
	/*
	 * prints all the request headers 
	 * */
	public void test001()
	{
		
		System.out.println("----------- Printing request parameters----------");
		given()
		.log()
		.headers()
		.when()
		.get("/1")
		.then()
		.statusCode(200);
		
	}
	
	@Test
	/*
	 * Get's the Student details who is doing Computer Science programme
	 * 
	 * */
	public void test002()
	{
		System.out.println("----------- Printing request parameters----------");
		given()
		.when()
		.get("/list?programme=Computer Science&limit=1")
		.then()
		.log()
		.all()
		.statusCode(200);
		
	}
}

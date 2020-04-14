package com.students.filters;

import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

/* done the class till section11. start from section 12 */

/*java -jar rest.jar --server.port=8899*/

public class FiltersExample {

	public static StringWriter requestWriter;
	public static PrintStream requestCapture;
	
	public static StringWriter responseWriter;
	public static PrintStream responseCapture;
	
	
	public static StringWriter errorWriter;
	public static PrintStream errorCapture;

	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost:8899";
		RestAssured.basePath = "/student";
	}

	@Before
	public void beforeEachMethod() {
	
		requestWriter = new StringWriter();
		requestCapture = new PrintStream(new WriterOutputStream(requestWriter),true);
		
		responseWriter = new StringWriter();
		responseCapture = new PrintStream(new WriterOutputStream(responseWriter),true);
		
		errorWriter = new StringWriter();
		errorCapture = new PrintStream(new WriterOutputStream(errorWriter),true);



	}

	@Test
	public void getStudent() {
		String response = RestAssured.given().when().get("/list").asString();
		System.out.println(response);

		RestAssured
		.given()
		.filter(new RequestLoggingFilter(requestCapture))
		.filter(new ResponseLoggingFilter(responseCapture))
		.when()
		.get("/list");
		//System.err.println(requestWriter.toString());
		System.err.println(responseWriter.toString());
		
		
		RestAssured
		.given()
		.filter(new ErrorLoggingFilter(errorCapture))
		.when()
		.get("/listqqq");
		//System.err.println(errorWriter.toString().toUpperCase());


	}

}

package com.students.loggingexamples;

import org.junit.Test;

import com.student.base.TestBase;
import com.student.model.Student;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

public class LoggigResponseValues extends TestBase {


	
	@Test
	/*
	 * This will print the response headers
	 * 
	 * */
	public void test001()
	{
		System.out.println("----------- Printing response parameters----------");
		given()
		.param("programme", "Computer Science")
		.param("limit", "1")
		.when()
		.get("/list")
		.then()
		.log()
		.headers()
		.statusCode(200);
		
	}
	
	@Test
	/*
	 * This will print all the response status line
	 * 
	 * */
	public void test002()
	{
		System.out.println("----------- Printing response status line----------");
		given()
		.param("programme", "Computer Science")
		.param("limit", "1")
		.when()
		.get("/list")
		.then()
		.log()
		. status()
		.statusCode(200);
		
	}
	
	@Test
	/*
	 * This will printthe response body
	 * 
	 * */
	public void test003()
	{
		System.out.println("----------- Printing response body ----------");
		given()
		.param("programme", "Computer Science")
		.param("limit", "1")
		.when()
		.get("/list")
		.then()
		.log()
		.body()
		.statusCode(200);
		
	}	
	
	/*
	 * This will print the response body if test fail
	 * 
	 * */
	@Test
	public void test004()
	{
		System.out.println("----------- Printing response body if test fail----------");
		given()
		.param("programme", "Computer Science")
		.param("limit", "1")
		.when()
		.get("/list")
		.then()
		.log()
		.ifError()
       .statusCode(200);
	}	

}

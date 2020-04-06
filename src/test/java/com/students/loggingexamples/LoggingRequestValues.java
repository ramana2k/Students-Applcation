package com.students.loggingexamples;

import org.junit.Test;

import com.student.base.TestBase;
import com.student.model.Student;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

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
		.param("programme", "Computer Science")
		.param("limit", "1")
		.log()
		.params()
		.when()
		.get("/list")
		.then()
		.statusCode(200);
		
	}
	
	/*
	 * This will log the body of the request
	 * */
	@Test
	public void test003()
	{
		
		System.out.println("----------- Printing body of the request parameters----------");

	 Student student=new Student();
	 
	 ArrayList<String> courses = new ArrayList<String>();
	 courses.add("java");
	 courses.add("nodejs");
	 student.setCourses(courses);
	 student.setFirstName("pritam");
	 student.setLastName("dara");
	 student.setEmail("pritamdara1@gmail.com");
	 student.setProgramme("computer science");
	 
	 given()
	 .contentType(ContentType.JSON)
	 .when()
	 .log()
	 .body()
	 .body(student)
	 .post()
	 .then()
	 .statusCode(201);
	}
	
	@Test
	public void test004()
	{
		
		System.out.println("----------- Printing all request of the request parameters----------");

	 Student student=new Student();
	 
	 ArrayList<String> courses = new ArrayList<String>();
	 courses.add("java");
	 courses.add("nodejs");
	 student.setCourses(courses);
	 student.setFirstName("pritam");
	 student.setLastName("dara");
	 student.setEmail("pritamdara2@gmail.com");
	 student.setProgramme("computer science");
	 
	 given()
	 .contentType(ContentType.JSON)
	 .when()
	 .log()
	 .all()
	 .body(student)
	 .post()
	 .then()
	 .statusCode(201);
	}
	
	
	/*
	 * Print logs only if the test fails
	 * */
	@Test
	public void test005()
	{
		
		System.out.println("----------- Printing logs if the test fails----------");

	 Student student=new Student();
	 
	 ArrayList<String> courses = new ArrayList<String>();
	 courses.add("java");
	 courses.add("nodejs");
	 student.setCourses(courses);
	 student.setFirstName("pritam");
	 student.setLastName("dara");
	 student.setEmail("pritamdara3@gmail.com");
	 student.setProgramme("computer science");
	 given()
	 .contentType(ContentType.JSON)
	 .when()
	 .log()
	 .ifValidationFails()
	 .body(student)
	 .post()
	 .then()
	 .statusCode(201);
	}
}

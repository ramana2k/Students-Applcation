package com.students.tests;

import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.student.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StudentGettests extends TestBase{
	
	@Test
	public void getStuentsdetails()
	{
    Response res=  given()
      .when()
      .get("/list");
    System.out.println(res.body().prettyPrint());
    System.out.println(res.body().prettyPrint());

		
	}
	
/*	@Test
	public void getStudentInfo()
	{
		Response res= given()
		.when()
		.get("/100");
		
		System.out.println(res.body().prettyPrint());
		
		given()
		.when()
		.get("/100")
		.then()
		.statusCode(200);
		
	}
*/
}

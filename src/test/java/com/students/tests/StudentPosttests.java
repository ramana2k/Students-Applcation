package com.students.tests;

import java.util.ArrayList;

import org.junit.Test;

import com.student.base.TestBase;
import com.student.model.Student;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class StudentPosttests extends TestBase{
	
	@Test
	public void createStudent()
	{
		
	 Student student=new Student();
	 
	 ArrayList<String> courses = new ArrayList<String>();
	 courses.add("java");
	 courses.add("nodejs");
	 student.setCourses(courses);
	 student.setFirstName("pritam");
	 student.setLastName("dara");
	 student.setEmail("pritamdara@gmail.com");
	 student.setProgramme("computer science");
	 
	 given()
	 .contentType(ContentType.JSON)
	 .when()
	 .body(student)
	 .post()
	 .then()
	 .statusCode(201);
	 
		
	}

}

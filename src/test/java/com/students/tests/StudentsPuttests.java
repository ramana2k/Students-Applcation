package com.students.tests;

import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.student.model.Student;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class StudentsPuttests {


	@Test
	public void updateStudent()
	{
		
		
		 Student student=new Student();
		 
		 ArrayList<String> courses = new ArrayList<String>();
		 courses.add("java");
		 courses.add("nodejs");
		 student.setCourses(courses);
		 student.setFirstName("pritam_updated");
		 student.setLastName("dara");
		 student.setEmail("pritamdara@gmail.com");
		 student.setProgramme("computer science_updated");
		 
		 given()
		 .contentType(ContentType.JSON)
		 .when()
		 .body(student)
		 .put("/101")
		 .then()
		 .statusCode(200);
		 
			
		
	}
}

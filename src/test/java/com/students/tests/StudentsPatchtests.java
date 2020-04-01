
package com.students.tests;



import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.student.model.Student;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class StudentsPatchtests {



	@Test
	public void updateStudent() {

		Student student = new Student();

		ArrayList<String> courses = new ArrayList<String>();
		courses.add("java");
		courses.add("nodejs");
		student.setCourses(courses);
		student.setFirstName("pritam_updated");
		student.setLastName("dara");
		student.setEmail("pritamdara_updated@gmail.com");
		student.setProgramme("computer science_updated");

		given().contentType(ContentType.JSON).when().body(student).patch("/101").then().statusCode(200);

	}
}

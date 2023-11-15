package com.jspiders.studentmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.studentmanagementsystem.pojo.StudentPojo;
import com.jspiders.studentmanagementsystem.responce.StudentResponce;
import com.jspiders.studentmanagementsystem.service.StudentService;

@RestController
@CrossOrigin
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping("add")
	public ResponseEntity<StudentResponce> addStudent(@RequestBody StudentPojo pojo){
		StudentPojo student = service.addStudent(pojo);
		if (student != null) {
			return new ResponseEntity<StudentResponce>(new StudentResponce("Student Added Successfully", student, null), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<StudentResponce>(new StudentResponce("Data not Added", student, null), HttpStatus.NOT_ACCEPTABLE);

	}
	
	@PostMapping("remove/{id}")
	public ResponseEntity<StudentResponce> removeStudent(@PathVariable int id){
		boolean conf = service.removeStudent(id);
		if (conf ==true) {
			return new ResponseEntity<StudentResponce>(new StudentResponce("Data Removed Suvvessfully", null, null), HttpStatus.OK);
		}
		return new ResponseEntity<StudentResponce>(new StudentResponce("Data not removed", null, null), HttpStatus.BAD_REQUEST);
		
	}
	
	@PostMapping("search/{id}")
	public ResponseEntity<StudentResponce> searchStudent(@PathVariable int id){
		StudentPojo pojo = service.searchById(id);
		if (pojo != null) {
			return new ResponseEntity<StudentResponce>(new StudentResponce("Student data fetched successfuly", pojo, null), HttpStatus.FOUND);
			
		}
		return new ResponseEntity<StudentResponce>(new StudentResponce("Student data not found", null, null), HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("searchAll")
	public ResponseEntity<StudentResponce> searchAllStudents(){
		List<StudentPojo> students = service.searchAllStudents();
		
		if (!students.isEmpty()) {
			return new ResponseEntity<StudentResponce>(new StudentResponce("All Data Fetched...", null, students), HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponce>(new StudentResponce("Data Not Fetched", null, null), HttpStatus.NOT_FOUND);
	}
	
	
}

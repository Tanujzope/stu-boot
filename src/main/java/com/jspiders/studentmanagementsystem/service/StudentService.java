package com.jspiders.studentmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jspiders.studentmanagementsystem.pojo.StudentPojo;
import com.jspiders.studentmanagementsystem.repository.StudentRepository;

@Service

public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	public StudentPojo addStudent(StudentPojo pojo) {
		StudentPojo student = repository.save(pojo);
		return student;
	}

	public StudentPojo searchById(int id) {
		StudentPojo pojo = repository.findById(id).orElse(null);
		return pojo;
	}

	public boolean removeStudent(int id) {
		try {
			repository.deleteById(id);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}

	public List<StudentPojo> searchAllStudents() {
		List<StudentPojo> students = repository.findAll();
		return students;
		
	}

}

package com.jspiders.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.studentmanagementsystem.pojo.StudentPojo;

@Repository
public interface StudentRepository extends JpaRepository<StudentPojo, Integer> {

	

}

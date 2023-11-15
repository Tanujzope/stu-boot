package com.jspiders.studentmanagementsystem.responce;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.studentmanagementsystem.pojo.StudentPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponce {
	private String msg;
	private StudentPojo pojo;
	private List<StudentPojo> students;
}

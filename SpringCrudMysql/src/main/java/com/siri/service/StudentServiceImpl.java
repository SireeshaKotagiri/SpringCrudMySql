package com.siri.service;

import java.util.List;

import com.siri.entity.Student;



public interface StudentServiceImpl {
	
	Student saveStudent(Student student);
	
	List<Student> getStudent();
	
	Student getStudentById(int id);
	
	Student updateStudent(Student student);

	String deleteStudent(int id);
	
}

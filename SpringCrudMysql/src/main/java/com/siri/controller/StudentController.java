package com.siri.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.siri.entity.Student;
import com.siri.service.StudentServiceImpl;


@RestController
public class StudentController {
	Logger logger = LoggerFactory.getLogger(StudentController.class);
	@Autowired
	private StudentServiceImpl iStudent;

	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody  Student Student) {
		logger.info("<< request in controller save employee >>", Student);
		return iStudent.saveStudent(Student);
	}

	@GetMapping("/student")
	public List<Student> findAllStudent() {
		logger.info("<< request in controller get employee >>");
		return iStudent.getStudent();
	}

	@GetMapping("/studentById/{id}")
	public Student findStudentById(@PathVariable int id) {
		logger.info("<< request in controller get employee by id >>", id);
		return iStudent.getStudentById(id);
	}

	

	

	@PutMapping("/update")
	public Student updateEmployeeEntity(@RequestBody Student StudentEntity) {
		logger.info("<< request in controller update employee >>", StudentEntity);
		return iStudent.updateStudent(StudentEntity);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		logger.info("<< request in controller delete employee >>", id);
		return iStudent.deleteStudent(id);
	}


}

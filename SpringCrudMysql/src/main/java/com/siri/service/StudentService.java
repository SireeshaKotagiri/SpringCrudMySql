package com.siri.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.siri.controller.StudentController;
import com.siri.entity.Student;
import com.siri.exception.UserAlreadyExistException;
import com.siri.exception.UserNotFoundException;
import com.siri.repository.StudentRepository;

@Service
public class StudentService implements StudentServiceImpl{
	Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	public StudentRepository sRepository;

	@Override
	public Student saveStudent(Student student) {
		Student std=sRepository.findById(student.getId());
		if(!ObjectUtils.isEmpty(std)) {
			throw new UserAlreadyExistException("student already exist try another id");
		}
		logger.info("<< request in service persisted student >>", student);
		return sRepository.save(student);
	}

	@Override
	public List<Student> getStudent() {
		// TODO Auto-generated method stub
		logger.info("<< request in service persisted student >>");
		return sRepository.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		Student std=sRepository.findById(id);
		if(std==null) {
			throw new UserNotFoundException("student not found:"+std.getName());
		}
		logger.info("<< request in service persisted student >>", id);
		return std;
	}

	@Override
	public Student updateStudent(Student student) {
		Student std=sRepository.findById(student.getId());
		if(std==null) {
			throw new UserNotFoundException("student not exist that id");
		}else {
			Student s=new Student();
			s.setId(student.getId());
			s.setName(student.getName());
			s.setAddress(student.getAddress());		
			logger.info("<< request in service persisted student >>", student);
		return sRepository.save(s);
		}
	}

	@Override
	public String deleteStudent(int id) {
		Student std=sRepository.deleteById(id);
		
		logger.info("<< request in service persisted student >>", id);
		return "student deleted successfully"+id;
	}

}

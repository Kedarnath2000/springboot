package com.jspiders.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springboot.pojo.Student;
import com.jspiders.springboot.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student findStudentById(long id) {
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent()) {
			return student.get();
		}else {
			return null;
		}
	}
	
	public List<Student> findAllStudents() {
		return studentRepository.findAll();
	}
	
	public Student deleteStudentById(long id) {
		Student student=findStudentById(id);
		studentRepository.deleteById(id);
		return student;
	}
	
	public Student updateStudent(Student student) {
		Student studentToBeUpdated=findStudentById(student.getId());
		if(studentToBeUpdated!=null) {
			return studentRepository.save(student);
		}else {
			return null;
		}
	}
	
	public Student findStudentByName(String name) {
		return studentRepository.findByName(name);
	}
	
	public Student findStudentByEmail(String email) {
		return studentRepository.findByEmail(email);
	}
	
	public Student findStudentByMobile(long mobile) {
		return studentRepository.findByMobile(mobile);
	}
	
	public Student findStudentNameAndEmail(String name,String email) {
		return studentRepository.findByNameAndEmail(name, email);
		
	}

}

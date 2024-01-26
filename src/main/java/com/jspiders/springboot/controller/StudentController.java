package com.jspiders.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springboot.pojo.Student;
import com.jspiders.springboot.response.StudentResponse;
import com.jspiders.springboot.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping(path="/student")
	public ResponseEntity<StudentResponse> addStudent(@RequestBody Student student) {
		Student addedStudent=studentService.addStudent(student);
		StudentResponse studentResponse=new StudentResponse();
		studentResponse.setMessage("student added");
		studentResponse.setStudent(addedStudent);
		studentResponse.setStatus(HttpStatus.CREATED.value());
		studentResponse.setStudents(null);
		return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.CREATED);
		
	}
	
	@GetMapping(path = "/student/{id}")
	public ResponseEntity<StudentResponse> findStudentById(@PathVariable long id) {
		Student student=studentService.findStudentById(id);
		if(student!=null) {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("student found");
			studentResponse.setStatus(HttpStatus.FOUND.value());
			studentResponse.setStudent(student);
			studentResponse.setStudents(null);
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.FOUND);
		}else {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("student not found");
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			studentResponse.setStudent(null);
			studentResponse.setStudents(null);
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path="/students")
	public ResponseEntity<StudentResponse> findAllStudents() {
		List<Student> students=studentService.findAllStudents();
		if(students!=null && students.size()>0) {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("students found");
			studentResponse.setStatus(HttpStatus.FOUND.value());
			studentResponse.setStudent(null);
			studentResponse.setStudents(students);
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.FOUND);
		}else {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("students not found");
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			studentResponse.setStudent(null);
			studentResponse.setStudents(null);
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="/student/{id}")
	public ResponseEntity<StudentResponse> deleteStudentById(@PathVariable long id) {
		Student student=studentService.deleteStudentById(id);
		if(student!=null) {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("student deleted");
			studentResponse.setStatus(HttpStatus.FOUND.value());
			studentResponse.setStudent(student);
			studentResponse.setStudents(null);
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.FOUND);
		}else {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("student not deleted");
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			studentResponse.setStudent(null);
			studentResponse.setStudents(null);
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(path="/student")
	public ResponseEntity<StudentResponse> updateStudent(@RequestBody Student student) {
		Student studentUpdated=studentService.updateStudent(student);
		if(studentUpdated!=null) {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("student updated");
			studentResponse.setStatus(HttpStatus.FOUND.value());
			studentResponse.setStudent(studentUpdated);
			studentResponse.setStudents(null);
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.FOUND);
		}else {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("student not updated");
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			studentResponse.setStudent(null);
			studentResponse.setStudents(null);
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path="/student")
	public ResponseEntity<StudentResponse> findStudentByName(@RequestParam String name) {
		Student student=studentService.findStudentByName(name);
		if(student!=null) {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("student found");
			studentResponse.setStatus(HttpStatus.FOUND.value());
			studentResponse.setStudent(student);
			studentResponse.setStudents(null);
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.FOUND);
		}else {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("student not found");
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			studentResponse.setStudent(null);
			studentResponse.setStudents(null);
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path="/studentbyemail")
	public ResponseEntity<StudentResponse> findStudentByEmail(@RequestParam String email) {
		Student student=studentService.findStudentByEmail(email);
		if(student!=null) {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("student found");
			studentResponse.setStatus(HttpStatus.FOUND.value());
			studentResponse.setStudent(student);
			studentResponse.setStudents(null);
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.FOUND);
		}else {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("student not found");
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			studentResponse.setStudent(null);
			studentResponse.setStudents(null);
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path="/studentbymobile")
	public ResponseEntity<StudentResponse> findStudentByMobile(@RequestParam long mobile) {
		Student student=studentService.findStudentByMobile(mobile);
		if(student!=null) {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("student found");
			studentResponse.setStatus(HttpStatus.FOUND.value());
			studentResponse.setStudent(student);
			studentResponse.setStudents(null);
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.FOUND);
		}else {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("student not found");
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			studentResponse.setStudent(null);
			studentResponse.setStudents(null);
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = "/studentbynameandemail")
	public ResponseEntity<StudentResponse> findStudentByNameAndEmail(@RequestParam String name,@RequestParam String email) {
		Student student=studentService.findStudentNameAndEmail(name, email);
		if(student!=null) {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("student found");
			studentResponse.setStatus(HttpStatus.FOUND.value());
			studentResponse.setStudent(student);
			studentResponse.setStudents(null);
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.FOUND);
		}else {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("student not found");
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			studentResponse.setStudent(null);
			studentResponse.setStudents(null);
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
	
	
	
	

}

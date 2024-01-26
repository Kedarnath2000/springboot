package com.jspiders.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.springboot.pojo.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Student findByName(String name);
	
	Student findByEmail(String email);
	
	Student findByMobile(long mobile);
	
	Student findByNameAndEmail(String name,String email);

}

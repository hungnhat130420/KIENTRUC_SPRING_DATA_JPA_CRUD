package com.lab2.springboot_lab2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentRepositoryTest {
	@Autowired StudentRepository studentRepository;
	
	@Test
	public void getAllStudent() {
		System.out.println("All student : " + studentRepository.getAll());
	}
	
	@Test
	public void getStudentByFirstName() {
		System.out.println("Get student by first name " + studentRepository.getStudentByFirstName("Nhat"));
	}
	
	@Test
	public void addStudent() {
		studentRepository.addStudent(4L, "Tran", "Mi", "TranMi@gmail.com");
		System.out.println("add success");
	}
	@Test
	public void updateStudent() {
		studentRepository.updateStudent(4L, "TranMi123456@gmail.com");
		System.out.println("update success");
	}
	@Test
	public void deleteStudent() {
		studentRepository.deleteStudent(4L);
		System.out.println("delete success");
	}
	
	
	
}

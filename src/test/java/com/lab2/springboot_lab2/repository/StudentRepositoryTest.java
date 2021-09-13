package com.lab2.springboot_lab2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void getAll(){
        System.out.println("all student : " + studentRepository.getAllStudent());
    }
    @Test
    public void getStudentByFirstName(){
        System.out.println("Student by fist name " + studentRepository.getStudentByFirstName("Nhat"));
    }
    @Test
    public void updateStudent(){
        studentRepository.updateStudent(3L,"vanthanh123@gmail.com");
        System.out.println("update success");
    }
    @Test 
    public void addStudent() {
    	studentRepository.addStudent(5L, "Chi", "Thanh", "chithanh@gmail.com");
    	System.out.println("add success");
    }
	    @Test
	    public void deleteStudent() {
	    	studentRepository.deleteStudent(5L);
	    	System.out.println("delete success");
	    }

}

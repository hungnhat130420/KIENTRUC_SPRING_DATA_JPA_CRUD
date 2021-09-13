package com.lab2.springboot_lab2.repository;

import com.lab2.springboot_lab2.entity.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    //Code repo
    @Test
    public void saveStudent(){
        Student student = Student.builder()
                            .firstName("tam")
                            .lastName("van")
                            .email("tamvantrung@gmail.com")
                            .build();
      studentRepository.save(student)              ;
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("student list " + studentList);
    }
    @Test
    public void printAllByFirstName(){
        List<Student> students = studentRepository.findByFirstName("nhat");
        System.out.println("student list " + students);
    }
    @Test
    public void printAllByLastName(){
        List<Student> students = studentRepository.findByFirstName("tam");
        System.out.println("student list " + students);
    }
    @Test
    public void updateStudentTest(){
        Student student = studentRepository.findById(1L).get();
        student.setEmail("nguyentrannhathung.130420@gmail.com");
        Student studentUpdate = studentRepository.save(student);
        System.out.println("student is : " + studentUpdate);
    }
    @Test
    public void deleteStudentTest(){
        Student student = studentRepository.findById(2L).get();
        studentRepository.delete(student);

        Student student1 = null;
        Optional<Student> optionalStudent = studentRepository.findById(2L);
        if(optionalStudent.isPresent()){
            student1=optionalStudent.get();
        }
        Assertions.assertThat(student1).isNull();
    }

}

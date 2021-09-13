package com.lab2.springboot_lab2.repository;

import com.lab2.springboot_lab2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query(value="select * from tbl_student",nativeQuery = true)
    List<Student> getAll();
    
    @Query(value="select * from tbl_student where first_name=?1",nativeQuery = true)
    List<Student> getStudentByFirstName(String first_name);
    
    @Transactional
    @Modifying
    @Query(value="insert into tbl_student(employeeid,first_name,last_name,email) values (?1,?2,?3,?4 )",nativeQuery = true)
    void addStudent(Long employeeid,String first_name,String last_name,String email);
    
    @Transactional
    @Modifying
    @Query(value="update tbl_student set email=?2 where employeeid=?1",nativeQuery = true)
    void updateStudent(Long employeeid,String email);
    
    @Transactional
    @Modifying
    @Query(value="delete from tbl_student where employeeid=?1",nativeQuery = true)
    void deleteStudent(Long employeeid);
}
package com.lab2.springboot_lab2.repository;

import com.lab2.springboot_lab2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("select s from Student s")
    List<Student> getAllStudent();

    @Query("select s from Student s where s.firstName=?1")
    List<Student> getStudentByFirstName(String firstName);

    @Transactional
    @Modifying
    @Query(value="insert into tbl_student(employeeid,first_name,last_name,email) values (?1,?2,?3,?4)",nativeQuery = true)
    void addStudent(Long employeeid,String first_name,String last_name,String email);

    @Transactional
    @Modifying
    @Query("update Student s set s.email=?2 where s.employeeID=?1")
    void updateStudent(Long id,String email);
    
    @Transactional
    @Modifying
    @Query("delete from Student s where s.employeeid=?1")
    void deleteStudent(Long id);
}
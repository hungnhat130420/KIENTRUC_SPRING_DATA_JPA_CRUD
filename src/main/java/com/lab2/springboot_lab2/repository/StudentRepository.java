package com.lab2.springboot_lab2.repository;

import com.lab2.springboot_lab2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByLastName(String lastName);
    public List<Student> findByEmail(String name);


}
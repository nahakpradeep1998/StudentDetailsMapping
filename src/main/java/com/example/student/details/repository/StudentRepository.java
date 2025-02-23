package com.example.student.details.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.student.details.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    @Query("SELECT s.name, e FROM Education e JOIN student s WHERE s.id = :id")
    List<Object[]> findEducationDetailsWithStudentNameByStudentId(@Param("id") Long id);
   
}
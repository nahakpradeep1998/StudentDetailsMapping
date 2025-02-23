package com.example.student.details.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.details.entity.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
}
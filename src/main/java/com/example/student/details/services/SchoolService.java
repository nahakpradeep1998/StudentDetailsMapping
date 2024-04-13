package com.example.student.details.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.details.entity.Education;
import com.example.student.details.entity.Student;
import com.example.student.details.repository.EducationRepository;
import com.example.student.details.repository.StudentRepository;

@Service
public class SchoolService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EducationRepository educationRepository;

    public Student saveStudent(Student student) {
	return studentRepository.save(student);
    }

    public Education saveEducation(Education education) {
	return educationRepository.save(education);
    }

    public Optional<Student> findStudentById(Long id) {
	return studentRepository.findById(id);
    }

    public List<Object[]> getStudentWithEducationsById(Long id) {
	return studentRepository.findEducationDetailsWithStudentNameByStudentId(id);
    }

}

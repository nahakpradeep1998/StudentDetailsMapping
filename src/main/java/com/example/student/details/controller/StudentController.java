package com.example.student.details.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.example.student.details.entity.Education;
import com.example.student.details.entity.Student;
import com.example.student.details.services.SchoolService;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private SchoolService schoolService;

    @PostMapping("/create/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
	return new ResponseEntity<>(schoolService.saveStudent(student), HttpStatus.CREATED);
	
    }
    
    @PostMapping("/create/student/educationDetails/{studentId}")
    public ResponseEntity<Education> addEducation(@PathVariable Long studentId, @RequestBody Education education) {
	Student student = schoolService.findStudentById(studentId).orElseThrow(
		() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id " + studentId));

	education.setStudent(student);
	Education savedEducation = schoolService.saveEducation(education);
	return ResponseEntity.ok(savedEducation);
    }
    
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Object[]>> getEducationsByStudentId(@PathVariable("studentId") Long studentId) {
        List<Object[]> educations = schoolService.getStudentWithEducationsById(studentId);
        if (educations.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(educations);
    }
   
}

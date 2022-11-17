package com.bnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bnt.exception.StudentNotFoundException;
import com.bnt.model.Student;
import com.bnt.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;

	@PostMapping("/addStudent")
	public String addNewStudent(@RequestBody Student s) {

		String stud = null;
		try {
			stud = studentService.addStudent(s);

			if (stud.length() != 0) {
				System.out.println("student in controller");
			} else {
				stud = "Add student Details Successfully";
			}
		} catch (Exception ex) {
			ex.getMessage();
		}

		return stud;

	}

	@GetMapping(value = "/getById/{studId}")
	public ResponseEntity<Student> getAll(@PathVariable int studId) throws StudentNotFoundException {

		return ResponseEntity.ok(studentService.displayStudent(studId));

	}

	@GetMapping(value = "/getAllStudent")
	public ResponseEntity<List<Student>> getAllStudent() {
		return ResponseEntity.ok(studentService.displayAllStudent());

	}
	
	
	
}

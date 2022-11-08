package com.bnt.service;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnt.dao.StudentDao;
import com.bnt.model.Student;

@Service
public class StudentService {

	@Autowired
	 StudentDao studentDao;

	public String validateStudent(Student s) {
		String stud = "";
		if (s!= null) {
			if (s.getRollNo() == 0) {
				stud = stud.concat("roll number can not be zero ");
			}
			if (s.getName() == null || s.getName().trim().isEmpty()) {
				stud = stud.concat(" name can not be null or empty ");
			}
			
			if (s.getSubject() == null || s.getSubject().isEmpty()) {
				stud = stud.concat(" subject data can not be empty or null ");
			}

		} else {
			stud = "Invalid Request";
		}
		return stud;

	}

	

	@Transactional
	public String addStudent(Student student) {
		String stud = validateStudent(student);

		if (stud.length() != 0) {
			return stud;
		}
		else {
			try {
				studentDao.addStudent(student) ;
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		return stud;
		} 
	@Transactional
	public Student displayStudent(int studId) {

		return studentDao.getStudent(studId);
	}

	@Transactional
	public List<Student> displayAllStudent( ) {
List<Student> list=studentDao.getAllStudent();
		return list;
	}
	}



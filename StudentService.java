package com.bnt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnt.dao.StudentDao;
import com.bnt.exception.StudentNotFoundException;
import com.bnt.model.Student;
import com.bnt.model.Subject;

@Service
public class StudentService {

	@Autowired
	StudentDao studentDao;

	public String validateStudent(Student s) {
		String stud = "";
		if (s != null) {
			if (s.getRollNo() == 0) {
				stud = stud.concat("roll number can not be zero ");
			}
			if (s.getName() == null || s.getName().trim().isEmpty()) {
				stud = stud.concat(" name can not be null or empty ");
			}
			if (s.getSubject() == null || s.getSubject().isEmpty()) {
				stud = stud.concat(" subject data can not be null or empty ");
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
		} else {
			try {
				studentDao.addStudent(student);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return stud;
	}

	@Transactional
	public Student displayStudent(int studId) throws StudentNotFoundException {
		Student student = studentDao.getStudent(studId);
		if (student != null) {
			return student;
		} else {
			throw new StudentNotFoundException("student not found with id " + studId);
		}

	}

	@Transactional
	public List<Student> displayAllStudent() {
		List<Student> list = studentDao.getAllStudent();
		return list;
	}

	@Transactional
	public Map<String, List<Student>> displayMarks() {
		List<Student> list = studentDao.getAllStudent();
		Map<String, List<Student>> resultMap = new HashMap<String, List<Student>>();
		List<Student> greaterThan80Percentage = new ArrayList<Student>();
		List<Student> greaterThan70Percentage = new ArrayList<Student>();
		List<Student> greaterThan60Percentage = new ArrayList<Student>();
		List<Student> lessThan30Percentage = new ArrayList<Student>();
		double total = 0;
		int outOfMarks = 0;
		double percentage = 0.0;

		for (Student stud : list) {
			List<Subject> subject = stud.getSubject();
			for (Subject sub : subject) {

				total = sub.getMarks() + sub.getMarks() + sub.getMarks();
				// System.out.println(total);
				outOfMarks = sub.getTotalMarks() + sub.getTotalMarks() + sub.getTotalMarks();
				// System.out.println(outOfMarks);
				percentage = (total * 100) / outOfMarks;
				// System.out.println(percentage);
				if (percentage >80 && percentage <=100) {
					greaterThan80Percentage.add(stud);
				} else if (percentage >= 70 && percentage <= 80) {
					greaterThan70Percentage.add(stud);
				} else if (percentage >= 60 && percentage <70) {
					greaterThan60Percentage.add(stud);
				} else if(percentage>=40&& percentage<60){
					lessThan30Percentage.add(stud);
				}
				
				System.out.println(total);
				System.out.println(outOfMarks);
				System.out.println(percentage);

				resultMap.put("Student have greater than 80 % marks :", greaterThan80Percentage);
				resultMap.put("Student have greater than 70 % marks or less than 80 % marks :",greaterThan70Percentage);
				resultMap.put("Student have greater than 30 % marks or less than 70 % marks:", greaterThan60Percentage);
				resultMap.put("Student have less than 30 % marks :", lessThan30Percentage);

			}

		}
		
		return resultMap;
	}

}

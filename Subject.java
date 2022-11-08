package com.bnt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sId;
	private String subjectName;
	private int marks;
	private int totalMarks;
	
	@ManyToOne
    @JoinColumn(name = "studId")
	private Student student;

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject(int sId, String subjectName, int marks, int totalMarks, Student student) {
		super();
		this.sId = sId;
		this.subjectName = subjectName;
		this.marks = marks;
		this.totalMarks = totalMarks;
		this.student = student;
	}

	@Override
	public String toString() {
		return "Subject [sId=" + sId + ", subjectName=" + subjectName + ", marks=" + marks + ", totalMarks="
				+ totalMarks + ", student=" + student + "]";
	}

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}

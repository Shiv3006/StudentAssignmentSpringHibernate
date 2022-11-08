package com.bnt.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int studId;

	private int rollNo;

	private String name;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "student", cascade = CascadeType.ALL)
	private List<Subject> subject;

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}

	public Student(int studId, int rollNo, String name, List<Subject> subject) {
		super();
		this.studId = studId;
		this.rollNo = rollNo;
		this.name = name;
		this.subject = subject;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [studId=" + studId + ", rollNo=" + rollNo + ", name=" + name + ", subject=" + subject + "]";
	}

}

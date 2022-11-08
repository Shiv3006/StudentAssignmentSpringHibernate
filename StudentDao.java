package com.bnt.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bnt.model.Student;
@Repository
public class StudentDao {
	@Autowired
	 SessionFactory sessionFactory;

	public Student addStudent(Student student) {
		sessionFactory.getCurrentSession().save(student);
		return student;
	}

	public Student getStudent(int studId) {
		return sessionFactory.getCurrentSession().get(Student.class, studId);
	}
	
	public List<Student> getAllStudent() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = (CriteriaBuilder) session.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

}
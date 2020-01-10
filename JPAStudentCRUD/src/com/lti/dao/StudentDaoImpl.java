package com.lti.dao;

import javax.persistence.EntityManager;

import com.lti.model.Student;
import com.lti.utils.JpaUtils;

public class StudentDaoImpl implements StudentDao {
	private EntityManager entityManager;
	
	public StudentDaoImpl() {
		entityManager = JpaUtils.getEntityManager();
	}

	@Override
	public int createStudent(Student student) {
		entityManager.persist(student);
		return 1;
	}

	@Override
	public Student readStudent(int rollNumber) {
		Student student = entityManager.find(Student.class, rollNumber);
		return student;
	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
		
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
		
	}

	@Override
	public void rollbackTransaction() {
		entityManager.getTransaction().rollback();
	}

	@Override
	public int updateStudent(Student student) {
		entityManager.merge(student);
		return 1;
	}

	@Override
	public int deleteStudent(int rollNumber) {	
		
		entityManager.remove(rollNumber);
		
		return 1;
	}

}

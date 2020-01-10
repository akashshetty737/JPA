package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Student;

public class Main {
	public static void main(String[] args) {
		
			
			Student student = new Student(11,"Goodshah",99.98);			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
			EntityManager entityManager = factory.createEntityManager();
			

			
			
//			FOR ADDING DATA TO TABLE
			
//			entityManager.getTransaction().begin();
//			entityManager.persist(student);
//			entityManager.getTransaction().commit();
			
			
			
//// 		FOR READING DATA FROM THE TABLE
			
//			Student student2 = entityManager.find(Student.class, student.getRollNumber());
//			System.out.println(student2);
//			
//// 		FOR DELETING DATA FROM THE TABLE
			
//			entityManager.getTransaction().begin();
//			entityManager.remove(student2);
//			entityManager.getTransaction().commit();
//			
////			
////		student2 = entityManager.find(Student.class, student.getRollNumber());
////		System.out.println(student2);
//			
//			FOR UPDATING DATA IN TABLE
			entityManager.getTransaction().begin();
			student.setStudentName("Akash Shetty");
			entityManager.merge(student);
			entityManager.getTransaction().commit();
			Student student2 = entityManager.find(Student.class, student.getRollNumber());
			System.out.println(student2);
			
			
			
			
			
	}

}

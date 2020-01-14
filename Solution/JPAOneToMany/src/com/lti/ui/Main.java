package com.lti.ui;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.model.Department;
import com.lti.model.Employee;

public class Main {
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
	static EntityManager  entityManager = factory.createEntityManager();
	static Scanner sc = new Scanner(System.in);

	public static void loadData() {
		
		Employee emp1 = new Employee(101,"Akash",5000);
		Employee emp2 = new Employee(102,"Gaurav",6000);
		Employee emp3 = new Employee(103,"Shubham",7000);
		Employee emp4 = new Employee(104,"Sumeet",5000);
		
		Set<Employee> emps = new HashSet<Employee>();
		emps.add(emp1);
		emps.add(emp4);
		
		Set<Employee> emps2 = new HashSet<Employee>();
		emps.add(emp2);
		emps.add(emp3);
		
		Department dept = new Department(10, "Development");
		Department dept2 = new Department(20, "HR");
		
		dept.setEmployees(emps);
		dept2.setEmployees(emps2);
		
		emp1.setDepartment(dept);
		emp2.setDepartment(dept2);
		emp3.setDepartment(dept2);
		emp4.setDepartment(dept);
		
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(dept);
		entityManager.persist(dept2);
		
		entityManager.getTransaction().commit();
		
		
	}
	public static void searchByName() {
		
		System.out.println("Enter a name");
		String name =  sc.next();
		
		String jpql = "Select e From Employee e where employeeName= :name";
		TypedQuery<Employee> tquery = entityManager.createQuery(jpql, Employee.class);
		tquery.setParameter("name", name);
		List<Employee> result = tquery.getResultList();
		System.out.println(result);
	}
	public static void searchBySalary() {
		System.out.println("Enter a salary");
		double salary =  sc.nextDouble();
		
		String jpql = "Select e From Employee e where employeeSalary= :salary";
		TypedQuery<Employee> tquery = entityManager.createQuery(jpql, Employee.class);
		tquery.setParameter("salary", salary);
		List<Employee> result = tquery.getResultList();
		System.out.println(result);
	}
	public static void searchForSalaryMoreThan() {
		String jpql = "Select e From Employee e where employeeSalary> (Select employeeSalary from Employee e where employeeName = 'Sumeet')";
		TypedQuery<Employee> tquery = entityManager.createQuery(jpql, Employee.class);
		List<Employee> result = tquery.getResultList();
		System.out.println(result);
	
	}
	public static void searchByDepartmentId() {
		System.out.println("Enter a department id");
		int deptId =  sc.nextInt();
		
		String jpql = "SELECT e FROM Employee e JOIN e.department d WHERE d.departmentId= :deptId";
		TypedQuery<Employee> tquery = entityManager.createQuery(jpql, Employee.class);
		tquery.setParameter("deptId", deptId);
		List<Employee> result = tquery.getResultList();
		System.out.println(result);
	
	}
	public static void searchByDepartmentName() {
		System.out.println("Enter a department name");
		String deptName =  sc.next();
		
		String jpql = "SELECT e FROM Employee e JOIN e.department d WHERE d.departmentName= :deptName";
		TypedQuery<Employee> tquery = entityManager.createQuery(jpql, Employee.class);
		tquery.setParameter("deptName", deptName);
		List<Employee> result = tquery.getResultList();
		System.out.println(result);
	
	}
	public static void main(String[] args) {
		loadData();
	
			
	}

}

package com.lti.dao;

import com.lti.model.Student;

public interface StudentDao {
	public int createStudent(Student student);
	public Student readStudent(int rollNumber);
	public int updateStudent(Student student);
	public int deleteStudent(int rollNumber);
	
	
	public void beginTransaction();
	public void commitTransaction();
	public void rollbackTransaction();
	
	
	

}

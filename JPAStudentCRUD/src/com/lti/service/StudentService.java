package com.lti.service;
import com.lti.model.Student;

public interface StudentService {
	public boolean addStudent(Student student);
	public Student findStudentByRollNumber(int rollNumber);
	public int updateStudent(Student student);
	public int deleteStudent(int rollNumber);
}

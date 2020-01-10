package com.lti.service;

import com.lti.dao.StudentDao;
import com.lti.dao.StudentDaoImpl;
import com.lti.model.Student;

public class StudentServiceImpl implements StudentService {
	private StudentDao dao;
	
	public StudentServiceImpl() {
		dao = new StudentDaoImpl();
	}

	@Override
	public boolean addStudent(Student student) {
		dao.beginTransaction();
		int result =dao.createStudent(student);
		System.out.println(result);
		if(result == 1){
			dao.commitTransaction();
			System.out.println(result);
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public Student findStudentByRollNumber(int rollNumber) {
		return dao.readStudent(rollNumber);
	}

	@Override
	public int updateStudent(Student student) {
		dao.beginTransaction();
		int result = dao.updateStudent(student);
		if(result == 1){
		dao.commitTransaction();
		return 1;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public int deleteStudent(int rollNumber) {
		dao.beginTransaction();
//		System.out.println("error1");
		int result = dao.deleteStudent(rollNumber);
		
		
		if(result == 1){
		dao.commitTransaction();
		return 1;
		
		}
		else
		{
			return 0;
		}
	}
	
}

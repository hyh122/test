package com.example.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.DataContext;
import com.example.domain.IService.IStudentService;
import com.example.model.Student;

public class StudentService implements IStudentService{
	
	private DataContext dataContext;
	
	public StudentService(){
		dataContext=new DataContext();
	}
	
	public boolean addStudnet(Student student) {
		try{
			dataContext.add(student, Student.class, Integer.class);
			return true;
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Student> getStudents() throws SQLException {
		// TODO Auto-generated method stub
		List<Student> mList=null;
		mList=dataContext.queryForAll(Student.class, Integer.class);
		return mList;
		
	}

	@Override
	public Student getStudnetById(int studentID) throws SQLException{
		// TODO Auto-generated method stub
		return dataContext.queryById(Student.class, Integer.class, studentID);
	}
	
	public void deleteallstudent() throws SQLException{
		// TODO Auto-generated method stub
		 dataContext.deleteAll(Student.class, Integer.class);
	}
	
}

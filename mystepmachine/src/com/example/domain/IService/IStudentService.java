package com.example.domain.IService;

import java.sql.SQLException;
import java.util.List;

import com.example.model.Student;

public interface IStudentService {
	public boolean addStudnet(Student student);
	public List<Student> getStudents() throws SQLException;
	public Student getStudnetById(int studentID) throws SQLException;
}

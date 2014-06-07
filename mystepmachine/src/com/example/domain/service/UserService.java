package com.example.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.DataContext;

import com.example.model.Student;
import com.example.model.User;

public class UserService {
private DataContext dataContext;
	
	public UserService(){
		dataContext=new DataContext();
	}
	
	public boolean addUser(User user) {
		try{
			dataContext.add(user, User.class, Integer.class);
			return true;
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	public User getUserById(int UserID) throws SQLException{
		// TODO Auto-generated method stub
		return dataContext.queryById(User.class, Integer.class, UserID);
	}
	
	public void updateUser(User user) throws SQLException{
		dataContext.update(user, User.class, Integer.class);
	}
	//判断第一个用户是否为空
		public boolean isnulluser() throws SQLException{
			User user=new User();
			user=getUserById(1);
			if(user==null){
				return false;
			}
			return true;
		}
}

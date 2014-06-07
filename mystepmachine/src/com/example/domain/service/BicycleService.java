package com.example.domain.service;

import java.sql.SQLException;

import com.example.dao.DataContext;
import com.example.domain.IService.IBicycleService;
import com.example.model.Bicycle;

public class BicycleService implements IBicycleService {

	private DataContext dataContext;
	
	public BicycleService(){
		dataContext=new DataContext();
	}
	
	@Override
	public boolean addBicycle(Bicycle bicycle) throws SQLException {
		// TODO Auto-generated method stub
		dataContext.add(bicycle, Bicycle.class, Integer.class);
		return true;
	}

}

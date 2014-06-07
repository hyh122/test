package com.example.domain.IService;

import java.sql.SQLException;

import com.example.dao.DataContext;
import com.example.model.Bicycle;

public interface IBicycleService {

	public boolean addBicycle(Bicycle bicycle) throws SQLException;
}

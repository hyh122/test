package com.example.domain.IService;

import java.sql.SQLException;
import java.util.List;

import com.example.model.MealCard;
import com.example.model.Student;

public interface IMealCardService {
	public MealCard getMealCardByStudent(Student student)throws SQLException;
	public void addMealCard(MealCard mealCard)throws SQLException;
}

package com.example.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.DataContext;
import com.example.domain.IService.IMealCardService;
import com.example.model.MealCard;
import com.example.model.Student;
import com.j256.ormlite.stmt.QueryBuilder;

public class MealCardService implements IMealCardService {

	private DataContext dataContext;
	
	public MealCardService(){
		dataContext=new DataContext();
	}
	
	@Override
	public MealCard getMealCardByStudent(Student student)
			throws SQLException {
		// TODO Auto-generated method stub
		List<MealCard> mList=null;
		QueryBuilder<MealCard, Integer> querryMealCard=
				dataContext.getQueryBuilder(MealCard.class, Integer.class);
		querryMealCard.where().eq("student_id", student.getStudentID());		
		mList=dataContext.query(MealCard.class, Integer.class, querryMealCard.prepare());
		return mList.get(0);
	}

	@Override
	public void addMealCard(MealCard mealCard) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}

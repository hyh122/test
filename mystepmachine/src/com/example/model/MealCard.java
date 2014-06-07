package com.example.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="T_MealCard")
public class MealCard {//餐卡类
	
	@DatabaseField(generatedId=true)
	private int mealCardID;//餐卡ID
	
	@DatabaseField(foreign=true)
	private Student student;//所属的学生
	
    public MealCard(){
    	//无参构造函数
    }

	public int getMealCardID() {
		return mealCardID;
	}

	public void setMealCardID(int mealCardID) {
		this.mealCardID = mealCardID;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
    
    
}


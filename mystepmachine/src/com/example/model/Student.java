package com.example.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="T_Student")
public class Student {//学生类
	
	@DatabaseField(generatedId=true)
	private int studentID;//学生ID
	@DatabaseField(canBeNull=false)
	private String studentName;//学生姓名
	@DatabaseField(canBeNull=false)
	private String school;//所在学校
	@DatabaseField(foreign=true)
	private MealCard mealCard;//学生餐卡
	
    public Student(){//无参构造函数
    	
    }
	public Student(int studentID){//有参构造函数
		this.studentID=studentID;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public MealCard getMealCard() {
		return mealCard;
	}
	public void setMealCard(MealCard mealCard) {
		this.mealCard = mealCard;
	}
	
	
}


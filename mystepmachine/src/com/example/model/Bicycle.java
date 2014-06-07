package com.example.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="T_Bicycle")
public class Bicycle {//自行车类

	@DatabaseField(generatedId=true)
	private int bicycleID;//自行车ID
	
	@DatabaseField(canBeNull=false)
	private String bicycleName;//自行车类型
	
	@DatabaseField(foreign=true)
	private Student student;//所属的学生
	
    public Bicycle(){//无参构造函数
    	
    }

	public int getBicycleID() {
		return bicycleID;
	}

	public void setBicycleID(int bicycleID) {
		this.bicycleID = bicycleID;
	}

	public String getBicycleName() {
		return bicycleName;
	}

	public void setBicycleName(String bicycleName) {
		this.bicycleName = bicycleName;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
    
}


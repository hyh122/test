package com.example.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="T_User")
public class User {//�û���
	@DatabaseField(generatedId=true)
	private int userID;//ѧ��ID
	@DatabaseField(canBeNull=false)
	private String username;//ѧ������
	@DatabaseField(canBeNull=false)
	private String password;//����ѧУ
	@DatabaseField(canBeNull=false)
	private String usersex;//ѧ������
	@DatabaseField(canBeNull=false)
	private String birthday;//����ѧУ
	@DatabaseField(canBeNull=false)
	private float userhigh;//ѧ������
	@DatabaseField(canBeNull=false)
	private float userweight;//����ѧУ
	@DatabaseField(canBeNull=false)
	private float steplength;//ѧ������
	@DatabaseField(canBeNull=false)
	private int usergoal;//����ѧУ
	public User(int userID, String username, String password, String usersex,
			String birthday, float userhigh, float userweight,
			float steplength, int usergoal) {
	
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.usersex = usersex;
		this.birthday = birthday;
		this.userhigh = userhigh;
		this.userweight = userweight;
		this.steplength = steplength;
		this.usergoal = usergoal;
	}
	public User() {
		super();
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public float getUserhigh() {
		return userhigh;
	}
	public void setUserhigh(float userhigh) {
		this.userhigh = userhigh;
	}
	public float getUserweight() {
		return userweight;
	}
	public void setUserweight(float userweight) {
		this.userweight = userweight;
	}
	public float getSteplength() {
		return steplength;
	}
	public void setSteplength(float steplength) {
		this.steplength = steplength;
	}
	public int getUsergoal() {
		return usergoal;
	}
	public void setUsergoal(int usergoal) {
		this.usergoal = usergoal;
	}

	
	
	
	
}

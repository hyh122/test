package domain.businessEntity.systemManagement;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
//OR映射标签表明
@DatabaseTable(tableName = "T_User")
public class User {
	public User(){
		this.id=0;
		this.email="";
		this.password="";
		this.username="";
		this.userPhone="";
		this.userProfessional="";
	}
	//表列自增长标签
	@DatabaseField(generatedId = true)
	private int id;
	//该列不可为空
	@DatabaseField(canBeNull = false)
	private String userPhone;
	
	@DatabaseField(canBeNull = false)
	private String password;
	
	@DatabaseField(canBeNull = false)
	private String username;
	
	@DatabaseField(canBeNull = true)
	private String userProfessional;
	
	@DatabaseField(canBeNull = true)
	private String email;
	
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserProfessional() {
		return userProfessional;
	}
	public void setUserProfessional(String userProfessional) {
		this.userProfessional = userProfessional;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

package ui.viewModel.SystemManagement;

import java.util.ArrayList;
import java.util.List;


import ui.viewModel.ModelErrorInfo;
import ui.viewModel.ViewModel;

public class UserModel extends ViewModel {
	private String userPhone;	
	private String password;
	private String username;
	private String userProfessional;
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
	@Override
	public List<ModelErrorInfo> verifyModel() {
		List<ModelErrorInfo> errs=null;
		if(errs == null)
			errs = new ArrayList<ModelErrorInfo>();
		if(userPhone.equals("") || password.equals("")){
			ModelErrorInfo err=new ModelErrorInfo();
			err.setErrAttName("user");
			err.setErrMsg("用户名或密码不能为空 ");
			errs.add(err);
		}	
		return errs;
	}

}

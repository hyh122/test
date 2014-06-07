package ui.caseStudy;

import java.util.List;

import ui.activity.ActivityOfAF4Ad;
import ui.viewModel.ModelErrorInfo;
import ui.viewModel.ViewModel;
import ui.viewModel.SystemManagement.UserModel;

import com.example.demoone.R;

import domain.businessEntity.systemManagement.User;
import domain.businessService.systemManagement.ISystemManagementService;
import domain.businessService.systemManagement.SystemManagementService;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends ActivityOfAF4Ad {
	private TextView tv_username;
	private TextView tv_phone;
	private TextView tv_email;
	private TextView tv_professional;
	private ISystemManagementService service;
	private SharedPreferences sp_userPhone;
	private String userPhone;
	private UserModel uModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 实例化service
		service = new SystemManagementService();
		

	}

	public void initView() {
		tv_username = (TextView) findViewById(R.id.tv_watch_card_info_name);
		tv_email = (TextView) findViewById(R.id.tv_watch_card_info_email);
		tv_phone = (TextView) findViewById(R.id.tv_watch_card_info_mobilephone);
		tv_professional = (TextView) findViewById(R.id.tv_watch_card_info_professional);

		uModel = (UserModel) vm;

		
	}

	@Override
	protected void initControlsAndRegEvent() {
		initView();
		
		// 设置TextView的内容
		tv_username.setText(uModel.getUsername());
		tv_email.setText(uModel.getEmail());
		tv_professional.setText(uModel.getUserProfessional());
		tv_phone.setText(uModel.getUserPhone());

	}

	@Override
	protected ViewModel initModel() {
		UserModel uModel = new UserModel();
		// 通过配置文件来获取数据
		sp_userPhone = getSharedPreferences("login_and_regist", MODE_PRIVATE);
		userPhone = sp_userPhone.getString("userPhone", "");
		User user = service.findUserByPhone(userPhone);
		uModel.setUserPhone(user.getUserPhone());
		uModel.setUsername(user.getUsername());
		uModel.setEmail(user.getEmail());
		uModel.setUserProfessional(user.getUserProfessional());

		return uModel;
	}

	@Override
	protected void upDateView(ViewModel aVM) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processViewModelErrorMsg(List<ModelErrorInfo> errsOfVM,
			String errMsg) {
		// TODO Auto-generated method stub

	}
}

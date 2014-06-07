package ui.caseStudy;

import java.util.List;

import ui.activity.ActivityOfAF4Ad;
import ui.viewModel.ModelErrorInfo;
import ui.viewModel.ViewModel;

import com.example.demoone.R;

import domain.businessEntity.systemManagement.User;
import domain.businessService.systemManagement.ISystemManagementService;
import domain.businessService.systemManagement.SystemManagementService;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class EditActivity extends ActivityOfAF4Ad {

	private EditText edit_userName, edit_userPhone, edit_userTel,
			edit_userEmail, edit_userQQ, edit_userProfessional,
			edit_userAddress,edit_pwd;
	private ImageButton imageBtn_save;
	private ISystemManagementService service;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit);
		

	}

	private void initView() {
		edit_userName = (EditText) findViewById(R.id.edit_userName);
		edit_userPhone = (EditText) findViewById(R.id.edit_userPhone);
		edit_userEmail = (EditText) findViewById(R.id.edit_userEmail);
		edit_userProfessional = (EditText) findViewById(R.id.edit_userProfessional);
		edit_pwd = (EditText) findViewById(R.id.edit_pwd);
		imageBtn_save = (ImageButton) findViewById(R.id.imageBtn_save);

	}

	@Override
	protected void initControlsAndRegEvent() {
		initView();
		
		//实例化SystemManagementServcie
				service = new SystemManagementService();
				
				/**
				 * 监听保存键单击响应情况
				 */
				imageBtn_save.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						User user = new User();
						//使用getText方法获取编辑框控件的内容
						user.setUsername(edit_userName.getText().toString());
						user.setUserPhone(edit_userPhone.getText().toString());
						user.setEmail(edit_userEmail.getText().toString());
						user.setUserProfessional(edit_userProfessional.getText().toString()); 
						user.setPassword(edit_pwd.getText().toString());
						if(service.saveUser(user)){
							//设置一个Intent
							Intent intent = new Intent(EditActivity.this,ViewPagerActivity.class);
							//设置Bundle 用于Intent传值
							Bundle bundle = new Bundle();
							bundle.putString("phone", edit_userPhone.getText().toString());
							intent.putExtras(bundle);
							//跳转到主界面
							startActivity(intent);
							finish();
						}else {
							Toast toast = Toast.makeText(EditActivity.this, "注册失败", Toast.LENGTH_SHORT);
							toast.show();
						}
						
					}
				});
		
	}

	@Override
	protected ViewModel initModel() {
		// TODO Auto-generated method stub
		return null;
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

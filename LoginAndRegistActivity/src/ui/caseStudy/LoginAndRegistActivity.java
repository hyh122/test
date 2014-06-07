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
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginAndRegistActivity extends ActivityOfAF4Ad {

	private Button btn_login, btn_regist; // 按钮变量声明
	private EditText et_userphone, et_password; // 编辑框变量声明
	private String userPhone, password;
	private ISystemManagementService service;
	private UserModel uModel;

	// Activity生命周期开始
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_and_regist); // 加载当前Activity显示的页面
		service = new SystemManagementService();
		initView(); // 初始化View
	}

	/**
	 * 初始化View
	 */
	private void initView() {
		// 通过R文件映射找到activity_login_and_regist.xml上面相应的控件名称，然后赋予声明的变量
		btn_login = (Button) findViewById(R.id.btn_login);
		btn_regist = (Button) findViewById(R.id.btn_regist);
		et_userphone = (EditText) findViewById(R.id.et_userphone);
		et_password = (EditText) findViewById(R.id.et_password);

		uModel = (UserModel) vm;
		// 对登录按钮设置相应的点击监听
		btn_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				userPhone = et_userphone.getText().toString(); // 获取输入框中的值
				password = et_password.getText().toString();
				uModel.setUserPhone(userPhone);
				uModel.setPassword(password);

				List<ModelErrorInfo> errs = uModel.verifyModel();
				String msgError = "";
				for (ModelErrorInfo modelErrorInfo : errs) {
					msgError += modelErrorInfo.getErrMsg();
				}
				if (!msgError.equals("")) {
					Toast toast = Toast.makeText(LoginAndRegistActivity.this,
							msgError, Toast.LENGTH_SHORT);
					toast.show();
				}
				if (msgError.equals("")) {
					if (login()) {
						// 实现Activity跳转意图，从LoginAndRegistActivity跳转至MainActivity
						Intent intent = new Intent(LoginAndRegistActivity.this,
								ViewPagerActivity.class);
						Bundle bundle = new Bundle();
						bundle.putString("phone", userPhone);
						intent.putExtras(bundle);
						startActivity(intent);
						// 结束当前Activity
						finish();
						Toast toast2 = Toast.makeText(
								LoginAndRegistActivity.this, "登录成功",
								Toast.LENGTH_SHORT);
						toast2.show();
					} else {
						Toast toast2 = Toast.makeText(
								LoginAndRegistActivity.this, "用户名或密码错误",
								Toast.LENGTH_SHORT);
						toast2.show();
					}
				}// 验证用户名密码正确性
			}
		});

		// 对注册按钮设置相应的点击监听
		btn_regist.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// 实现Activity跳转意图，从LoginAndRegistActivity跳转至MainActivity
				Intent intent = new Intent(LoginAndRegistActivity.this,
						EditActivity.class);
				startActivity(intent);
				// 结束当前Activity
				finish();

			}
		});
	}

	public boolean login() {
		// 调用service中的方法
		String tmp = uModel.getUserPhone();
		User user = service.findUserByPhone(uModel.getUserPhone());
		if (user.getPassword().equals(uModel.getPassword()))
			return true;
		else
			return false;
	}

	@Override
	protected void initControlsAndRegEvent() {
		initView();

	}

	@Override
	protected ViewModel initModel() {
		UserModel uModel = new UserModel();
		uModel.setUserPhone("");
		uModel.setPassword("");
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

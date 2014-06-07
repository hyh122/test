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

	private Button btn_login, btn_regist; // ��ť��������
	private EditText et_userphone, et_password; // �༭���������
	private String userPhone, password;
	private ISystemManagementService service;
	private UserModel uModel;

	// Activity�������ڿ�ʼ
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_and_regist); // ���ص�ǰActivity��ʾ��ҳ��
		service = new SystemManagementService();
		initView(); // ��ʼ��View
	}

	/**
	 * ��ʼ��View
	 */
	private void initView() {
		// ͨ��R�ļ�ӳ���ҵ�activity_login_and_regist.xml������Ӧ�Ŀؼ����ƣ�Ȼ���������ı���
		btn_login = (Button) findViewById(R.id.btn_login);
		btn_regist = (Button) findViewById(R.id.btn_regist);
		et_userphone = (EditText) findViewById(R.id.et_userphone);
		et_password = (EditText) findViewById(R.id.et_password);

		uModel = (UserModel) vm;
		// �Ե�¼��ť������Ӧ�ĵ������
		btn_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				userPhone = et_userphone.getText().toString(); // ��ȡ������е�ֵ
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
						// ʵ��Activity��ת��ͼ����LoginAndRegistActivity��ת��MainActivity
						Intent intent = new Intent(LoginAndRegistActivity.this,
								ViewPagerActivity.class);
						Bundle bundle = new Bundle();
						bundle.putString("phone", userPhone);
						intent.putExtras(bundle);
						startActivity(intent);
						// ������ǰActivity
						finish();
						Toast toast2 = Toast.makeText(
								LoginAndRegistActivity.this, "��¼�ɹ�",
								Toast.LENGTH_SHORT);
						toast2.show();
					} else {
						Toast toast2 = Toast.makeText(
								LoginAndRegistActivity.this, "�û������������",
								Toast.LENGTH_SHORT);
						toast2.show();
					}
				}// ��֤�û���������ȷ��
			}
		});

		// ��ע�ᰴť������Ӧ�ĵ������
		btn_regist.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// ʵ��Activity��ת��ͼ����LoginAndRegistActivity��ת��MainActivity
				Intent intent = new Intent(LoginAndRegistActivity.this,
						EditActivity.class);
				startActivity(intent);
				// ������ǰActivity
				finish();

			}
		});
	}

	public boolean login() {
		// ����service�еķ���
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

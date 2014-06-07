package com.example.ui;

import java.sql.SQLException;
import java.util.Calendar;

import com.example.domain.service.StudentService;
import com.example.domain.service.UserService;
import com.example.model.User;





import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class settingUi extends Activity{
	//�����ʾ��һ������ѡ����
	private Button btn_birthDate;
	//�����ÿ��Ŀ���һ
	private Button add;
	//�����ÿ��Ŀ���һ
	private Button minus;
	//���水ť
	private Button save;
	//����˻ص�ԭ��activity�İ�ť
	private ImageButton imbtn_back;
	//��ʾÿ��Ŀ��
	private EditText et_goal;
	private StudentService studentservice;
	//user��Ϣ
	private String username="1111",password="2222",usersex,birthday;
	private float userheight,userweight,steplength;
	private int goalcount;
	
	//��ѡ�����
	private RadioGroup group;
	private RadioButton rb;
	
	//user
	private User user;
	//userservice
	private UserService userservice;

	private TextView tv_showbirth;
	private EditText et_height,et_weight,et_steplength;
    private int year, monthOfYear, dayOfMonth, hourOfDay, minute;
    private int x=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_mian);
//		//��ʼ��user��userservice
		user=new User();
		userservice=new UserService();
		
		//�ҵ���ť��id
		btn_birthDate=(Button) findViewById(R.id.btn_birthdate);
		add=(Button) findViewById(R.id.add);
		add.setOnClickListener(new addListener());
		
		minus=(Button) findViewById(R.id.minus);
		minus.setOnClickListener(new minusListener());
		
		save=(Button) findViewById(R.id.save);
		save.setOnClickListener(new saveListener());
		
		imbtn_back=(ImageButton) findViewById(R.id.imbtn_back);
		imbtn_back.setOnClickListener(new backListener());
		//�ҵ�textview
		tv_showbirth=(TextView) findViewById(R.id.tv_showbirth);
		//�ҵ�edittext
		et_height=(EditText) findViewById(R.id.et_height);
		et_weight=(EditText) findViewById(R.id.et_weight);
		et_steplength=(EditText) findViewById(R.id.et_steplength);
		et_goal=(EditText) findViewById(R.id.et_goal);  
		studentservice=new StudentService();
		Calendar calendar = Calendar.getInstance();
	        year = calendar.get(Calendar.YEAR);
	        monthOfYear = calendar.get(Calendar.MONTH);
	        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
	        hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
	        minute = calendar.get(Calendar.MINUTE);
	        
	        btn_birthDate.setOnClickListener(new OnClickListener()
	        {
	            public void onClick(View view)
	            {
	                /**
	                 * ʵ����һ��DatePickerDialog�Ķ���
	                 * �ڶ���������һ��DatePickerDialog.OnDateSetListener�����ڲ��࣬���û�ѡ������ڵ��done����������onDateSet����
	                 */
	                DatePickerDialog datePickerDialog = new DatePickerDialog(settingUi.this, new DatePickerDialog.OnDateSetListener()
	                {
	                    public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth)
	                    {
	                        tv_showbirth.setText( + year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
	                        
	                    }
	                }, year, monthOfYear, dayOfMonth);
	                datePickerDialog.updateDate(1990, 0, 01);
	                
	                datePickerDialog.show();
	            }

			
	        });
	        
	    group=(RadioGroup) findViewById(R.id.radioGroup);
	    rb=(RadioButton) findViewById(group.getCheckedRadioButtonId());
	    usersex=rb.getText().toString();
	    group.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
			      //��ȡ������ѡ�����ID
	               int radioButtonId = group.getCheckedRadioButtonId();
		               //����ID��ȡRadioButton��ʵ��
		              rb=(RadioButton) findViewById(radioButtonId);
		              usersex=rb.getText().toString();
			}
		});

			
}
	//����Ŀ�경�����ļ���
			private final class addListener implements View.OnClickListener{
				@Override
				public void onClick(View v) {
					if(!et_goal.getText().toString().equals(""))
					{
						x=Integer.parseInt(et_goal.getText().toString());
						x++;
					}
					else
						x=0;
					et_goal.setText(String.valueOf(x));
				}
			}
			//����Ŀ�경�����ļ���
			private final class minusListener implements View.OnClickListener{
				@Override
				public void onClick(View v) {
					if(!et_goal.getText().toString().equals(""))
					{
						x=Integer.parseInt(et_goal.getText().toString());
						x--;
					}
					else 
						x=0;
					et_goal.setText(String.valueOf(x));
				}
			}
			//�˻ص�ǰһ��activity�ļ���
			private final class backListener implements View.OnClickListener{
				@Override
				public void onClick(View v) {
//					Intent intent=new Intent(settingUi.this,MainActivity.class);
//					startActivity(intent);
					settingUi.this.finish();
				}
			}
			//�������ݵļ���
			private final class saveListener implements View.OnClickListener{
				@Override
				public void onClick(View v) {
					birthday=tv_showbirth.getText().toString();
					userheight=Float.valueOf(et_height.getText().toString());
					userweight=Float.valueOf(et_weight.getText().toString());
					steplength=Float.valueOf(et_steplength.getText().toString());
					goalcount=Integer.parseInt(et_goal.getText().toString());
					
					user=new User(1,username,password,usersex,birthday,userheight,userweight,steplength,goalcount);
					Log.e("setting",user.getUsername()+user.getPassword()+user.getUsersex()+user.getBirthday()+user.getUserhigh()+user.getUserweight()+
							user.getSteplength()+user.getUsergoal());
					try {
						if(userservice.isnulluser())//�������ݿⲻ�ǿյ�,�����ݣ�����£���������û�
						userservice.updateUser(user);
						else
							userservice.addUser(user);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					 Toast.makeText(getApplicationContext(), "����ɹ�", Toast.LENGTH_SHORT).show();  
				}
			}
}

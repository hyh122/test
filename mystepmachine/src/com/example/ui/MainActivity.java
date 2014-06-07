package com.example.ui;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.defUser.defaultUser;
import com.example.domain.service.UserService;
import com.example.model.User;



import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnKeyListener;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
	//��ť
	Button history_button;
	Button assess_button;
	Button setting_button;
	private Button start;
	
	private int step=0;//����ֵ
	private double meter=0;//�������
	private double colouis=0;//��·������ֵ
	private double achievedgoal;//Ŀ����ɶ�
	
	//TextView
	private TextView tv_stepnumber,tv_meters,tv_colouis,tv_goal;
	private TextView scroll_word;//���ù�����Ļ
	
	//����Ŀ���textview��ʾ
	private TextView tv_goalnum;
	//�����ݿ����user����
	private UserService userservice;
	
	//user
	private User user;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//�ҵ���ť��id
		history_button=(Button) this.findViewById(R.id.history);
		assess_button=(Button) this.findViewById(R.id.assess);
		setting_button=(Button) this.findViewById(R.id.setting);
		start=(Button) findViewById(R.id.start);
		//�ҵ�textView��id
		tv_stepnumber=(TextView) findViewById(R.id.tv_stepnumber);
		tv_meters=(TextView) findViewById(R.id.tv_meters);
		tv_colouis=(TextView) findViewById(R.id.tv_colouis);
		tv_goal=(TextView) findViewById(R.id.tv_goal);
		tv_goalnum=(TextView) findViewById(R.id.tv_goalnum);
		
		//�԰�ť���м���
		history_button.setOnClickListener(new historyButtonListener());
		assess_button.setOnClickListener(new assessButtonListener());
		setting_button.setOnClickListener(new settingButtonListener());
		start.setOnClickListener(new startButtonListener());
		//���ù�����Ļ
		scroll_word=(TextView) this.findViewById(R.id.scroll_word);
		scroll_word.setMovementMethod(ScrollingMovementMethod.getInstance());
		
		
		//�����ݿ����user������
		user=new User();
		//user=defaultUser.getdefaultUser();
		userservice=new UserService();
		try {
		if(userservice.isnulluser()){//�ж����ݿ��һ���û��Ƿ�Ϊ�գ����ǵĻ���ȡ����������ȡĬ�ϵ�user
			user=userservice.getUserById(1);
		}
		else
			user=defaultUser.getdefaultUser();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		tv_goalnum.setText("Ŀ��:"+String.valueOf(user.getUsergoal()));


	
	}
	//��ѯ��ʷ��¼��ť�ļ���
	private final class historyButtonListener implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			//String number=mobiletext.getText().toString();
			
			Intent intent = new Intent(MainActivity.this,historyUi.class); 
			startActivity(intent);
			
		}
	}
	
	//������ť�ļ���
		private final class assessButtonListener implements View.OnClickListener{
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//String number=mobiletext.getText().toString();
				
				Intent intent = new Intent(MainActivity.this,assessUi.class); 
				startActivity(intent);
				
			}
		}
		//���ð�ť�ļ���
		private final class settingButtonListener implements View.OnClickListener{
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//String number=mobiletext.getText().toString();
				
				Intent intent = new Intent(MainActivity.this,settingUi.class); 
				startActivity(intent);
				
			}
		}
		//��ʼ��ť�ļ���
				private final class startButtonListener implements View.OnClickListener{
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						//��ʾ������
						step++;
						tv_stepnumber.setText(String.valueOf(step));
						//��ʾ���߾�����
						meter=step*(user.getSteplength()/100);
						//����yֵֻ������λС��
						DecimalFormat df = new DecimalFormat("0.00");
						String num = df.format(meter);
						tv_meters.setText(num);
						//��ʾ��·��������
						DecimalFormat df2 = new DecimalFormat("0.000");
						int speed=2;
						colouis=colouis+(1.25*speed*3600/1000/1000);
						String colouisnum = df2.format(colouis);
						tv_colouis.setText(colouisnum);
						//��ʾĿ����ɶ�ֵ
						achievedgoal=(step/Float.valueOf(user.getUsergoal()))*100;
						DecimalFormat df3 = new DecimalFormat("0.00");
						String numgoal = df3.format(achievedgoal);
						tv_goal.setText(numgoal+"%");
				}
			}
	
}

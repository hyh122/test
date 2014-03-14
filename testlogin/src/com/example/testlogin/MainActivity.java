package com.example.testlogin;

import com.example.view.ViewActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText username;
	private EditText passwordnumber;
	private Button loginbutton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		username=(EditText) this.findViewById(R.id.user);
		passwordnumber=(EditText) this.findViewById(R.id.password);
		loginbutton=(Button) this.findViewById(R.id.login);
		
		loginbutton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String password=passwordnumber.getText().toString();
				if(password.equals("123456"))
				{
					Intent intent=new Intent(MainActivity.this,ViewActivity.class);
					startActivity(intent);
				}
				else{
					System.out.println("login fial");
				}
			}
			
		});
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

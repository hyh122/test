package ui.caseStudy;

import java.util.ArrayList;
import java.util.List;

import com.example.demoone.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class TestTwoActivity extends Activity {

	private Spinner sp_send, sp_city, sp_age;
	private ArrayAdapter<String> adapter;
    private List<String> list_send = new ArrayList<String>();
    private List<String> list_city = new ArrayList<String>();
    private List<String> list_age = new ArrayList<String>();
    private TextView txt_send;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_two);
		sp_send = (Spinner) findViewById(R.id.sp_send);
		sp_city = (Spinner) findViewById(R.id.sp_city);
		sp_age = (Spinner) findViewById(R.id.sp_age);
		txt_send=(TextView) findViewById(R.id.txt_send);
		// 设置下拉列表中的内容
		list_send.add("WiFi");
		list_send.add("蓝牙");
		list_send.add("二维码");
		list_send.add("短信");

		// 准备一个数组适配器，并使用系统的样式
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list_send);

		// 设置下拉列表的样式为浮动菜单
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp_send.setAdapter(adapter);// 设置适配器

		sp_send.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int  position, long id) {
				// TODO Auto-generated method stub
			
				txt_send.setText(list_send.get(position));
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}

			
		});


		// 设置下拉列表中的内容
		list_city.add("福州");
		list_city.add("上海");
		list_city.add("深圳");
		list_city.add("广州");

		// 准备一个数组适配器，并使用系统的样式
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list_city);

		// 设置下拉列表的样式为浮动菜单
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp_city.setAdapter(adapter);// 设置适配器

		// 设置下拉列表中的内容
		list_age.add("10岁");
		list_age.add("20岁");
		list_age.add("30岁");
		list_age.add("40岁");

		// 准备一个数组适配器，并使用系统的样式
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list_age);

		// 设置下拉列表的样式为浮动菜单
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp_age.setAdapter(adapter);// 设置适配器
		
	}
}

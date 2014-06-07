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
		// ���������б��е�����
		list_send.add("WiFi");
		list_send.add("����");
		list_send.add("��ά��");
		list_send.add("����");

		// ׼��һ����������������ʹ��ϵͳ����ʽ
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list_send);

		// ���������б����ʽΪ�����˵�
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp_send.setAdapter(adapter);// ����������

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


		// ���������б��е�����
		list_city.add("����");
		list_city.add("�Ϻ�");
		list_city.add("����");
		list_city.add("����");

		// ׼��һ����������������ʹ��ϵͳ����ʽ
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list_city);

		// ���������б����ʽΪ�����˵�
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp_city.setAdapter(adapter);// ����������

		// ���������б��е�����
		list_age.add("10��");
		list_age.add("20��");
		list_age.add("30��");
		list_age.add("40��");

		// ׼��һ����������������ʹ��ϵͳ����ʽ
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list_age);

		// ���������б����ʽΪ�����˵�
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp_age.setAdapter(adapter);// ����������
		
	}
}

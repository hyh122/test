package app;


import ui.viewModel.ViewModel;
import foundation.data.DataHelper;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


/**
 * 
 * @author 2011����
 * 
 */
public class MyApplication extends Application {

	// ���ݿ�����
	public static DataHelper DATAHELPER;

	// ���ݿ���
	public static String DATAFILENAME = "myApp.db";
	
	// Activity��ת�㲥������
	public static ViewFwdRcv VWFWDRCV;

	@Override
	public void onCreate() {

		super.onCreate();
		// ��ʼ��ȫ�ֱ���
		DATAHELPER = new DataHelper(getApplicationContext(), DATAFILENAME);
		System.out.println("abc");
	}
	//Activity��ת�㲥��������Ķ���
		public class ViewFwdRcv extends BroadcastReceiver {

			@Override
			public void onReceive(Context arg0, Intent arg1) {

				//��ȡԴԴActivity��Ŀ��ԴActivity������
				String frmActClsNm = arg1.getStringExtra("frmActClsNm");
				String toActClsNm = arg1.getStringExtra("toActClsNm");

				if (frmActClsNm.equals(toActClsNm) || frmActClsNm == null
						|| toActClsNm == null) {
					return;
				}
				
	            //ԴActivity��ViewModel����
				ViewModel ObjOfFrmActVM = null;
				
				//Ŀ��Activity��ViewModel����
				ViewModel ObjOfToActVM = null;
				
				//ԴActivity��ViewModel����Ĵ������
				Bundle bdlOfFrmAct = arg1.getExtras();
				
				//Ŀ��Activity��ViewModel����Ĵ������
				Bundle bdlOfToAct = null;
				
				if (bdlOfFrmAct != null) {
				  // ��ȡԴActivity��ViewModel����
				  ObjOfFrmActVM = ViewModel.readFromBundle(bdlOfFrmAct);
				}
				//����ԴActivity��ViewModel���󣬱任����Ŀ��Activity��ViewModel����
				ObjOfToActVM = ViewModelTansformation(frmActClsNm, ObjOfFrmActVM,
						toActClsNm);

				//���Ŀ��Activity��ViewModel����
				if (ObjOfToActVM != null) {
					bdlOfToAct = ObjOfToActVM.writeToBundle();
				}

				Class<?> clsOfToAct=null;
				try {
					clsOfToAct = Class.forName(toActClsNm);

					Intent toActIntent = new Intent(MyApplication.this, clsOfToAct);
					if (bdlOfToAct != null) {
						toActIntent.putExtras(bdlOfToAct);
					}
					toActIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					startActivity(toActIntent);
				} catch (ClassNotFoundException e) {
					Log.e(toActClsNm, "Ŀ��Activity�����Ҳ���");
				}

			}
		}

		protected ViewModel ViewModelTansformation(String frmActClsNm,
				ViewModel objOfFrmActVM, String toActClsNm) {

			ViewModel resultVMofToAct = null;

			/*
			if (frmActClsNm.equals(Activity1.class.getName())
					&& toActClsNm.equals(Aoivtity2.class.getName())){
				// ǿ������ת��
				if (objOfFrmActVM != null) {
					ViewModelX objOfVMX = (ViewModelX) objOfFrmActVM;
					ViewModelY objOfVMY = new ViewModelY();

					//��ͼģ�ͱ任
					objOfVMY.setAge2(objOfVMX.getAge() + 1);
					resultVMofToAct = objOfVMY;
				}
			}
			*/
		
			return resultVMofToAct;
		}
}

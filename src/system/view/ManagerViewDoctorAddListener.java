package system.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
*@author:yb
*@version 创建时间：2018年1月18日 下午4:05:36
*/
public class ManagerViewDoctorAddListener implements ActionListener{

	private ManagerMainView managerMainView;
	
	public ManagerViewDoctorAddListener(ManagerMainView managerMainView) {
		this.managerMainView=managerMainView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try
	    {
		  org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		    
	    }
	    catch(Exception e3)
	    {
	        //TODO exception
	    }
		DoctorAddView ai = new DoctorAddView();
		ai.init();
		
	}

}

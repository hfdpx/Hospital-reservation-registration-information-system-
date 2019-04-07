package system.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import system.dao.DoctorDao;
import system.dao.impl.DoctorDaoImpl;
import system.entity.Doctor;
import system.service.DoctorService;
import system.service.impl.DoctorServiceImpl;
import system.view.ManagerMainView;

/*
*@author:yb
*@version 创建时间：2018年1月18日 上午11:17:26
*/
public class ManagerMainViewSelectDoctorListener implements ActionListener{

	private ManagerMainView managerMainView;
	private DoctorDao doctorDao = new DoctorDaoImpl();
	private Doctor doctor;
	public  ManagerMainViewSelectDoctorListener(ManagerMainView managerMainView) {
		this.managerMainView=managerMainView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JTextField jtf;
		jtf=managerMainView.getJtf2();
		
//		loginComBox.addItem("医生姓名查询");
//		loginComBox.addItem("医生级别查询");
//		loginComBox.addItem("所属科室查询");
		
		String[] colNames = { "医生编号", "医生姓名", "性别", "级别", "所属科室","擅长方向","办公地点" };
		
		if(managerMainView.getLoginComBox().getSelectedIndex()==0) {
			
			DoctorService doctorService = new DoctorServiceImpl();
			
			String[][] dates = doctorService.getOneDoctorMessage(jtf.getText());
			
			DefaultTableModel dtm = managerMainView.getQueryTableModel();
			
			dtm.setDataVector(dates, colNames);
			
		}else if(managerMainView.getLoginComBox().getSelectedIndex()==1) {
			
			DoctorService doctorService = new DoctorServiceImpl();

			String[][] dates = doctorService.getSomeDoctorMessageByLevel(jtf.getText().trim());

			DefaultTableModel dtm = managerMainView.getQueryTableModel();

			
			dtm.setDataVector(dates, colNames);
			
			
		}else if(managerMainView.getLoginComBox().getSelectedIndex()==2) {
		
			DoctorService doctorService = new DoctorServiceImpl();

			String[][] dates = doctorService.getSomeDoctorMessageByRoom(jtf.getText().trim());

			DefaultTableModel dtm = managerMainView.getQueryTableModel();

			
			dtm.setDataVector(dates, colNames);
		}
	}
	
}

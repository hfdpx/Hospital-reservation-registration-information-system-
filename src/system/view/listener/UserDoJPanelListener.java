package system.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import system.dao.DoDao;
import system.dao.DoctorDao;
import system.dao.RoomDao;
import system.dao.impl.DoDaoImpl;
import system.dao.impl.DoctorDaoImpl;
import system.dao.impl.RoomDaoImpl;
import system.entity.DO;
import system.entity.Doctor;
import system.entity.Room;
import system.entity.User;
import system.service.DoctorService;
import system.service.UserService;

import system.service.impl.DoctorServiceImpl;
import system.service.impl.UserServiceImpl;
import system.view.UserDoctorJPanel;
import system.view.UserDoMessageJpanel;

public class UserDoJPanelListener implements ActionListener{
    private UserDoctorJPanel  userDoPanel;
    private String buttonMessage;
    private DoctorService doctorservice;
    private String[] colNames = { "医生编号", "医生姓名", "性别", "级别", "所属科室","擅长方向","办公地点" };

    
    
	public UserDoJPanelListener(UserDoctorJPanel userDoPanel,String buttonMessage){
		this.userDoPanel=userDoPanel;
		this.buttonMessage=buttonMessage;
		doctorservice=new DoctorServiceImpl();


		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(buttonMessage.equals("科室查询")){
			

			String roomnumber= userDoPanel.getKeshiTextField().getText();
			String[][] dates =doctorservice.getSomeDoctorMessageByRoom(roomnumber) ;
			DefaultTableModel dtm = userDoPanel.getQueryTableModel();
			dtm.setDataVector(dates, colNames);
		}
        
        if(buttonMessage.equals("医生查询")){
        	
        	String doctorname=userDoPanel.getZhuanjiaTextField().getText();
        	String[][] dates =doctorservice.getOneDoctorMessage(doctorname);
        	DefaultTableModel dtm = userDoPanel.getQueryTableModel();
			dtm.setDataVector(dates, colNames);
		}
		
        if(buttonMessage.equals("刷新")){
        	String[][] dates=doctorservice.getDoctorMessage();
        	DefaultTableModel dtm = userDoPanel.getQueryTableModel();
			dtm.setDataVector(dates, colNames);
        }
       
        
	}

}

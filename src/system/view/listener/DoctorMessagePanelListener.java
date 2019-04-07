package system.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import system.dao.DoctorDao;
import system.dao.RoomDao;
import system.dao.impl.RoomDaoImpl;
import system.entity.Doctor;
import system.entity.Room;
import system.service.DoctorService;
import system.service.impl.DoctorServiceImpl;
import system.view.DoctorMessageJPanel;

public class DoctorMessagePanelListener implements ActionListener {
    private  DoctorMessageJPanel doctorMessagrPanel;
    private  String buttonMessage;
    private  Doctor doctor;
    private  DoctorService doctorService;
    private DoctorDao doctorDao;
    
	public DoctorMessagePanelListener(DoctorMessageJPanel doctorMessagrPanel,String buttonMessage) {
		// TODO Auto-generated method stub
        this.doctorMessagrPanel=doctorMessagrPanel;
        this.buttonMessage=buttonMessage;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(buttonMessage.equals("修改")){
			doctorMessagrPanel.getJtfgood().setEnabled(true);
			doctorMessagrPanel.getJtfkroom().setEnabled(true);
			doctorMessagrPanel.getJtflevel().setEnabled(true);
			doctorMessagrPanel.getJtfpassword().setEnabled(true);
			doctorMessagrPanel.getJtfrepassword().setEnabled(true);
			doctorMessagrPanel.getJtfsex().setEnabled(true);
			doctorMessagrPanel.getJtftime().setEnabled(true);
	   }
		if(buttonMessage.equals("完成")){
			doctor=new Doctor();
			if(String.valueOf(doctorMessagrPanel.getJtfpassword().getPassword()).equals//当输入的密码和再次输入的密码一致时
					(String.valueOf(doctorMessagrPanel.getJtfrepassword().getPassword()))){
				doctorMessagrPanel.getJtfgood().setEnabled(false);
				doctorMessagrPanel.getJtfkroom().setEnabled(false);
				doctorMessagrPanel.getJtflevel().setEnabled(false);
				doctorMessagrPanel.getJtfpassword().setEnabled(false);
				doctorMessagrPanel.getJtfrepassword().setEnabled(false);
				doctorMessagrPanel.getJtfsex().setEnabled(false);
				doctorMessagrPanel.getJtftime().setEnabled(false);
				
				
				
//				System.out.println(doctorMessagrPanel.getJtfgood().getText());
//				System.out.println();
//				System.out.println();
//				System.out.println();
//				System.out.println();
//				System.out.println();
//				System.out.println();
//				System.out.println();
				RoomDao roomDao=new RoomDaoImpl();
				Room room=roomDao.getRoomByRoomName(doctorMessagrPanel.getJtfkroom().getText());
				//System.out.println(doctorMessagrPanel.getJtfgood().getText());
				//System.out.println(doctorMessagrPanel.getJtfname().getText());
				//System.out.println(room.getId());
				doctor.setBelongRoom(room.getId());
				
				doctor.setGoodAt(doctorMessagrPanel.getJtfgood().getText());
				doctor.setLevel(doctorMessagrPanel.getJtflevel().getText());
				doctor.setLoginPassWord(String.valueOf(doctorMessagrPanel.getJtfpassword().getPassword()));
				doctor.setSex(doctorMessagrPanel.getJtfsex().getText());
				doctor.setTime(doctorMessagrPanel.getJtftime().getText());
				doctor.setLoginName(doctorMessagrPanel.getJtfname().getText());
				doctor.setName(doctorMessagrPanel.getJtfname().getText());
				
				doctor.setWorkWhere(room.getWhere());
				System.out.println(doctor.getGoodAt());
				doctorService=new DoctorServiceImpl();
				doctorService.updateDoctorByLoginName(doctor);
				
			}else{
				JOptionPane.showMessageDialog(doctorMessagrPanel, "密码确认错误请重新输入密码!");
			}
		
		}
	}

}

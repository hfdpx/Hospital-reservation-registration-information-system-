package system.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import system.dao.DoDao;
import system.dao.DoctorDao;
import system.dao.impl.DoDaoImpl;
import system.dao.impl.DoctorDaoImpl;
import system.entity.DO;
import system.entity.Doctor;
import system.service.UserService;
import system.service.impl.UserServiceImpl;
import system.view.UserDoctorJPanel;

/**
 * UserDoJPanel中点击预约按钮的监听器
 * 
 * 
 * @author yb
 * @date 2018-1-18 下午7:36:07
 */
public class UserDoJPanelDoButtonListener implements ActionListener {
	private UserDoctorJPanel userDoPanel;
	private String doMessage;

	public UserDoJPanelDoButtonListener(UserDoctorJPanel userDoPanel, String str) {
		this.userDoPanel = userDoPanel;
		doMessage = str;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// try{
		JTable tb = new JTable();

		tb = userDoPanel.getQueryTable();
		if (tb.getSelectedRow() != -1) {
			// 从表中得到所选医生的ID
			int doctorId = Integer.parseInt(tb.getValueAt(tb.getSelectedRow(),
					0).toString());
			// 从表中得到所选医生的所属科室
			String doctorRoom = tb.getValueAt(tb.getSelectedRow(), 3)
					.toString();
			// 得到用户的ID
			UserService uservice = new UserServiceImpl();
			int userId = uservice.getUserIdByName(userDoPanel.getName());
			// 得到所选的医生
			DoctorDao doctorDao = new DoctorDaoImpl();
			Doctor doctor = doctorDao.getDoctorByID(doctorId);
			System.out.println("ybybyb");
			DO doEntity = new DO();
			doEntity.setdId(doctorId);
			doEntity.setDoTime(doctor.getTime());
			doEntity.setuId(userId);

			DoDao doDao = new DoDaoImpl();
			doDao.insertDo(doEntity);

			JOptionPane.showMessageDialog(userDoPanel, "预约挂号成功!");
		}
		// }catch(Exception er){
		// // JOptionPane.showMessageDialog(userDoPanel,"预约挂号未成功!");
		// }
	}

}

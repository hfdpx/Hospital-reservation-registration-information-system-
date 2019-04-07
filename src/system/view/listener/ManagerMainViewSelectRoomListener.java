package system.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import system.dao.RoomDao;
import system.dao.impl.RoomDaoImpl;
import system.entity.Room;
import system.view.ManagerMainView;

/*
*@author:yb
*@version 创建时间：2018年1月18日 下午4:57:15
*/
public class ManagerMainViewSelectRoomListener implements ActionListener{

	private ManagerMainView managerMainView;
	private RoomDao roomDao = new RoomDaoImpl();
	
	public  ManagerMainViewSelectRoomListener(ManagerMainView managerMainView) {
		this.managerMainView=managerMainView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String[] colNames2 = { "科室名称", "科室人数", "科室地点", "科室主攻方向"};
		
		JTextField jtf;
		jtf=managerMainView.getJtksname();
		
		Room r = roomDao.getRoomByRoomName(jtf.getText());
		
		
		String[][] dates = new String[1][4];
		
		dates[0][0]=r.getName();
		dates[0][1]=r.getNum()+"";
		dates[0][2]=r.getWhere();
		dates[0][3]=r.getD_o();
		
		DefaultTableModel dtm = managerMainView.getQueryTableModel2();
			
	    dtm.setDataVector(dates, colNames2);
			
	}

}

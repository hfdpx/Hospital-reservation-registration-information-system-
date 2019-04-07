package system.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import system.dao.RoomDao;
import system.dao.impl.RoomDaoImpl;
import system.service.RoomService;
import system.service.UserService;
import system.service.impl.RoomServiceImpl;
import system.service.impl.UserServiceImpl;
import system.view.ManagerMainView;

/*
*@author:yb
*@version 创建时间：2018年1月18日 上午11:08:07
*/
public class ManagerMainViewDeleteRoomListener implements ActionListener{

	private ManagerMainView managerMainView;
	private RoomDao roomDao = new RoomDaoImpl();
	
	private String name="";
	private JTable tb;
	
	public  ManagerMainViewDeleteRoomListener(ManagerMainView managerMainView) {
		this.managerMainView=managerMainView;
		//this.name=str;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		tb=managerMainView.getQueryTable2();
		
		if(tb.getSelectedRow()!=-1) {
			String name = tb.getValueAt(tb.getSelectedRow(), 0).toString();
			System.out.println(name);
			roomDao.deleteRoomByRoomName(name);
			DefaultTableModel dtm = managerMainView.getQueryTableModel2();
			
			RoomService roomService = new RoomServiceImpl();
			
			String[][] dates = roomService.getRoomMessage();
			
			String[] colNames2 = { "科室名称", "科室人数", "科室地点", "科室主攻方向"};
			
			dtm.setDataVector(dates, colNames2);
		}
		
	}

}

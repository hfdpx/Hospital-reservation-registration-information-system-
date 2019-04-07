package system.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import system.dao.UserDao;
import system.dao.impl.UserDaoImpl;
import system.exception.DaoException;
import system.service.UserService;
import system.service.impl.UserServiceImpl;
import system.view.ManagerMainView;

/*
*@author:yb
*@version 创建时间：2018年1月18日 下午1:19:18
*/
public class ManagerMainViewSelectUserListener implements ActionListener{

	private ManagerMainView managerMainView;
	private UserDao userDao = new UserDaoImpl();
	
	public  ManagerMainViewSelectUserListener(ManagerMainView managerMainView) {
		this.managerMainView=managerMainView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String[] colNames1 = { "用户编号", "用户名称", "用户电话", "用户地址", "用户身份证号" };
		
		JTextField jtf;
		jtf=managerMainView.getJtf1();
		
		
//		loginComBox1.addItem("用户名查询");
//		loginComBox1.addItem("身份证号查询");
		
		UserService userService = new UserServiceImpl();
		
		
		
		if(managerMainView.getLoginComBox1().getSelectedIndex()==0) {
			
			
			try {
				String[][] dates = userService.getOneUserMessageByName(jtf.getText());

				
				DefaultTableModel dtm = managerMainView.getQueryTableModel1();

				dtm.setDataVector(dates, colNames1);
			} catch (DaoException e5) {
				throw e5;
			}
		}else if(managerMainView.getLoginComBox1().getSelectedIndex()==1) {
			
            try {
            	 String[][] dates = userService.getOneMessageByCardNumber(jtf.getText());
     			
                 DefaultTableModel dtm = managerMainView.getQueryTableModel1();
     			
     			dtm.setDataVector(dates, colNames1);
			}catch (DaoException e5){
				throw e5;
			}
		}
	}

}

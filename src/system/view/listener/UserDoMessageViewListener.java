package system.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import system.service.DoService;
import system.service.impl.DoServiceImpl;
import system.view.UserDoMessageJpanel;

public class UserDoMessageViewListener implements ActionListener {
    private String username;
    private UserDoMessageJpanel userDoMessageJPanel;
    private JTable tb;
   
	public UserDoMessageViewListener(UserDoMessageJpanel  userDoMessageJPanel,String username){
		this.userDoMessageJPanel=userDoMessageJPanel;
		this.username=username;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("刪除预约挂号")){
		  tb=userDoMessageJPanel.getQueryTable();
		  if(tb.getSelectedRow()!=-1){//点击表格中的内容
			  String doctorname=tb.getValueAt(tb.getSelectedRow(), 1).toString();
			  DoService doService=new DoServiceImpl();
			  doService.deleteDoByID(username, doctorname);
			
			  Vector<String> colNames = new Vector<String>();
			  Collections.addAll(colNames,  "用户姓名", "医生姓名", "科室", "地点", "预约时间");
			
			  Vector<Vector<String>>  vectorDo=new Vector<Vector<String>>();
			  DoService doservice=new DoServiceImpl();
			  vectorDo=doservice.getDoByUserName(username);
			  DefaultTableModel dtm = userDoMessageJPanel.getQueryTableModel();
			  dtm.setDataVector(vectorDo, colNames);
			  JOptionPane.showMessageDialog(userDoMessageJPanel, "删除成功");
		}
	}
		if(e.getActionCommand().equals("刷新挂号记录")){
			Vector<String> colNames = new Vector<String>();
			  Collections.addAll(colNames,  "用户姓名", "医生姓名", "科室", "地点", "预约时间");
			Vector<Vector<String>>  vectorDo=new Vector<Vector<String>>();
			  DoService doservice=new DoServiceImpl();
			  vectorDo=doservice.getDoByUserName(username);
			  DefaultTableModel dtm = userDoMessageJPanel.getQueryTableModel();
			  dtm.setDataVector(vectorDo, colNames);
		}

	}

}

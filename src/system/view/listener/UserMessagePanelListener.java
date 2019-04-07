package system.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import system.entity.User;
import system.service.UserService;
import system.service.impl.UserServiceImpl;
import system.view.UserMessagePanel;

/*
*@author:yb
*@version 创建时间：2018年1月17日 下午9:11:03
*/
public class UserMessagePanelListener implements ActionListener{
	private UserMessagePanel userMessagePanel;
	private String buttonMessage;
	private User user;
	private UserService userService;
	public UserMessagePanelListener (UserMessagePanel userMessagePanel,String buttonMessage) {
		this.userMessagePanel=userMessagePanel;
		this.buttonMessage=buttonMessage;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(buttonMessage.equals("修改")){
//			userMessagePanel.getJtfuserid().setEnabled(true);
//			userMessagePanel.getJtfuloginname().setEnabled(true);
			userMessagePanel.getJtfrepassword().setEnabled(true);
			userMessagePanel.getJtfpassword().setEnabled(true);
//			userMessagePanel.getJtfIDcardnum().setEnabled(true);
			userMessagePanel.getJtfphone().setEnabled(true);
			userMessagePanel.getJtfadress().setEnabled(true);
		}
		if(buttonMessage.equals("完成")){
//			String str1=userMessagePanel.getJtfadress().getText();
//			String str2=userMessagePanel.getJtfIDcardnum().getText();
//			System.out.print(str1);
			user=new User();
			if(String.valueOf(userMessagePanel.getJtfpassword().getPassword()).equals
					(String.valueOf(userMessagePanel.getJtfrepassword().getPassword()))){//当输入的密码和再次输入的密码一致时
			    userMessagePanel.getJtfrepassword().setEnabled(false);
			    userMessagePanel.getJtfpassword().setEnabled(false);
			    userMessagePanel.getJtfIDcardnum().setEnabled(false);
			    userMessagePanel.getJtfphone().setEnabled(false);
			    userMessagePanel.getJtfadress().setEnabled(false);
			    user.setAdress(userMessagePanel.getJtfadress().getText());
			    user.setId(Integer.parseInt(userMessagePanel.getJtfuserid().getText()));
			    user.setIdCardName(userMessagePanel.getJtfIDcardnum().getText());
			    user.setLoginName(userMessagePanel.getJtfuloginname().getText());
			    user.setPassWord(String.valueOf(userMessagePanel.getJtfpassword().getPassword()));
			    user.setTelNumber(userMessagePanel.getJtfphone().getText());
			    userService=new UserServiceImpl();
			    userService.updateUserByLoginName(user);
			    
			}else{
				JOptionPane.showMessageDialog(userMessagePanel, "密码确认错误请重新输入密码!");
			}
		}

	}

}

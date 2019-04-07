package system.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import system.entity.Doctor;
import system.entity.User;
import system.service.AllShareService;
import system.service.impl.AllShareServiceImpl;
import system.view.DoctorMainView;
import system.view.LoginView;
import system.view.ManagerMainView;
import system.view.RigisterView;
import system.view.UserMainView;


/*
*@author:yb
*@version 创建时间：2018年1月17日 下午3:11:05
*/
public class LoginViewListener implements ActionListener {
	private LoginView loginView;
	private AllShareService allShareService = new AllShareServiceImpl();
	
	public LoginViewListener(LoginView loginView) {
		this.loginView = loginView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==loginView.getLoginBtn()) {
			String username = loginView.getUsernameField().getText();
			char[] arrays = loginView.getPwdField().getPassword();
			String password = new String(arrays);
			System.out.println(username + "  " + password);
			
			if (loginView.getloginComBox().getSelectedIndex() == 0) {
				try {
					User u = allShareService.userLogin(username, password);
					// 表示登录成果
					// 隐藏登录界面
					loginView.dispose();
					// 启动主界面
					// MainView main = new MainView();
					// main.init();
					try
				    {
					  org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
				    }
				    catch(Exception e2)
				    {
				        //TODO exception
				    }

				UserMainView main = new UserMainView(username);
				main.setVisible(true);
					
					// main.init(emp.getUsername(), datas);
				} catch (Exception er) {
					// 弹出一个提示框,展示错误信息给用户
					JOptionPane.showMessageDialog(loginView, er.getMessage());
				}
			} else if (loginView.getloginComBox().getSelectedIndex() == 1) {
				try {
					Doctor d = allShareService.doctorLogin(username, password);
					loginView.dispose();
					
					try
				    {
					  org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					    
				    }
				    catch(Exception e3)
				    {
				        //TODO exception
				    }
					
					DoctorMainView doctormain=new DoctorMainView(username);
					doctormain.setVisible(true);
					
				} catch (Exception er) {
					JOptionPane.showMessageDialog(loginView, er.getMessage());
				}
				
				
			}else if(loginView.getloginComBox().getSelectedIndex() == 2) {
				if(username.equals("root")&&password.equals("123")) {
					JOptionPane.showMessageDialog(loginView, "登录成功");
					
					try
				    {
					  org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					    
				    }
				    catch(Exception e3)
				    {
				        //TODO exception
				    }
					
					ManagerMainView mmv = new ManagerMainView();
					mmv.init();
					
				}else {
					JOptionPane.showMessageDialog(loginView, "管理员名或者密码错误");
				}
			}
		}else if(e.getSource()==loginView.getRegisterBtn()) {
			try
		    {
			  org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			    
		    }
		    catch(Exception e3)
		    {
		        //TODO exception
		    }
			
			RigisterView rgisterview = new RigisterView();
			rgisterview.init();
		}
		
	}

}

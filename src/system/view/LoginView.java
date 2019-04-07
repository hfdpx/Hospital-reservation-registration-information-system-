package system.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import system.view.listener.LoginViewListener;

/**
 * 
 * 登录界面
 * 
 * @author yb 2018-1-16
 */
public class LoginView extends JFrame {
	private JTextField usernameField;
	private JLabel usernameLabel;
	private JPasswordField pwdField;
	private JLabel pwdLabel;
	private JButton loginBtn, registerBtn;
	private JComboBox loginComBox;

	public LoginView() {
		this.setSize(500, 350);
		this.setTitle("门诊挂号系统");
		usernameLabel = new JLabel("用户名:");

		usernameField = new JTextField();
		pwdField = new JPasswordField();
		pwdLabel = new JLabel("密 码:");

		loginBtn = new JButton("登录");
		registerBtn = new JButton("注册");

		loginComBox = new JComboBox();
		loginComBox.addItem("用户");
		loginComBox.addItem("医生");
		loginComBox.addItem("管理员");

		initLayout();

		// 设置居中的效果
		system.utils.GUIUtils.setCenterInWindow(this);
		// 设置窗口大小不能调整
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private JPanel titlePanel() {
		JLabel title = new JLabel("门诊挂号系统");
		title.setFont(new Font("隶书", Font.BOLD, 30));
		JPanel panel = new JPanel();
		panel.add(title);
		return panel;
	}

	private JPanel centerPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);

		usernameLabel.setBounds(30, 20, 80, 25);
		usernameField.setBounds(130, 20, 150, 25);
		loginComBox.setBounds(320, 20, 90, 25);

		pwdLabel.setBounds(30, 70, 80, 25);
		pwdField.setBounds(130, 70, 150, 25);

		loginBtn.setBounds(130, 130, 50, 30);
		registerBtn.setBounds(240, 130, 50, 30);

		/*** 为登录按钮绑定事件 **/
		loginBtn.addActionListener(new LoginViewListener(this));
		registerBtn.addActionListener(new LoginViewListener(this));

		panel.add(usernameLabel);
		panel.add(usernameField);
		panel.add(pwdField);
		panel.add(pwdLabel);
		panel.add(loginBtn);
		panel.add(registerBtn);
		panel.add(loginComBox);

		return panel;
	}

	private void initLayout() {
		this.add(titlePanel(), BorderLayout.NORTH);
		this.add(centerPanel(), BorderLayout.CENTER);

	}

	public JTextField getUsernameField() {
		return usernameField;
	}

	public JPasswordField getPwdField() {
		return pwdField;
	}

	public JComboBox getloginComBox() {
		return loginComBox;
	}

	public JButton getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(JButton loginBtn) {
		this.loginBtn = loginBtn;
	}

	public JButton getRegisterBtn() {
		return registerBtn;
	}

	public void setRegisterBtn(JButton registerBtn) {
		this.registerBtn = registerBtn;
	}

	// public static void main(String[] args) {
	// try
	// {
	// org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	//
	// // //设置本属性将改变窗口边框样式定义
	// // BeautyEyeLNFHelper.frameBorderStyle =
	// BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
	// // org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	// //
	// }
	// catch(Exception e)
	// {
	// //TODO exception
	// }
	// LoginView loginview=new LoginView();
	// loginview.setVisible(true);
	//
	// }
}

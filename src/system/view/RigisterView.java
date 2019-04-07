package system.view;



import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import system.view.listener.UserRigisterViewListener;
import system.view.utils.GUIUtils;

public class RigisterView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel usmLabel ;
	private JLabel psdLabel ;
	private JLabel resLabel ; 
	private JLabel skeyLabel;
	private JLabel addressLabel;
	private JLabel idcardLabel;
	private JTextField usmField ; 
	private JPasswordField psdField ; 
	private JPasswordField resField ;
	private JTextField skeyField;
	private JTextField addressField;
	private JTextField idcardField;
	private JButton registerBtn;
	private JButton cancelBtn;
	private JPanel jpl;
 /**
 * 初始化方法
 */
public void init(){
	//设置标题
	this.setTitle("注册");
	//设置窗口大小
	this.setSize(370, 500);
	//设置窗口位置居中
	GUIUtils.setCenterInWindow(this);

	jpl = new JPanel();
	jpl.setSize(370,500);
	this.add(jpl);
//	//设置窗口监听事件
//	this.addWindowListener(new WindowAdapter() {	
//		public void windowClosed(WindowEvent e) {
//			System.exit(0);
//		}
//	});
	//设置空布局
	jpl.setLayout(null);
	//窗口内组件实例化
	usmLabel = new JLabel("用户名 ： ");
	usmField = new JTextField("");
	
	psdLabel = new JLabel("设置密码：");
	resLabel = new JLabel("确认密码：");
	skeyLabel = new JLabel("电话:");
	addressLabel = new JLabel("地址:");
	idcardLabel = new JLabel("身份证号:");
	
	
	psdField = new JPasswordField("");
	resField = new JPasswordField("");
	skeyField = new JTextField("");
	addressField = new JTextField("");
	idcardField = new JTextField("");
	registerBtn = new JButton ("注册");
	cancelBtn = new JButton("取消");
	
	registerBtn.addActionListener(new UserRigisterViewListener(this));
	cancelBtn.addActionListener(new UserRigisterViewListener(this));
	
	//设置字体
	Font font = new Font("宋体",0,14);
	//设置各组件位置
	usmLabel.setBounds(65, 50, 70, 30);
	usmLabel.setFont(font);
	jpl.add(usmLabel);
	
	usmField.setBounds(155, 50, 120, 30);
	usmField.setFont(font);
	jpl.add(usmField);
	
	skeyLabel.setBounds(65, 100, 70, 30);
	skeyLabel.setFont(font);
	jpl.add(skeyLabel);
	
	skeyField.setBounds(155, 100, 120, 30);
	skeyField.setFont(font);
	jpl.add(skeyField);
	
	addressLabel .setBounds(65, 150, 70, 30);
	addressLabel.setFont(font);
	jpl.add(addressLabel);	
	
	addressField.setBounds(155, 150, 120, 30);
	addressField.setFont(font);
	jpl.add(addressField);
	
	idcardLabel.setBounds(65, 200, 70, 30);
	idcardLabel.setFont(font);
	jpl.add(idcardLabel);
	
	idcardField.setBounds(155, 200, 120, 30);
	jpl.add(idcardField);
	
	psdLabel.setBounds(65, 250, 70, 30);
	psdLabel.setFont(font);
	jpl.add(psdLabel);
	
	psdField.setBounds(155, 250, 120, 30);
	psdField.setFont(font);
	jpl.add(psdField);
	
	resLabel.setBounds(65, 300, 70, 30);
	resLabel.setFont(font);
	jpl.add(resLabel);
	
	resField.setBounds(155, 300, 120, 30);
	resField.setFont(font);
	jpl.add(resField);
	
	registerBtn.setBounds(85, 370, 70, 30);
	registerBtn.setFont(font);
	jpl.add(registerBtn);
	
	cancelBtn.setBounds(185, 370, 70, 30);
	cancelBtn.setFont(font);
	jpl.add(cancelBtn);
	
//	//注册按钮绑定监听事件
//	registerBtn.addActionListener(new RegisterViewListener(this));
//	cancelBtn.addActionListener(new RegisterViewListener(this));
//     //设置窗口可见
	this.setVisible(true);
	
	}
public JTextField getUsmField() {
	return usmField;
}
public void setUsmField(JTextField usmField) {
	this.usmField = usmField;
}
public JPasswordField getPsdField() {
	return psdField;
}
public void setPsdField(JPasswordField psdField) {
	this.psdField = psdField;
}
public JPasswordField getResField() {
	return resField;
}
public void setResField(JPasswordField resField) {
	this.resField = resField;
}
public JTextField getSkeyField() {
	return skeyField;
}
public void setSkeyField(JTextField skeyField) {
	this.skeyField = skeyField;
}
public JTextField getAddressField() {
	return addressField;
}
public void setAddressField(JTextField addressField) {
	this.addressField = addressField;
}
public JTextField getIdcardField() {
	return idcardField;
}
public void setIdcardField(JTextField idcardField) {
	this.idcardField = idcardField;
}
//public static void main(String[] args) {
//	
//	try
//    {
//	  org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//	    
//    }
//    catch(Exception e3)
//    {
//        //TODO exception
//    }
//	
//	Rigister rgisterview = new Rigister();
//	rgisterview.init();
//}
public JButton getRegisterBtn() {
	return registerBtn;
}
public void setRegisterBtn(JButton registerBtn) {
	this.registerBtn = registerBtn;
}
public JButton getCancelBtn() {
	return cancelBtn;
}
public void setCancelBtn(JButton cancelBtn) {
	this.cancelBtn = cancelBtn;
}
}


package system.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import system.dao.UserDao;
import system.dao.impl.UserDaoImpl;
import system.entity.User;
import system.view.listener.UserMessagePanelListener;

/**
 * 用户主界面中用户个人信息面板
 * 
 * 
 * @author yb
 * @date 2018-1-17 下午3:46:05
 */
public class UserMessagePanel extends JPanel {
	private JTextField jtfuserid, jtfuloginname, jtfIDcardnum, jtfphone,
			jtfadress;
	private JPasswordField jtfpassword, jtfrepassword;
	private JLabel jlbuserid, jlbuloginname, jlbIDcardnum, jlbphone;
	private JLabel jlbpassword, jlbrepassword, jlbadress;
	private JButton updateBtn, finishBtn;
	private JLabel title;
	private String name;

	public UserMessagePanel(String str) {
		name = str;
		this.setLayout(null);
		init();
	}

	private void init() {

		jtfuserid = new JTextField();// 用户ID
		jtfuloginname = new JTextField();// 用户姓名
		jtfIDcardnum = new JTextField();// 省份证号
		jtfphone = new JTextField();// 电话号码
		jtfpassword = new JPasswordField();// 密码
		jtfrepassword = new JPasswordField();// 确认密码
		jtfadress = new JTextField();// 家庭地址

		title = new JLabel("个人信息");
		title.setFont(new Font("黑体", Font.BOLD, 30));
		jlbuserid = new JLabel("用户ID:");
		jlbuloginname = new JLabel("用户姓名:");
		jlbIDcardnum = new JLabel("身份证号:");
		jlbphone = new JLabel("电话号码:");
		jlbpassword = new JLabel("密码:");
		jlbrepassword = new JLabel("确认密码:");
		jlbadress = new JLabel("家庭地址:");

		updateBtn = new JButton("修改");
		updateBtn.addActionListener(new UserMessagePanelListener(this, "修改"));

		finishBtn = new JButton("完成");
		finishBtn.addActionListener(new UserMessagePanelListener(this, "完成"));

		title.setBounds(300, 15, 500, 40);
		jlbuserid.setBounds(70, 80, 60, 30);
		jtfuserid.setBounds(130, 80, 120, 30);
		jlbuloginname.setBounds(420, 80, 70, 30);
		jtfuloginname.setBounds(510, 80, 120, 30);

		jlbpassword.setBounds(70, 150, 70, 30);
		jtfpassword.setBounds(130, 150, 220, 30);
		jlbrepassword.setBounds(420, 150, 70, 30);
		jtfrepassword.setBounds(510, 150, 220, 30);

		jlbIDcardnum.setBounds(70, 220, 70, 30);
		jtfIDcardnum.setBounds(160, 220, 250, 30);

		jlbphone.setBounds(70, 290, 70, 30);
		jtfphone.setBounds(160, 290, 250, 30);

		jlbadress.setBounds(70, 360, 70, 30);
		jtfadress.setBounds(160, 360, 330, 30);

		updateBtn.setBounds(550, 220, 80, 40);
		finishBtn.setBounds(550, 340, 80, 40);

		this.add(title);
		this.add(jlbuserid);
		this.add(jtfuserid);
		this.add(jlbuloginname);
		this.add(jtfuloginname);
		this.add(jlbpassword);
		this.add(jtfpassword);
		this.add(jlbrepassword);
		this.add(jtfrepassword);
		this.add(jlbIDcardnum);
		this.add(jtfIDcardnum);
		this.add(jlbphone);
		this.add(jtfphone);
		this.add(jlbadress);
		this.add(jtfadress);
		this.add(updateBtn);
		this.add(finishBtn);

		UserDao userdao = new UserDaoImpl();
		User u = null;
		u = userdao.getUserByLoginName(name);

		jtfuserid.setEnabled(false);
		jtfuloginname.setEnabled(false);
		jtfpassword.setEnabled(false);
		jtfrepassword.setEnabled(false);
		jtfIDcardnum.setEnabled(false);
		jtfphone.setEnabled(false);
		jtfadress.setEnabled(false);

		jtfuserid.setText(u.getId() + "");
		jtfuloginname.setText(u.getLoginName());
		jtfIDcardnum.setText(u.getIdCardName());
		jtfphone.setText(u.getTelNumber());
		jtfpassword.setText(u.getPassWord());
		jtfrepassword.setText(u.getPassWord());
		jtfadress.setText(u.getAdress());
	}

	public JTextField getJtfuserid() {
		return jtfuserid;
	}

	public void setJtfuserid(JTextField jtfuserid) {
		this.jtfuserid = jtfuserid;
	}

	public JTextField getJtfuloginname() {
		return jtfuloginname;
	}

	public void setJtfuloginname(JTextField jtfuloginname) {
		this.jtfuloginname = jtfuloginname;
	}

	public JTextField getJtfIDcardnum() {
		return jtfIDcardnum;
	}

	public void setJtfIDcardnum(JTextField jtfIDcardnum) {
		this.jtfIDcardnum = jtfIDcardnum;
	}

	public JTextField getJtfphone() {
		return jtfphone;
	}

	public void setJtfphone(JTextField jtfphone) {
		this.jtfphone = jtfphone;
	}

	public JTextField getJtfadress() {
		return jtfadress;
	}

	public void setJtfadress(JTextField jtfadress) {
		this.jtfadress = jtfadress;
	}

	public JPasswordField getJtfpassword() {
		return jtfpassword;
	}

	public void setJtfpassword(JPasswordField jtfpassword) {
		this.jtfpassword = jtfpassword;
	}

	public JPasswordField getJtfrepassword() {
		return jtfrepassword;
	}

	public void setJtfrepassword(JPasswordField jtfrepassword) {
		this.jtfrepassword = jtfrepassword;
	}

	public JButton getUpdateBtn() {
		return updateBtn;
	}

	public void setUpdateBtn(JButton updateBtn) {
		this.updateBtn = updateBtn;
	}

	public JButton getFinishBtn() {
		return finishBtn;
	}

	public void setFinishBtn(JButton finishBtn) {
		this.finishBtn = finishBtn;
	}

	public JLabel getTitle() {
		return title;
	}

	public void setTitle(JLabel title) {
		this.title = title;
	}

}

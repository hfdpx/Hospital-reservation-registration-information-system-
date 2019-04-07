package system.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import system.dao.DoctorDao;
import system.dao.RoomDao;
import system.dao.impl.DoctorDaoImpl;
import system.dao.impl.RoomDaoImpl;
import system.entity.Doctor;
import system.entity.Room;
import system.view.listener.DoctorMessagePanelListener;

/**
 * 医生界面中医生个人信息面板
 * 
 * 
 * @author yb
 * @date 2018-1-17
 */
public class DoctorMessageJPanel extends JPanel {
	private JTextField jtfname, jtfkroom, jtfsex, jtflevel, jtfgood, jtftime;
	private JPasswordField jtfpassword, jtfrepassword;
	private JLabel jlbname, jlbkroom, jlbpassword, jlbtime;
	private JLabel jlbsex, jlblevel, jlbgood, jlbrepassword;
	private JLabel title;
	private JButton updateBtn, finishBtn;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DoctorMessageJPanel(String str) {
		name = str;
		this.setLayout(null);
		init();
	}

	private void init() {
		title = new JLabel("个人信息");
		title.setFont(new Font("黑体", Font.BOLD, 30));
		jlbname = new JLabel("姓名:");
		jlbpassword = new JLabel("密码:");
		jlbrepassword = new JLabel("确认密码:");
		jlbsex = new JLabel("性别:");
		jlblevel = new JLabel("职称:");
		jlbkroom = new JLabel("所属科室:");
		jlbgood = new JLabel("擅长方向:");
		jlbtime = new JLabel("坐诊时间:");

		jtfname = new JTextField();
		jtfkroom = new JTextField();
		jtfsex = new JTextField();
		jtflevel = new JTextField();
		jtfgood = new JTextField();
		jtftime = new JTextField();

		jtfpassword = new JPasswordField();
		jtfrepassword = new JPasswordField();

		updateBtn = new JButton("修改");
		finishBtn = new JButton("完成");

		title.setBounds(300, 15, 500, 40);

		jlbname.setBounds(70, 80, 60, 30);
		jtfname.setBounds(140, 80, 170, 30);
		jlbsex.setBounds(420, 80, 70, 30);
		jtfsex.setBounds(510, 80, 170, 30);

		jlbpassword.setBounds(70, 150, 70, 30);
		jtfpassword.setBounds(140, 150, 170, 30);
		jlbrepassword.setBounds(420, 150, 70, 30);
		jtfrepassword.setBounds(510, 150, 170, 30);

		jlbkroom.setBounds(70, 220, 70, 30);
		jtfkroom.setBounds(140, 220, 170, 30);
		jlblevel.setBounds(420, 220, 70, 30);
		jtflevel.setBounds(510, 220, 170, 30);

		jlbgood.setBounds(70, 290, 70, 30);
		jtfgood.setBounds(140, 290, 170, 30);
		jlbtime.setBounds(420, 290, 70, 30);
		jtftime.setBounds(510, 290, 170, 30);

		updateBtn.setBounds(200, 350, 80, 40);
		updateBtn.addActionListener(new DoctorMessagePanelListener(this, "修改"));
		finishBtn.setBounds(450, 350, 80, 40);
		finishBtn.addActionListener(new DoctorMessagePanelListener(this, "完成"));

		jtfname.setEnabled(false);
		jtfpassword.setEnabled(false);
		jtfrepassword.setEnabled(false);
		jtfsex.setEnabled(false);
		jtflevel.setEnabled(false);
		jtfkroom.setEnabled(false);
		jtfgood.setEnabled(false);
		jtftime.setEnabled(false);

		DoctorDao doctordao = new DoctorDaoImpl();
		Doctor doctor = null;
		doctor = doctordao.getDoctorByLoginName(name);

		jtfname.setText(doctor.getName());
		jtfpassword.setText(doctor.getLoginPassWord());
		jtfrepassword.setText(doctor.getLoginPassWord());
		jtfsex.setText(doctor.getSex());
		jtflevel.setText(doctor.getLevel());
		// 所属科室
		RoomDao roomdao = new RoomDaoImpl();
		Room room = roomdao.getRoomByID(doctor.getBelongRoom());
		jtfkroom.setText(room.getName());
		jtfgood.setText(doctor.getGoodAt());
		jtftime.setText(doctor.getTime());

		this.add(title);
		this.add(jlbname);
		this.add(jtfname);
		this.add(jlbpassword);
		this.add(jtfpassword);
		this.add(jlbrepassword);
		this.add(jtfrepassword);
		this.add(jlbsex);
		this.add(jtfsex);
		this.add(jlblevel);
		this.add(jtflevel);
		this.add(jlbkroom);
		this.add(jtfkroom);
		this.add(jlbgood);
		this.add(jtfgood);
		this.add(jtftime);
		this.add(jlbtime);
		this.add(updateBtn);
		this.add(finishBtn);
	}

	public JTextField getJtfname() {
		return jtfname;
	}

	public void setJtfname(JTextField jtfname) {
		this.jtfname = jtfname;
	}

	public JTextField getJtfkroom() {
		return jtfkroom;
	}

	public void setJtfkroom(JTextField jtfkroom) {
		this.jtfkroom = jtfkroom;
	}

	public JTextField getJtfsex() {
		return jtfsex;
	}

	public void setJtfsex(JTextField jtfsex) {
		this.jtfsex = jtfsex;
	}

	public JTextField getJtflevel() {
		return jtflevel;
	}

	public void setJtflevel(JTextField jtflevel) {
		this.jtflevel = jtflevel;
	}

	public JTextField getJtfgood() {
		return jtfgood;
	}

	public void setJtfgood(JTextField jtfgood) {
		this.jtfgood = jtfgood;
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

	public JTextField getJtftime() {
		return jtftime;
	}

	public void setJtftime(JTextField jtftime) {
		this.jtftime = jtftime;
	}

}

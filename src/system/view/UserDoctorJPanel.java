package system.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import system.service.DoctorService;
import system.service.impl.DoctorServiceImpl;
import system.view.listener.UserDoJPanelDoButtonListener;
import system.view.listener.UserDoJPanelListener;

/**
 * 用户界面预约挂号面板
 * 
 * 
 * @author yb
 * @date 2018-1-17 下午2:58:14
 */
public class UserDoctorJPanel extends JPanel {
	private JLabel keshiLabel, zhuanjiaLabel;
	private JTextField zhuanjiaTextField;
	private UserDoctorJPanel panel;
	private JPanel northPanel;
	private JTextField keshiTextField;
	private JButton queryKeshiBtn1, queryDoctorBtn3, yuyueBtn, refreshBtn;
	private DefaultTableModel queryTableModel;
	private JTable queryTable;
	private DoctorService doctorservice;
	private String name;

	public UserDoctorJPanel(String str) {
		this.setLayout(null);
		name = str;
		init();
	}

	private void init() {
		northPanel = new JPanel();
		northPanel.setLayout(null);
		northPanel.setBounds(0, 0, 800, 100);
		// 科室查询下拉列表
		keshiTextField = new JTextField();

		// 用来查询的各组件
		queryKeshiBtn1 = new JButton("查询");// 科室查询
		queryDoctorBtn3 = new JButton("查询");// 医生查询

		yuyueBtn = new JButton("预约");
		keshiLabel = new JLabel("科室查询");
		zhuanjiaLabel = new JLabel("医生查询");
		refreshBtn = new JButton("刷新");
		zhuanjiaTextField = new JTextField();

		queryKeshiBtn1
				.addActionListener(new UserDoJPanelListener(this, "科室查询"));
		// queryBingzhengBtn2.addActionListener(new
		// UserDoJPanelListener(this,"病症查询"));
		queryDoctorBtn3
				.addActionListener(new UserDoJPanelListener(this, "医生查询"));
		// queryTimeBtn4.addActionListener(new
		// UserDoJPanelListener(this,"坐诊时间查询"));
		yuyueBtn.addActionListener(new UserDoJPanelDoButtonListener(this, "预约"));
		refreshBtn.addActionListener(new UserDoJPanelListener(this, "刷新"));

		keshiLabel.setBounds(140, 15, 60, 30);
		keshiTextField.setBounds(220, 15, 140, 30);
		queryKeshiBtn1.setBounds(440, 15, 50, 30);

		zhuanjiaLabel.setBounds(140, 55, 60, 30);
		zhuanjiaTextField.setBounds(220, 55, 140, 30);
		queryDoctorBtn3.setBounds(440, 55, 50, 30);

		refreshBtn.setBounds(600, 15, 100, 30);
		yuyueBtn.setBounds(600, 55, 100, 30);

		northPanel.add(keshiLabel);
		northPanel.add(keshiTextField);

		northPanel.add(zhuanjiaLabel);
		northPanel.add(zhuanjiaTextField);

		northPanel.add(queryKeshiBtn1);
		northPanel.add(queryDoctorBtn3);
		northPanel.add(yuyueBtn);
		northPanel.add(refreshBtn);
		northPanel.setVisible(true);
		this.add(northPanel, BorderLayout.NORTH);

		this.add(tablePanel());

	}

	// 重载表格面板(带参数)
	private JScrollPane tablePanel() {

		doctorservice = new DoctorServiceImpl();
		// 预约面板中的表格
		String[][] domessage = doctorservice.getDoctorMessage();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(new JLabel("预约挂号"));
		scrollPane.setBounds(0, 100, 820, 390);
		String[] colNames1 = { "医生编号", "医生姓名", "性别", "级别", "所属科室", "擅长方向",
				"办公地点" };

		queryTableModel = new DefaultTableModel(domessage, colNames1);

		queryTable = new JTable(queryTableModel);

		scrollPane.setViewportView(queryTable);

		return scrollPane;
	}

	public JTextField getZhuanjiaTextField() {
		return zhuanjiaTextField;
	}

	public void setZhuanjiaTextField(JTextField zhuanjiaTextField) {
		this.zhuanjiaTextField = zhuanjiaTextField;
	}

	public JTextField getKeshiTextField() {
		return keshiTextField;
	}

	public void setKeshiTextField(JTextField keshiTextField) {
		this.keshiTextField = keshiTextField;
	}

	public DefaultTableModel getQueryTableModel() {
		return queryTableModel;
	}

	public void setQueryTableModel(DefaultTableModel queryTableModel) {
		this.queryTableModel = queryTableModel;
	}

	public JTable getQueryTable() {
		return queryTable;
	}

	public void setQueryTable(JTable queryTable) {
		this.queryTable = queryTable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

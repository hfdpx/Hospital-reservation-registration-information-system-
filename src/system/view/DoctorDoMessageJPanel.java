package system.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import system.service.DoService;
import system.service.impl.DoServiceImpl;
import system.view.listener.DoctorDoMessageViewListener;

/**
 * 医生主界面中医生挂号信息面板
 * 
 * 
 * @author yb
 * @date 2018-1-17 下午4:32:07
 */
public class DoctorDoMessageJPanel extends JPanel {
	private DefaultTableModel queryTableModel;
	private JTable queryTable;
	private String doctorname;

	public DoctorDoMessageJPanel(String doctorname) {
		this.setLayout(new BorderLayout());
		this.doctorname = doctorname;
		init();
	}

	// 重载init方法带参数
	private void init() {
		JPanel northPanel = new JPanel();
		JLabel jlbtitle = new JLabel("用户挂号信息");
		jlbtitle.setFont(new Font("黑体", Font.BOLD, 30));
		JButton deleteBtn = new JButton(" 完成看病 ");
		JButton refreshBtn = new JButton(" 刷新记录 ");
		northPanel.add(jlbtitle);
		northPanel.add(deleteBtn);
		northPanel.add(refreshBtn);
		// 添加监听器
		deleteBtn.addActionListener(new DoctorDoMessageViewListener(this,
				doctorname));
		refreshBtn.addActionListener(new DoctorDoMessageViewListener(this,
				doctorname));

		this.add(northPanel, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(new JLabel("考勤查询"));
		// 表头
		Vector<String> colNames = new Vector<String>();
		Collections.addAll(colNames, "用户姓名", "医生姓名", "科室", "地点", "预约时间");
		// 表格中的预约信息
		Vector<Vector<String>> vectorDo = new Vector<Vector<String>>();
		DoService doservice = new DoServiceImpl();
		vectorDo = doservice.getDoByDoctorName(doctorname);
		// 向表中添加信息
		queryTableModel = new DefaultTableModel(vectorDo, colNames);

		queryTable = new JTable(queryTableModel);

		scrollPane.setViewportView(queryTable);
		this.add(scrollPane, BorderLayout.CENTER);

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

}

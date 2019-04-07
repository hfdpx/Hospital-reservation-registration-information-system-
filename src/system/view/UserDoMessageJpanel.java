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
import system.view.listener.UserDoMessageViewListener;

/**
 * 用户主界面中用户挂号信息查询面板
 * 
 * 
 * @author yb
 * @date 2018-1-16 下午9:17:10
 */
public class UserDoMessageJpanel extends JPanel {
	private DefaultTableModel queryTableModel;
	private JTable queryTable;
	private String name;

	public UserDoMessageJpanel(String str) {
		this.setLayout(new BorderLayout());
		name = str;
		init();
	}

	// 重载init方法带参数
	private void init() {
		JPanel northPanel = new JPanel();
		JLabel jlbtitle = new JLabel("用户挂号信息");
		jlbtitle.setFont(new Font("黑体", Font.BOLD, 30));
		JButton deleteBtn = new JButton("刪除预约挂号");
		JButton refreshBtn = new JButton("刷新挂号记录");
		northPanel.add(jlbtitle);
		northPanel.add(deleteBtn);
		northPanel.add(refreshBtn);

		deleteBtn.addActionListener(new UserDoMessageViewListener(this, name));
		refreshBtn.addActionListener(new UserDoMessageViewListener(this, name));
		this.add(northPanel, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(new JLabel("考勤查询"));
		Vector<String> colNames = new Vector<String>();
		Collections.addAll(colNames, "用户姓名", "医生姓名", "科室", "地点", "预约时间");

		Vector<Vector<String>> vectorDo = new Vector<Vector<String>>();
		DoService doservice = new DoServiceImpl();
		vectorDo = doservice.getDoByUserName(name);
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

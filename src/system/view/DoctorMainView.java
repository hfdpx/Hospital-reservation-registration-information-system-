package system.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import system.view.utils.GUIUtils;
import system.view.utils.TimeThread;

/**
 * 医生主界面
 * 
 * 
 * @author yb
 * @date 2018-1-17 上午12:47:52
 */
public class DoctorMainView extends JFrame {
	// 定义树模型
	private JTree tree;

	// 定义树的节点
	private DefaultMutableTreeNode rootNode;
	private DefaultMutableTreeNode docterMessageNode;
	private DefaultMutableTreeNode doctoeyuyueNode;
	private DefaultMutableTreeNode hospitaldoctorNode;
	private DefaultMutableTreeNode aboutUsEmpNode;
	// 选项卡
	private JTabbedPane tabbedPane;
	private JTable yuyueTable;
	private DefaultTableModel yuyueTableModel;
	private JLabel lblshowtime;
	private JPanel timeJPanel;
	private String name;

	public DoctorMainView(String str) {
		this.setSize(1080, 750);
		this.setTitle("门诊挂号系统--医生端");
		name = str;

		// 创建一个分割面板:JSplitPane.HORIZONTAL_SPLIT水平分割
		JSplitPane splitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		// 设置分割线的大小
		splitPanel.setDividerSize(1);
		// 设置分割线的默认的位置
		splitPanel.setDividerLocation(150);
		// 设置分割线不可移动
		splitPanel.setEnabled(false);

		// 为分割面板的左部添加组件
		splitPanel.setLeftComponent(initLeft());
		// 为分割面板的右部添加组件
		splitPanel.setRightComponent(initRight());
		this.add(splitPanel);
		GUIUtils.setCenterInWindow(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 界面显示当前时间
		timeJPanel = new JPanel();
		lblshowtime = new JLabel();
		TimeThread tt = new TimeThread(this.lblshowtime);
		Thread th = new Thread(tt);
		th.start();
		timeJPanel.add(lblshowtime);
		this.add(timeJPanel, BorderLayout.SOUTH);

	}

	// 主界面中右边的视图效果
	private JScrollPane initRight() {
		JScrollPane scrollPane = new JScrollPane();
		// 初始化选项卡JTabbedPAne.Top制定选项卡的位置,
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		// 选项卡的数量根据添加的面板的数据自动增加
		tabbedPane.add(aboutUsEmpPanel());
		tabbedPane.add(new DoctorMessageJPanel(name));
		tabbedPane.add(new DoctorDoMessageJPanel(name));
		tabbedPane.add(new DoctorHospitalMessageJpanel(name));
		// 设置每个选项卡的标题
		tabbedPane.setTitleAt(0, "关于我们");
		tabbedPane.setTitleAt(1, "个人信息");
		tabbedPane.setTitleAt(2, "预约信息查询");
		tabbedPane.setTitleAt(3, "医生信息查询");
		// 对于滚动面板中添加元素必须在其视口中添加
		scrollPane.setViewportView(tabbedPane);

		return scrollPane;
	}

	private JPanel aboutUsEmpPanel() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		JLabel jbltp = new JLabel();
		jbltp.setIcon(new ImageIcon(this.getClass().getResource(
				"/images/2p.png")));
		jbltp.setBounds(0, 0, 300, 275);
		panel.add(jbltp);
		return panel;
	}

	// 主界面中坐部的视图效果
	private Component initLeft() {
		// 表示滚动面板,JTree,JTable必须添加在滚动面板中
		JScrollPane scrollPane = new JScrollPane();
		// 实例化输的节点
		rootNode = new DefaultMutableTreeNode("门诊挂号系统");
		docterMessageNode = new DefaultMutableTreeNode("个人信息");
		doctoeyuyueNode = new DefaultMutableTreeNode("预约信息查询");
		hospitaldoctorNode = new DefaultMutableTreeNode("医生信息查询");
		aboutUsEmpNode = new DefaultMutableTreeNode("关于我们");
		rootNode.add(aboutUsEmpNode);
		rootNode.add(docterMessageNode);
		rootNode.add(doctoeyuyueNode);
		rootNode.add(hospitaldoctorNode);
		tree = new JTree(rootNode);

		/** 绑定事件:单击树的节点选择对应的选项卡 **/
		tree.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 获得当前选择的树的节点
				Object node = tree.getLastSelectedPathComponent();
				if (node == null) {
					return;
				}
				// 获得节点的名称
				String nodeName = node.toString();
				// 获得选项卡的数量
				int tabCount = tabbedPane.getTabCount();
				for (int i = 0; i < tabCount; i++) {
					String title = tabbedPane.getTitleAt(i);
					if (nodeName.equals(title)) {
						// 选择指定位置的选项卡
						tabbedPane.setSelectedIndex(i);
					}

				}
			}
		});
		scrollPane.setViewportView(tree);
		return scrollPane;
	}

	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();

			// //设置本属性将改变窗口边框样式定义
			// BeautyEyeLNFHelper.frameBorderStyle =
			// BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
			// org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			//
		} catch (Exception e) {
			// TODO exception
		}

		DoctorMainView doctormain = new DoctorMainView("赵小米");
		doctormain.setVisible(true);
	}

}

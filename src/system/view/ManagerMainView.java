package system.view;



import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import system.dao.RoomDao;
import system.dao.impl.RoomDaoImpl;
import system.entity.Room;
import system.service.DoctorService;
import system.service.RoomService;
import system.service.UserService;
import system.service.impl.DoctorServiceImpl;
import system.service.impl.RoomServiceImpl;
import system.service.impl.UserServiceImpl;
import system.view.listener.ManagerMainViewDeleteRoomListener;
import system.view.listener.ManagerMainViewDeleteUserListener;
import system.view.listener.ManagerMainViewDoctorDeleteDoctorListener;
import system.view.listener.ManagerMainViewSelectDoctorListener;
import system.view.listener.ManagerMainViewSelectRoomListener;
import system.view.listener.ManagerMainViewSelectUserListener;
import system.view.utils.GUIUtils;

public class ManagerMainView extends JFrame {
	
	        
	        String str="";
	
	        private JComboBox loginComBox;
	        
			private JComboBox loginComBox1;
	        
			private JButton jbRefresh;
		// 定义树模型
			private JTree tree;
			// 定义菜单栏
			private JMenuBar menuBar;
			// 菜单
//			private JMenu noteMenu;

			// 定义树的节点
			private DefaultMutableTreeNode rootNode;
			private DefaultMutableTreeNode userEmpNode;
			private DefaultMutableTreeNode docteroNode;
			private DefaultMutableTreeNode roomEmpNode;
			private DefaultMutableTreeNode aboutUsEmpNode;
			// 选项卡
			private JTabbedPane tabbedPane;

			private JTable queryTable;
			private JTable queryTable1;
			private JTable queryTable2;
			private DefaultTableModel queryTableModel;
			private DefaultTableModel queryTableModel1;
			private DefaultTableModel queryTableModel2;
			
			private JButton queryBtn;
			private JButton queryBtn1;
			private JButton queryBtn2;
			private JButton deleteBtn;
			private JButton deleteBtn1;
			private JButton deleteBtn2;
			private JButton addBtn;
			private JButton addBtn2;
			private JButton changeBtn;
			private JButton changeBtn2;
			//用户表的信息定义
			private JTextField jtf1;
			private JLabel jbusername,jbtel,jbaddress,jbidcard;
			private JTextField jtusername,jttel,jtaddress,jtidcard;
			//医生表的信息定义
			private JTextField jtf2;
			private JLabel jbdcname,jbdcrank,jbdcroom,jbdcgood;
			private JTextField jtdcname,jtdcrank,jtdcroom,jtdcgood;
			//科室表的信息定义
			private JTextField jtf3;
			private JLabel jbksname,jbksgood;
			private JTextField jtksname,jtksgood;


			public void init() {
				this.setSize(1050, 650);
				this.setTitle("门诊挂号系统");
				// 初始化一个菜单栏
				menuBar = new JMenuBar();
				this.setJMenuBar(menuBar);
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
			}

			// 主界面中右边的视图效果
			private JScrollPane initRight() {
				JScrollPane scrollPane = new JScrollPane();
				// 初始化选项卡 JTabbedPane.TOP 指定选项卡标签的位置.
				tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				// 选项卡的数量根据添加的面板的数据自动增加
				tabbedPane.add(aboutUsEmpPanel());
				tabbedPane.add(userEmpPanel());
				tabbedPane.add(docterPanel());
				tabbedPane.add( roomEmpPanel());
				// 设置每个选项卡的标题
				tabbedPane.setTitleAt(0, "关于我们");
				tabbedPane.setTitleAt(1, "用户信息管理");
				tabbedPane.setTitleAt(2, "医生信息管理");
				tabbedPane.setTitleAt(3, "科室信息管理");
				// 对于滚动面板中添加元素必须在其视口中添加
				scrollPane.setViewportView(tabbedPane);

				return scrollPane;
			}
	
			private JPanel aboutUsEmpPanel() {
			JPanel panel = new JPanel();
			JLabel jbltp=new JLabel();
			jbltp.setIcon(new ImageIcon(this.getClass().getResource("/images/3p.png")));
			jbltp.setBounds(0, 0, 300, 275);
			panel.add(jbltp);
			return panel;
		}

			/**
			 * 医生信息管理的面板
			 * 
			 * @return
			 */
			private JPanel docterPanel() {
				JPanel panel = new JPanel();
				panel.setLayout(null);
				JPanel northPanel = new JPanel();
				panel.add(northPanel);
				northPanel.add(new JLabel("用户信息管理"));	
				northPanel.setLayout(null);
				northPanel.setBounds(0, 0, 800, 100);
			    
				loginComBox=new  JComboBox();
				loginComBox.addItem("医生姓名查询");
				loginComBox.addItem("医生级别查询");
				loginComBox.addItem("所属科室查询");

				loginComBox.setBounds(30, 20, 150, 30);
				
				northPanel.add(loginComBox);
				
				jtf2 = new JTextField();
				jtf2.setBounds(200, 20, 100, 30);
				northPanel.add(jtf2);
				
				queryBtn = new JButton("查询");
				northPanel.add(queryBtn);
				queryBtn.setBounds(320, 20, 100, 30);
				deleteBtn = new JButton("删除");
				northPanel.add(deleteBtn);
				deleteBtn.setBounds(540, 45, 100, 25);
				
				jbRefresh = new JButton("刷新");
				jbRefresh.setBounds(670, 15, 100, 25);
				northPanel.add(jbRefresh);
				
				
				addBtn = new JButton("添加");
				northPanel.add(addBtn);
				addBtn.setBounds(670, 45, 100, 25);
				
				
				addBtn.addActionListener(new ManagerViewDoctorAddListener(this));
				
		
				
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setColumnHeaderView(new JLabel("                                                                                                  医生信息管理          "));

				String[] colNames = { "医生编号", "医生姓名", "性别", "级别", "所属科室","擅长方向","办公地点" };

//				String[][] datas = {
//						{ "1001", "周棋洛", "男", "主任","儿科", "眼科","112" },
//						{ "1002", "陈独秀", "男", "主任","儿科", "眼科" ,"113" },
//						{ "1003", "白起", "男", "主任","儿科", "皮肤科" ,"114" },
//						{ "1004", "李泽言", "女", "主任","脑科", "脑科" ,"115"}
//
//				};
//				queryTableModel = new DefaultTableModel(datas, colNames);

				DoctorService doctorService = new DoctorServiceImpl();
				
				String[][] dates = doctorService.getDoctorMessage();
				
				queryTableModel = new DefaultTableModel(dates, colNames);
				
				queryTable = new JTable(queryTableModel);
				scrollPane.setViewportView(queryTable);
				
				deleteBtn.addActionListener(new ManagerMainViewDoctorDeleteDoctorListener(this));
				
				queryBtn.addActionListener(new ManagerMainViewSelectDoctorListener(this));
				
				jbRefresh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String[] colNames = { "医生编号", "医生姓名", "性别", "级别", "所属科室","擅长方向","办公地点" };
						
						DoctorService doctorService = new DoctorServiceImpl();
						String[][] dates = doctorService.getDoctorMessage();

						DefaultTableModel dtm =queryTableModel;
						
						dtm.setDataVector(dates, colNames);					
					
						
					}
				});
				
				scrollPane.setBounds(0, 100, 823, 390);
				panel.add(scrollPane);

				return panel;
			}

			

			/**
			 *用户信息管理的面板
			 * 
			 * @return
			 */
			private JPanel userEmpPanel() {			
				JPanel panel = new JPanel();
				panel.setLayout(null);
				JPanel northPanel1 = new JPanel();
				
				northPanel1.add(new JLabel("用户信息管理"));	
				northPanel1.setLayout(null);
				northPanel1.setBounds(0, 0, 800, 100);

				loginComBox1=new  JComboBox();
				loginComBox1.addItem("用户名查询");
				loginComBox1.addItem("身份证号查询");
				
				loginComBox1.setBounds(30, 20, 150, 30);
				
				northPanel1.add(loginComBox1);
				
				jtf1 = new JTextField();
				jtf1.setBounds(200, 20, 100, 30);
				
				queryBtn1 = new JButton("查询");
				deleteBtn1 = new JButton("删除");
				jbRefresh = new JButton("刷新");
				
				
				
				
				
				
				
				
				jbRefresh.setBounds(540, 20, 100, 30);
				queryBtn1.setBounds(330, 20, 100, 30);
				deleteBtn1.setBounds(540, 55, 100, 35);
				
				northPanel1.add(jbRefresh);
				northPanel1.add(deleteBtn1);
				northPanel1.add(queryBtn1);
				northPanel1.add(jtf1);
				panel.add(northPanel1);
				//用户信息表
				JScrollPane scrollPane1 = new JScrollPane();
				scrollPane1.setViewportView(new JLabel("用户信息管理"));
				scrollPane1.setBounds(0, 100, 823, 390);
				String[] colNames1 = { "用户编号", "用户名称", "用户电话", "用户地址", "用户身份证号" };

				
				UserService userService = new UserServiceImpl();
				String[][] dates = userService.getUserMessage();

				queryTableModel1 = new DefaultTableModel(dates, colNames1);
				
				queryTable1 = new JTable(queryTableModel1);

				
				queryBtn1.addActionListener(new ManagerMainViewSelectUserListener(this));
		     
				
			    deleteBtn1.addActionListener(new ManagerMainViewDeleteUserListener(this));

			    jbRefresh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String[] colNames1 = { "用户编号", "用户名称", "用户电话", "用户地址", "用户身份证号" };

						
						UserService userService = new UserServiceImpl();
						String[][] dates = userService.getUserMessage();

						DefaultTableModel dtm = queryTableModel1;
							
						dtm.setDataVector(dates, colNames1);						
					
						
					}
				});
			    

		        scrollPane1.setViewportView(queryTable1);
	
		panel.add(scrollPane1);
		return panel;
}
			
			/**
			 *科室信息管理的面板
			 * 
			 * @return
			 */
			
			private JPanel roomEmpPanel() {
				JPanel panel = new JPanel();
				panel.setLayout(null);
				JPanel northPanel2 = new JPanel();
				panel.add(northPanel2);
				northPanel2.setLayout(null);
				northPanel2.setBounds(0, 0, 800, 100);

				//科室增删改查栏
				jbksname = new JLabel("科室名查询");
				jbksgood = new JLabel("主攻方向查询");
				jtksname = new JTextField();
				
				jtksgood = new JTextField();
				
				jbksname.setBounds(20, 15, 100, 30);
				jtksname.setBounds(100, 15, 100, 30);
				jbksgood.setBounds(270,15, 100, 30);
				jtksgood.setBounds(355, 15, 100, 30);
				northPanel2.add(jbksname);
				northPanel2.add(jtksname);
				//northPanel2.add(jbksgood);
				//northPanel2.add(jtksgood);
				
				queryBtn2 = new JButton("查询");
				northPanel2.add(queryBtn2);
				queryBtn2.setBounds(250, 15, 100, 25);
				deleteBtn2 = new JButton("删除");
				deleteBtn2.setBounds(540, 60, 100, 25);
				northPanel2.add(deleteBtn2);
				changeBtn2 = new JButton("修改");
				
				jbRefresh = new JButton("刷新");
				jbRefresh.setBounds(540, 15, 100, 25);
				northPanel2.add(jbRefresh);
				
				changeBtn2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try
					    {
						  org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
						    
					    }
					    catch(Exception e3)
					    {
					        //TODO exception
					    }
						RoomUpdateView window = new RoomUpdateView();
		
					}
				});
				
				northPanel2.add(changeBtn2);
				changeBtn2.setBounds(670, 15, 100, 25);
				addBtn2 = new JButton("添加");
				northPanel2.add(addBtn2);
				addBtn2.setBounds(670, 60, 100, 25);
				
				addBtn2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try
					    {
						  org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
						    
					    }
					    catch(Exception e3)
					    {
					        //TODO exception
					    }
						
						RoomAddView window = new RoomAddView();
		
					}
				});
				
//				addBtn2.addActionListener(l);
				
//                科室信息表
				JScrollPane scrollPane2 = new JScrollPane();
				scrollPane2.setViewportView(new JLabel("科室信息管理"));
				String[] colNames2 = { "科室名称", "科室人数", "科室地点", "科室主攻方向"};
//
//				String[][] datas = {
//						{  "周棋洛", "周一", "许墨医生", "眼科" },
//						{  "陈独秀", "周二", "许墨医生", "眼科" },
//						{  "白起", "周三", "许墨医生", "皮肤科" },
//						{  "李泽言", "周六", "许墨医生", "脑科" }
//
//				};
//				queryTableModel = new DefaultTableModel(datas, colNames);
				
				RoomService roomService = new RoomServiceImpl();
				
				String[][] dates = roomService.getRoomMessage();

				queryTableModel2 = new DefaultTableModel(dates, colNames2);
				
				queryTable2 = new JTable(queryTableModel2);

				deleteBtn2.addActionListener(new ManagerMainViewDeleteRoomListener(this));
				
				queryBtn2.addActionListener(new ManagerMainViewSelectRoomListener(this));
				
				
				jbRefresh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String[] colNames2 = { "科室名称", "科室人数", "科室地点", "科室主攻方向"};

						
						RoomService roomService = new RoomServiceImpl();
						String[][] dates = roomService.getRoomMessage();

						DefaultTableModel dtm = queryTableModel2;
							
						dtm.setDataVector(dates, colNames2);						
					
						
					}
				});
				
				
				
				scrollPane2.setViewportView(queryTable2);
				scrollPane2.setBounds(0, 100, 823, 390);
				panel.add(scrollPane2);

				return panel;
			}

			

			public JTextField getJtksname() {
				return jtksname;
			}

			public void setJtksname(JTextField jtksname) {
				this.jtksname = jtksname;
			}

			// 主界面中左部的视图效果
			private JScrollPane initLeft() {//导航菜单可隐藏的效果(未做)
				// 表示滚动面板,JTree,JTable必须添加在滚动面板中.
				JScrollPane scrollPane = new JScrollPane();
				// 实例化树的节点
				rootNode = new DefaultMutableTreeNode("门诊挂号系统");
				userEmpNode = new DefaultMutableTreeNode("用户信息管理");
				roomEmpNode = new DefaultMutableTreeNode("医生信息管理");
				docteroNode = new DefaultMutableTreeNode("科室信息管理");

				aboutUsEmpNode=new DefaultMutableTreeNode("关于我们");
				rootNode.add(aboutUsEmpNode);
				rootNode.add(userEmpNode);
				rootNode.add(roomEmpNode);
				rootNode.add(docteroNode);
				tree = new JTree(rootNode);

				/*** 绑定事件:单击树的节点选择对应的选项卡 ***/
				tree.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// 获得当前所选择的树的节点
						Object node = tree.getLastSelectedPathComponent();
						if (node == null) {
							return;
						}
						// 获得节点的名称
						String nodeName = node.toString();
						System.out.println(nodeName);
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

			
			public JTable getQueryTable() {
				return queryTable;
			}
			public JTable getQueryTable1() {
				return queryTable1;
			}
			public JTable getQueryTable2() {
				return queryTable2;
			}
			
			public static void main(String[] args) {
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
			}

			public DefaultTableModel getQueryTableModel() {
				return queryTableModel;
			}

			public void setQueryTableModel(DefaultTableModel queryTableModel) {
				this.queryTableModel = queryTableModel;
			}

			public DefaultTableModel getQueryTableModel1() {
				return queryTableModel1;
			}

			public void setQueryTableModel1(DefaultTableModel queryTableModel1) {
				this.queryTableModel1 = queryTableModel1;
			}

			public DefaultTableModel getQueryTableModel2() {
				return queryTableModel2;
			}

			public void setQueryTableModel2(DefaultTableModel queryTableModel2) {
				this.queryTableModel2 = queryTableModel2;
			}

			public JTextField getJtf2() {
				return jtf2;
			}

			public void setJtf2(JTextField jtf2) {
				this.jtf2 = jtf2;
			}

			public JComboBox getLoginComBox() {
				return loginComBox;
			}

			public void setLoginComBox(JComboBox loginComBox) {
				this.loginComBox = loginComBox;
			}

			public JComboBox getLoginComBox1() {
				return loginComBox1;
			}

			public void setLoginComBox1(JComboBox loginComBox1) {
				this.loginComBox1 = loginComBox1;
			}


			public JTextField getJtf1() {
				return jtf1;
			}

			public void setJtf1(JTextField jtf1) {
				this.jtf1 = jtf1;
			}

			
			
			

	}
	
package system.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import system.dao.RoomDao;
import system.dao.impl.RoomDaoImpl;
import system.entity.Room;
import system.view.utils.GUIUtils;

/*
*@author:yb
*@version 创建时间：2018年1月18日 下午5:47:54
*/
public class RoomAddView {

	private JFrame frame;
	private JPanel jpl;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					try
//				    {
//					  org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//					    
//				    }
//				    catch(Exception e3)
//				    {
//				        //TODO exception
//				    }
//					
//					RoomAddView window = new RoomAddView();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the application.
	 */
	public RoomAddView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 429, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		GUIUtils.setCenterInWindow(frame);
		
		jpl = new JPanel();
		jpl.setSize(429, 477);
		frame.getContentPane().add(jpl);
		jpl.setLayout(null);
		
		JLabel label = new JLabel("科室名称");
		label.setBounds(57, 73, 72, 18);
		jpl.add(label);
		
		textField = new JTextField();
		textField.setBounds(207, 70, 126, 24);
		jpl.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("科室地点");
		lblNewLabel.setBounds(57, 158, 72, 18);
		jpl.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(207, 155, 126, 24);
		jpl.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("科室主攻方向");
		lblNewLabel_1.setBounds(57, 241, 112, 18);
		jpl.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(207, 238, 126, 24);
		jpl.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Room r = new Room();
				RoomDao roomDao = new RoomDaoImpl();
				r.setName(textField.getText());
				r.setWhere(textField_1.getText());
				r.setD_o(textField_2.getText());
				r.setNum(0);
				r.setId(roomDao.listRoom().size()+1);
				
				try {
					roomDao.insertRoom(r);
					
					JOptionPane.showMessageDialog(frame,"添加科室信息成功");
					
				}catch(Exception e2) {
					throw e2;
				}
				
			}
		});
		btnNewButton.setBounds(57, 338, 86, 27);
		jpl.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(223, 338, 103, 27);
		jpl.add(btnNewButton_1);
	}
}

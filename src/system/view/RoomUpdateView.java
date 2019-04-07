package system.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import system.dao.RoomDao;
import system.dao.impl.RoomDaoImpl;
import system.entity.Room;
import system.view.utils.GUIUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
*@author:yb
*@version 创建时间：2018年1月18日 下午6:23:39
*/
public class RoomUpdateView {

	private JFrame frame;
	private JPanel jpl;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					
//					try
//				    {
//					  org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//					    
//				    }
//				    catch(Exception e3)
//				    {
//				        //TODO exception
//				    }
//					RoomUpdateView window = new RoomUpdateView();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public RoomUpdateView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 429, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		GUIUtils.setCenterInWindow(frame);
		
		frame.setVisible(true);
		jpl = new JPanel();
		jpl.setSize(429, 486);
		frame.getContentPane().add(jpl);
		jpl.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请填写需要修改的科室名称");
		lblNewLabel.setBounds(14, 58, 180, 23);
		jpl.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(208, 57, 113, 24);
		jpl.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("更新的科室办公地点");
		lblNewLabel_1.setBounds(40, 147, 166, 18);
		jpl.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("更新的科室主攻方向");
		lblNewLabel_2.setBounds(35, 248, 159, 18);
		jpl.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(208, 144, 113, 24);
		jpl.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(208, 245, 113, 24);
		jpl.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Room r = new Room();
				RoomDao roomDao = new RoomDaoImpl();
				
				r.setName(textField.getText());
				r.setWhere(textField_1.getText());
				r.setD_o(textField_2.getText());
				r.setNum(roomDao.getRoomByRoomName(textField.getText()).getNum());
				r.setId(roomDao.getRoomByRoomName(textField.getText()).getId());
				
			
				
				try {
					roomDao.updateRoomByRoomName(textField.getText(), r);
					
					JOptionPane.showMessageDialog(frame,"修改科室信息成功");
					
				}catch(Exception e2) {
					throw e2;
				}
			
			}
		});
		btnNewButton.setBounds(45, 347, 113, 27);
		jpl.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		btnNewButton_1.setBounds(238, 347, 113, 27);
		jpl.add(btnNewButton_1);
	}

}

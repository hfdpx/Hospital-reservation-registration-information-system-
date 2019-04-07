package system.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import system.dao.DoctorDao;
import system.entity.Doctor;
import system.entity.User;
import system.exception.DaoException;
import system.utils.DBUtils;

/*
*@author:yb
*@version 创建时间：2018年1月16日 下午6:40:47
*/

/*
 * 下面是接口的具体实现方法
 */
public class DoctorDaoImpl implements DoctorDao{

	@Override
	public List<Doctor> listDoctor() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<Doctor> doctors = new ArrayList<Doctor>();
		Doctor doctor;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "select * from Doctors";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//执行sql语句获得结果集
			rs = psmt.executeQuery();
			while(rs.next()) {
				doctor=new Doctor();
				doctor.setId(rs.getInt(1));
				doctor.setName(rs.getString(2));
				doctor.setSex(rs.getString(3));
				doctor.setLevel(rs.getString(4));
				doctor.setBelongRoom(rs.getInt(5));
				doctor.setWorkWhere(rs.getString(6));
				doctor.setLoginName(rs.getString(7));
				doctor.setLoginPassWord(rs.getString(8));
				doctor.setGoodAt(rs.getString(9));
				doctor.setTime(rs.getString(10));
				
				doctors.add(doctor);
			}
			
		}catch(Exception e){
			throw new DaoException(e);
		}finally {//finally 中的代码一定会被执行
			DBUtils.close(conn, psmt, rs);//手动释放物理资源
		}
		
		return doctors;
	}


	@Override
	public Doctor getDoctorByLoginName(String loginName) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Doctor d = null;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "select * from Doctors where D_Login_Name=?";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setString(1,loginName);
			//执行sql语句获得结果集
			rs = psmt.executeQuery();
			if(rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setSex(rs.getString(3));
				d.setLevel(rs.getString(4));
				d.setBelongRoom(rs.getInt(5));
				d.setWorkWhere(rs.getString(6));
				d.setLoginName(rs.getString(7));
				d.setLoginPassWord(rs.getString(8));
				d.setGoodAt(rs.getString(9));
				d.setTime(rs.getString(10));
			}
		}catch(Exception e2) {
			throw new DaoException(e2);
		}finally {
			// 必须手动释放物理资源
			DBUtils.close(conn, psmt, rs);
		}
		return d;
	}

	@Override
	public void deleteDoctorByLoginName(String loginName) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "CALL delete_doctor_By_D_Login_Name(?)";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setString(1,loginName);
			//执行sql语句获得结果集
			rs = psmt.executeQuery();
		}catch(Exception e3) {
			throw new DaoException(e3);
		}finally {
			// 必须手动释放物理资源
			DBUtils.close(conn, psmt, rs);
		}
	}

	@Override
	public void updateDoctorByLoginName(String loginName,Doctor doctor) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "update Doctors set D_Level=?,D_Belong_Room=?,D_Work_Where=?,D_Login_passWord=?,D_Good_At=?,D_Time=? ,D_Sex=? where D_Login_Name = ?";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setString(1, doctor.getLevel());
			psmt.setInt(2, doctor.getBelongRoom());
			psmt.setString(3, doctor.getWorkWhere());
			psmt.setString(4, doctor.getLoginPassWord());
			psmt.setString(5, doctor.getGoodAt());
			psmt.setString(6, doctor.getTime());
			psmt.setString(7, doctor.getSex());
			psmt.setString(8,loginName);
			//执行sql语句获得结果集
			psmt.execute();
		}catch(Exception e4) {
			throw new DaoException(e4);
		}finally {
			// 必须手动释放物理资源
			DBUtils.close(conn, psmt, rs);
		}
	}

	@Override
	public void insertDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "insert into Doctors values(?,?,?,?,?,?,?,?,?,?)";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setInt(1, doctor.getId());
			psmt.setString(2, doctor.getName());
			psmt.setString(3, doctor.getSex());
			psmt.setString(4, doctor.getLevel());
			psmt.setInt(5, doctor.getBelongRoom());
			psmt.setString(6, doctor.getWorkWhere());
			psmt.setString(7, doctor.getLoginName());
			psmt.setString(8, doctor.getLoginPassWord());
			psmt.setString(9, doctor.getGoodAt());
			psmt.setString(10, doctor.getTime());
			//执行sql语句获得结果集
			psmt.execute();
		}catch(Exception e4) {
			throw new DaoException(e4);
		}finally {
			// 必须手动释放物理资源
			DBUtils.close(conn, psmt, rs);
		}
	}


	@Override
	public List<Doctor> listSomeDoctorByLevel(String level) {
		
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<Doctor> doctors = new ArrayList<Doctor>();
		Doctor doctor;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "select * from Doctors where D_Level= ?";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			
			//绑定参数
			psmt.setString(1, level);
			//执行sql语句获得结果集
			rs = psmt.executeQuery();
			while(rs.next()) {
				doctor=new Doctor();
				doctor.setId(rs.getInt(1));
				doctor.setName(rs.getString(2));
				doctor.setSex(rs.getString(3));
				doctor.setLevel(rs.getString(4));
				doctor.setBelongRoom(rs.getInt(5));
				doctor.setWorkWhere(rs.getString(6));
				doctor.setLoginName(rs.getString(7));
				doctor.setLoginPassWord(rs.getString(8));
				doctor.setGoodAt(rs.getString(9));
				doctor.setTime(rs.getString(10));
				
				doctors.add(doctor);
			}
			
		}catch(Exception e){
			throw new DaoException(e);
		}finally {//finally 中的代码一定会被执行
			DBUtils.close(conn, psmt, rs);//手动释放物理资源
		}
		
		return doctors;
	}


	@Override
	public List<Doctor> listSomeDoctorByRoom(String rName) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<Doctor> doctors = new ArrayList<Doctor>();
		Doctor doctor;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "select * from Doctors,Room where R_Name= ? and D_Belong_Room=R_Id";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			
			//绑定参数
			psmt.setString(1,rName);
			//执行sql语句获得结果集
			rs = psmt.executeQuery();
			while(rs.next()) {
				doctor=new Doctor();
				doctor.setId(rs.getInt(1));
				doctor.setName(rs.getString(2));
				doctor.setSex(rs.getString(3));
				doctor.setLevel(rs.getString(4));
				doctor.setBelongRoom(rs.getInt(5));
				doctor.setWorkWhere(rs.getString(6));
				doctor.setLoginName(rs.getString(7));
				doctor.setLoginPassWord(rs.getString(8));
				doctor.setGoodAt(rs.getString(9));
				doctor.setTime(rs.getString(10));
				
				doctors.add(doctor);
			}
			
		}catch(Exception e){
			throw new DaoException(e);
		}finally {//finally 中的代码一定会被执行
			DBUtils.close(conn, psmt, rs);//手动释放物理资源
		}
		
		
		for(Doctor d:doctors) {
			System.out.println(d.getLoginName());
		}
		
		return doctors;
		
	}


	@Override
	public Doctor getDoctorByID(int doctorID) {
		// TODO Auto-generated method stub
				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;
				Doctor d = null;
				try {
					//获得数据库链接
					conn = (Connection) DBUtils.newConnection();
					//sql语句
					final String sql = "select * from Doctors where D_Id=?";
					//获得PreparedStatement的实例
					psmt = conn.prepareStatement(sql);
					//绑定参数
					psmt.setInt(1,doctorID);
					//执行sql语句获得结果集
					rs = psmt.executeQuery();
					if(rs.next()) {
						d = new Doctor();
						d.setId(rs.getInt(1));
						d.setName(rs.getString(2));
						d.setSex(rs.getString(3));
						d.setLevel(rs.getString(4));
						d.setBelongRoom(rs.getInt(5));
						d.setWorkWhere(rs.getString(6));
						d.setLoginName(rs.getString(7));
						d.setLoginPassWord(rs.getString(8));
						d.setGoodAt(rs.getString(9));
						d.setTime(rs.getString(10));
					}
				}catch(Exception e2) {
					throw new DaoException(e2);
				}finally {
					// 必须手动释放物理资源
					DBUtils.close(conn, psmt, rs);
				}
				return d;
	}


}

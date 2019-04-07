package system.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import system.dao.DoDao;
import system.entity.DO;
import system.entity.Room;
import system.exception.DaoException;
import system.utils.DBUtils;

/*
*@author:yb
*@version 创建时间：2018年1月16日 下午11:54:03
*/
/*
 * 下面是DO的具体规则实现方法
 */
public class DoDaoImpl implements DoDao {

	@Override
	public List<DO> listDo() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<DO> d_o_s = new ArrayList<DO>();
		DO d_o = null;
		
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "select * from DO";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//执行sql语句获得结果集
			rs = psmt.executeQuery();
			while(rs.next()) {
				d_o = new DO();
				d_o.setuId(rs.getInt(1));
				d_o.setDoTime(rs.getString(2));
				d_o.setdId(rs.getInt(3));
				d_o.setDoIllness(rs.getString(4));
				d_o_s.add(d_o);
			}
			
		}catch(Exception e){
			throw new DaoException(e);
		}finally {//finally 中的代码一定会被执行
			DBUtils.close(conn, psmt, rs);//手动释放物理资源
		}
		
		return d_o_s;
	}

	@Override
	public void insertDo(DO d_o) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "insert into DO values(?,?,?,?)";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setInt(1, d_o.getuId());
			psmt.setString(2, d_o.getDoTime());
			psmt.setInt(3, d_o.getdId());
			psmt.setString(4, d_o.getDoIllness());
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
	public void deleteDo(int uId,int doctorId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "delete from DO where U_Id = ? and D_Id = ? ";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setInt(1,uId);
			psmt.setInt(2,doctorId);
			//执行sql语句获得结果集
			psmt.execute();
		}catch(Exception e3) {
			throw new DaoException(e3);
		}finally {
			// 必须手动释放物理资源
			DBUtils.close(conn, psmt, rs);
		}
	}

	@Override
	public void updateDo(int uId, DO d_o) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "update DO set D_Time=?,D_Id=?,D_illness=? where U_Id = ?";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setString(1, d_o.getDoTime());
			psmt.setInt(2, d_o.getdId());
			psmt.setString(3, d_o.getDoIllness());
			psmt.setInt(4, uId);
			//执行sql语句获得结果集
			psmt.execute();
		}catch(Exception e4) {
			throw new DaoException(e4);
		}finally {
			// 必须手动释放物理资源
			DBUtils.close(conn, psmt, rs);
		}
	}
	
	public DO getDo(int uId) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		DO d_o = null;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "select * from DO where U_Id = ? ";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setInt(1,uId);
			//执行sql语句获得结果集
			rs = psmt.executeQuery();
			if(rs.next()) {
				d_o = new DO();
			    d_o.setuId(rs.getInt(1));
				d_o.setDoTime(rs.getString(2));
				d_o.setdId(rs.getInt(3));
				d_o.setDoIllness(rs.getString(4));
			}
		}catch(Exception e2) {
			throw new DaoException(e2);
		}finally {
			// 必须手动释放物理资源
			DBUtils.close(conn, psmt, rs);
		}
		return d_o;
	}

	@Override
	public DO getDoByUserId(int uId) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		DO d_o = null;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "select * from DO where U_Id = ? ";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setInt(1,uId);
			//执行sql语句获得结果集
			rs = psmt.executeQuery();
			if(rs.next()) {
				d_o = new DO();
			    d_o.setuId(rs.getInt(1));
				d_o.setDoTime(rs.getString(2));
				d_o.setdId(rs.getInt(3));
				d_o.setDoIllness(rs.getString(4));
			}
		}catch(Exception e2) {
			throw new DaoException(e2);
		}finally {
			// 必须手动释放物理资源
			DBUtils.close(conn, psmt, rs);
		}
		return d_o;
	}

	@Override
	public List<DO> getListDoByUserId(int uId) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<DO> d_o_s = new ArrayList<DO>();
		DO d_o = null;
		
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "select * from DO where U_Id = ? ";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setInt(1,uId);
			//执行sql语句获得结果集
			rs = psmt.executeQuery();
			while(rs.next()) {
				d_o = new DO();
				d_o.setuId(rs.getInt(1));
				d_o.setDoTime(rs.getString(2));
				d_o.setdId(rs.getInt(3));
				d_o.setDoIllness(rs.getString(4));
				d_o_s.add(d_o);
			}
			
		}catch(Exception e){
			throw new DaoException(e);
		}finally {//finally 中的代码一定会被执行
			DBUtils.close(conn, psmt, rs);//手动释放物理资源
		}
		
		return d_o_s;
	}

	@Override
	public DO getDoByDoctorId(int docId) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		DO d_o = null;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "select * from DO where D_Id = ? ";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setInt(1,docId);
			//执行sql语句获得结果集
			rs = psmt.executeQuery();
			if(rs.next()) {
				d_o = new DO();
			    d_o.setuId(rs.getInt(1));
				d_o.setDoTime(rs.getString(2));
				d_o.setdId(rs.getInt(3));
				d_o.setDoIllness(rs.getString(4));
			}
		}catch(Exception e2) {
			throw new DaoException(e2);
		}finally {
			// 必须手动释放物理资源
			DBUtils.close(conn, psmt, rs);
		}
		return d_o;
	}

	@Override
	public List<DO> getListDoByDoctorId(int docId) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<DO> d_o_s = new ArrayList<DO>();
		DO d_o = null;
		
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "select * from DO where D_Id = ? ";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setInt(1,docId);
			//执行sql语句获得结果集
			rs = psmt.executeQuery();
			while(rs.next()) {
				d_o = new DO();
				d_o.setuId(rs.getInt(1));
				d_o.setDoTime(rs.getString(2));
				d_o.setdId(rs.getInt(3));
				d_o.setDoIllness(rs.getString(4));
				d_o_s.add(d_o);
			}
			
		}catch(Exception e){
			throw new DaoException(e);
		}finally {//finally 中的代码一定会被执行
			DBUtils.close(conn, psmt, rs);//手动释放物理资源
		}
		
		return d_o_s;
	}

}

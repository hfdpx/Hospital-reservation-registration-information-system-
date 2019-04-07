package system.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import system.dao.UserDao;
import system.entity.User;
import system.exception.DaoException;
import system.utils.DBUtils;

/*
*@author:yb
*@version 创建时间：2018年1月16日 上午11:24:06
*/

/*
 * 这是接口方法的具体实现
 * @Override可以验证下面的方法是不是父类中具有的,保险,因为父类中如果没有这个方法的话编译也能够通过,编译器认为这是你自己重新写的子方法
 * // TODO Auto-generated method stub 提示你说这个方法是自动生成的
 */
public class UserDaoImpl implements UserDao {

	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		User u;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "select U_Id,U_Login_Name,U_Id_Card_Number,U_PassWord,U_Tel_Number,U_Adress from Users";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//执行sql语句获得结果集
			rs = psmt.executeQuery();
			while(rs.next()) {
				u=new User();
				u.setId(rs.getInt(1));
				u.setLoginName(rs.getString(2));
				u.setIdCardName(rs.getString(3));
				u.setPassWord(rs.getString(4));
				u.setTelNumber(rs.getString(5));
				u.setAdress(rs.getString(6));
				users.add(u);
			}
			
		}catch(Exception e){
			throw new DaoException(e);
		}finally {//finally 中的代码一定会被执行
			DBUtils.close(conn, psmt, rs);//手动释放物理资源
		}
		return users;
	}

	@Override
	public User getUserByLoginName(String loginName) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		User u=null;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "select U_Id,U_Login_Name,U_Id_Card_Number,U_PassWord,U_Tel_Number,U_Adress from Users where U_Login_Name=?";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setString(1,loginName);
			//执行sql语句获得结果集
			rs = psmt.executeQuery();
			if(rs.next()) {
				u=new User();
				u.setId(rs.getInt(1));
				u.setLoginName(rs.getString(2));
				u.setIdCardName(rs.getString(3));
				u.setPassWord(rs.getString(4));
				u.setTelNumber(rs.getString(5));
				u.setAdress(rs.getString(6));
			}
		}catch(Exception e2) {
			throw new DaoException(e2);
		}finally {
			// 必须手动释放物理资源
			DBUtils.close(conn, psmt, rs);
		}
		return u;
	}

	@Override
	public void deleteUserByLoginName(String loginName) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "CALL delete_user_By_U_Login_Name(?)";
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
	public void updateUserByLoginName(String loginName, User user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "update Users set U_PassWord=?,U_Tel_Number=?,U_Adress=? where U_Login_Name = ?";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setString(1, user.getPassWord());
			psmt.setString(2, user.getTelNumber());
			psmt.setString(3, user.getAdress());
			psmt.setString(4,loginName);
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
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "insert into Users values(?,?,?,?,?,?)";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setInt(1, user.getId());
			psmt.setString(2, user.getLoginName());
			psmt.setString(3, user.getIdCardName());
			psmt.setString(4, user.getPassWord());
			psmt.setString(5, user.getTelNumber());
			psmt.setString(6, user.getAdress());
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
	public User getUserByCardNumber(String cardNumber) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		User u=null;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "select U_Id,U_Login_Name,U_Id_Card_Number,U_PassWord,U_Tel_Number,U_Adress from Users where U_Id_Card_Number=?";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setString(1,cardNumber);
			//执行sql语句获得结果集
			rs = psmt.executeQuery();
			if(rs.next()) {
				u=new User();
				u.setId(rs.getInt(1));
				u.setLoginName(rs.getString(2));
				u.setIdCardName(rs.getString(3));
				u.setPassWord(rs.getString(4));
				u.setTelNumber(rs.getString(5));
				u.setAdress(rs.getString(6));
			}
		}catch(Exception e2) {
			throw new DaoException(e2);
		}finally {
			// 必须手动释放物理资源
			DBUtils.close(conn, psmt, rs);
		}
		return u;
	}

	@Override
	public User getUserByID(int userID) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		User u=null;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "select U_Id,U_Login_Name,U_Id_Card_Number,U_PassWord,U_Tel_Number,U_Adress from Users where U_Id=?";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setInt(1,userID);
			//执行sql语句获得结果集
			rs = psmt.executeQuery();
			if(rs.next()) {
				u=new User();
				u.setId(rs.getInt(1));
				u.setLoginName(rs.getString(2));
				u.setIdCardName(rs.getString(3));
				u.setPassWord(rs.getString(4));
				u.setTelNumber(rs.getString(5));
				u.setAdress(rs.getString(6));
			}
		}catch(Exception e2) {
			throw new DaoException(e2);
		}finally {
			// 必须手动释放物理资源
			DBUtils.close(conn, psmt, rs);
		}
		return u;
	}
	
	
}

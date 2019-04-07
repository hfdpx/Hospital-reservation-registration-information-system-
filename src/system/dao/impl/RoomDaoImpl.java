package system.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import system.dao.RoomDao;
import system.entity.Doctor;
import system.entity.Room;
import system.exception.DaoException;
import system.utils.DBUtils;

/*
*@author:yb
*@version 创建时间：2018年1月16日 下午11:10:25
*/
/*
 * 下面是关于Room具体规则的实现方法
 */
public class RoomDaoImpl implements RoomDao {

	@Override
	public List<Room> listRoom() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<Room> rooms = new ArrayList<Room>();
		Room room;
		
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "select * from Room";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//执行sql语句获得结果集
			rs = psmt.executeQuery();
			while(rs.next()) {
				room = new Room();
				room.setId(rs.getInt(1));
				room.setName(rs.getString(2));
				room.setNum(rs.getInt(3));
				room.setWhere(rs.getString(4));
				room.setD_o(rs.getString(5));
				rooms.add(room);
			}
			
		}catch(Exception e){
			throw new DaoException(e);
		}finally {//finally 中的代码一定会被执行
			DBUtils.close(conn, psmt, rs);//手动释放物理资源
		}
		
		return rooms;
	}

	@Override
	public Room getRoomByRoomName(String name) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Room room = null;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "select * from Room where R_Name=?";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setString(1,name);
			//执行sql语句获得结果集
			rs = psmt.executeQuery();
			if(rs.next()) {
				room = new Room();
				room.setId(rs.getInt(1));
				room.setName(rs.getString(2));
				room.setNum(rs.getInt(3));
				room.setWhere(rs.getString(4));
				room.setD_o(rs.getString(5));
			}
		}catch(Exception e2) {
			throw new DaoException(e2);
		}finally {
			// 必须手动释放物理资源
			DBUtils.close(conn, psmt, rs);
		}
		return room;
	}

	@Override
	public void deleteRoomByRoomName(String name) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "CALL delete_Room_By_Room_Name(?)";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setString(1,name);
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
	public void updateRoomByRoomName(String name, Room r) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "update Room set R_Name=?,R_Where=?,R_DO=? where R_Name=?";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setString(1, r.getName());
			psmt.setString(2, r.getWhere());
			psmt.setString(3, r.getD_o());
			psmt.setString(4, name);
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
	public void insertRoom(Room r) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "insert into Room values(?,?,?,?,?)";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setInt(1, r.getId());
			psmt.setString(2, r.getName());
			psmt.setInt(3,0);
			psmt.setString(4, r.getWhere());
			psmt.setString(5, r.getD_o());
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
	public Room getRoomByID(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Room room = null;
		try {
			//获得数据库链接
			conn = (Connection) DBUtils.newConnection();
			//sql语句
			final String sql = "select * from Room where R_Id=?";
			//获得PreparedStatement的实例
			psmt = conn.prepareStatement(sql);
			//绑定参数
			psmt.setInt(1, id);
			//执行sql语句获得结果集
			rs = psmt.executeQuery();
			if(rs.next()) {
				room = new Room();
				room.setId(rs.getInt(1));
				room.setName(rs.getString(2));
				room.setNum(rs.getInt(3));
				room.setWhere(rs.getString(4));
				room.setD_o(rs.getString(5));
			}
		}catch(Exception e2) {
			throw new DaoException(e2);
		}finally {
			// 必须手动释放物理资源
			DBUtils.close(conn, psmt, rs);
		}
		return room;
	}
	public static void main(String[] args){
		RoomDaoImpl r=new RoomDaoImpl();
		Room room=r.getRoomByRoomName("儿科");
		System.out.print(room.getId());
	}
	

}

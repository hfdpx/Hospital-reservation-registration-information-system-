package system.test;

import org.junit.Test;

import system.dao.RoomDao;
import system.dao.impl.RoomDaoImpl;
import system.entity.Room;

/*
*@author:yb
*@version 创建时间：2018年1月16日 下午11:16:47
* 说明:测试的所有代码作者yb已经测试,若需要重新测试,吧代码解开注释即可
*/
/*
 * Room的Dao层测试
 */
public class RoomDaoTest {
	private RoomDao roomDao = new  RoomDaoImpl();
	
//	@Test
//	public void listRoom() {
//		List<Room> rooms = roomDao.listRoom();
//		System.out.println(rooms.size());
//		for(Room room:rooms) {
//			System.out.println(room.getD_o());
//		}
//	}
	
//	@Test
//	public void getRoomByRoomName() {
//		String name = "骨伤外科";
//		Room room = roomDao.getRoomByRoomName(name);
//		System.out.println(room.getD_o());
//	}
	
//	@Test
//	public void deleteRoomByRoomName() {
//		String name = "骨伤外科";
//		roomDao.deleteRoomByRoomName(name);
//	}
	
//	@Test
//	public void updateRoomByRoomName() {
//		String name = "神经内科";
//		Room r = new Room();
//		r = roomDao.getRoomByRoomName(name);
//		r.setD_o("xxx");
//		r.setName("ssssssss");
//		r.setWhere("asdasdas");
//		roomDao.updateRoomByRoomName(name, r);
//	}
//	
//	@Test
//	public void insertRoom() {
//		Room r = new Room();
//		r.setId(2);
//		r.setName("xxxxxxss");
//		r.setNum(0);
//		r.setWhere("ssssssssdfgsfs");
//		r.setD_o("asdasdasdasddddsss");
//		roomDao.insertRoom(r);
//	}
}

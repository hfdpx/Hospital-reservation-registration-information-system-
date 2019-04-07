package system.dao;

import java.util.List;

import system.entity.Room;

/*
*@author:yb
*@version 创建时间：2018年1月16日 下午10:45:18
*/
/*
 * 该接口定义访问科室表的所有规则
 */
public interface RoomDao {
	/*
	 * 定义查询所有科室的方法
	 */
	public List<Room> listRoom();
	
	/*
	 * 定义根据科室名查询科室的方法
	 */
	public Room getRoomByRoomName(String name);
	
	/*
	 * 定义根据科室名称删除科室的方法
	 */
	public void deleteRoomByRoomName(String name);
	
	/*
	 * 定义根据科室名称修改科室信息的方法
	 */
	public void updateRoomByRoomName(String name,Room r);
	
	/*
	 * 定义增加科室的方法
	 */
	public void insertRoom(Room r);
	
	/*
	 * 定义根据科室ID查询科室的方法
	 */
	public Room getRoomByID(int id);
	
}

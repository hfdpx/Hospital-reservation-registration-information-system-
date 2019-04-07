package system.service.impl;

import java.util.List;

import system.dao.RoomDao;
import system.dao.impl.RoomDaoImpl;
import system.entity.Room;
import system.exception.DaoException;
import system.exception.UsernameOrPwdErrorException;
import system.service.RoomService;

/*
*@author:yb
*@version 创建时间：2018年1月18日 上午9:55:25
*/
public class RoomServiceImpl implements RoomService{

	private RoomDao roomDao = new RoomDaoImpl();
	
	@Override
	public String[][] getRoomMessage() throws DaoException, UsernameOrPwdErrorException {
		// TODO Auto-generated method stub
		int i;
		int size = roomDao.listRoom().size();
		String[][] dates = new String[size][4];
		
		List<Room> rooms = roomDao.listRoom();
		
		for(i=0;i<size;i++) {
			dates[i][0]=rooms.get(i).getName();
			dates[i][1]=rooms.get(i).getNum()+"";
			dates[i][2]=rooms.get(i).getWhere();
			dates[i][3]=rooms.get(i).getD_o();
			
		}
		return dates;
	}

}

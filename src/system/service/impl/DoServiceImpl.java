package system.service.impl;

import java.util.List;
import java.util.Vector;

import system.dao.DoDao;
import system.dao.DoctorDao;
import system.dao.RoomDao;
import system.dao.UserDao;
import system.dao.impl.DoDaoImpl;
import system.dao.impl.DoctorDaoImpl;
import system.dao.impl.RoomDaoImpl;
import system.dao.impl.UserDaoImpl;
import system.entity.DO;
import system.entity.Doctor;
import system.entity.Room;
import system.entity.User;
import system.exception.DaoException;
import system.exception.UsernameOrPwdErrorException;
import system.service.DoService;
import system.service.UserService;

public class DoServiceImpl implements DoService {
	private UserDao userDao;
    private int userID;
    private int doctorID;
    private DoDao doDao;
    private List<DO> listdo;
    private DoctorDao doctorDao=new DoctorDaoImpl();
    
	@Override
	public Vector<Vector<String>> getDoByUserName(String username)
			throws DaoException, UsernameOrPwdErrorException {
		userDao=new UserDaoImpl();
		userID=userDao.getUserByLoginName(username).getId();
		//System.out.println(userID);
		doDao=new DoDaoImpl();
		listdo=doDao.getListDoByUserId(userID);//通过userid获得用户预约信息
		//System.out.println(listdo);
		Vector<Vector<String>> vectors = new Vector<Vector<String>>();
		for (DO doentity : listdo){
			Vector<String> vertorDO=new Vector<String>();
			Doctor doctor=doctorDao.getDoctorByID(doentity.getdId());//获得预约的ID号对应的doctor实体
			
			//与ROom连接查出对应的科室名
			RoomDao  roomDao=new RoomDaoImpl();
			Room room=roomDao.getRoomByID(doctor.getBelongRoom());
			vertorDO.add(username);
			vertorDO.add(doctor.getName());
			vertorDO.add(String.valueOf(room.getName()));
			//System.out.println(String.valueOf(room.getName()));
			vertorDO.add(doctor.getWorkWhere());
			vertorDO.add(doctor.getTime());
			vectors.add(vertorDO);
		}
		return vectors;
	}
	@Override
	public void deleteDoByID(String  userName,String doctorName) throws DaoException,
		UsernameOrPwdErrorException {
		Doctor doctor=new Doctor();
		User user=new User();
		UserDao userDao=new UserDaoImpl();
		user=userDao.getUserByLoginName(userName);
		DoctorDao doctorDao=new DoctorDaoImpl();
		doctor=doctorDao.getDoctorByLoginName(doctorName);
		doDao=new DoDaoImpl();
		doDao.deleteDo(user.getId(), doctor.getId());
	}
	
	@Override
	public Vector<Vector<String>> getDoByDoctorName(String doctorname)
			throws DaoException, UsernameOrPwdErrorException {
		
		DoctorDao doctorDao=new DoctorDaoImpl();
		int doctorId=doctorDao.getDoctorByLoginName(doctorname).getId();//得到DoctorID
		//System.out.print(doctorId);
		doDao=new DoDaoImpl();
		listdo=doDao.getListDoByDoctorId(doctorId);//返回预约信息的List列表
		//System.out.print(listdo);
		Vector<Vector<String>> vectors = new Vector<Vector<String>>();
		
		
		for (DO doentity : listdo){
			Vector<String> vertorDO=new Vector<String>();
			//通过医生的ID得到医生实体
			Doctor doctor=doctorDao.getDoctorByID(doentity.getdId());
			
			//System.out.println(doctor.getLevel());
			
			//通过用户ID得到用户实体
			UserDao userDao=new UserDaoImpl();
			User user=userDao.getUserByID(doctorId);
			//与ROom连接查出对应的科室名
			RoomDao  roomDao=new RoomDaoImpl();
			Room room=roomDao.getRoomByID(doctor.getBelongRoom());
			vertorDO.add( user.getLoginName());
			vertorDO.add(doctor.getName());
			vertorDO.add(room.getName());
			vertorDO.add(room.getWhere());
			vertorDO.add(doctor.getTime());
			vectors.add(vertorDO);
		}
		return vectors;
	}
	
	public static void main(String[] args){
		DoServiceImpl s=new DoServiceImpl();
		s.getDoByDoctorName("赵飞燕");
	}
	
	
	
	
}

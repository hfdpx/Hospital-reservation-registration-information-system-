package system.service;

import java.util.Vector;

import system.exception.DaoException;
import system.exception.UsernameOrPwdErrorException;

public interface DoService {
	//通过用户名得到用户预约信息
	public Vector<Vector<String>> getDoByUserName(String name)
			throws DaoException,UsernameOrPwdErrorException;
    //通过用户名删除预约信息
	public void deleteDoByID(String  userName,String doctorName)
    		throws DaoException,UsernameOrPwdErrorException;
	//通过医生名得到预约信息
	public Vector<Vector<String>> getDoByDoctorName(String name)
			throws DaoException,UsernameOrPwdErrorException;

}

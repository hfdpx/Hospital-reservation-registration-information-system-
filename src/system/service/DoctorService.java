package system.service;

import system.entity.Doctor;
import system.exception.DaoException;
import system.exception.UsernameOrPwdErrorException;

/*
*@author:yb
*@version 创建时间：2018年1月18日 上午8:47:42
*/
/*
 * 定义医生对象的业务规则
 */
public interface DoctorService {
	/*
	 * 定义获得所有医生信息的业务规则,要求返回 "医生编号", "医生姓名", "性别", "级别", "所属科室","擅长方向","办公地点" 组成的二维字符串数组 
	 */
	public String[][] getDoctorMessage() throws DaoException,UsernameOrPwdErrorException;

	/*
	 * 定义根据意思名字获得某个医生信息的业务规则,要求返回 "医生编号", "医生姓名", "性别", "级别", "所属科室","擅长方向","办公地点" 组成的二维字符串数组 
	 */
	public String[][] getOneDoctorMessage(String name) throws DaoException,UsernameOrPwdErrorException;

 
	/*
	 * 定义根据医生在职务返回所有的医生,,要求返回 "医生编号", "医生姓名", "性别", "级别", "所属科室","擅长方向","办公地点" 组成的二维字符串数组 
	 */
	public String[][] getSomeDoctorMessageByLevel(String level) throws DaoException,UsernameOrPwdErrorException;

	/*
	 * 根据医生的科室返回所有的医生要求返回 "医生编号", "医生姓名", "性别", "级别", "所属科室","擅长方向","办公地点" 组成的二维字符串数组 
	 */
	public String[][] getSomeDoctorMessageByRoom(String rName) throws DaoException,UsernameOrPwdErrorException;

	//
	public void updateDoctorByLoginName(Doctor doctor)
			throws DaoException;
	
}

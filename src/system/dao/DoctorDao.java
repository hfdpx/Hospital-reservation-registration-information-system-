package system.dao;

import java.util.List;

import system.entity.Doctor;

/*
*@author:yb
*@version 创建时间：2018年1月16日 下午6:31:29
*/

/*
 * 该接口定义访问医生信息表的所有规则
 */
public interface DoctorDao {
	/*
	 * 定义查询所有医生信息的方法
	 */
	public List<Doctor> listDoctor();
	
	/*
	 * 定义通过职务查询一些医生信息的方法
	 */
	
	public List<Doctor> listSomeDoctorByLevel(String level);
	
	/*
	 * 定义通过科室查询一些医生信息的方法
	 */
	public List<Doctor> listSomeDoctorByRoom(String rName);
	
	
	/*
	 * 定义通过医生登录名查询医生信息的方法
	 */
	
	public Doctor getDoctorByLoginName(String loginName);
	
	/*
	 * 定义通过医生登录名删除医生的方法
	 */
	public void deleteDoctorByLoginName(String loginName);
	
	/*
	 * 定义通过医生登录名修改医生信息的方法
	 */
	public void updateDoctorByLoginName(String loginName,Doctor doctor);
	
	/*
	 * 定义插入医生信息的方法
	 */
	public void insertDoctor(Doctor doctor);
	
	//
	public Doctor getDoctorByID(int doctorID);
	
}

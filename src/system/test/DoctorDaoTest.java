package system.test;

import java.util.List;

import org.junit.Test;

import system.dao.DoctorDao;
import system.dao.impl.DoctorDaoImpl;
import system.entity.Doctor;
import system.exception.DaoException;

/*
*@author:yb
*@version 创建时间：2018年1月16日 下午6:59:13
*/
/*
 * doctor的dao层测试类
 * 说明:测试的所有代码作者yb已经测试,若需要重新测试,把代码解开注释即可
 */
public class DoctorDaoTest {
	private DoctorDao doctorDao = new DoctorDaoImpl();
	@Test
	public void listDoctor() {
		List<Doctor> doctors = doctorDao.listDoctor();
		System.out.println(doctors.size());
		for(Doctor doctor:doctors) {
			System.out.println(doctor.getLoginName());
		}
	}
	
//	@Test
//	public void getDoctorByLoginName() {
//		String loginName="彭俊";
//		Doctor d = null;
//		d=doctorDao.getDoctorByLoginName(loginName);
//		System.out.println(d.getLoginName()+" "+d.getLevel());
//		
//	}
	
//	@Test
//	public void deleteDoctorByLoginName() {
//		doctorDao.deleteDoctorByLoginName("赵小米");
//	}
	
//	@Test
//	public void updateDoctorByLoginName() {
//		Doctor d = null;
//		String loginName="彭俊";
//		d = doctorDao.getDoctorByLoginName(loginName);
//		d.setLevel("主任医师");
//		d.setBelongRoom(2);
//		d.setWorkWhere("www");
//		d.setLoginPassWord("ssss");
//		d.setGoodAt("dsdasd");
//		doctorDao.updateDoctorByLoginName(loginName, d);
//	}
	
//	@Test
//	public void insertDoctor() {
//		Doctor d = new Doctor();
//		d.setId(11);
//		d.setLevel("xxx");
//		d.setLoginName("sb");
//		d.setLoginPassWord("123");
//		d.setName("sb");
//		d.setSex("男");
//		d.setWorkWhere("sssss");
//		d.setBelongRoom(1);
//		d.setGoodAt("asdasdas");
//		doctorDao.insertDoctor(d);
//	
//	}
	
}

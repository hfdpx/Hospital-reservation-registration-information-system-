package system.service.impl;

import system.dao.DoctorDao;
import system.dao.UserDao;
import system.dao.impl.DoctorDaoImpl;
import system.dao.impl.UserDaoImpl;
import system.entity.Doctor;
import system.entity.User;
import system.exception.DaoException;
import system.exception.UsernameOrPwdErrorException;
import system.service.AllShareService;

/*
*@author:yb
*@version 创建时间：2018年1月17日 下午3:55:26
*/
public class AllShareServiceImpl implements AllShareService{

	private UserDao userDao = new UserDaoImpl();
	private DoctorDao doctorDao = new DoctorDaoImpl();
	@Override
	public User userLogin(String name, String password) throws DaoException, UsernameOrPwdErrorException {
		// TODO Auto-generated method stub
		// 1.额外功能：校验数据格式 "" "  " "        "
		String reg = "\\s*";// 表示零个或者多个空格
		if (name == null || name.matches(reg)) {
			throw new RuntimeException("格式不正确");
		}
		if (password == null || password.matches(reg)) {
			throw new RuntimeException("格式不正确");
		}
		
		User u = null;
		u = userDao.getUserByLoginName(name);
		if(u==null) {
			throw new UsernameOrPwdErrorException("用户名或者密码错误！");
		}else if(!password.equals(u.getPassWord())) {
			throw new UsernameOrPwdErrorException("用户名或者密码错误！");
		}
					
		return u;
	}

	@Override
	public Doctor doctorLogin(String name, String password) throws DaoException, UsernameOrPwdErrorException {
		// TODO Auto-generated method stub
		String reg = "\\s*";// 表示零个或者多个空格
		if (name == null || name.matches(reg)) {
			throw new RuntimeException("格式不正确");
		}
		if (password == null || password.matches(reg)) {
			throw new RuntimeException("格式不正确");
		}
		
		Doctor d = null;
		d = doctorDao.getDoctorByLoginName(name);
		if(d==null) {
			throw new UsernameOrPwdErrorException("用户名或者密码错误！");
		}else if(!password.equals(d.getLoginPassWord())) {
			throw new UsernameOrPwdErrorException("用户名或者密码错误！");
		}
		
		return d;
	}
	
}

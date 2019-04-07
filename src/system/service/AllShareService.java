package system.service;

import system.entity.Doctor;
import system.entity.User;
import system.exception.DaoException;
import system.exception.UsernameOrPwdErrorException;

/*
*@author:yb
*@version 创建时间：2018年1月17日 下午3:39:33
*/
/*
 * 定义所有对象共享的业务规则
 */
public interface AllShareService {
	/*
	 * 定义用户登陆的业务逻辑
	 */
	public User userLogin(String name,String password)
	       throws DaoException,UsernameOrPwdErrorException;
	
	/*
	 * 定义医生登陆的业务逻辑
	 */
	public Doctor doctorLogin(String name,String password)
			throws DaoException,UsernameOrPwdErrorException;
	
}

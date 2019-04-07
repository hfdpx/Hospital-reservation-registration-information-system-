package system.service;

import system.entity.User;
import system.exception.DaoException;
import system.exception.UsernameOrPwdErrorException;

/*
*@author:yb
*@version 创建时间：2018年1月17日 下午10:35:43
*/
/*
 * 定义用户对象业务规则
 */
public interface UserService {
	/*
	 * 定义获得所有用户信息的业务逻辑,要求返回"用户编号", "用户名称", "用户电话", "用户地址", "用户身份证号"这些特定信息,构成一个二维字符串数组返回
	 */
	public String[][] getUserMessage() throws DaoException,UsernameOrPwdErrorException;
	
	/*
	 * 定义通过用户的登录名获得用户信息,要求返回"用户编号", "用户名称", "用户电话", "用户地址", "用户身份证号"这些特定信息,构成一个二维字符串数组返回
	 */
	public String[][] getOneUserMessageByName(String name) throws DaoException,UsernameOrPwdErrorException;

	/*
	 * 定义通过用户的身份证号码获得用户信息
	 */
	public String[][] getOneMessageByCardNumber(String cardNumber) throws DaoException,UsernameOrPwdErrorException;


	//
	public void updateUserByLoginName(User user) 
			throws DaoException,UsernameOrPwdErrorException;
    public int  getUserIdByName(String username)
    		throws DaoException,UsernameOrPwdErrorException;
    
}

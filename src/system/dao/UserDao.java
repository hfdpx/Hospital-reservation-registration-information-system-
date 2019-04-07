package system.dao;
import java.util.List;

import system.entity.User;
/*
*@author:yb
*@version 创建时间：2018年1月16日 上午11:02:19
*/

/*
 * 该接口定义访问用户表的访问规则
 */
public interface UserDao {
	/*
	 * 定义查询所有用户信息的方法
	 */
	public List<User> listUser();
	
	/*
	 * 定义根据用户登陆名查询用户信息的方法
	 */
	public User getUserByLoginName(String loginName);
	
	/*
	 * 定义删除用户的方法,通过用户登录名
	 */
	public void deleteUserByLoginName(String loginName);
	
	/*
	 * 定义修改用户的方法,通过用户登录名
	 */
	public void updateUserByLoginName(String loginName,User user);
	
	/*
	 * 定义插入用户的方法
	 */
	public void insertUser(User user);
	
	/*
	 * 定义根据用户身份证号码查询用户信息的方法
	 */
	public User getUserByCardNumber(String cardNumber);
	
	/*
	 * 定义根据用户ID查询用户信息的方法
	 */
	public User getUserByID(int  userID);
	
}

package system.test;

import java.util.List;

import org.junit.Test;

import system.dao.UserDao;
import system.dao.impl.UserDaoImpl;
import system.entity.User;

/*
*@author:yb
*@version 创建时间：2018年1月16日 下午2:05:07
*/
/*
 * 该类的作用:进行对用户表的dao层进行测试,如果你需要再次进行测试,可以开发注释掉的代码重新进行测试,但请注意不要将所有代码全部解开注释来进行测试,这样会导致数据混乱
 * 
 */
public class UserDaoTest {
	private UserDao userdao = new UserDaoImpl();
	
//	@Test//进行单元测试,很方便的一个功能,必须是void 无参数类型的
//	public void listUser() {
//		List<User> users = userdao.listUser();
//		
//		for(User user:users) {
//			System.out.println(user.getLoginName());
//		}
//	}
	
	/*
	@Test
	public void getUserByLoginName() {
		String loginName="方振兴";
		User u = null;
		u=userdao.getUserByLoginName(loginName);
		System.out.println(u.getLoginName()+" "+u.getIdCardName());
	}
	*/
	
	@Test
	public void deleteUserByLoginName() {
		userdao.deleteUserByLoginName("殷彪");
	}
	
	/*
	@Test
	public void updateUserByLoginName() {
		User user=null;
		String loginName="殷彪";
		user=userdao.getUserByLoginName(loginName);
		user.setAdress("湖南中医药大学034300");
		user.setPassWord("123456");
		user.setTelNumber("11111");
		userdao.updateUserByLoginName(loginName, user);
	}
	*/
	/*
	@Test
	public void insertUser() {
		User u = new User();
		u.setId(11);
		u.setLoginName("殷仓");
		u.setIdCardName("xxxxx");
		u.setPassWord("321");
		u.setTelNumber("963852");
		u.setAdress("adasdasda");
		userdao.insertUser(u);
	}
	*/
}

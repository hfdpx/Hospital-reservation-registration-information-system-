package system.service.impl;

import java.util.List;

import system.dao.UserDao;
import system.dao.impl.UserDaoImpl;
import system.entity.User;
import system.exception.DaoException;
import system.exception.UsernameOrPwdErrorException;
import system.service.UserService;

/*
*@author:yb
*@version 创建时间：2018年1月17日 下午10:39:36
*/
public class UserServiceImpl implements UserService{

	private UserDao userDao = new UserDaoImpl();
	private String loginName;
	
	@Override
	public String[][] getUserMessage() throws DaoException, UsernameOrPwdErrorException {
		// TODO Auto-generated method stub
		int i;
		int size = userDao.listUser().size();
		String[][] dates = new String[size][5];
		List<User> users=null;
		try {
			 users = userDao.listUser();
		}catch(Exception e5) {
			System.out.println("yyyyyyyyyyyyy");
			throw e5;
		}
		
		

				for(i=0;i<size;i++) {
					dates[i][0]=users.get(i).getId()+"";
					dates[i][1]=users.get(i).getLoginName();
					dates[i][2]=users.get(i).getTelNumber();
					dates[i][3]=users.get(i).getAdress();
					dates[i][4]=users.get(i).getIdCardName();
				}

		
		
		return dates;
	}

	@Override
	public String[][] getOneUserMessageByName(String name) throws DaoException, UsernameOrPwdErrorException {
		// TODO Auto-generated method stub
		
		String[][] dates = new String[1][5];
		User user = null;
		UserDao userDao = new UserDaoImpl();
		
		user=userDao.getUserByLoginName(name);
		
		
		dates[0][0]=user.getId()+"";
		dates[0][1]=user.getLoginName();
		dates[0][2]=user.getTelNumber();
		dates[0][3]=user.getAdress();
		dates[0][4]=user.getIdCardName();
		
		
		return dates;
	}

	@Override
	public String[][] getOneMessageByCardNumber(String cardNumber) throws DaoException, UsernameOrPwdErrorException {
		// TODO Auto-generated method stub
		String[][] dates = new String[1][5];
		User user = new User();
		UserDao userDao = new UserDaoImpl();
		user=userDao.getUserByCardNumber(cardNumber);
		
		dates[0][0]=user.getId()+"";
		dates[0][1]=user.getLoginName();
		dates[0][2]=user.getTelNumber();
		dates[0][3]=user.getAdress();
		dates[0][4]=user.getIdCardName();
		
		
		return dates;
		
	}
	@Override
	public void updateUserByLoginName(User user) throws DaoException, UsernameOrPwdErrorException {
		// TODO Auto-generated method stub
		userDao = new UserDaoImpl();
		loginName = user.getLoginName();
		userDao.updateUserByLoginName(loginName, user);

	}

	@Override
	public int getUserIdByName(String username) throws DaoException,
			UsernameOrPwdErrorException {
		
		userDao=new UserDaoImpl();
		User user=userDao.getUserByLoginName(username);
		int userid=user.getId();
		return userid;
	}

}

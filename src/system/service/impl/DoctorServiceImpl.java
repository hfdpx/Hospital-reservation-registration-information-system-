package system.service.impl;

import java.util.List;

import system.dao.DoctorDao;
import system.dao.RoomDao;
import system.dao.impl.DoctorDaoImpl;
import system.dao.impl.RoomDaoImpl;
import system.entity.Doctor;
import system.exception.DaoException;
import system.exception.UsernameOrPwdErrorException;
import system.service.DoctorService;

/*
*@author:yb
*@version 创建时间：2018年1月18日 上午8:51:12
*/
public class DoctorServiceImpl implements DoctorService{

	private DoctorDao doctorDao = new DoctorDaoImpl();
	private RoomDao roomDao = new RoomDaoImpl();
	
	@Override
	public String[][] getDoctorMessage() throws DaoException, UsernameOrPwdErrorException {
		// TODO Auto-generated method stub
		int i;
		int size = doctorDao.listDoctor().size();
		String[][] dates = new String [size][7];
		
		List<Doctor> doctors = doctorDao.listDoctor();

		for(i=0;i<size;i++) {
			dates[i][0]=doctors.get(i).getId()+"";
			dates[i][1]=doctors.get(i).getLoginName();
			dates[i][2]=doctors.get(i).getSex();
			dates[i][3]=doctors.get(i).getLevel();
			dates[i][4]=roomDao.getRoomByID(doctors.get(i).getBelongRoom()).getName();
		    dates[i][5]=doctors.get(i).getGoodAt();
		    dates[i][6]=doctors.get(i).getWorkWhere();
		}
		
		return dates;
	}

	@Override
	public String[][] getOneDoctorMessage(String name) throws DaoException, UsernameOrPwdErrorException {
		// TODO Auto-generated method stub
		String[][] dates = new String [1][7];
		
		Doctor doctor = doctorDao.getDoctorByLoginName(name);
		
		dates[0][0]=doctor.getId()+"";
		dates[0][1]=doctor.getLoginName();
		dates[0][2]=doctor.getSex();
		dates[0][3]=doctor.getLevel();
		dates[0][4]=roomDao.getRoomByID(doctor.getBelongRoom()).getName();
	    dates[0][5]=doctor.getGoodAt();
	    dates[0][6]=doctor.getWorkWhere();
	    
	    return dates;
	    
	}

	@Override
	public String[][] getSomeDoctorMessageByLevel(String level) throws DaoException, UsernameOrPwdErrorException {
		// TODO Auto-generated method stub
		
		int i;
		int size = doctorDao.listSomeDoctorByLevel(level).size();
		String[][] dates = new String [size][7];
		
		List<Doctor> doctors = doctorDao.listSomeDoctorByLevel(level);
		
		for(i=0;i<size;i++) {
			dates[i][0]=doctors.get(i).getId()+"";
			dates[i][1]=doctors.get(i).getLoginName();
			dates[i][2]=doctors.get(i).getSex();
			dates[i][3]=doctors.get(i).getLevel();
			dates[i][4]=roomDao.getRoomByID(doctors.get(i).getBelongRoom()).getName();
		    dates[i][5]=doctors.get(i).getGoodAt();
		    dates[i][6]=doctors.get(i).getWorkWhere();
		}
		
		return dates;
	}

	@Override
	public String[][] getSomeDoctorMessageByRoom(String rName) throws DaoException, UsernameOrPwdErrorException {
		// TODO Auto-generated method stub
		int i;
		int size = doctorDao.listSomeDoctorByRoom(rName).size();
		String[][] dates = new String [size][7];
		System.out.println("*"+rName+"*");
		
		List<Doctor> doctors = doctorDao.listSomeDoctorByRoom(rName);
		
		
		
		
		for(i=0;i<size;i++) {
			dates[i][0]=doctors.get(i).getId()+"";
			dates[i][1]=doctors.get(i).getLoginName();
			dates[i][2]=doctors.get(i).getSex();
			dates[i][3]=doctors.get(i).getLevel();
			dates[i][4]=roomDao.getRoomByID(doctors.get(i).getBelongRoom()).getName();
		    dates[i][5]=doctors.get(i).getGoodAt();
		    dates[i][6]=doctors.get(i).getWorkWhere();
		}
		
		return dates;
		
	}

	@Override
	public void updateDoctorByLoginName(Doctor doctor) throws DaoException {
		// TODO Auto-generated method stub
		String loginName=doctor.getLoginName();
		doctorDao.updateDoctorByLoginName(loginName, doctor);
	}

}

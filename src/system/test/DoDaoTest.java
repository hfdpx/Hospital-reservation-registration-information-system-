package system.test;

import org.junit.Test;

import system.dao.DoDao;
import system.dao.impl.DoDaoImpl;
import system.entity.DO;

/*
*@author:yb
*@version 创建时间：2018年1月17日 上午12:14:27
*/
/*
 * DO层测试
 */
public class DoDaoTest {
	private DoDao doDao = new DoDaoImpl();
	
//	@Test
//	public void listDo(){
//		List<DO> d_o_s = doDao.listDo();
//		System.out.println(d_o_s.size());
//		for(DO d_o:d_o_s) {
//			System.out.println(d_o.getuId());
//		}
//	}
	
//	@Test
//	public void insertDo(){
//		DO d_o = new DO();
//		d_o.setuId(1);
//		d_o.setDoTime("星期一");
//		d_o.setdId(1);
//		d_o.setDoIllness("asdasda");
//		doDao.insertDo(d_o);
//	}
	
//	@Test
//	public void deleteDo() {
//		int i=1;
//		doDao.deleteDo(i);
//	}
	
//	@Test
//	public void updateDo() {
//		DO d_o = new DO();
//		d_o = doDao.getDo(1);
//		d_o.setDoTime("星期二");
//		d_o.setdId(3);
//		d_o.setDoIllness("sdfsdfsd");
//		doDao.updateDo(1, d_o);
//	}
	
//	@Test
//	public void getDo() {
//		int i=1;
//		DO d_o = doDao.getDo(i);
//		System.out.println(d_o.getuId());
//	}
	
}

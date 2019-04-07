package system.dao;

import java.util.List;

import system.entity.DO;

/*
*@author:yb
*@version 创建时间：2018年1月16日 下午11:53:45
*/
/*
 * 该接口定义了访问DO表的所有规则
 */
public interface DoDao {
	/*
	 * 定义查询所有预约的方法
	 */
	public List<DO> listDo();
	
	/*
	 * 增加通过用户id获得DO对象的方法
	 */
	public DO getDo(int uId);
	
	/*
	 * 定义增加预约的方法
	 */
	public void insertDo(DO d_o);
	
	/*
	 * 定义删除预约的方法
	 */
	public void deleteDo(int uId,int doctorId);
	
	/*
	 * 定义修改预约的方法
	 */
	public void updateDo(int uId,DO d_o);
	
	//
	public DO getDoByUserId(int uId);
	
	public List<DO> getListDoByUserId(int uId);
	
	public DO getDoByDoctorId(int docId);
	
	public List<DO> getListDoByDoctorId(int docId);
	
}

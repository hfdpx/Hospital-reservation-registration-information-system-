package system.service;

import system.exception.DaoException;
import system.exception.UsernameOrPwdErrorException;

/*
*@author:yb
*@version 创建时间：2018年1月18日 上午9:51:56
*/
/*
 * 定义科室对象业务规则
 */
public interface RoomService {
	/*
	 * 定义获得所有科室信息的业务规则,要求返回"科室名称", "科室人数", "科室地点", "科室主攻方向"
	 */
	public String[][] getRoomMessage() throws DaoException,UsernameOrPwdErrorException;

}

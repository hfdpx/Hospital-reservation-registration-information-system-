package system.entity;
/*
*@author:yb
*@version 创建时间：2018年1月16日 上午10:30:01
*/

/*
 * 医生对象
 * id 医生编号
 * name 医生姓名
 * sex 医生性别
 * level 医生职务级别
 * belongRoom 医生所属科室
 * workWhere 医生诊室地点
 * loginName 医生登录名
 * loginPassWord 医生密码
 */
public class Doctor {
	private int id;
	private String name;
	private String sex;
	private String level;
	private int belongRoom;
	private String workWhere;
	private String loginName;
	private String loginPassWord;
	private String goodAt;
	private String time;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getGoodAt() {
		return goodAt;
	}
	public void setGoodAt(String goodAt) {
		this.goodAt = goodAt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getBelongRoom() {
		return belongRoom;
	}
	public void setBelongRoom(int belongRoom) {
		this.belongRoom = belongRoom;
	}
	public String getWorkWhere() {
		return workWhere;
	}
	public void setWorkWhere(String workWhere) {
		this.workWhere = workWhere;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPassWord() {
		return loginPassWord;
	}
	public void setLoginPassWord(String loginPassWord) {
		this.loginPassWord = loginPassWord;
	}
	
}

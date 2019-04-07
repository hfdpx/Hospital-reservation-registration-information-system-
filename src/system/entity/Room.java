package system.entity;
/*
*@author:yb
*@version 创建时间：2018年1月16日 上午10:29:46
*/

/*
 * 科室对象
 * id 科室编号
 * name 科室名称
 * where 科室地点
 * d_o 科室主攻方向
 */
public class Room {
	private int id;
	private String name;
	private int num;
	private String where;
	private String d_o;
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	public String getD_o() {
		return d_o;
	}
	public void setD_o(String d_o) {
		this.d_o = d_o;
	}
	
}

package system.entity;
/*
*@author:yb
*@version 创建时间：2018年1月16日 上午10:29:13
*/

/*
 * 用户对象
 * id 用户id
 * loginName 用户登录名
 * idCardNumber 用户身份证号码
 * password 用户登陆密码
 * telNumber 用户电话
 * adress 用户住址
 */
public class User {
	private int id;
	private String loginName;
	private String idCardName;
	private String passWord;
	private String telNumber;
	private String adress;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getIdCardName() {
		return idCardName;
	}
	public void setIdCardName(String idCardName) {
		this.idCardName = idCardName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
}

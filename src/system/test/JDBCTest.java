package system.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import system.utils.DBUtils;

/*
 *@author:yb
 *@version 创建时间：2018年1月16日 上午10:34:43
 */
/*
 * 获取与数据库连接的工具类
 */
/*
 * 数据库名称:
 * hospital_reservation_registration_system
 */
public class JDBCTest {
	@Test
	public void testConnection() throws Exception {
		String username = "root";
		String pwd = "";
		String url = "jdbc:mysql://localhost:3306/hospital_reservation_registration_system?useUnicode=true& characterEncoding=utf8";

		// 1. 加载数据库驱动类
		Class.forName("com.mysql.jdbc.Driver");
		// 2. 通過DirverManager獲得Connection的實力
		Connection conn = DriverManager.getConnection(url, username, pwd);
		System.out.println(conn);
	}

	@Test
	public void testNewConnection() {
		Connection conn = DBUtils.newConnection();
		System.out.println(conn);

	}

}

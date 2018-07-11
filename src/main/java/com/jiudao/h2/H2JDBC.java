package com.jiudao.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class H2JDBC {
	public static void main(String[] args) {
		try {
			
			/**
			 * 推荐使用TCP/IP的服务器模式（远程连接）方式链接H2数据库
			 * 这种方式允许多个客户端同时连接到H2数据库
			 * such as: jdbc:h2:tcp://localhost/~/test
			 * 或者
			 * jdbc:h2:tcp://localhost/D:/work_software/H2/data
			 * 如果以内存模式连接H2数据库，那么需要注意的是服务器重启之后，内存中的数据库和表就不存在了
			 * jdbc:h2:tcp://localhost/mem:test
			 */
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/D:/work_software/H2/data", "sa", "");
			String sql = "select * from test";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				System.out.println("id = " + id + ", name = " + name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

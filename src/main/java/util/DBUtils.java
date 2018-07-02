package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	private static String initSize;
	private static String maxSize;
	private static BasicDataSource dataSource;
	
	
	static{
		//读取配置信息
		//创建连接池
		Properties prop = new Properties();//获取文件输入流
		InputStream  ips = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			prop.load(ips);
			driver = prop.getProperty("Driver");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			initSize = prop.getProperty("initSize");
			maxSize = prop.getProperty("maxSize");
			
			
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			dataSource.setInitialSize(Integer.parseInt(initSize));
			dataSource.setMaxActive(Integer.parseInt(maxSize));
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	public static Connection getConn() throws SQLException{
		
		return dataSource.getConnection();
		
	}
	
	public static void close(ResultSet rs,Statement state,Connection conn){
		try{
			if(rs!=null){
				rs.close();
			}if(state!=null){
				state.close();
			}if(conn!=null){
				conn.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}

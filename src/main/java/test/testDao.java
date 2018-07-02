package test;


import java.sql.SQLException;
import java.util.List;

import dao.UserDao;
import entity.User;

public class testDao {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		try {
//			List<User> users = userDao.findAll();
//			System.out.println(users);
			User user = new User();
			user.setUsername("123");
			user.setEmail("123@qq.com");
			user.setPassword("123456789");
			userDao.add(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

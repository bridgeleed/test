package test;

import java.sql.SQLException;

import util.DBUtils;

public class Test2 {
	public static void main(String[] args) throws SQLException {
		System.out.println(DBUtils.getConn());
	}

}

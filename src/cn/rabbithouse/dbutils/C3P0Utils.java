package cn.rabbithouse.dbutils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	private static ComboPooledDataSource cpd = new ComboPooledDataSource();
	public static ComboPooledDataSource getDataSource(){
		return cpd;
	}
	public static Connection getConnection() throws SQLException{
		return cpd.getConnection();
	}
}

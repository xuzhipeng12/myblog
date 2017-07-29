package cn.rabbithouse.dbutils;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.sql.DataSource;
public class ConnectionPool implements DataSource{
	private static String driver;
	private static String url;
	private static String username;
	private static String passwd;
	private static int initSize ;
	private static LinkedList<Connection> connPool = new LinkedList<>();
	static{
		ResourceBundle rb = ResourceBundle.getBundle("dbinfo");
		driver = rb.getString("driver");
		url  = rb.getString("url");
		username = rb.getString("username");
		passwd = rb.getString("passwd");
		initSize = Integer.parseInt(rb.getString("initSize"));
		try {
			Class.forName(driver);
			for(int i=0;i<initSize;i++){
				connPool.add(DriverManager.getConnection(url,username,passwd));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void release(Connection conn,PreparedStatement ps, ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				rs = null;
			}
		}
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				ps = null;
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				conn = null;
			}
		}
	}
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}
	@Override
	public int getLoginTimeout() throws SQLException {
		return 0;
	}
	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}
	@Override
	public void setLogWriter(PrintWriter arg0) throws SQLException {
		
	}
	@Override
	public void setLoginTimeout(int arg0) throws SQLException {
		
	}
	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		return false;
	}
	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		return null;
	}
	@Override
	public Connection getConnection() throws SQLException {
		if(connPool.size()>0){
			return new MyConnectionWarper(connPool.removeFirst(), connPool);
		}else{
			throw new RuntimeException("服务器忙，请稍后访问");
		}
	}
	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return null;
	}
}

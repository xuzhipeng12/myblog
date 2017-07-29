package cn.rabbithouse.dbutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

public class MyConnectionWarper extends MyConnection {
	private Connection conn;
	private LinkedList<Connection> pool ;
	public MyConnectionWarper(Connection conn,LinkedList<Connection> pool) {
		super(conn);
		this.conn = conn;
		this.pool = pool;
	}
	@Override
	public void close() throws SQLException {
		pool.addLast(conn);
	}
}

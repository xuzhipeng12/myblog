package cn.rabbithouse.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.rabbithouse.dbutils.C3P0Utils;
import cn.rabbithouse.dbutils.ConnectionPool;
import cn.rabbithouse.domain.ArticleOneLevelClass;
import cn.rabbithouse.domain.ArticleTwoLevelClass;

public class BlogClassesDaoImpl{
	private static ConnectionPool connpool = new ConnectionPool();
	public ArrayList<ArticleOneLevelClass> getOneLevelClass() throws SQLException {
		ArrayList<ArticleOneLevelClass> list = new ArrayList<>();
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		list = (ArrayList<ArticleOneLevelClass>) qr.query("select * from article_one_level_class",new BeanListHandler<ArticleOneLevelClass>(ArticleOneLevelClass.class));
		return list;
	}
	public void insertNewOneClass(ArticleOneLevelClass aolc) throws SQLException {
		Connection conn = connpool.getConnection();
		PreparedStatement ps = conn.prepareStatement("INSERT INTO article_one_level_class VALUES(?,?)");
		ps.setString(1, aolc.getOneLevelClass());
		ps.setString(2, aolc.getClsText());
		ps.executeUpdate();
		connpool.release(conn, ps, null);
	}

	public ArrayList<ArticleTwoLevelClass> getTwoLevelClassByOneClass(ArticleOneLevelClass aolc) throws SQLException {
		ArrayList<ArticleTwoLevelClass> list = new ArrayList<>();
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		list = (ArrayList<ArticleTwoLevelClass>) qr.query("select * from article_two_level_classs where oneLevelClass=?",new BeanListHandler<ArticleTwoLevelClass>(ArticleTwoLevelClass.class),aolc.getOneLevelClass());
		return list;
	}
	public ArrayList<ArticleTwoLevelClass> getTwoLevelClass() throws SQLException {
		ArrayList<ArticleTwoLevelClass> list = new ArrayList<>();
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		list = (ArrayList<ArticleTwoLevelClass>) qr.query("select * from article_two_level_class",new BeanListHandler<ArticleTwoLevelClass>(ArticleTwoLevelClass.class));
		return list;
	}
}

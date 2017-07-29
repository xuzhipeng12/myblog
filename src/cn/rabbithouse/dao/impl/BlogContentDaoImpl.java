package cn.rabbithouse.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import cn.rabbithouse.dbutils.C3P0Utils;
import cn.rabbithouse.dbutils.ConnectionPool;
import cn.rabbithouse.domain.BlogContent;

public class BlogContentDaoImpl {
	private static ConnectionPool connpool = new ConnectionPool();
	public void inserBlogContent(BlogContent bc) throws SQLException {
		QueryRunner qr = new  QueryRunner(C3P0Utils.getDataSource());
		qr.update("INSERT INTO article VALUES(?,?,?,?,?,?,?,?,?,?)",
				bc.getArtId(),
				bc.getTotalClass(),
				bc.getOneLevelClass(),
				bc.getTwoLevelClass(),
				bc.getBlogHead(),
				bc.getBlogContent(),
				bc.getBlogAuthor(),
				bc.getWriteDate().toLocaleString(),
				bc.getAbstruct(),
				bc.getImgUrl());
	}
	public void deleteBlogContent(BlogContent bc) throws SQLException {
	}
	
	public ArrayList<BlogContent> getArticleById(BlogContent bc) throws SQLException {
		return getArticles("select * from article where artId="+bc.getArtId());
	}
	
	public ArrayList<BlogContent> selectAllBlogContent() throws SQLException {
		return getArticles("SELECT * FROM article ORDER BY writeDate DESC");
	}
	
	public ArrayList<BlogContent> getArticleByOneClass(BlogContent bc) throws SQLException {
		return getArticles("select * from article where oneLevelClass = "+"'"+bc.getOneLevelClass()+"'");
	}
	
	public ArrayList<BlogContent> getArticleByTwoClass(BlogContent bc) throws SQLException {
		return getArticles("select * from article where twoLevelClass = "+"'"+bc.getTwoLevelClass()+"'");
	}
	private  ArrayList<BlogContent> getArticles(String sql) throws SQLException {
		ArrayList<BlogContent> list = new ArrayList<>();
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		list = (ArrayList<BlogContent>) qr.query(sql, new BeanListHandler<BlogContent>(BlogContent.class));
		return list;
	}
	public ArrayList<BlogContent> getArticleByPages(int currentpage, int num) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		ArrayList<BlogContent> list = (ArrayList<BlogContent>) qr.query("SELECT * FROM article LIMIT ?,?",new BeanListHandler<BlogContent>(BlogContent.class),currentpage*num,num);
		return list;
	}
	public int getTotalArticleNum() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		int num  = qr.query("select * from article",new ColumnListHandler()).size();
		return num;
	}
}

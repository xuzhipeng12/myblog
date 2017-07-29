package cn.rabbithouse.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import cn.rabbithouse.dao.impl.BlogContentDaoImpl;
import cn.rabbithouse.domain.BlogContent;

public class BlogServiceImpl {

	public void addBlog(BlogContent bc) throws Exception {
		BlogContentDaoImpl bcd = new BlogContentDaoImpl();
		bcd.inserBlogContent(bc);
	}

	public ArrayList<BlogContent> selectAllBlogContent() throws Exception {
		BlogContentDaoImpl bcd = new BlogContentDaoImpl();
		return bcd.selectAllBlogContent();
	}

	public ArrayList<BlogContent> getArticleById(BlogContent bc) throws Exception {
		BlogContentDaoImpl bcd = new BlogContentDaoImpl();
		return bcd.getArticleById(bc);
	}

	public ArrayList<BlogContent> getArticleByPage(int currentpage, int num) throws SQLException {
		BlogContentDaoImpl bdc = new BlogContentDaoImpl();
		return bdc.getArticleByPages(currentpage,num);
	}

	public int getTotalArticlNum() throws SQLException {
		BlogContentDaoImpl bdc = new BlogContentDaoImpl();
		return bdc.getTotalArticleNum();
	}
}

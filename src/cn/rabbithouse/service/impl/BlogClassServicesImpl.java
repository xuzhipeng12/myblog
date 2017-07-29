package cn.rabbithouse.service.impl;

import java.util.ArrayList;

import cn.rabbithouse.dao.impl.BlogClassesDaoImpl;
import cn.rabbithouse.dao.impl.BlogContentDaoImpl;
import cn.rabbithouse.domain.ArticleOneLevelClass;
import cn.rabbithouse.domain.ArticleTwoLevelClass;
import cn.rabbithouse.domain.BlogContent;

public class BlogClassServicesImpl {

	public ArrayList<ArticleOneLevelClass> getOneLevelClass() throws Exception {
		BlogClassesDaoImpl bc = new BlogClassesDaoImpl();
		return bc.getOneLevelClass();
	}

	public ArrayList<BlogContent> getArticleByOneClass(BlogContent bc) throws Exception {
		BlogContentDaoImpl bcd  = new BlogContentDaoImpl();
		return bcd.getArticleByOneClass(bc);
	}

	public ArrayList<ArticleTwoLevelClass> getTwoLevelByOneLevel(ArticleOneLevelClass aolc) throws Exception {
		BlogClassesDaoImpl bcd = new BlogClassesDaoImpl();
		return bcd.getTwoLevelClassByOneClass(aolc);
	}

	public ArrayList<ArticleTwoLevelClass> getTwoLevelClass() throws Exception {
		BlogClassesDaoImpl bcd = new BlogClassesDaoImpl();
		return bcd.getTwoLevelClass();
	}

	public ArrayList<BlogContent> getArticleByTwoClass(BlogContent bc) throws Exception {
		BlogContentDaoImpl bcd  = new BlogContentDaoImpl();
		return bcd.getArticleByTwoClass(bc);
	}



}

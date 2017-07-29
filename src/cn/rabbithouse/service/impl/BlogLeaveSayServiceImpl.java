package cn.rabbithouse.service.impl;

import java.util.ArrayList;

import cn.rabbithouse.dao.impl.ArticleLeaveSayDoaImpl;
import cn.rabbithouse.domain.BlogContent;
import cn.rabbithouse.domain.LeaveSay;

public class BlogLeaveSayServiceImpl {
	public void addLeaveSay(LeaveSay ls) throws Exception {
		ArticleLeaveSayDoaImpl als = new ArticleLeaveSayDoaImpl();
		als.insertLeaveSay(ls);
	}
	public ArrayList<LeaveSay> getLeaveSayByArtId(BlogContent bc) throws Exception {
		ArticleLeaveSayDoaImpl als = new ArticleLeaveSayDoaImpl();
		return als.getLeaveSayById(bc);
	}
}

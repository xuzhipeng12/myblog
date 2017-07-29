package cn.rabbithouse.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.rabbithouse.dbutils.C3P0Utils;
import cn.rabbithouse.dbutils.ConnectionPool;
import cn.rabbithouse.domain.BlogContent;
import cn.rabbithouse.domain.LeaveSay;

public class ArticleLeaveSayDoaImpl{
	public void insertLeaveSay(LeaveSay ls) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		qr.update("INSERT INTO leave_say(levId,artId,message,leaveDate,whoLeave) VALUES(null,?,?,?,?)",ls.getArtId(),ls.getMessage(),ls.getLeaveDate(),ls.getWhoLeave())	;
	}
	public ArrayList<LeaveSay> getLeaveSayById(BlogContent bc) throws SQLException {
		ArrayList<LeaveSay> list = new ArrayList<>();
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		list = (ArrayList<LeaveSay>) qr.query("SELECT * FROM leave_say WHERE artId=?",new BeanListHandler<LeaveSay>(LeaveSay.class),bc.getArtId());
		return list;
	}
}

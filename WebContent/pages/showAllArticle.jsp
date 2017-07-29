<%@page import="cn.rabbithouse.service.impl.BlogServiceImpl"%>
<%@page import="cn.rabbithouse.domain.BlogContent"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/contentstyle.css">
</head>
<body>
	<%
		BlogServiceImpl bservice= new BlogServiceImpl();
		ArrayList<BlogContent> articles = null;
		try {
			articles = bservice.selectAllBlogContent();
			request.setAttribute("articles", articles);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("articles", articles);
	%>
	<table>
	<c:forEach items="${articles}" var="bc" varStatus="i">
		<tr><td>
		<div class="article">
		<h2><a href="${pageContext.request.contextPath}/ShowArticle?id=${bc.id}"rel="bookmark" title="${bc.blogHead }">${bc.blogHead }</a></h2>
		<div class="thumbnail_box">
		<!-- 截图 -->
		<div class="thumbnail">
			<!-- 图片 -->
			<a href="${pageContext.request.contextPath}/ShowArticle?id=${bc.id}" rel="bookmark" title="${bc.blogHead }">
			<img ${bc.imgUrl} class="attachment-thumbnail size-thumbnail wp-post-image" alt="摘要" width="130px"height="130px"></a>
		</div></div>    	
		<!-- 文章概要 -->		
		<div class="entry_post"><span>${bc.abstruct}</span></div>
		<div class="clear"></div>
		<div class="info">发布：${bc.writeDate} | 分类：<a href="http://www.laozuo.org/vps" rel="category tag"><c:if test="${empty bc.twoLevelClass}">${bc.oneLevelClass}</c:if>${bc.twoLevelClass}</a> | 所属分类：<a href="http://www.laozuo.org/tag/hostdare" rel="tag">${bc.totalClass }</a>, <a href="http://www.laozuo.org/tag/hostdare-vps" rel="tag">${bc.oneLevelClass}</a></div><div class="comments_num"></div>
		</div>
		</td></tr>
	</c:forEach>
	</table>
</body>
</html>
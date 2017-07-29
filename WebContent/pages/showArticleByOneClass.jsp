<%@page import="cn.rabbithouse.domain.BlogContent"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>许志鹏的博客-XuzhipengHome</title>
<meta http-equiv="keywords" content="许志鹏,rabbithouse,xuzhipeng">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/centerleftstyle.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/contentstyle.css">

<style type="text/css">

</style>
</head>

<body>
	<!-- top div -->
	<%@include file="/pages/topdiv.jsp"%>
	<!--中间文章区域div-->
	<div id="center_all">
	<div id=center>
		<!-- 左侧导航区 -->
		<%@include file="/pages/centerleft.jsp" %>
		<!-- 中间文章区域 -->
		<div id="center-center"  style="float:left; margin-left: 12%;">
			<table>
				<c:forEach items="${articles}" var="bc" varStatus="i">
					<tr><td>
					<div class="article">
					<h2><a href="${pageContext.request.contextPath}/servlet/showArticle?id=${bc.artId}"rel="bookmark" title="${bc.blogHead }">${bc.blogHead }</a></h2>
					<div class="thumbnail_box">
					<!-- 缩略图  -->
					<div class="thumbnail">
						<!-- 图片 -->
						<a href="${pageContext.request.contextPath}/servlet/showArticle?id=${bc.artId}" rel="bookmark" title="${bc.blogHead }">
						<img ${bc.imgUrl} class="attachment-thumbnail size-thumbnail wp-post-image" alt="摘要" width="115px"height="115px"></a>
					</div></div>    	
					<!-- 文章概要 -->		
					<div class="entry_post"><span>${bc.abstruct}</span></div>
					<div class="clear"></div>
					<div class="info">发布：${bc.writeDate} | 分类：<a href="http://www.laozuo.org/vps" rel="category tag"><c:if test="${empty bc.twoLevelClass}">${bc.oneLevelClass}</c:if>${bc.twoLevelClass}</a> | 所属分类：<a href="http://www.laozuo.org/tag/hostdare" rel="tag">${bc.totalClass }</a> > <a href="http://www.laozuo.org/tag/hostdare-vps" rel="tag">${bc.oneLevelClass}</a></div><div class="comments_num"></div>
					</div>
					</td></tr>
				</c:forEach>
			</table>
		</div>
		<!-- 右侧待定 -->
		<div id="center-right"></div>
	</div>
	</div>
</body>
</html>
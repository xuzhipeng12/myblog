<!--  
　　　　　　　　　　　　　　　 　 _,,..--─-- ､..、 
　　　　　　　　　　　　　　　,.‐'"　 　　　　　　｀`'､ 
　　　　　　　　　　　　　　,.´　　　　　　　　 　　　 ヽ. 
　　　　　　　　　 　 　　 /　　　　　　　　　　　 　 　 i. 
　　　　　　　　　　　 　 i´　　　　　 　 　 　　　　　 　.| 
　　　　　　　　　　　　　ｌ　　　　　　　　　　　　● 　ノ`-､__ .、 
　　　　　　　　　　　　∧,,∧　　　　　　　　　　 　／＿_,,.．-ﾉ 
　　　　　　　　　　　　(´･ω･)　　　　　　　　　　＼,.．-ｰ''´ 
　　　i⌒'‐.､ _　　　　（　　つ;;;;;,,,,....　　　......,,,,,;;;;ノ 
　　　|　 　　　｀` ‐---｀Ｊ‐'　 　　　　　　　　　　`ヽ、 
　　　|　 　 　 　 　γ'‐-､..,,_　　　　 _,,.;-''"´｀ヽ 　　.i、 
　　　.l　　　　　　　ゝ　 　　 ￣￣￣　　　　　　｝　　 i. 
　　　 .i、 　 　 　 　ゝ｀‐　　　　　　　　　　　　ﾉ　　　,ｉ 
　　　　i、::..　　 　 　｀､　.....　　　　　 　　..::::,,'"　　　.,! 
　　　　 ヽ::::....　 　　　｀`'ー-､..,,_;;;;;;;;;;;;;;．''"　　 ...:::/ 
　　　　　 `:､;;;:::......　　　　　　　　　　　　　　....:::;;;／ 
　 　 　 　 　 ＼;;;;;;;;::::::::..............................::::::::;;;;;;;;ノ'

-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>许志鹏的博客-XuzhipengHome</title>
<meta http-equiv="keywords" content="许志鹏,rabbithouse,xuzhipeng">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/contentstyle.css">
<style>
#pages{
	margin-top: 10px;
	margin-bottom:30px;
	text-align: right;
	float:right;
}
#pages a{
 	color: #0088dd;
	text-decoration: none;
	font-size: 15px;
	border: 1px solid #d0d0d0;
 }
 #pages a:HOVER {
	border: 1px solid #0088dd;
}

</style>

</head>
<body>
	<!-- top div -->
	<%@include file="/pages/topdiv.jsp"%>
	<!--中间文章区域div-->
	<div id="center_all">
		<div id=center>
			<!-- 中间左边文章分类区 -->
			<!-- 左侧导航区域 -->
			<%@include file="/pages/centerleft.jsp" %>
			<!-- 中间文章区域 -->
			<div id="center-center" style="float:left; margin-left: 15%;">
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
							<img ${bc.imgUrl} class="attachment-thumbnail size-thumbnail wp-post-image" alt="摘要" width="110px" width="110px"></a>
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
			<!-- 分页显示-->
			<div id="pages">
				<a id="first" href="${pageContext.request.contextPath}/servlet/listArticles?page=1" style="visibility: ${currentpage==1? 'hidden':'visible'}">首页</a>
				<a id="previous" href="${pageContext.request.contextPath}/servlet/listArticles?page=${currentpage-1}" style="visibility: ${currentpage==1? 'hidden':'visible'}">&lt;&lt;上一页</a>
				<c:forEach begin="1" end="${totalpages}" varStatus="bc">
					<a href="${pageContext.request.contextPath}/servlet/listArticles?page=${bc.index}">${bc.index}</a>
				</c:forEach>
				<a id="next" href="${pageContext.request.contextPath}/servlet/listArticles?page=${currentpage+1}">下一页 &gt;&gt;</a>
				<a id="last" href="${pageContext.request.contextPath}/servlet/listArticles?page=${totalpages}">最后</a>
			</div>
			<!-- 右侧待定 -->
			<div id="center-right"></div>
		</div>
	</div>
</body>
</html>
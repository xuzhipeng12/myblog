<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/topstyle.css">
<div id="top">
	<div id="top-left">
		<a href="${pageContext.request.contextPath}/index.jsp">Xuzhipeng</a> <br /> <span>天下大事莫不做细，天下难事莫不做易</span>
	</div>
	<div id="top-right">
		<a class="lba" href="${pageContext.request.contextPath}/index.jsp">首页</a> <a class="lba"
			href="${pageContext.request.contextPath}/pages/about.jsp">关于我</a> <a class="lba"
			href="${pageContext.request.contextPath}/pages/building.html">技术专区</a> <a class="lba"
			href="${pageContext.request.contextPath}/pages/building.html">生活</a> <a class="lba"
			href="${pageContext.request.contextPath}/pages/building.html">留言板</a> &nbsp; <span
			style="font-size: 20px"> <a class="lba" id="login"
			href="${pageContext.request.contextPath}/pages/login.jsp" ${empty usrname ? "":"hidden"}>登陆</a> <c:if
				test="${usrname != null}">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> ${usrname } <b class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li><a href="#">查看资料</a></li>
							<li><a href="#">EJB</a></li>
							<li class="divider"></li>
							<li><a href="${pageContext.request.contextPath}/pages/myeditor.jsp">写博客</a></li>
							<li class="divider"></li>
						</ul></li>
				</ul>
				    	|<a href="${pageContext.request.contextPath}/servlet/logOut">注销</a>
			</c:if>
		</span>
	</div>
	<div class="clearfloat"></div>
	<div id="show">
		<img alt="show" src="${pageContext.request.contextPath}/images/top-banner.jpeg">
	</div>
</div>
<div id="clear"></div>
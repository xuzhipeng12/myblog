<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/centerleftstyle.css">
<div id="center-left">
    <aside class="NavSidebar">
      <nav>
        <h2>文章分类</h2>
        <ul>
          <c:forEach items="${oneLevelClass}" var="oc">
          	<li><a href="${pageContext.request.contextPath}/servlet/showArticleByOneLevelClass?olc=${oc.oneLevelClass}">${oc.oneLevelClass}</a></li>
	          	<ul style="list-style:square;">
	          	<c:forEach items="${twoLevelClass}" var="tc">
	          		<c:if test="${tc.oneLevelId == oc.oneLevelId}">
	          		 <li><a href="${pageContext.request.contextPath}/servlet/showArticleByTwoLevelClass?tlc=${tc.twoLevelClass}">${tc.twoLevelClass}</a></li>
	          		</c:if>
	          	</c:forEach>
	          	</ul>
          </c:forEach>
        </ul>
      </nav>
      <nav>
        <h2>日期</h2>
        <%@include file="/pages/calender.html" %>
      </nav>
    </aside>
</div>
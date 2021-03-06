<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/manage/header.jsp"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://cdn.bootcss.com/jquery/3.3.1/core.js"></script>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.slim.min.js"></script>
<script src="https://cdn.bootcss.com/require.js/2.3.5/require.min.js"></script>
<link href="https://cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.min.css"
	rel="stylesheet">
<script src="https://cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.min.js"></script>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	rel="stylesheet">
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>所有分类</title>
</head>

<body>
	<div class="jumbotron">
		<div class="container">
			<h3>分类列表</h3>
			<c:if test="${empty listCategories }">
				<h4>无数据，添加数据</h4>
			</c:if>
		</div>


		<c:if test="${!empty listCategories }">
			<table class="table table-hover">
				<tr>
					<td>序号</td>
					<td>分类名称</td>
					<td>描述</td>
					<td>操作</td>
				</tr>
				<tr>
					<c:forEach items="${listCategories }" var="cs" varStatus="vs">
						<tr>
							<td>${vs.count }</td>
							<td>${cs.name }</td>
							<td>${cs.description }</td>
							<td><a class="btn btn-warning"
								href="${pageContext.request.contextPath }/manage/ManageServlet?op=delCategoryById&id=${cs.name }">删除</a>
								<a class="btn btn-info"
								href="${pageContext.request.contextPath }/manage/updateCategory.jsp?id=${cs.id }&name=${cs.name}&description=${cs.description}">修改</a>
							</td>
						</tr>
					</c:forEach>
				</tr>
			</table>
		</c:if>
	</div>
</body>

</html>
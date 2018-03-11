<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<title>后台管理系统</title>
</head>

<body>

	<div class="jumbotron">
		<div class="container">
			<h3>欢迎使用后台管理系统</h3>
			<p class="text-center">
				<img src="../img/pcdongtai_b60a4b2d8e0d0d6392de47d4cec6fdc3.gif" />
			</p>
			<p>
				<a class="btn btn-primary btn-lg"
					href="${pageContext.request.contextPath }/manage/addCategory.jsp">添加分类</a>
				<a class="btn btn-primary btn-lg"
					href="${pageContext.request.contextPath }/manage/ManageServlet?op=listCategory">查询分类</a>
				<a class="btn btn-primary btn-lg"
					href="${pageContext.request.contextPath }/manage/addProduct.jsp">添加商品</a>
				<a class="btn btn-primary btn-lg"
					href="${pageContext.request.contextPath }/manage/ManageServlet?op=listProduct">查询商品</a>
				<a class="btn btn-primary btn-lg"
					href="${pageContext.request.contextPath }/manage/ManageServlet?op=findCart">订单查询</a>
				<a class="btn btn-primary btn-lg" href="http://www.baidu.com"
					role="button" target="_blank">了解更多</a>
			</p>
		</div>
	</div>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://cdn.bootcss.com/holder/2.8.2/holder.min.js"></script>
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
					href="${pageContext.request.contextPath }/manage/ManageServlet?op=listCategories">查询分类</a>
				<a class="btn btn-primary btn-lg"
					href="${pageContext.request.contextPath }/manage/addProduct.jsp">添加商品</a>
				<a class="btn btn-primary btn-lg"
					href="${pageContext.request.contextPath }/manage/ManageServlet?op=listProducts">查询商品</a>
				<a class="btn btn-primary btn-lg"
					href="${pageContext.request.contextPath }/manage/ManageServlet?op=findCart">订单查询</a>
				<a class="btn btn-primary btn-lg" href="http://www.baidu.com"
					role="button" target="_blank">了解更多</a>
			</p>
		</div>
	</div>

	<footer> <!--导入网页底部-->
	<div class="navbar-fixed-bottom">
		<embed type="text/html" src="../base-web/foot.html">
		</embed>
	</div>

	<!-- <div class="navbar navbar-default navbar-fixed-bottom">
			<div class="container text-center">&copy;版权所有</div>
		</div> --> </footer>
</body>

</html>
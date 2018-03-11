<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base-web/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>跳转页</title>
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
</head>
<body>
	<br>

	<div class="jumbotron">
		<div class="container">
			<p class="text-center">
				<img src="../img/pcdongtai_b60a4b2d8e0d0d6392de47d4cec6fdc3.gif" />
			</p>
			<p class="text-center">
			<h3>${message }</h3>
			</p>
			<p>
				<a class="btn btn-primary btn-lg"
					href="${pageContext.request.contextPath }/shopping/shopping-index.html"
					role="button" target="_self">购物首页</a> <a
					class="btn btn-primary btn-lg"
					href="${pageContext.request.contextPath }/shopping/CartServlet?op=listCarts"
					role="button" target="_self">购物车</a> <a
					class="btn btn-primary btn-lg" href="http://www.baidu.com"
					role="button" target="_self">了解更多</a>
			</p>
		</div>
	</div>



</body>
</html>
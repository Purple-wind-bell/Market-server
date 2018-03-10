<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
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
<style type="text/css">
nav div div ul li ul {
	width: 450px;
	height: auto;
}
</style>

</head>

<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Collect the nav links, forms, and other content for toggling -->

		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="../index.html" target="_blank">首页</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<form class="navbar-form navbar-left"
				action="https://www.baidu.com/s" target="_blank">
				<div class="form-group">
					<input type="text" class="form-control" name="wd" placeholder="搜索">
				</div>
				<button type="submit" class="btn btn-default">搜索</button>
			</form>

			<ul class="nav navbar-nav navbar-right">
				<li>
					<!--用户名显示  -->
					 <c:if test="${empty cookie.username.value }">
						<a href="${pageContext.request.contextPath }/login.html"
							target="_blank"></a>
					</c:if> <c:if test="${!empty cookie.username.value }">
						${cookie.username.value }
					</c:if>
				</li>
				<li><a href="${pageContext.request.contextPath }/regist.html"
					target="_blank">注册</a></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">用户服务 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="col-sm-3"><a href="#" target="_blank">消息</a></li>
						<li class="col-sm-3"><a
							href="${pageContext.request.contextPath }/shopping/CartServlet?op=listCarts"
							target="_blank">购物车</a></li>
						<li class="col-sm-3"><a href="${pageContext.request.contextPath }/usermanage/usermanage.html"
							target="_blank">个人设置</a></li>
						<li class="col-sm-3"><a
							href="${pageContext.request.contextPath }/manage" target="_blank">后台管理</a></li>
						<li class="col-sm-3"><a
							href="${pageContext.request.contextPath }/user/LoginRegistServlet?op=logout">注销</a></li>
						<li class="col-sm-3"><a href="#" target="_blank">帮助</a></li>
					</ul></li>
				<li><a href="mailto:market@qq.com" target="_blank">联系我们</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

</body>

</html>
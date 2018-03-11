<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
<html>

<head>
<meta charset="utf-8">
<title>添加商品</title>
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
<link rel="stylesheet" type="text/css" href="css/base-web.css" />
</head>

<body>
	<header>
		<!--导入导航栏-->
	</header>

	<form
		action="${pageContext.request.contextPath }/manage/ManageServlet?op=addProduct"
		method="post">
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">商品名称:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control input-text-short" name="name"
					id="name" placeholder="名称">
			</div>
		</div>

		<div class="form-group">
			<label for="price" class="col-sm-2 control-label">价格:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control input-text-middle"
					name="price" id="price" placeholder="价格">
			</div>
		</div>

		<div class="form-group">
			<label for="category" class="col-sm-2 control-label">分类:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control input-text-middle"
					name="category" id="category" placeholder="分类">
			</div>
		</div>

		<div class="form-group">
			<label for="description" class="col-sm-2 control-label">描述:</label>
			<div class="col-sm-10">
				<textarea class="form-control input-text-middle" cols="40" rows="3"
					name="description" id="description" placeholder="描述"></textarea>
			</div>
		</div>

		<div class="form-group">
			<label for="file" class="col-sm-2 control-label">图片:</label>
			<div class="col-sm-10">
				<input type="file" class="form-control input-text-middle"
					name="file" id="file">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-success ">提交</button>
				<button type="reset" class="btn btn-primary ">重置</button>
			</div>
		</div>
	</form>

	<footer>
		<!-- <div class="navbar navbar-default navbar-static-bottom">
			<div class="container text-center">&copy;版权所有</div>
		</div> -->
	</footer>
</body>

</html>
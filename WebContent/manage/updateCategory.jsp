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
<title>修改分类</title>
</head>

<body>
	<form
		action="${pageContext.request.contextPath }/manage/ManageServlet?op=updateCategoryById"
		method="post">
		<input type="hidden" id="id" name="id" value="${param.id }">
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">分类的名称:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control input-text-middle"
					name="name" id="name" placeholder="${param.name }">
			</div>
		</div>
		<div class="form-group ">
			<label for="description " class="col-sm-2 control-label ">分类描述:</label>
			<div class="col-sm-10 ">
				<textarea class="form-control input-text-middle " cols="40 "
					rows="3 " name="description" id="description"
					placeholder="${param.description }"></textarea>
			</div>
		</div>

		<div class="form-group ">
			<div class="col-sm-offset-2 col-sm-10 ">
				<button type="submit" class="btn btn-success ">提交</button>
				<button type="reset" class="btn btn-primary ">重置</button>
			</div>
		</div>
	</form>



</body>

</html>
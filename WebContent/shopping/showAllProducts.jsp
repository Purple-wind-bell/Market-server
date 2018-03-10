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
<title>商品列表</title>
</head>

<body>



	<div class="container-fluid text-center">
		<div class="row">
			<div class="col-sm-4 col-md-3 cos-lg-2">
				<img src="../img/show-img/logo.jpg" />
			</div>

			<c:if test="${empty listProducts }">
				<h4>没有商品信息</h4>
				<div class="col-sm-6 col-md-4 cos-lg-3">
					<img src="../img/show-img/lb01.jpg" />
				</div>
			</c:if>
			<c:if test="${!empty listProducts }">
				<c:forEach items="${listProducts }" var="cs" varStatus="vs">
					<div class="col-sm-4 col-md-3 cos-lg-2">
						<dl>
							<dt>${cs.name }</dt>
							<dd>
								<img src="../img/show-img/logo.jpg" />
							</dd>
							<dd>价格：${cs.price }</dd>

							<dd>
								<a class="btn btn-sussess"
									href="${pageContext.request.contextPath }/shopping/CartServlet?op=addToCart&productId=${cs.id }&quantity=1"
									target="_blank">添加购物车</a>
							</dd>
						</dl>
					</div>
				</c:forEach>
			</c:if>
		</div>
	</div>


	<footer>
		<!--导入网页底部-->
		<!--<div class="navbar-fixed-bottom">
				<embed type="text/html" src="./base-web/foot.html">
				</embed>
			</div>-->

		<div class="navbar navbar-default navbar-fixed-bottom">
			<div class="container text-center">&copy;版权所有</div>
		</div>
	</footer>
</body>

</html>
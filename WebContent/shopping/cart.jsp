<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base-web/head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<script type="text/javascript">
	function dellAllItems() {
		var sure = window.confirm("确定要清空购物车吗？");
		if (sure) {
			window.location.href = "${pageContext.request.contextPath}/shopping/CartServlet?op=delAllCarts";
		}
	}

	function delOneItem(productId) {
		var sure = window.confirm("确定要删除该商品吗？");
		if (sure) {
			window.location.href = "${pageContext.request.contextPath}/shopping/CartServlet?op=delCart&productId="
					+ productId;
		}
	}

	function changeNum(quantityInputObj, productId, oldNum) {
		var num = quantityInputObj.value;
		//验证：数量必须是整数
		if (!/^[1-9][0-9]*/.test(num)) {
			alert("请输入数量");
			return;
		}
		var sure = window.confirm("确认要把数量改为" + num + "么？");
		if (sure) {
			//提交到服务器，修改数量
			window.location.href = "${pageContext.request.contextPath}/shopping/CartServlet?op=editCart&productId="
					+ productId + "&quantity=" + num;
		} else {
			//恢复原来的数量
			quantityInputObj.value = oldNum;
		}
	}
</script>

<title>购物车</title>
</head>


<body>
	<div class="jumbotron">
		<div class="container">
			<h3>购物车详情</h3>

			<c:if test="${empty carts}">
				<h4>您还没有购买任何商品</h4>
				<a
					href="${pageContext.request.contextPath}/shopping/shopping-index.html">去购买</a>
			</c:if>
			<c:if test="${!empty carts}">
				<h4>您购买的商品如下:</h4>
				<a href="javascript:dellAllCarts()">清空购物车</a>
				<table class="table table-hover">
					<tr>
						<th>商品名称</th>
						<th>单价</th>
						<th>数量</th>
						<th>小计</th>
						<th>操作</th>
					</tr>
					<tr>
						<c:forEach items="${carts }" var="item" varStatus="vs">
							<tr>
								<td><img alt=""
									src="${pageContext.request.contextPath}/img/${item.product.path}/${item.product.filename}"></td>
								<td>${item.product.price}</td>
								<!--CartItem books  -->
								<td><input type="text" id="quantity"
									value="${item.quantity}" size="3"
									onchange="changeNum(this,${item.product.id},${item.quantity})" />
									<!-- 	购物车页面数量发生变更 --></td>
								<td>${item.subprice}</td>
								<td><a class="btn btn-warning"
									href="javascript:delOneItem('${item.product.id}')">删除</a></td>
							</tr>
						</c:forEach>
					</tr>
				</table>

				<td colspan="5">
					总价：${totalPrice}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
					href="${pageContext.request.contextPath}/shopping/SettleServlet?op=genOrder">去结算</a>
				</td>
			</c:if>
		</div>
	</div>
</body>

</html>
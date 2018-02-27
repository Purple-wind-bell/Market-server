//刷新验证码
function refresh() {
	var codeimg = document.getElementById("imgCode");
	codeimg.src = "CaptchServlet?time=" + Math.random();
}

//获取邮箱验证码
function getEmailCode() {
	var emailCode = document.getElementById("getEmail");
	var user = document.getElementById("username");
	emailCode.src = "EmailCodeServlet?username=" + user.value;
}
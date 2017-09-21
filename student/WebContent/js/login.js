function checkLogin(){
	var flag=true;
	if ($("#uname").val()==""){
		$("#msg").html("用户名不能为空！");
		flag = false;
		return;
	}
	if ($("#pwd").val()==""){
		$("#msg").html("密码不能为空！");
		flag = false;
		return;
	}if(flag){
		$("#loginForm").submit();
	}
	return;
}
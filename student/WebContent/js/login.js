function checkLogin(){
	var flag=true;
	if ($("#UserName").val()==""){
		$("#Msg").html("用户名不能为空！");
		flag = false;
		return;
	}
	if ($("#UserPwd").val()==""){
		$("#Msg").html("密码不能为空！");
		flag = false;
		return;
	}if(flag){
		$("#loginForm").submit();
	}
	return;
}
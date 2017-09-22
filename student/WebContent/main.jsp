<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#query").on("click",function(){
			var name=$("input[name='queryName']").val();
			var sex=$("input[name='sex']:checked").val();
			var url="student?act=query&studentName="+name+"&sex="+sex;
			window.location.href=url;
		});
	});

</script>
</head>
<body>
	<h1>学生列表</h1>
	<a href="http://localhost:8080/student/user?option=logout">退出</a>
	<hr>query:<br>
	姓名:<input type="text" name="queryName" value="${studentName }"/>&nbsp;&nbsp;
	性别:<input type="radio" ${sex==1?'checked':'' } name="sex" value="1"/>男
	<input type="radio" ${sex==0?'checked':'' } name="sex" value="0"/>女
	<input type="radio" ${sex==2?'checked':'' } name="sex" value="2" checked/>全部
	<a id="query" >查询</a>
	<div>
		<a href="add.jsp">添加学生信息</a>
	</div>
	<table border="1">
		<thead>
			<tr>
				<th>序号</th>
				<th>学号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>年级</th>
				<th>性别</th>
				<th>出生日期</th>
				<th>创建时间</th>
				<th>修改时间</th>
				<th colspan="2">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list }" var="stu" varStatus="status">
				<tr>
					<td>${status.index+1 }</td>
					<td>${stu.studentId }</td>
					<td>${stu.studentName }</td>
					<td>${stu.age }</td>
					<td>${stu.grade }</td>
					<td><c:if test="${stu.sex==1 }">男</c:if>
					
					<c:if test="${stu.sex==0 }">女</c:if>
					</td>
					
					<td>${stu.createDate }</td>
					<td>${stu.updateDate }</td>
					<td><a href="student?act=showStu&studentId=${stu.studentId  }">修改</a></td>
					<td><a href="student?act=delete&studentId=${stu.studentId  }">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:set var="page" value="${page }"></c:set>
	  共有:${page.totalRecord }个学生,共:${page.totalPage }页,当前页:${page.currentPage  }页<br/>
	 <select name="pageSize">
	 	<option value="2">2</option>
	 	<option value="5">5</option>
	 	<option value="10">10</option>
	 </select>
	 <a href="student?currentPage=1">首页</a>
	 <c:if test="${page.currentPage >1 }">
		<a href="student?currentPage=${page.currentPage -1 }">上一页</a>
	 </c:if>
	 ${page.currentPage }
	 <c:if test="${page.currentPage <page.totalPage }">
		<a href="student?currentPage=${page.currentPage +1 }">下一页</a>
	 </c:if>
	 <a href="student?currentPage=${page.totalPage}">尾页</a>
</body>
</html>
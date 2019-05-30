
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>学生信息页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/main.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

</script>
</head>

<body class="sd">
	<div class="sd-l">
		<div class="sd-l-top">
			<img src="image/user.jpg" width="100" height="100"><font color="white" size="3">管理员</font>
		</div>
		<div class="sd-l-list">
			<li class="sd-list-li on"><span class="sd-list-title"><i
					class="icon-sz"></i>系统管理<i class="icon-fx"></i></span>
				<ul>
					<li><a href="pages/add.jsp"><i class="icon-add"></i>添加学员</a></li>
					<li><a href="SelectServlet"><i class="icon-list"></i>学员列表</a></li>
				</ul></li>
		</div>
	</div>
	<div class="sd-r">
		<a class="sd-r-box" href=""></a>
		<div class="sd-r-top"></div>
		<div class="sd-r-bottom">
			<div class="sd-r-title">学员列表</div>

			<div class="sd-box-opt">
				<div class="sd-opt-l fl">
					<a href="pages/add.jsp"><span class="opt-add"></span></a> <span
						class="opt-del"></span>
				</div>
				<form action="like_servlet" method="get">
					<div class="sd-opt-r fr">
						
						   <input type="text" placeholder="根据姓名模糊搜索" name="searchName"> 
						   <input type="submit" value="搜索">						
						
					</div>
				</form>
			</div>
			<div class="sd-box-center">
				<table>
					<thead>
						<tr>
							<!-- <th><input type="checkbox"></th> -->
							<th>学生编号</th>
							<th>学生姓名</th>
							<th>学生性别</th>
							<th>学生年龄</th>
							<th>学生电话</th>
							<th>学生地址</th>
							<th>编辑</th>
							<th>删除</th>
						</tr>
					</thead>
					<tbody id="tbody">
					<c:forEach items="${StudentList }" var="s">
							<tr>
								
								<!-- <td><input type="checkbox"></td> -->
								<td>${s.id }</td>
								<td>${s.name }</td>
								<td>${s.sex }</td>
								<td>${s.age }</td>
								<td>${s.phone }</td>
								<td>${s.address }</td>
								<td>
									<%-- <form action="edit_servlet" method="post">
										<input type="hidden" name="id" value=${s.id } />
									 	<input type="submit" value="编辑">
									</form> --%>
									<a href="delete_servlet?id=${s.id }" onclick="return confirm('确认删除吗')">删除</a>
								  
								</td> 
								<td>
									<%-- <form action="delete_servlet" method="post">
										<input type="hidden" name="id" value=${s.id } />
										<input type="submit" value="删除">
									</form> --%>
									 <a href="edit_servlet?id=${s.id }">修改</a></td>
								</td> 
								
							</tr>
							</c:forEach>
					</tbody>
				</table>
				<div class="studio-table-page">
					<a href="SelectServlet?pageNum=${pageNum==1?1:pageNum-1 }">上一页</a>
					<c:forEach begin="1" end="${count }" step="1" varStatus="sta">
						<a href="SelectServlet?pageNum=${sta.count }">${sta.count }</a>
					</c:forEach>
					<a href="SelectServlet?pageNum=${pageNum+1>count?pageNum:pageNum+1 }">下一页</a>
				</div>
			</div>
		</div>

		<script src="js/jquery-3.2.1.min.js"></script>
		<script>
			$(".icon-fx").on('click',function(){
				$(".sd-list-li ul").toggle();
				$(this).toggleClass("on");
			})
		</script>
</body>
</html>

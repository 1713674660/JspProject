<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>修改学生信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/main.css">

<script type="text/javascript">
	/* function telblur() {
		var tel = $("#phone").val();
		var patrn = /^1[358]\d{9}$/;
		var s = document.getElementById("Tel");
		if (!patrn.exec(tel)) {
			s.innerHTML = "<font color='red' size='2'>电话号码格式错误 <font>";
		} else {
			s.innerHTML = "";
		}
	}

	function ageblur() {
		var age = $("#age").val();
		var patrn = /^[0-9]{1,2}$/;
		var a = document.getElementById("a");
		if (!patrn.exec(age)) {
			a.innerHTML = "<font color='red' size='2'>年龄格式错误 <font>";
		} else {
			a.innerHTML = "";
		}
	} */

	function test() {
		var url = "SelectServlet";
		window.location.href = url;
	}
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
					<li class="on"><a href="pages/add.jsp"><i class="icon-add"></i>添加学员</a>
					</li>
					<li><a href="SelectServlet"><i class="icon-list"></i>学员列表</a></li>
				</ul></li>
		</div>
	</div>
	<div class="sd-r">
		<div class="sd-r-top"></div>
		<div class="sd-r-bottom">
			<div class="sd-r-title">修改学员</div>
			<div class="sd-r-box">
				<div class="sd-center-add">
					<form action="update_servlet" method="POST">
						<li><label>学生编号：</label> <input type="text" placeholder=""
							name="id" value="${student.id }" readonly="readonly"><font color='red' size='2'>只读 <font></li>
						<li><label>学生姓名：</label> <input type="text" placeholder=""
							name="name" value="${student.name }" readonly="readonly"><font color='red' size='2'>只读<font></li>
						<li><label>学生密码：</label> <input type="text" placeholder="" value="${student.password }"
							name="password" pattern="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$" required="required"></li>
						<li><label>学生性别：</label> 
							 <input style="height:15px;weight:15px; margin:-70px"  type="radio" value="${student.sex }" name="sex" checked="checked"/>${student.sex }
						       <input style="height:15px;weight:15px; margin:-70px" type="radio" value="${student.sex=='男'?'女':'男' }" name="sex" />${student.sex=='男'?'女':'男' }
						</li>

						<li><label>学生年龄：</label> <input type="text" id="a" placeholder=""
							name="age" value="${student.age }" required="required" pattern="^(?:[1-9][0-9]?|1[01][0-9]|120)$"></li>
						<li><label>学生地址：</label> <input type="text" placeholder=""
							name="address" value="${student.address }" required="required"></li>
						<li><label>学生电话：</label> <input type="text" id="Tel" placeholder=""
							name="phone" value="${student.phone }" required="required" pattern="^1[358]\d{9}$"></li> <input class="submit" type="submit" value="提交">
						<input class="submit" type="reset" name="reset" value="取消  "
							onclick="test()">
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery-3.2.1.min.js"></script>
	<script>
		$(".icon-fx").on('click', function() {
			$(".sd-list-li ul").toggle();
			$(this).toggleClass("on");
		})
	</script>
</body>
</html>

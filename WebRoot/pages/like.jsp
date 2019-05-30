<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
  <head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  </head>
  <body>
      
    <div class="jumbotron jumbotron-fluid bg-light">
        <div class="container">
            <h1 class="display-5">查询--信息列表</h1>
            <hr class="my-2">
            <p>姓名中含有 “<%=request.getParameter("searchName") %>” 的学生信息</p>
        </div>
    </div>
    <nav class="nav justify-content-center|justify-content-end">
        <a class="nav-link active" href="SelectServlet">返回学员列表</a>
    </nav>
    <table class="table">
        <thead>
            <tr>
            <th></th>
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
        <tbody>
            <c:forEach items="${StudentList }" var="s">
            	<tr>
            
                    <td>
                        
                    </td>
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
                        <a href="delete_servlet?do=likeQuery&searchName=${searchName }&pageNum=${count }&id=${s.id }" onclick="return confirm('确认删除吗')">删除</a>
                    </td>
                    <td>
                       <%--  <form action="delete_servlet" method="post">
                            <input type="hidden" name="id" value=${s.id } />
                            <input type="submit" value="删除">
                        </form> --%>
                         <a href="edit_servlet?id=${s.id }" onclick="return confirm('确认修改吗？修改后将返回学员列表')">修改</a></td>
                    </td>
            
                </tr>
            </c:forEach>
        </tbody>
    </table>
   <nav aria-label="Page navigation">
     <ul class="pagination">
       <li class="page-item">
         <a class="page-link" href="like_servlet?searchName=${searchName }&pageNum=${pageNum==1?1:pageNum-1 }" aria-label="Previous">
           <span aria-hidden="true">&laquo;</span>
           <span class="sr-only">Previous</span>
         </a>
       </li>
       <c:forEach begin="1" end="${count }" step="1" varStatus="sta">
       		<li class="page-item"><a class="page-link" href="like_servlet?searchName=${searchName }&pageNum=${sta.count }">${sta.count }</a></li>
       </c:forEach>
       
       <li class="page-item">
         <a class="page-link" href="like_servlet?searchName=${searchName }&pageNum=${pageNum+1>count?pageNum:pageNum+1 }" aria-label="Next">
           <span aria-hidden="true">&raquo;</span>
           <span class="sr-only">Next</span>
         </a>
       </li>
     </ul>
   </nav>
    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>
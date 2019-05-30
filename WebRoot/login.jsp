<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
      
    <div class="jumbotron">
        <dib class="container">
            <h1 class="display-5">学生信息管理系统</h1>
        </dib>
    </div>
    
    <div class="container-fluid">
      <div class="row">
        <div class="col-lg-3">
          <ul class="nav justify-content-center">
              <li class="nav-item">
                  <a class="nav-link active" href="#">Active link</a>
              </li>
              <li class="nav-item">
                  <a class="nav-link" href="#">Link</a>
              </li>
              <li class="nav-item">
                  <a class="nav-link disabled" href="#">Disabled link</a>
              </li>
          </ul>
        </div>

        <div class="col-lg-5">
          <form action="login_servlet" method="post">
            <div class="form-group">
              <label for="">用户名</label>
              <input type="text" name="name" id="" class="form-control" placeholder="用户名" aria-describedby="helpId" required="required">
            </div>
            <div class="form-group">
              <label for="">密码</label>
              <input type="password" name="password" id="" class="form-control" placeholder="密码" aria-describedby="helpId" required="required">
            </div>
            <button type="submit" class="btn btn-outline-primary">登录</button>
            
          </form>
          
          
          <!-- Modal -->
            <div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h4 class="modal-title" id="modelTitleId">林科大实训二班第二组--管理员注册</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                      <form action="create_servlet" method="post">
                      	<div class="form-group">
                        <label for="">用户名</label>
                        <input type="text" name="name2" id="" class="form-control" placeholder="" aria-describedby="helpId" required="required">
                      </div>
                      <div class="form-group">
                        <label for="">密码（6~16位数字或字母）</label>
                        <input type="password" name="password2" id="" class="form-control" placeholder="" aria-describedby="helpId" required="required">
                      </div>
                       <div class="form-group">
                        <label for="">确认密码</label>
                        <input type="password" name="password3" id="" class="form-control" placeholder="" aria-describedby="helpId" required="required">
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save</button>
                      </div>
                      </form>
                  </div>
                </div>
              </div>
            </div>
        </div>
             <%
            	String info3=(String)request.getAttribute("info3");
            	if(info3==null){
            		info3="";
            	}
             %>
        <div class="col-lg-4">
          <div class="jumbotron jumbotron-fluid">
            <div class="container">
             <button type="button" class="btn btn-outline-primary"  data-toggle="modal" data-target="#modelId">注册</button>
             
               <hr class="my-2">
              <p class="lead">
                <a class="btn btn-primary btn-lg" href="" role="button"><%=info3 %></a>
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>




    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>
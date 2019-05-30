package com.zhangchi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhangchi.Db.Db;
import com.zhangchi.model.User;

@WebServlet("/login_servlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter pw=resp.getWriter();
		
		//接收页面的参数
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		
		User user=new User();
		user.setName(name);
		user.setPassword(password);
		
//		if("".equals(name)||"".equals(password)){
//			pw.write("<script language='javascript'> alert('用户名或密码不能为空，请重新登录');window.document.location.href='login.jsp'   </script>");
//		}else{
			
			Db db=new Db();
			int num=db.loginSelect(user);
			if(num>0){
				req.getSession().setAttribute("filterName", name);
				resp.sendRedirect("SelectServlet");
			}else{
				pw.write("<script language='javascript'> alert('用户名或密码输入错误，请重新登录');window.document.location.href='login.jsp'   </script>");
			}
		}
		

	
}

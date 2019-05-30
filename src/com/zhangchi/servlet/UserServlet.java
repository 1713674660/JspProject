package com.zhangchi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhangchi.Db.Db;
import com.zhangchi.model.User;
 
@WebServlet("/create_servlet")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		//resp.setCharacterEncoding("utf-8");
		
		PrintWriter pw=resp.getWriter();
		//接收页面参数
		String name=req.getParameter("name2");
		String password=req.getParameter("password2");
		String password2=req.getParameter("password3");
		
		//创建对象
		User user=new User();
		user.setName(name);
		user.setPassword(password);
		
		Pattern p = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$");
		Matcher m = p.matcher(password);
		Boolean flag = m.matches();
		
		Db db=new Db();
//		if("".equals(name)||"".equals(password)||"".equals(password2)){
//			pw.write("<script language='javascript'>alert('用户名、密码和确认密码都不能为空');window.document.location.href='login.jsp'</script>");
//		}
//		else{
			if(flag==false){
				pw.write("<script language='javascript'>alert('密码为6~16位的数字加字母');window.document.location.href='login.jsp'</script>");
			}else{
				int num2=db.find(name,password);
				if(num2>0){
					pw.write("<script language='javascript'>alert('当前用户已存在');window.document.location.href='login.jsp'</script>");
				}else{
					if(password.equals(password2)){
						int num = db.insert(user);
						if(num>0){
							req.setAttribute("info3", "注册成功");
							req.getRequestDispatcher("login.jsp").forward(req,resp);
						}else{
							req.setAttribute("info3", "注册失败");
							req.getRequestDispatcher("login.jsp").forward(req,resp);
						}
					}else{
						pw.write("<script language='javascript'>alert('两次输入的密码不同');window.document.location.href='login.jsp'</script>");
					}
					
				}
			}

	}

	
}

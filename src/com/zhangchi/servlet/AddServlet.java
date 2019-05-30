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
import com.zhangchi.model.Student;

@WebServlet("/add_servlet")
public class AddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw=resp.getWriter();
		
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String sex=req.getParameter("sex");
		String address=req.getParameter("address");
		String phone=req.getParameter("phone");
		String age=req.getParameter("age");
//		
//		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
//		Matcher m = p.matcher(phone);
//		Boolean flag = m.matches();
//		
//		Pattern p2 = Pattern.compile("^(?:[1-9][0-9]?|1[01][0-9]|120)$");
//		Matcher m2 = p2.matcher(age);
//		Boolean flag2 = m2.matches();
//		
//		Pattern p3 = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$");
//		Matcher m3 = p3.matcher(password);
//		Boolean flag3 = m3.matches();
		
	Db db=new Db();
//		if("".equals(name)||"".equals(password)||"".equals(sex)||"".equals(age)||"".equals(address)||"".equals(phone)){
//			pw.write("<script language='javascript'> alert('学生信息需要录入完整');window.document.location.href='pages/add.jsp' </script>");
//		
//		}
//			else if(flag==false||flag2==false||flag3==false){
//			pw.write("<script language='javascript'> alert('学生电话号码或年龄或密码（6~16位数字加字母）格式不符合');window.document.location.href='pages/add.jsp' </script>");
//		}
			int num=db.findStudent(name,password);
			if(num>0){
				pw.write("<script language='javascript'> alert('当前用户已存在') ;window.document.location.href='pages/add.jsp' </script>");
			}else{
				Student s=new Student();
				s.setName(name);
				s.setPassword(password);
				s.setSex(sex);
				s.setAddress(address);
				s.setAge(Integer.parseInt(age));
				s.setPhone(phone);
				int num1=db.create(s);
				if(num1>0){
					resp.sendRedirect("SelectServlet");  
				}else{
					pw.write("<script language='javascript'> alert('未知原因添加失败，请重试！');"
							+ "window.document.location.href='pages/add.jsp' </script>");
				}
			}
		}
		

	
}

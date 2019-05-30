package com.zhangchi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhangchi.Db.Db;
import com.zhangchi.model.Student;

@WebServlet("/edit_servlet")
public class EditServelt extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		//创建Student类的对象
		Student student=new Student();
		
		//创建Db类的对象
		Db db=new Db();
		student=db.findOne(Integer.parseInt(id));
		
		req.getSession().setAttribute("student", student);
		resp.sendRedirect("pages/update.jsp");
	}

	
}

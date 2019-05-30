package com.zhangchi.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhangchi.Db.Db;
import com.zhangchi.model.Student;

@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收页码
		String pageNum=req.getParameter("pageNum");
		//创建集合
		List<Student> StudentList = new ArrayList<Student>();
		//创建Db类对象
		Db db=new Db();
		
		//处理页码
		if(pageNum==null){
			StudentList=db.queryLimit(1, 5);
			//页码传回页面
			req.setAttribute("pageNum", 1);
		}else{
			StudentList=db.queryLimit(Integer.parseInt(pageNum), 5);
			//页码传回页面
			req.setAttribute("pageNum", pageNum);
		}
		
		int count=db.getCount();
		req.getSession().setAttribute("StudentList", StudentList);
		req.getSession().setAttribute("count", count%5==0?count/5:count/5+1);
		
		req.getRequestDispatcher("pages/manage.jsp").forward(req,resp);
	}

	
}

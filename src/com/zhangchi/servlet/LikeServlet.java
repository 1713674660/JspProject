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
import com.zhangchi.Db.Db2;
import com.zhangchi.model.Student;

@WebServlet("/like_servlet")
public class LikeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Db db = new Db();
		Db2 db2=new Db2();
		String pageNum=req.getParameter("pageNum");
		String name = req.getParameter("searchName");
		
		List<Student> StudentList=new ArrayList<Student>();
		//œ‘ æÀ˘”–
	    if(name==null || name==""){
			if(pageNum==null){
				req.setAttribute("pageNum",1);
				StudentList =db.queryLimit(1,5);
			}else{
				req.setAttribute("pageNum", pageNum);
				StudentList=db.queryLimit(Integer.parseInt(pageNum),5 );
			}
			int count=db.getCount();
			req.setAttribute("StudentList", StudentList);
			req.setAttribute("searchName", "");
			req.setAttribute("count", count%5==0?count/5:count/5+1);
			req.getRequestDispatcher("pages/like.jsp").forward(req, resp);
		}else{
				if(pageNum==null){
					req.setAttribute("pageNum",1);
					StudentList=db2.likeQuery(name,1,5);
				}else{
					req.setAttribute("pageNum", pageNum);
					StudentList=db2.likeQuery(name, Integer.parseInt(pageNum), 5);
				}
				int count=db2.likeCount(name);
				req.setAttribute("StudentList", StudentList);
				req.setAttribute("count", count%5==0?count/5:count/5+1);
				req.setAttribute("searchName", name);
				req.getRequestDispatcher("pages/like.jsp").forward(req, resp);
		}
	}

}

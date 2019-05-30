package com.zhangchi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhangchi.Db.Db;

@WebServlet("/delete_servlet")
public class DeleteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		
		String id=req.getParameter("id");
		String method=req.getParameter("do");
		String name=req.getParameter("searchName");
		String pageNum=req.getParameter("pageNum");
		Db db = new Db();
		int num=db.delete(Integer.parseInt(id));
		
		if(num>0){
			if("likeQuery".equals(method)){
				req.getRequestDispatcher("like_servlet").forward(req,resp);
			}else{
				resp.sendRedirect("SelectServlet");
			}
			
		}else{
			pw.write("<script language='javascript'> alert('删除失败，返回学员列表');window.document.location.href='SelectServlet' </script>");
		}
		
	}

}

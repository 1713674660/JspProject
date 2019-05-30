package com.zhangchi.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/pages/*")
public class JspFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		  PrintWriter pw = response.getWriter();
		  HttpServletRequest servletRequest = (HttpServletRequest) request;
		  HttpServletResponse servletResponse = (HttpServletResponse) response;
		  HttpSession session = servletRequest.getSession();
		  
		  String path = servletRequest.getRequestURI();
		  String empName = (String) session.getAttribute("filterName");
		 
		  if(path.indexOf("/login.jsp") > -1) {
		   chain.doFilter(servletRequest, servletResponse);
		   return;
		  }
		 
		  if (empName == null || "".equals(empName)) {
		   pw.write("<script language='javascript'>alert('½ûÖ¹Î´µÇÂ¼·ÃÎÊ£¡');window.document.location.href='/JspProject/login.jsp'</script>");
		   //servletResponse.sendRedirect("/JspProject/login.jsp");
		  } else {
		   
		   chain.doFilter(request, response);
		  }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}

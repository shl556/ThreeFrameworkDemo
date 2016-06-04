package com.shl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shl.javabeans.tools.Uservalidate;

public class UservalidateServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
              doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          String lgname =request.getParameter("lgname");
          String lgpass =request.getParameter("lgpass");
          Uservalidate validate=new Uservalidate();
          validate.setLgname(lgname);
          validate.setLgpass(lgpass);
          try {
			boolean valid =validate.isvalid();
			if(valid){
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				String errormsg="用户名或密码错误，请重新输入！";
				request.setAttribute("errormsg", errormsg);
				request.setAttribute("lgname", lgname);
				request.setAttribute("lgpass", lgpass);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

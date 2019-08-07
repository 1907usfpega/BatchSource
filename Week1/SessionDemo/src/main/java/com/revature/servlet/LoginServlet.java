package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		
		String name=request.getParameter("name");
		String pass=request.getParameter("password");
		if (pass.equals("bitches")) {
			out.print("WELCOME, "+name);
			HttpSession sess=request.getSession();
			sess.setAttribute("name", name);
		}
		else {
			out.print("Sorry Username or Password Error");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}

}

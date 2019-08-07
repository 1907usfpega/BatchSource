package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daoimpl.UsernameDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 4L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsernameDaoImpl udi = new UsernameDaoImpl();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		boolean cpw = false;
		try {
			cpw = udi.correctPassword(name, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cpw) {
			out.print("Welcome, " + name);
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
		} else {
			request.getRequestDispatcher("registration.html").forward(request, response);
		}
		out.close();
	}

}

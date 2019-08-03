package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daoimpl.EmployeeDaoImpl;

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
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//Check against DaoImpl here. User/PW combo. Verification in EmployeeDaoImpl.
		int employeeID = 0;
		try {
			employeeID = edi.verifyPassword(name, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (employeeID > 0)
		{
			out.print("Welcome, " + name);
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("emplID", employeeID);
		}
		else
		{
			out.print("Sorry, username or password error.");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		
		out.close();
	}

}

package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.RegistrationForm;
import com.revature.daoimpl.EmployeeDaoImpl;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		RegistrationForm rf = mapper.readValue(request.getInputStream(), RegistrationForm.class);
		PrintWriter pw = response.getWriter();
		if (rf.getPw().equals(rf.getCpw())) {
			// Enter Employee Into Database
			try {
				edi.registerEmployee(rf);
				pw.write("<h3>Registration Successful</h3>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				pw.write("<h3>Something Went Wrong</h3>");
			}
		} else {
			// Tell Employee they done fucked up
			pw.write("<h3>Passwords Do Not Match.</h3>");
		}
	}

}

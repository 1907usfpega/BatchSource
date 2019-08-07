package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.VGDaoImpl;

/**
 * Servlet implementation class VGServlet
 */
public class VGServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	//
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper map=new ObjectMapper();
		VGDaoImpl vgdi=new VGDaoImpl();
		int id=map.readValue(request.getParameter("vgid"), Integer.class);
		PrintWriter pw= response.getWriter();
		String vgjson;
		try {
			vgjson=map.writeValueAsString(vgdi.getVGbyID(id));
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			pw.print(vgjson);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pw.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

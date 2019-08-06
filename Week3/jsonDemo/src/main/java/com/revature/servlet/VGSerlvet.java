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
 * Servlet implementation class VGSerlvet
 */
public class VGSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in doGet");
		ObjectMapper mapper=new ObjectMapper();
		VGDaoImpl vgdi= new VGDaoImpl();
		int id=mapper.readValue(request.getParameter("vgid"), Integer.class);
		PrintWriter out=response.getWriter();
		try {
			String vgJSON=mapper.writeValueAsString(vgdi.getVGbyId(id));
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(vgJSON);
			System.out.println(vgJSON);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.VGDaoImp;

/**
 * Servlet implementation class vgServlet
 */
public class vgServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
	// ex: http://localhost:8080/JSONDemo/vg?vgid=2
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get info aboot vg
		System.out.println("en doGet");
		ObjectMapper mapper = new ObjectMapper();
		VGDaoImp vgdi = new VGDaoImp();
		int id = mapper.readValue(request.getParameter("vgid"), Integer.class);
		PrintWriter out = response.getWriter();
		String vgJSON;
		try {
			vgJSON = mapper.writeValueAsString(vgdi.getVGById(id));
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

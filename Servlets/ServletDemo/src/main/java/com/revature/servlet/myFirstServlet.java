package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class myFirstServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4579454540825277736L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		System.out.println("What up y'all");	
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		System.out.println("Post up!");
	}
	
}
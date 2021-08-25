package com.freesky.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freesky.entity.Person;

public class MyController extends HttpServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5877766428484572751L;
	
	private Person person = new Person();

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		request.setAttribute("person", person);
		
		RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
		
		rd.forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}

package com.techelevator;

import java.io.IOException;
import java.time.Instant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClockServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().println("<!DOCTYPE html>");
		response.getWriter().println("<html>");
		response.getWriter().println("<body>");
		response.getWriter().println("<head>");
		response.getWriter().println("<title>ClockServlet</title>");
		response.getWriter().println("</head>");
		response.getWriter().println("<h1>The time is now, "+ java.util.Date.from(Instant.now()).toString() +"!</h1>");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
	}
}
package com.adag;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String urlString = request.getParameter("url");
	//	String fileUrl = "C:\\Users\\admin\\Downloads\\" + request.getParameter("inputfile");
		
		String videoUrl = XvideosDownloader.getVideoUrl(urlString);

		request.setAttribute("videoUrl", videoUrl);
		RequestDispatcher rd = request.getRequestDispatcher("download.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
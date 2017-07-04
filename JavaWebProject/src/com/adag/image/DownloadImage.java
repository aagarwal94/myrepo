package com.adag.image;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadImage
 */
public class DownloadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String[] urlString = request.getParameterValues("ImagesUrl");
		
		for(String str : urlString){ 
		URL url = new URL(str);
		InputStream inputStream = url.openConnection().getInputStream();

		// obtains ServletContext
	   ServletContext context = getServletContext();
	   // gets MIME type of the file
	   String mimeType = context.getMimeType(str);
	   if (mimeType == null) { 
	    // set to binary type if MIME mapping not found 
	   mimeType = "application/jpg";
	         } 
	   System.out.println("MIME type: " + mimeType);
	
	    // modifies response
	    response.setContentType(mimeType);
	    response.setContentLength(inputStream.available());
	   
	   // forces download
	   String headerKey = "Content-Disposition";
	   String headerValue = String.format("attachment; filename=\"%s\"", url.getFile());
	   response.setHeader(headerKey, headerValue);
	   
	   // obtains response's output stream
	   OutputStream outStream = response.getOutputStream();
	   
	   byte[] buffer = new byte[8];
	   int bytesRead = -1;
	   
	   while ((bytesRead = inputStream.read(buffer)) != -1) {
	   outStream.write(buffer, 0, bytesRead);
	   }
	   
	   inputStream.close();
	   outStream.flush();
	   outStream.close();
}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

}

package ua.kpi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Basket")
public class Basket extends HttpServlet {
	private static final long serialVersionUID = 1L;      
   
 

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		
		PrintWriter out = response.getWriter();
		String st = request.getParameter("add-kiss");
		out.println(st);
		
		
	}
	
	

}

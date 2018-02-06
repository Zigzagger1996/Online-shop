package ua.kpi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersistException;
import dbController.BasketGoods;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String searchString = request.getParameter("search");
		
		try {
			BasketGoods bg = new BasketGoods();
			String info = bg.searchByNameAndGetInfo(searchString);
			
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			
			if(info.equals("")) {
				out.println("Nothing to show");
			} else out.println(info);
			
		} catch (PersistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

}

package ua.kpi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersistException;
import dbController.Authorization;
import dbController.Registration;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
  

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String firstName = request.getParameter("firstName");
		String secondName = request.getParameter("secondName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			Registration registration = new Registration();
			String info = registration.insertNewUser(firstName, secondName, email, password);
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if (info.equals(""))
			out.println("Данные введены неверно!");
		out.println(info);		
		out.close();
		} catch (PersistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

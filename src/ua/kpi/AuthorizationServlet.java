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


@WebServlet("/AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		try {
			Authorization authorization = new Authorization();
			String info = authorization.checkForUser(login, password);
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if (info.equals(""))
			out.println("Данные введены неверно, либо такого пользоватея не сущесвтует");
		out.println(info);		
		out.close();
		} catch (PersistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

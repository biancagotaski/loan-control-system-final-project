package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gotaski.business.Administrator;
import com.gotaski.business.User;

import dao.LoanDao;
import dao.UserDao;

@WebServlet("/AccessController")
public class AccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AccessController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("invalid", false);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
				
		User user = UserDao.validation(email, password);
		
		if(user != null) {
			request.getSession().setAttribute("user", user);
			request.setAttribute("loans", LoanDao.getList());			
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} else {
			
			request.setAttribute("invalid", true);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}

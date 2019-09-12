package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

@WebServlet("/AccessController")
public class AccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AccessController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(UserDao.validation(email, password) != null) {			
			new UserController().doGet(request, response);			
		} else {
			request.getRequestDispatcher("userRegister.jsp").forward(request, response);
		}
	}

}

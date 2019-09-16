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

import dao.UserDao;

@WebServlet("/AccessController")
public class AccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AccessController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("userRegister.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		
		User user = UserDao.validation(email, password);
		
		if(user != null) {
			String type = (user instanceof Administrator) ? "Administrator" : "User";
			out.println("Usuário identificado: " + user.getName());
			out.println("Tipo: " + type);
			
			request.setAttribute("userLogged", email);
			request.setAttribute("users", UserDao.getList());
			request.getRequestDispatcher("userList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("userRegister.jsp").forward(request, response);
		}
	}

}

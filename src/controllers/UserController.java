package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gotaski.business.User;

import dao.UserDao;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserController() {
        super();        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("users", UserDao.getList());
		request.getRequestDispatcher("userList.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User(
				request.getParameter("name"), 
				request.getParameter("email"), 
				request.getParameter("password")
			);
		
		if(UserDao.addUser(user)) {
			
			this.doGet(request, response);
			
		} else {
			System.out.println("Entrou no else do UserController");
			request.setAttribute("msg", "Problemas na inclusão!!!");

			request.getRequestDispatcher("userRegister.jsp").forward(request, response);
		}
	}
}

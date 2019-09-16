package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gotaski.business.Administrator;
import com.gotaski.business.User;

import dao.AdministratorDao;
import dao.UserDao;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private List<User> list;
    
    public UserController() {
        super();
        
        list = new ArrayList<User>();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("idUser"));
		
		UserDao.delete(id);
		
		this.getUserList(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
				
		User registered = null;
		
		if("A".equals(type)) {
			Administrator a = new Administrator(name, email, password);
			a.setName(name);
			registered = AdministratorDao.insert(a);
			
		} else {
			User u = new User(name, email, password);
			u.setName(name);
			registered = UserDao.addUser(u);
		}
		
		this.getUserList(request, response);
	}
	
	protected void getUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("users", UserDao.getList());
		
		request.getRequestDispatcher("userList.jsp").forward(request, response);
	}
}

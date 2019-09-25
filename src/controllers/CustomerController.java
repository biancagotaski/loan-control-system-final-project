package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gotaski.business.Customer;

import dao.CustomerDao;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", CustomerDao.getList());
		request.getRequestDispatcher("customerList.jsp").forward(request, response);
		
		request.setAttribute("controller", "CustomerController");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("main.jsp").forward(request, response);
		
		Customer customer = new Customer(
					request.getParameter("name"),
					request.getParameter("lastName"),
					request.getParameter("email"),
					request.getParameter("birthday"),
					request.getParameter("CPF"),
					request.getParameter("street"),
					Integer.valueOf(request.getParameter("number")),
					request.getParameter("city"),
					request.getParameter("state")
				);
		
		CustomerDao.insert(customer);
		
		request.setAttribute("message", customer.toString());
		
		request.setAttribute("title", "Customer");
		
		request.setAttribute("controller", "CustomerController");
		
		request.getRequestDispatcher("final.jsp").forward(request, response);
	}

}

package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gotaski.business.Customer;
import com.gotaski.business.Loan;

import dao.CustomerDao;
import dao.LoanDao;

@WebServlet("/CustomerLoanController")
public class CustomerLoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Loan loan;
       
    public CustomerLoanController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loan = LoanDao.getLoanByID(Integer.valueOf(request.getParameter("id")));
		
		request.setAttribute("loan", loan);
		request.setAttribute("customers", CustomerDao.getList());

		//CRIAR ESSE JSP
		request.getRequestDispatcher("customerLoan.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loan.setCustomer(new Customer(Integer.valueOf(request.getParameter("idCustomer"))));
		
		LoanDao.associateCustomer(loan);
		
		request.setAttribute("loans", LoanDao.getList());
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}

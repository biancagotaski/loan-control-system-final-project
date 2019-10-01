package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gotaski.business.Loan;

import dao.LoanDao;

@WebServlet("/LoanController")
public class LoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoanController() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("screen") != null) {
			request.getRequestDispatcher("loanDetails.jsp").forward(request, response);
		} else {
			request.setAttribute("loans", LoanDao.getList());
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
		
//		List<Loan> loans = LoanDao.getList();
//		request.setAttribute("loans", loans);
//		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("idLoan") != null) {
//			int id = Integer.valueOf(request.getParameter("idLoan"));
			
//			LoanProductDao.delete(id);
			
			request.setAttribute("message", "...//LOAN");
			request.setAttribute("title", "Loan");
			request.setAttribute("controller", "LoanController");
			request.getRequestDispatcher("final.jsp").forward(request, response);			
			
		} else {
			Loan loan = new Loan(
						request.getParameter("startDate"),
						request.getParameter("endDate"),
						request.getParameter("CPFCustomer")
					);
			
			LoanDao.insert(loan);
			
			request.setAttribute("message", loan.toString());
			request.setAttribute("title", "Loan");
			request.setAttribute("controller", "LoanController");
			request.getRequestDispatcher("final.jsp").forward(request, response);
		}
	}

}

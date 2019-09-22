package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gotaski.business.Computer;

import dao.ComputerDao;

@WebServlet("/ComputerController")
public class ComputerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ComputerController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", ComputerDao.getList());
		request.getRequestDispatcher("computerList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Computer computer = new Computer(
					request.getParameter("name"),
					Float.valueOf(request.getParameter("value")),
					Integer.valueOf(request.getParameter("serialNumber")),
					request.getParameter("brand"),
				
					request.getParameter("operationalSystem"),
					Integer.valueOf(request.getParameter("cores")),
					Boolean.valueOf(request.getParameter("hasAccessories"))
				);
		
		ComputerDao.insert(computer);
		
		request.setAttribute("message", computer.toString());
		
		request.setAttribute("title", "Computer");
		
		request.setAttribute("controller", "ComputerController");
		
		request.getRequestDispatcher("final.jsp").forward(request, response);
	}
}

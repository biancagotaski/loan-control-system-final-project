package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ComputerController")
public class ComputerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ComputerController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//COMO SEGUNDO PARÂMETRO DO setAttribute QUE É PASSADA A LISTA QUE VEM DO DAO
		request.setAttribute("list", null);
		request.getRequestDispatcher("computerDetails.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}

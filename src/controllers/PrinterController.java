package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gotaski.business.Printer;

import dao.PrinterDao;

@WebServlet("/PrinterController")
public class PrinterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrinterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", PrinterDao.getList());
		request.getRequestDispatcher("printerList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Printer printer = new Printer(
					request.getParameter("name"),
					Float.valueOf(request.getParameter("value")),
					Integer.valueOf(request.getParameter("serialNumber")),
					request.getParameter("brand"),
					Boolean.valueOf(request.getParameter("isLaser")),
					Integer.valueOf(request.getParameter("maxLeaf")),
					Boolean.valueOf("hasWifi")
				);
		
		PrinterDao.insert(printer);
		
		request.setAttribute("message", printer.toString());
		
		request.setAttribute("title", "Printer");
		
		request.setAttribute("controller", "PrinterController");
		
		request.getRequestDispatcher("final.jsp").forward(request, response);
	}
}

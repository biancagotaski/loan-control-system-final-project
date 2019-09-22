package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gotaski.business.Projector;

import dao.ProjectorDao;

@WebServlet("/ProjectorController")
public class ProjectorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProjectorController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", ProjectorDao.getList());
		request.getRequestDispatcher("projectorList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Projector projector = new Projector(
					request.getParameter("name"),
					Float.valueOf(request.getParameter("value")),
					Integer.valueOf(request.getParameter("serialNumber")),
					request.getParameter("brand"),
					request.getParameter("resolution"),
					Boolean.valueOf(request.getParameter("hasLCD")),
					Boolean.valueOf(request.getParameter("hasLaser"))
				);
		
		ProjectorDao.insert(projector);
		
		request.setAttribute("message", projector.toString());
		
		request.setAttribute("title", "Projector");
		
		request.setAttribute("controller", "ProjectorController");
		
		request.getRequestDispatcher("final.jsp").forward(request, response);;
	}

}

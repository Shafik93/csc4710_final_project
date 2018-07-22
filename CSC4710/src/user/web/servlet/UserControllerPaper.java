package user.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDao;

/**
 * Servlet implementation class UserControllerPaper
 */
@WebServlet("/UserControllerPaper")
public class UserControllerPaper extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao dao = new UserDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControllerPaper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String action  = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")){
			int paperid = Integer.parseInt(request.getParameter("paperid"));
			try {
				dao.deletePaper(paperid);
				
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher view = request.getRequestDispatcher("PaperServlet");
		view.forward(request, response);
	}

}

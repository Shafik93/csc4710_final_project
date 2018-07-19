package user.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDao;
import user.domain.Manager;
import user.domain.User;
import user.service.ManagerService;
import user.service.UserException;
import user.service.UserService;

/**
 * Servlet implementation class ManagerServletLogin
 */
@WebServlet("/ManagerServletLogin")
public class ManagerServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServletLogin() {
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
		UserDao userdao = new UserDao();
		Manager manager = null;
		try {
			manager = userdao.findByUsername1(request.getParameter("username"));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ManagerService managerservice = new ManagerService();		
		if(manager.getMusername()!=null){
			try {
				managerservice.login(manager);
				request.getSession().setAttribute("session_manager", manager);
				request.getRequestDispatcher("/jsps/main.jsp").forward(request, response);
				//request.getSession().setAttribute("session_user", null);
				
			} catch (ClassNotFoundException | UserException e) {
				// TODO Auto-generated catch block
				request.setAttribute("msg", e.getMessage());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				request.setAttribute("msg", e.getMessage());
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				request.setAttribute("msg", e.getMessage());
			} 
		}
		else{
			request.setAttribute("msg", "Manager does not exist!");
			request.getRequestDispatcher("/jsps/managerLogin.jsp").forward(request, response);
		}
	}

}

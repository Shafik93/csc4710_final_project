package user.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDao;
import user.domain.User;
import user.service.UserException;
import user.service.UserService;

/**
 * Servlet implementation class UserServlet
 */

public class UserServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Map<String, String> form = new HashMap<String,String>();
		UserDao userdao = new UserDao();
		User user = null;
		try {
			user = userdao.findByUsername(request.getParameter("username"));
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

		UserService userservice = new UserService();		
		if(user.getUsername()!=null){
			try {
				userservice.login(user);
				request.getSession().setAttribute("session_user", user);
				
				request.getRequestDispatcher("/jsps/main.jsp").forward(request, response);
			//	request.getSession().setAttribute("session_manager", null);
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
			request.setAttribute("msg", "You need to register first");
			request.getRequestDispatcher("/jsps/user/login.jsp").forward(request, response);
		}
		
		
		
	}

}

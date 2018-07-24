package user.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDao;

/**
 * Servlet implementation class RejectedServlet
 */
@WebServlet("/RejectedServlet")
public class RejectedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
UserDao dao = new UserDao();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RejectedServlet() {
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
		String pcmem1 = "";
		String pcmem2 = "";
		pcmem1 = request.getParameter("pcmem1");
		pcmem2 = request.getParameter("pcmem2");
		
			
		try {
			request.setAttribute("RejectedList", dao.Rejected(pcmem1, pcmem2));
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List<Object> li = dao.Rejected(pcmem1, pcmem2);
			for(int i = 0; i < li.size();i++){
				System.out.println(li.get(i).toString());
			}
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		request.getRequestDispatcher("/Queryresult/rejected.jsp").forward(request, response);
	}

}

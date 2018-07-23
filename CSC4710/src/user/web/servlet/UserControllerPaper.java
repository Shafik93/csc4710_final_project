package user.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import user.dao.UserDao;
import user.domain.Paper;

/**
 * Servlet implementation class UserControllerPaper
 */
@WebServlet("/UserControllerPaper")
public class UserControllerPaper extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String paperserv = "PaperServlet";
	private static String paperform = "/Queryresult/paperform.jsp";
	private static String paperinsert = "/Queryresult/paperinsert.jsp";

	UserDao dao = new UserDao();
	Sql sql = new Sql();
    private static int p =0;
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
		String action  = request.getParameter("action");
		String forward ="";
		
		if(action.equalsIgnoreCase("delete")){
			int paperid = Integer.parseInt(request.getParameter("paperid"));
			try {
				dao.deletePaper(paperid);
				forward = paperserv;
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equalsIgnoreCase("edit")){
			int paperid = Integer.parseInt(request.getParameter("paperid"));
			try {
				Paper paper = findallByid(paperid);
				request.setAttribute("paper", paper);
				forward = paperform;
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equalsIgnoreCase("insert")){
			
			forward = paperinsert;
		}
	
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		if(request.getParameter("frmsub") != null){
		Paper paper = new Paper();
		paper.setPaperid(p);
		paper.setTitle(request.getParameter("title"));
		paper.setAbs(request.getParameter("abstract"));
		paper.setPdf(request.getParameter("pdf"));
		
		try {
			dao.updatePaper(paper);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher view = request.getRequestDispatcher(paperserv);
		view.forward(request, response);
		}
		else if(request.getParameter("frminsert") != null){
			Paper paper1 = new Paper();
			System.out.println(request.getParameter("title"));
			paper1.setTitle(request.getParameter("title"));
			paper1.setAbs(request.getParameter("abstract"));
			paper1.setPdf(request.getParameter("pdf"));
			try {
				dao.InsertPaper(paper1);
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher view = request.getRequestDispatcher(paperserv);
			view.forward(request, response);
		}
	}
	public Paper findallByid(int paperid) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		Paper paper = new Paper();
        try {
        	Class.forName(dao.connector).newInstance();
			Connection connect = DriverManager.getConnection(dao.conInfo);
            PreparedStatement preparedStatement = connect.
                    prepareStatement("select * from paper where paperid=?");
            preparedStatement.setInt(1, paperid);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                paper.setPaperid(rs.getInt("paperid"));
                paper.setTitle(rs.getString("title"));
                paper.setAbs(rs.getString("abstract"));
                paper.setPdf(rs.getString("pdf"));
                p = rs.getInt("paperid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paper;
    }
	
	
}

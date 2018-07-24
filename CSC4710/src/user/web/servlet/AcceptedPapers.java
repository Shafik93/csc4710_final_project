package user.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDao;
import user.domain.Paper;
import user.service.PaperService;

/**
 * Servlet implementation class AcceptedPapers
 */
@WebServlet("/AcceptedPapers")
public class AcceptedPapers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao dao = new UserDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptedPapers() {
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
		try {			
			request.setAttribute("AcceptedpapersList", Acceptedpaper());
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List<Object> li = Acceptedpaper();
			for(int i = 0; i < li.size();i++){
				System.out.println(li.get(i).toString());
			}
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/Queryresult/acceptedpaper.jsp").forward(request, response);
	
	}
	public List<Object> Acceptedpaper()throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName(dao.connector).newInstance();
			Connection connect = DriverManager.getConnection(dao.conInfo);
			
			
			String sql = "SELECT p.paperid, p.title, p.abstract, p.pdf "
						+"FROM accepted a,paper p "
						+"WHERE a.accept >1 "
						+"AND a.paperid = p.paperid";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Paper paper1 = new Paper();
	    		paper1.setPaperid(resultSet.getInt("paperid"));
	    		paper1.setTitle(resultSet.getString("title"));
	    		paper1.setAbs(resultSet.getString("abstract"));
	    		paper1.setPdf(resultSet.getString("pdf"));
	    		list.add(paper1);
			 }
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

}

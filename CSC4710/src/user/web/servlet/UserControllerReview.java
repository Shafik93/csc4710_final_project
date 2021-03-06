package user.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDao;
import user.domain.Paper;
import user.domain.Review;
import user.service.PaperService;


/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserControllerReview")
public class UserControllerReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String reviewserv = "ReviewServlet";
	private static String reviewform = "/Queryresult/reviewform.jsp";
	private static String reviewinsert = "/Queryresult/reviewinsert.jsp";
    UserDao dao = new UserDao();
    private static int pr = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControllerReview() {
        super();
        // TODO Auto-generated constructor stub

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action  = request.getParameter("action");
		String forward = "";
		if(action.equalsIgnoreCase("delete")){
			int reportid = Integer.parseInt(request.getParameter("reportid"));
			try {
				dao.deleteReview(reportid);
				forward = reviewserv;
				
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(action.equalsIgnoreCase("edit")){
			int reportid = Integer.parseInt(request.getParameter("reportid"));
			try{
				Review review = findallByid(reportid);
				request.setAttribute("review", review);
				forward = reviewform;
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equalsIgnoreCase("insert")){
			
			forward = reviewinsert;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		
	}

	/**
	 *
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("frmsub") != null){
			Review review = new Review();
			review.setReportid(pr);

            review.setComment(request.getParameter("comment"));
            review.setRecommendation(request.getParameter("recommendation"));
            review.setPaperid(Integer.parseInt(request.getParameter("paperid")));
            review.setEmail(request.getParameter("email"));
			
			try {
				dao.updateReview(review);
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher view = request.getRequestDispatcher(reviewserv);
			view.forward(request, response);
			}
		else if(request.getParameter("frminsert") != null){
			Review review1 = new Review();
		
			review1.setComment(request.getParameter("comment"));
			review1.setRecommendation(request.getParameter("recommendation"));
			review1.setPaperid(Integer.parseInt(request.getParameter("paperid")));
			review1.setEmail(request.getParameter("email"));
			try {
				dao.InsertReview(review1);
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher view = request.getRequestDispatcher(reviewserv);
			view.forward(request, response);
		}
	
		
	}
public Review findallByid(int reportid) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		Review review = new Review();
        try {
        	Class.forName(dao.connector).newInstance();
			Connection connect = DriverManager.getConnection(dao.conInfo);
            PreparedStatement preparedStatement = connect.
                    prepareStatement("select * from review where reportid=?");
            preparedStatement.setInt(1, reportid);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                review.setReportid(rs.getInt("reportid"));
                review.setSdate(rs.getDate("sdate"));
                review.setComment(rs.getString("comment"));
                review.setRecommendation(rs.getString("recommendation"));
                review.setPaperid(rs.getInt("paperid"));
                review.setEmail(rs.getString("email"));
                pr = rs.getInt("reportid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return review;
    }

}

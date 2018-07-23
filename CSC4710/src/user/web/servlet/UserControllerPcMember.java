package user.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDao;
import user.domain.Paper;
import user.domain.PcMember;

/**
 * Servlet implementation class UserControllerPcMember
 */
@WebServlet("/UserControllerPcMember")
public class UserControllerPcMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String pcmemberserv = "PcMemberServlet";
	private static String pcmemberform = "/Queryresult/pcmemberform.jsp";
	UserDao dao = new UserDao();
	private static int pc =0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControllerPcMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		String action  = request.getParameter("action");
		String forward ="";
		
		if(action.equalsIgnoreCase("delete")){
			int memberid = Integer.parseInt(request.getParameter("memberid"));
			try {
				dao.deletePcmember(memberid);
				forward = pcmemberserv;
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equalsIgnoreCase("edit")){
			int memberid = Integer.parseInt(request.getParameter("memberid"));
			try {
				PcMember pcmember = findallByid(memberid);
				request.setAttribute("pcmember", pcmember);
				forward = pcmemberform;
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		if(request.getParameter("frmsubpc") != null){
		PcMember pcmember = new PcMember();
		pcmember.setMemberid(pc);
		pcmember.setEmail(request.getParameter("email"));
		pcmember.setName(request.getParameter("name"));
		
		try {
			dao.updatePcmember(pcmember);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher view = request.getRequestDispatcher(pcmemberserv);
		view.forward(request, response);
		}
	}
	public PcMember findallByid(int memberid) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		PcMember pcmember = new PcMember();
        try {
        	Class.forName(dao.connector).newInstance();
			Connection connect = DriverManager.getConnection(dao.conInfo);
            PreparedStatement preparedStatement = connect.
                    prepareStatement("select * from pcmember where memberid=?");
            preparedStatement.setInt(1, memberid);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                pcmember.setMemberid(rs.getInt("memberid"));
                pcmember.setEmail(rs.getString("email"));
                pcmember.setName(rs.getString("name"));
                pc = rs.getInt("memberid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pcmember;
    }
	
	
}

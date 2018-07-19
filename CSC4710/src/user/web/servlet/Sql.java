package user.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDao;
import user.domain.User;
import user.service.UserException;

/**
 * Servlet implementation class Sql
 */
@WebServlet("/Sql")
public class Sql extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userdao = new UserDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sql() {
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
		if(request.getParameter("sql") != null){
			try {
				createTable();
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PrintWriter out = response.getWriter();
			out.println("The database has been initialized!!");
		}
	}
	/**
	 * initializing tables for database with tuples
	 */
	public void createTable() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(userdao.conInfo);
			
			//use database
			String sql = "use sampledb";
			PreparedStatement useDatabase = connect.prepareStatement(sql); 
		    useDatabase.executeUpdate();
		    
		    /**
		     * drop tables if exist
		     */
		  //drop manager
		    String drop = "DROP TABLE IF EXISTS manager;";
		    PreparedStatement dropManagerTable = connect.prepareStatement(drop);
		    dropManagerTable.executeUpdate();
		    
		    //drop tb_user
		    String drop2 = "DROP TABLE IF EXISTS tb_user;";
		    PreparedStatement dropUserTable = connect.prepareStatement(drop2);
		    dropUserTable.executeUpdate();
		    
		    //drop writePaper
		    String drop5 = "DROP TABLE IF EXISTS writePaper;";
			PreparedStatement dropWritePaperTable = connect.prepareStatement(drop5);
			dropWritePaperTable.executeUpdate();
			
			//drop author
		    String drop4 = "DROP TABLE IF EXISTS author;";
			PreparedStatement dropAuthorTable = connect.prepareStatement(drop4);
			dropAuthorTable.executeUpdate();
			
			//drop review
		    String drop7 = "DROP TABLE IF EXISTS review;";
			PreparedStatement dropReviewTable = connect.prepareStatement(drop7);
			dropReviewTable.executeUpdate();
			
			//drop pcMember
		    String drop6 = "DROP TABLE IF EXISTS pcmember;";
			PreparedStatement dropPcmemberTable = connect.prepareStatement(drop6);
			dropPcmemberTable.executeUpdate();
			
			//drop paper
		    String drop3 = "DROP TABLE IF EXISTS paper;";
		    PreparedStatement dropPaperTable = connect.prepareStatement(drop3);
		    dropPaperTable.executeUpdate();

		    
		    
		    //create tb_user
		    String sql2 = "CREATE TABLE tb_user "
		    		+ "(username VARCHAR(50) primary key,"
		    		+ " password VARCHAR(50) NOT NULL,"
		    		+ "email VARCHAR(50) NOT NULL);";
		    PreparedStatement createUserTable = connect.prepareStatement(sql2); 
		    createUserTable.executeUpdate();
		    //tuples
		    insertIntoUser("john1","john1","john1@gmail.com");
		    insertIntoUser("john2","john2","john2@gmail.com");
		    insertIntoUser("john3","john3","john3@gmail.com");
		    insertIntoUser("john4","john4","john4@gmail.com");
		    insertIntoUser("john5","john5","john5@gmail.com");
		    insertIntoUser("john6","john6","john6@gmail.com");
		    insertIntoUser("john7","john7","john7@gmail.com");
		    insertIntoUser("john8","john8","john8@gmail.com");
		    insertIntoUser("john9","john9","john9@gmail.com");
		    insertIntoUser("john10","john10","john10@gmail.com");
		    
		    
		    

		    //create manager
		    String sqlM = "CREATE TABLE manager "
		    		+ "(managerusername VARCHAR(50) PRIMARY KEY,"
		    		+ "password VARCHAR(50) NOT NULL,"
		    		+ "email VARCHAR(50) NOT NULL);";
		    PreparedStatement createManagerTable = connect.prepareStatement(sqlM); 
		    createManagerTable.executeUpdate();
		    //tuples
		    insertIntoManager("shafik","shafik","shafik@gmail.com");
		    
		    
		    
		    
		    //create paper
		    String sql3 = "CREATE TABLE paper"
		    		+ "(paperid INT AUTO_INCREMENT,"
		    		+ "title VARCHAR(50),"
		    		+ "abstract VARCHAR(250),"
		    		+ "pdf VARCHAR(100),"
		    		+ "PRIMARY KEY (paperid));";
		    PreparedStatement createTables = connect.prepareStatement(sql3); 
		    createTables.executeUpdate();
		    //tuples
		    insertIntoPaper("database", "ch1","csc4710");
		    insertIntoPaper("database", "ch2","csc4710");
		    insertIntoPaper("database", "ch3","csc4710");
		    insertIntoPaper("database", "ch4","csc4710");
		    insertIntoPaper("database", "ch5","csc4710");
		    insertIntoPaper("database", "ch6","csc4710");
		    insertIntoPaper("database", "ch7","csc4710");
		    insertIntoPaper("database", "ch8","csc4710");
		    insertIntoPaper("database", "ch9","csc4710");
		    insertIntoPaper("database", "ch10","csc4710");


		    
		    //create author
			String sql4 = "CREATE TABLE author"
					+ "(email VARCHAR(100),"
					+ "firstname VARCHAR(50),"
					+ "lastname VARCHAR(50),"
					+ "affiliation VARCHAR(100),"
					+ "PRIMARY KEY(email));";
			PreparedStatement createTableAuthor = connect.prepareStatement(sql4); 
			createTableAuthor.executeUpdate();
			//tuples
			insertIntoAuthor("mike1@gmail.com", "mike1","jackson","csc");
			insertIntoAuthor("mike2@gmail.com", "mike2","smith","eng");
			insertIntoAuthor("mike3@gmail.com", "mike3","oudeh","csc");
			insertIntoAuthor("mike4@gmail.com", "mike4","diaz","eng");
			insertIntoAuthor("mike5@gmail.com", "mike5","fields","csc");
			insertIntoAuthor("mike6@gmail.com", "mike6","snay","eng");
			insertIntoAuthor("mike7@gmail.com", "mike7","carter","eng");
			insertIntoAuthor("mike8@gmail.com", "mike8","bazi","csc");
			insertIntoAuthor("mike9@gmail.com", "mike9","nuzha","eng");
			insertIntoAuthor("mike10@gmail.com", "mike10","ataya","csc");
			

			
			
			 //create wirtePaper
			String sql5 = "CREATE TABLE writePaper"
					+ "(paperid INT,"
					+ "email VARCHAR(50),"
					+ "ordersignificance INT,"
					+ "PRIMARY KEY(paperid, email),"
					+ "FOREIGN KEY (paperid) REFERENCES paper(paperid),"
					+ "FOREIGN KEY (email) REFERENCES author(email));";
			PreparedStatement createTableWritePaper = connect.prepareStatement(sql5); 
			createTableWritePaper.executeUpdate();
			//tuples
			insertIntoWritePaper(1, "mike1@gmail.com", 1);
			insertIntoWritePaper(2, "mike2@gmail.com", 2);
			insertIntoWritePaper(3, "mike1@gmail.com", 6);
			insertIntoWritePaper(4, "mike3@gmail.com", 4);
			insertIntoWritePaper(5, "mike4@gmail.com", 2);
			insertIntoWritePaper(6, "mike6@gmail.com", 1);
			insertIntoWritePaper(7, "mike8@gmail.com", 8);
			insertIntoWritePaper(8, "mike9@gmail.com", 7);
			insertIntoWritePaper(9, "mike10@gmail.com", 9);
			insertIntoWritePaper(10, "mike10@gmail.com", 2);

			 //create pcmember
			String sql6 = "CREATE TABLE pcmember"
					+ "(memberid INT AUTO_INCREMENT,"
					+ "email VARCHAR(50),"
					+ "name VARCHAR(20),"
					+ "PRIMARY KEY (memberid),"
					+ "UNIQUE(email));";
			PreparedStatement createTablePcmember = connect.prepareStatement(sql6); 
			createTablePcmember.executeUpdate();
			//tuples
			insertIntoPcMember("dave1@gmail.com","dave1");
			insertIntoPcMember("dave2@gmail.com","dave2");
			insertIntoPcMember("dave3@gmail.com","dave3");
			insertIntoPcMember("dave4@gmail.com","dave4");
			insertIntoPcMember("dave5@gmail.com","dave5");
			insertIntoPcMember("dave6@gmail.com","dave6");
			insertIntoPcMember("dave7@gmail.com","dave7");
			insertIntoPcMember("dave8@gmail.com","dave8");
			insertIntoPcMember("dave9@gmail.com","dave9");
			insertIntoPcMember("dave10@gmail.com","dave10");
			
			
			 //create review
		    String sql7 = "CREATE TABLE review"
		    		+ "(reportid INT AUTO_INCREMENT,"
		    		+ "sdate DATE,"
		    		+ "comment VARCHAR(250),"
		    		+ "recommendation CHAR(1),"
		    		+ "paperid INT,"
		    		+ "email VARCHAR(100),"
		    		+ "PRIMARY KEY(reportid),"
		    		+ "UNIQUE(paperid, email),"
		    		+ "FOREIGN KEY (paperid) REFERENCES paper(paperid),"
		    		+ "FOREIGN KEY (email) REFERENCES pcmember(email));";
			PreparedStatement createTableReview = connect.prepareStatement(sql7); 
			createTableReview.executeUpdate();
			//tuples
			insertIntoReview("2018-06-01", "like it", "y", 1, "dave1@gmail.com");
			insertIntoReview("2018-06-02", "like it", "y", 2, "dave2@gmail.com");
			insertIntoReview("2018-06-03", "like it", "n", 3, "dave3@gmail.com");
			insertIntoReview("2018-06-04", "like it", "y", 4, "dave4@gmail.com");
			insertIntoReview("2018-06-05", "like it", "n", 5, "dave5@gmail.com");
			insertIntoReview("2018-06-06", "like it", "n", 6, "dave6@gmail.com");
			insertIntoReview("2018-06-07", "like it", "n", 7, "dave7@gmail.com");
			insertIntoReview("2018-06-08", "like it", "y", 8, "dave8@gmail.com");
			insertIntoReview("2018-06-09", "like it", "y", 9, "dave9@gmail.com");
			insertIntoReview("2018-06-10", "like it", "y", 10, "dave10@gmail.com");
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * insert functions
	 */
	public void insertIntoManager(String musername,String password, String email) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(userdao.conInfo);
			
			String sql = "INSERT INTO manager(managerusername, password, email) VALUES(?,?,?)";
			PreparedStatement pstm = connect.prepareStatement(sql);
			pstm.setString(1,musername);
			pstm.setString(2,password);
			pstm.setString(3,email);
			pstm.executeUpdate();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void insertIntoUser(String username, String password, String email) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(userdao.conInfo);
			
			String sql = "INSERT INTO tb_user(username, password, email) VALUES(?,?,?)";
			PreparedStatement pstm = connect.prepareStatement(sql);
			pstm.setString(1,username);
			pstm.setString(2,password);
			pstm.setString(3,email);
			pstm.executeUpdate();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void insertIntoPaper(String title, String Abstract, String pdf ) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(userdao.conInfo);
			
			String sql = "INSERT INTO paper(title, abstract, pdf) VALUES(?,?,?)";
			PreparedStatement pstm = connect.prepareStatement(sql);
			pstm.setString(1,title);
			pstm.setString(2,Abstract);
			pstm.setString(3,pdf);
			pstm.executeUpdate();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void insertIntoAuthor(String email, String firstname,String lastname, String affiliation ) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(userdao.conInfo);
			
			String sql = "INSERT INTO author(email, firstname, lastname, affiliation) VALUES(?,?,?,?)";
			PreparedStatement pstm = connect.prepareStatement(sql);
			pstm.setString(1,email);
			pstm.setString(2,firstname);
			pstm.setString(3,lastname);
			pstm.setString(4,affiliation);
			pstm.executeUpdate();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void insertIntoPcMember(String email, String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(userdao.conInfo);
			
			String sql = "INSERT INTO pcmember(email, name) VALUES(?,?)";
			PreparedStatement pstm = connect.prepareStatement(sql);
			pstm.setString(1,email);
			pstm.setString(2,name);
			pstm.executeUpdate();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void insertIntoReview(String sdate, String comment, String recommendation, int paperid, String email) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(userdao.conInfo);
			
			String sql = "INSERT INTO review(sdate, comment, recommendation, paperid, email) VALUES(?,?,?,?,?)";
			PreparedStatement pstm = connect.prepareStatement(sql);
			pstm.setDate(1, java.sql.Date.valueOf(sdate));
			pstm.setString(2, comment);
			pstm.setString(3, recommendation);
			pstm.setInt(4, paperid);
			pstm.setString(5, email);
			pstm.executeUpdate();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void insertIntoWritePaper(int paperid, String email, int ordersignificance) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection(userdao.conInfo);
			
			String sql = "INSERT INTO writepaper(paperid, email, ordersignificance) VALUES(?,?,?)";
			PreparedStatement pstm = connect.prepareStatement(sql);
			pstm.setInt(1, paperid);
			pstm.setString(2, email);
			pstm.setInt(3, ordersignificance);
			pstm.executeUpdate();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

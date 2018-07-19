Read me file:

Students need to import the CSC4710Demo.war into Eclipse workspace and open the structure of this project. 

Step 1: Open the readme file in the location ~/WebContent/readme
Step 2: Run the user.sql script 
Step 3: Run the  ~/WebContent/jsps/main.jsp in a local webserver(tomcat)

########
Students need to change the name and password if the database connection setting is not compatible with my code (name is “root” and password is “root”) 

This project shows a small web java example:

- which allows a user to register “name”, “password”, “Email” information to backend database bookstore.
- which allows a user to login to the main web page, if the name is already available in the user table and the password is correct. 


The web page part:
This project starts with the main.jsp file
- the main.jsp page : includes the Login and Register buttons which allow the user perform different functions

- the body.jsp page: 	a component of the main.jsp
- the top.jsp page:  	a component of the main.jsp

- the regist.jsp page:  includes three input information from a potential user
- the login.jsp page: includes the user and password information 


The java part:

- UserDao.java : makes some sql operations available 
- User.java    : wrap a user information from the register.jsp and should be consistent to the user table
- UserException: handles the error information
- UserService  : includes the login and register methods
- UserServletRegister: The class gets the user register information from register.jsp page and dispatch to login.jsp page if a user finishes the register process 
- UserServletLogin: The class gets a user object from database and in which compare the password stored. Then the user can dispatch to the main.jsp with its name showing on the frontleft side. 


############ Query results display in web pages ##############
a small example: list all the user in the tb_user table
- item.jsp 		: includes all the reference address of different queries.
- Queryresult/list.jsp	: output all the query results

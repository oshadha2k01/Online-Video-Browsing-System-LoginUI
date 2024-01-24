package RegisterUser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		        String FirstName = request.getParameter("fname");
		        String LastName = request.getParameter("lname");
		        String UserName = request.getParameter("uname");
		        String Password = request.getParameter("passw");
		        String Email = request.getParameter("email");
		        String PhoneNo = request.getParameter("phone");

		        boolean isTrue;

		        isTrue = UserDBUtil.insertuser(FirstName, LastName, UserName, Password, Email, PhoneNo);

		        if (isTrue) {
		            RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
		            dis.forward(request, response);
		        } else {
		            RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
		            dis2.forward(request, response);
		        }
		    }
		}



package RegisterUser;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uID = request.getParameter("id");
		String uFirstName = request.getParameter("fname");
		String uLastName = request.getParameter("lname");
		String uName = request.getParameter("uname");
		String uPassword = request.getParameter("pass");
		String uEmail = request.getParameter("email");
		String uPhoneNo = request.getParameter("phone");
		
		boolean isTrue;
		
		isTrue = UserDBUtil.updateuser(uID, uFirstName, uLastName, uName, uPassword, uEmail, uPhoneNo);
		
		 if (isTrue == true) {
			 
			 List<User> usDetails = UserDBUtil.getUserDetails(uID);
			 request.setAttribute("usDetails", usDetails);
			   
			 
	            RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
	            dis.forward(request, response);
	        } else {
	        	 List<User> usDetails = UserDBUtil.getUserDetails(uID);
				 request.setAttribute("usDetails", usDetails);
	        	
	            RequestDispatcher dis2 = request.getRequestDispatcher("useraccount.jsp");
	            dis2.forward(request, response);
	        }
	}

}

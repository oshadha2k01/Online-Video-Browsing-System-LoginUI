package RegisterUser;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uID = request.getParameter("id");
		
		boolean isTrue;
		
		isTrue = UserDBUtil.deleteUser(uID);
		
		if (isTrue == true) {
			 RequestDispatcher dis = request.getRequestDispatcher("userinsert.jsp");
	         dis.forward(request, response);
		}
		else {
			 List<User> usDetails = UserDBUtil.getUserDetails(uID);
			 request.setAttribute("usDetails", usDetails);
        	
            RequestDispatcher dis2 = request.getRequestDispatcher("useraccount.jsp");
            dis2.forward(request, response);
		}
		
	}

}

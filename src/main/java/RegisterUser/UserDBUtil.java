package RegisterUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	// validation for username and password
	public static boolean validate(String userName, String password) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
	        // SQL query to check the username and password from the table in database
			String sql = "select * from user_registration where uName='"+userName+"' and uPassword='"+password+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				
				isSuccess = true;
				
				} else {
					
				isSuccess = false;
				
				}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;	
	}
	
	
	 // Retrieve a list of User details based on the provided username
	public static List<User> getUser(String userName) {
		 ArrayList<User> user = new ArrayList<>();
		 
		 try {
			 
			 con = DBConnect.getConnection();
			 stmt = con.createStatement();
			// SQL query to retrieve user details for given username.
			 String sql = "select * from user_registration where uName='"+userName+"'";
			 rs = stmt.executeQuery(sql);
			 

				while(rs.next()) {
					int uID = rs.getInt(1);
					String uFirstName = rs.getString(2);
					String uLastName = rs.getString(3);
					String uName = rs.getString(4);
					String uPassword = rs.getString(5);
					String uEmail = rs.getString(6);
					String uPhoneNo = rs.getString(7);
					
					User usr = new User(uID, uFirstName, uLastName, uName, uPassword, uEmail, uPhoneNo );
					user.add(usr);
				}		  
			 
		 } catch (Exception e) {
			 e.printStackTrace();
			 
		 }
		return user;
		
	}
	
	
	//Insert data into the database
	
	public static boolean insertuser(String FirstName, String LastName, String UserName, String Password, String Email, String PhoneNo) {

		  boolean isSuccess = false;

		  try {
			  
		   

		    con = DBConnect.getConnection();
		    stmt = con.createStatement();
		 // SQL query to insert user data into the database
		    String sql = "insert into user_registration values ( 0,'"+FirstName+"', '"+LastName+"', '"+UserName+"', '"+Password+"', '"+Email+"', '"+PhoneNo+"' )";
		    int rs = stmt.executeUpdate(sql);

		    if(rs > 0) {
		      isSuccess = true;
		    } else {
		      isSuccess = false;
		    }

		  } catch(Exception e) {
		    e.printStackTrace();
		  }

		  return isSuccess;
		}
	
	  //Update user details in the database
	   
	public static boolean updateuser(String uID, String uFirstName, String uLastName, String uName, String uPassword, String uEmail, String uPhoneNo ) {
		
		
		try {
			
			 con = DBConnect.getConnection();
			 stmt = con.createStatement();
			// SQL query to update user details in the database.
			 String sql = "update user_registration set uFirstName='"+uFirstName+"', uLastName='"+uLastName+"', uName='"+uName+"', uPassword='"+uPassword+"', uEmail='"+uEmail+"', uPhoneNo='"+uPhoneNo+"'"
					 + "where uID = '"+uID+"'";
			  int rs = stmt.executeUpdate(sql);
			  
			    if(rs > 0) {
			      isSuccess = true;
			    } else {
			      isSuccess = false;
			    }
		}
		catch (Exception e) {
			e.printStackTrace();	
		}
		
		return isSuccess;
		
		
	}
	
	//Retrieve data from database
	
       public static List<User> getUserDetails(String Id) {
		
		int convertedID = Integer.parseInt(Id);
		
		ArrayList<User> usr = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			// SQL query to retrieve user details by checking the user ID.
			String sql = "select * from user_registration where uID='"+convertedID+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int uID = rs.getInt(1);
				String uFirstName = rs.getString(2);
				String uLastName = rs.getString(3);
				String uName = rs.getString(4);
				String uPassword = rs.getString(5);
				String uEmail = rs.getString(6);
				String uPhoneNo = rs.getString(7);
				
				User ur = new User(uID, uFirstName, uLastName, uName, uPassword, uEmail, uPhoneNo );
				usr.add(ur);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return usr;
	}
       
       //Delete user details  from database
       
       public static boolean deleteUser(String id) {
    	   int convId = Integer.parseInt(id);
    	   
    	   try {
    		   
    		   con = DBConnect.getConnection();
   			   stmt = con.createStatement();
   			// SQL query to delete user details by checking the user ID.
   			   String sql = "delete from user_registration where uID='"+convId+"'";
   			    int r = stmt.executeUpdate(sql);
   			    
   			    
			  
		           if(r > 0) {
		               isSuccess = true;
		           } else {
		              isSuccess = false;
		           }   
    	   }
    	   catch (Exception e) {
    		   e.printStackTrace();
    	   }
    	   return isSuccess;
    	    
       }
	
	

	
	
	
	

}

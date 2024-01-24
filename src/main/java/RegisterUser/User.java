package RegisterUser;

public class User {
	private int uID;
	private String uFirstName;
	private String uLastName;
	private String uName;
	private String uPass;
	private String uEmail;
	private String uPhoneNo;

	public User(int uID, String uFirstName, String uLastName, String uName, String uPass, String uEmail,
			String uPhoneNo) {
		this.uID = uID;
		this.uFirstName = uFirstName;
		this.uLastName = uLastName;
		this.uName = uName;
		this.uPass = uPass;
		this.uEmail = uEmail;
		this.uPhoneNo = uPhoneNo;
	}

	public int getuID() {
		return uID;
	}

	public String getuFirstName() {
		return uFirstName;
	}

	public String getuLastName() {
		return uLastName;
	}

	public String getuName() {
		return uName;
	}

	public String getuPass() {
		return uPass;
	}

	public String getuEmail() {
		return uEmail;
	}

	public String getuPhoneNo() {
		return uPhoneNo;
	}

	
	
}

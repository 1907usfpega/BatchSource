/**
 * 
 */
package user;

/**
 * @author MajorKey
 *
 */
public class User {
	private int userid;
	private String firstname;
	private String lastname;
	/**
	 * @param userid
	 * @param firstname
	 * @param lastname
	 */
	public User(int userid, String firstname, String lastname) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	/**
	 * @param firstname
	 * @param lastname
	 */
	public User(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	/**
	 * 
	 */
	public User() {
		super();
	}

	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
}

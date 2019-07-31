package user.screens;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Logout {

	public static void save(HashMap<Integer, Account> accounts, HashMap<String, User> users) {

		//------------------------------------Saving the Accounts-------------------------------------------
		FileOutputStream accountFileOutStream = null;
		ObjectOutputStream accountObjectOut = null;
		try {
			accountFileOutStream = new FileOutputStream("Accounts.ser");
			accountObjectOut = new ObjectOutputStream(accountFileOutStream);
			accountObjectOut.writeObject(accounts);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


		//------------------------------------Saving the Users-------------------------------------------
		FileOutputStream userFileOutStream = null;
		ObjectOutputStream userObjectOut = null;
		try {
			userFileOutStream = new FileOutputStream("Users.ser");
			userObjectOut = new ObjectOutputStream(userFileOutStream);
			userObjectOut.writeObject(users);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


		//------------------------------------Closing Stream-------------------------------------------
		if (accountObjectOut !=  null) {
			try {
				accountObjectOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (userObjectOut != null) {
			try {
				userObjectOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


		//------------------------------------Closing Files-------------------------------------------
		if (accountFileOutStream != null) {
			try {
				accountFileOutStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (userFileOutStream != null ) {
			try {
				userFileOutStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}//end save()

}//end Logout class


package com.revature.pojo;

	public class User {
		private int userID;
		private String username;
		private String password;
		private boolean isAdmin;
		
		public User(int userID, String username, String password) {
			this.userID = userID;
			this.username = username;
			this.password = password;
			this.isAdmin = false;
		}
		public User(String username, String password) {
			this.username = username;
			this.password = password;
			this.isAdmin = false;
		}
		
		public User(int userID, String username, String password,boolean isAdmin) {
			this.userID = userID;
			this.username = username;
			this.password = password;
			this.isAdmin = isAdmin;
		}
		
		public int getUserID() {
			return userID;
		}



		public void setUserID(int userID) {
			this.userID = userID;
		}



		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}


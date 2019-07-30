public static void registerUser(String userName, String password) {
    
		for (User user : users) {
			if (userName.equals(user.getName())) {
				System.out.println(
						"The user you want to create already exists. Please chose another name and try again!");
				View.registerView();
			}
		}
		User newUser = new User(userName, password);
		users.add(newUser);
		// TODO Serialize the list (maybe extra method)
		System.out.println("Your account was created, congratulations! ");
		View.loginView();
	}
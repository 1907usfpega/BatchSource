package core;

public class Six {

	public Six() {
		// TODO Auto-generated constructor stub
	}
	public boolean even(int x) {
		boolean isEven=false;
		for(int i=0; i<=x;i++) {
			isEven=!isEven;
		}
		System.out.println(isEven);
		return isEven;
	}
	
}

package factory;

//Creates object without showing creation logic to client
public class HondaFactory {

	//Use factory method to return Car Model to user based on String given
	
	public Car getCar(String whatCar, String color) {
		if("civic".equals(whatCar)) {
			return new Car("Honda", 2019, "Civic", color);
		}
		else if(whatCar.equals("crv")){
				return new Car("Honda", 2019, "CRV", color);
			}
			return null;
	}
	
}//end HondaFactory class

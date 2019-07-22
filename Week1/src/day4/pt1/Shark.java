package day4.pt1;

public class Shark extends Fish implements Hunt {

	@Override
	public void findPrey() {
		System.out.println("Fish are friends, not food.");
	}

	@Override
	public void swim() {
		System.out.println("Just keep swimming.");
	}

	@Override
	public void breathe() {
		System.out.println("I use my gills to breathe underwater.");
	}

}

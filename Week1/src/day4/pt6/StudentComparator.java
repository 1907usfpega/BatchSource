package day4.pt6;

import java.util.Comparator;

public class StudentComparator implements Comparator<Comparisons>{

	@Override
	public int compare(Comparisons arg0, Comparisons arg1) {
		return (int)(arg0.getGpa() - arg1.getGpa());
	}
	
}

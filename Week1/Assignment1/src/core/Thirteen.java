package core;

public class Thirteen {
	public String printSteps() {
		int a=0;
		StringBuilder sb = new StringBuilder();
		sb.append("");
		for(int x=0;x<5;x++) {
			for (int i = 0; i <x; i++) {
				sb.append(a);
				System.out.print(a);
				if(a==1) {a=0;}
				else {a=1;}
			}
			sb.append("\n");
			System.out.println();	
		}
		//System.out.println(sb.toString());
		return sb.toString();
	}
}

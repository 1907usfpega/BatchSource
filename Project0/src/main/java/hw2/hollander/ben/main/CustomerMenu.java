package hw2.hollander.ben.main;

public class CustomerMenu {
    public static void menu(int hash) {
    	char choice;
    	do {
    		
    		System.out.println("1: Deposit");
    		System.out.println("2: Withdraw");
    		System.out.println("3: View Balance");
    		System.out.println("ANY OTHER KEY TO EXIT");
    		choice = Driver.input.next().charAt(0);
    		switch(choice) {
    		case '1':
    			//deposit
    			break;
    		case '2':
    			//withdraw
    			break;
    		case '3':
    			//view balance
    			break;
    		default:
    			System.out.println("Goodbye");
    			System.exit(0);
    		}
    	}while(choice!='1' || choice!='2' || choice!='3');
    }
}

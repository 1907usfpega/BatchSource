package bankingApp;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class BankApp<BankAccount> {


	String AccountHolderName;
	double balance;
	int deposits;
	int withdrawals;
	public BankApp(String AccountHolderName,double balance,int deposits,int withdrawals)
	{
	this.AccountHolderName=AccountHolderName;
	this.balance=balance;
	this.withdrawals=withdrawals;
	this.deposits=deposits;
	}
	public void withdrawals(ArrayList<BankApp> list,double Amount,int index)
	{
	list.get(index).balance=list.get(index).balance-Amount;
	}
	public void Deposits(ArrayList<BankApp> list,double Amount,int index)
	{
	list.get(index).balance=list.get(index).balance+Amount;
	}
	}
	public class ATM extends BankApp
	{
	public ATM(String AccountHolderName, double balance,int deposits, int withdrawals)
	{
	super(AccountHolderName, balance, deposits, withdrawals);
	}
	public static void main(String[] args) throws FileNotFoundException
	{
	Scanner sc=new Scanner(System.in);
	ArrayList<BankApp>list=new ArrayList<BankApp>();
	File BankDetails = new File ("");
	Scanner scanner = new Scanner(BankDetails);
	String FirstName;
	double balance;
	BankApp account = null;
	int deposits,withdraws,index=0,option;
	boolean status;
	while(scanner.hasNextLine())
	{
	FirstName = scanner.next();
	balance = scanner.nextDouble();
	deposits=scanner.nextInt();
	withdraws= scanner.nextInt();
	account=new BankApp(FirstName,balance,deposits,withdraws);
	list.add(account);
	}
	while(true)
	{
	System.out.println("*** Main Menu ****");
	System.out.println("1.check Balance");
	System.out.println("2.Withdraw");
	System.out.println("3.Deposit");
	System.out.println("4.Display the largest change in balance (positive or negative)and the date on which it occurred. ");
	System.out.println("5.Display All Transactions");
	System.out.println("6.Display All Transactions on a specific date.");
	System.out.println("7.Exit");
	System.out.println("please Select any option");
	option=sc.nextInt();
	status= false;
	switch(option)
	{
	case 1:
	System.out.println("Please Enter AccountHolderName");
	FirstName=sc.next();
	for(BankApp obj:list)
	{
	if(FirstName.equals(obj.AccountHolderName))
	{
	System.out.println("The Account Details are");
	System.out.println("Name: "+obj.AccountHolderName);
	System.out.println("Available Balance: "+obj.balance);
	status=true;
	}
	index++;
	}
	if(status==false)
	System.out.println("Account Details are not found");
	break;
	case 2:
	System.out.println("Please Enter AccountHolderName");
	FirstName=sc.next();
	status=false;
	index=0;
	for(BankApp obj:list)
	{
	if(FirstName.equals(obj.AccountHolderName))
	{
	System.out.println("The Account Details are");
	System.out.println("Name: "+obj.AccountHolderName);
	System.out.println("Available Balance: "+obj.balance);
	status=true;
	System.out.println("Please Enter the Amount to withdraw");
	double Amount=sc.nextDouble();
	if(Amount>obj.balance)
	{
	System.out.println("Withdrwal is Not Possible");
	}
	else
	{
	account.withdrawals(list,Amount,index);
	System.out.println("Amount Debited Successfully");
	}
	}
	index++;
	}
	if(status==false)
	System.out.println("Account Details are not found");
	break;
	case 3:
	System.out.println("Please Enter AccountHolderName");
	FirstName=sc.next();
	status=false;
	index=0;
	for(BankApp obj:list)
	{
	if(FirstName.equals(obj.AccountHolderName))
	{
	System.out.println("The Account Details are");
	System.out.println("Name: "+obj.AccountHolderName);
	System.out.println("Available Balance: "+obj.balance);
	status=true;
	System.out.println("Please Enter the Amount to Deposit");
	double Amount=sc.nextDouble();
	account.Deposits(list, Amount, index);
	System.out.println("Amount Credited Successfully");
	}
	index++;
	}
	if(status==false)
	System.out.println("Account Details are not found");
	break;
	case 7:
	System.exit(0);
	default:
	System.out.println("Invalid Option please try again");
	}
	}
	}
	}



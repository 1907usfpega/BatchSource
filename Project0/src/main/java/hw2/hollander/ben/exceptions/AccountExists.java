package hw2.hollander.ben.exceptions;

public class AccountExists extends Exception{
    public AccountExists() {
        super("Account already exists");
    }
}

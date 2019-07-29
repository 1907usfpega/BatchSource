package hw2.hollander.ben.exceptions;

public class AccountNotEmptyException extends Exception {
    public AccountNotEmptyException(){
        super("Your account balance must be 0 for you to delete your account");
    }
}

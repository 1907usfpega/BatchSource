package hw2.hollander.ben.exceptions;

public class WrongCredentialsException extends Exception {
    public WrongCredentialsException() {
        super("Wrong username/password");
    }
}

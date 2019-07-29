package hw2.hollander.ben.exceptions;

public class BadValueException extends Exception {
    public BadValueException() { 
        super("You entered an invalid value");
    }
}

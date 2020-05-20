package ru.itmo;

@SuppressWarnings("serial")
public class NegativeQuantityException extends Exception {
    public NegativeQuantityException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }
}

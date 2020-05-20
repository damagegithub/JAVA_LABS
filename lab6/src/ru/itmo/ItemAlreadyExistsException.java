package ru.itmo;

@SuppressWarnings("serial")
public class ItemAlreadyExistsException extends Exception {
    public ItemAlreadyExistsException(final String errorMessage) {
        super(errorMessage);
    }
}


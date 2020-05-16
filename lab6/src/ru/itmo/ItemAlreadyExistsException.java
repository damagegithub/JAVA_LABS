package ru.itmo;

import java.lang.Exception;

@SuppressWarnings("serial")
public class ItemAlreadyExistsException extends Exception {
    public ItemAlreadyExistsException(final String errorMessage) {
        super(errorMessage);
    }
}

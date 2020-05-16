package ru.itmo;

import java.lang.Exception;

@SuppressWarnings("serial")
public class NegativeQuantityException extends Exception {
    public NegativeQuantityException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }
}

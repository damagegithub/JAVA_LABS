package ru.itmo;

import java.io.FileNotFoundException;

@SuppressWarnings("serial")
public class CatalogLoadException extends Exception {
    public CatalogLoadException(String errorMessage) {
        super(errorMessage);
    }

    public CatalogLoadException(ItemAlreadyExistsException e) {
        // TODO 自动生成的构造函数存根
        super(e);
    }

    public CatalogLoadException(FileNotFoundException e) {
        // TODO 自动生成的构造函数存根
        super(e);
    }
}

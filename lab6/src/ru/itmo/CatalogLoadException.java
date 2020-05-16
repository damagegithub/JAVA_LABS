package ru.itmo;

import java.io.FileNotFoundException;
import java.lang.Exception;

@SuppressWarnings("serial")
public class CatalogLoadException extends Exception {
    public CatalogLoadException(String errorMessage) {
        super(errorMessage);
    }

	public CatalogLoadException(ItemAlreadyExistsException e) {
		// TODO �Զ����ɵĹ��캯�����
		super(e);
	}

	public CatalogLoadException(FileNotFoundException e) {
		// TODO �Զ����ɵĹ��캯�����
		super(e);
	}
}

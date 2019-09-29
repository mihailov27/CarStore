package com.mmihaylov.backend.facade;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class CarStoreException extends RuntimeException {

    public CarStoreException(String msg) {
        super(msg);
    }

    public CarStoreException(Throwable th) {
        super(th);
    }

    public CarStoreException(String msg, Throwable th) {
        super(msg, th);
    }

}

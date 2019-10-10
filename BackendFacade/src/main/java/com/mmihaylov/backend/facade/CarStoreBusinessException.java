package com.mmihaylov.backend.facade;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class CarStoreBusinessException extends RuntimeException {

    public CarStoreBusinessException(String msg) {
        super(msg);
    }

    public CarStoreBusinessException(Throwable th) {
        super(th);
    }

    public CarStoreBusinessException(String msg, Throwable th) {
        super(msg, th);
    }

}

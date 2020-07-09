package com.keanntech.framework.common.exception;

import com.keanntech.framework.common.api.IErrorCode;

public class UserNotLoginException extends RuntimeException{
    private IErrorCode errorCode;

    public UserNotLoginException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public UserNotLoginException(String message) {
        super(message);
    }

    public UserNotLoginException(Throwable cause) {
        super(cause);
    }

    public UserNotLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}

package com.codewoorld.DevLingoAPI.exception;

public class LingoNotFoundException extends RuntimeException{
    public LingoNotFoundException(String message) {
        super(message);
    }

    public LingoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

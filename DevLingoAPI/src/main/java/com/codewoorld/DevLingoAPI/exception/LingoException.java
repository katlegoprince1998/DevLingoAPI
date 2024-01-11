package com.codewoorld.DevLingoAPI.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@RequiredArgsConstructor
@Data
public class LingoException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

}

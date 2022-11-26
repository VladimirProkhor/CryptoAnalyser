package com.javarush.prokhorov.exception;

import com.javarush.prokhorov.entity.ResultCode;

public class ApplicationException extends RuntimeException{
    public ApplicationException(String message) {
        super(ResultCode.ERROR + message);
    }
}

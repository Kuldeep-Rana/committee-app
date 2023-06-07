package com.codersdesks.committee.exception;

public class NoRecordFoundException extends Exception{
    public NoRecordFoundException(){

    }
    public NoRecordFoundException(String msg){
        super(msg);
    }
    public NoRecordFoundException(String msg, Throwable cause){
        super(msg,cause);
    }
}

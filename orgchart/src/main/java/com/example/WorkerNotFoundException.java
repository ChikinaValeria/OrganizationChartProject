package com.example;
public class WorkerNotFoundException extends RuntimeException{
    public WorkerNotFoundException(String message){
        super(message);
    }
}

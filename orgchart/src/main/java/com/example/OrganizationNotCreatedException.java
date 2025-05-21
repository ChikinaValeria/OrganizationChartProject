package com.example;
public class OrganizationNotCreatedException extends RuntimeException{
    public OrganizationNotCreatedException(String message){
        super(message);
    }
}

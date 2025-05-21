package com.example;
public class Worker extends OrgComponent{

    private String name;
   
    public Worker(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    
    @Override
    public void print(){
        System.out.println("Worker: " + name);
    }

}

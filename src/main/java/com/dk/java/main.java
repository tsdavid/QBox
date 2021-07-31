package com.dk.java;


abstract class MainAbstract {

    private String name;
    private int num;

    private String getName(){
        return this.name;
    }
    private int getNum(){
        return this.num;
    }

    public abstract void printName();
}


abstract class main extends MainAbstract{

    private void name(){
        System.out.println("");
    }
}

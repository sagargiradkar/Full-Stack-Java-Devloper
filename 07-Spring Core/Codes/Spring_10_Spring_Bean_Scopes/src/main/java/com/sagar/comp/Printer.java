package com.sagar.comp;

public class Printer {
    private static Printer INSTANCE = null;

    private Printer(){

    }
    static {
        System.out.println("Printer.class file loading ...");
    }
    public static Printer getINSTANCE   (){
        System.out.println("getInstance() method  called");
        if(INSTANCE == null){
            INSTANCE = new Printer();
        }
        return INSTANCE;
    }

    @Override
    public String toString() {
        return "Printer [hashcode() :: "+hashCode()+"]";
    }
}

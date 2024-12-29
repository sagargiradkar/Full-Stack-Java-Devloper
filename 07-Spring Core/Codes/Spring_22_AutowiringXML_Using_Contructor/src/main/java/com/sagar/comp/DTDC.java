package com.sagar.comp;

public class DTDC implements Courier{

    static {
        System.out.println("DTDC.class file is loading....");
    }

    public DTDC(){
        System.out.println("DTDC:: Zero parameterized constructor ...");
    }
    @Override
    public String deliver(int oid) {
        System.out.println("DTDC.Deliver()");

        return "DTDC Courier will delivered with the order is ::"+oid+" for the orderd products";

    }
}

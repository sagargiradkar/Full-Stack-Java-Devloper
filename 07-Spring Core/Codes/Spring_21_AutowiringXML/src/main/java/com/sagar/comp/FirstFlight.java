package com.sagar.comp;

public class FirstFlight implements Courier{

    static {
        System.out.println("Flipkart.class file is loading....");
    }

    public FirstFlight(){
        System.out.println("FirstFlight:: Zero parameterized constructor ...");
    }
    @Override
    public String deliver(int oid) {
        System.out.println("FirstFlight.Deliver()");

        return "FirstFlight Courier will delivered with the order is ::"+oid+" for the orderd products";

    }
}

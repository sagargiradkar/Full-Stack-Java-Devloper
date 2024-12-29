package com.sagar.comp;

public class BlueDart implements Courier{

    static {
        System.out.println("BlueDart.class file is loading....");
    }

    public BlueDart(){
        System.out.println("BlueDart:: Zero parameterized constructor ...");
    }
    @Override
    public String deliver(int oid) {
        System.out.println("BlueDart.Deliver()");

        return "BulueDart Courier will delivered with the order is ::"+oid+" for the orderd products";

    }
}

package com.sagar.comp;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "dtdc")
@Scope(scopeName = "prototype")
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

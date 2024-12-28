package com.sagar.comp;

public class Person {
    private String name;
    private String address;
    private int age;

    // Constructor
    public Person(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", address=" + address + ", age=" + age + "]";
    }
}

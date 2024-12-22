package com.sagar.comp;

public class Student {
    private Integer sno;
    private String sname;
    private String saddr;
    private float avg;

    static {
        System.out.println("Student.class file is loading");
    }
    public Student(Integer sno, String sname, String saddr, float avg) {
        this.sno = sno;
        this.sname = sname;
        this.avg = avg;
        this.saddr = saddr;
        System.out.println("Student :: 4 param constructor");
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                ", saddr='" + saddr + '\'' +
                ", avg=" + avg +
                '}';
    }
}

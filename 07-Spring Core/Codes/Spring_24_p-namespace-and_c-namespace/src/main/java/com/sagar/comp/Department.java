package com.sagar.comp;

import java.util.Date;

public class Department {
    private int dno;
    private Date doj;
    private String dname;

    public Department(int dno, Date doj, String dname) {
        this.dno = dno;
        this.doj = doj;
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dno=" + dno +
                ", doj=" + doj +
                ", dname='" + dname + '\'' +
                '}';
    }
}

package com.sagar.comp;

import java.util.Date;

public class Employee {
    private int eno;
    private String ename;
    private Date dob;
    private Department dept;

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eno=" + eno +
                ", ename='" + ename + '\'' +
                ", dob=" + dob +
                ", dept=" + dept +
                '}';
    }
}

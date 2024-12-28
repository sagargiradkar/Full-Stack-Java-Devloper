package com.sagar.comp;

import java.util.Date;

public class PersonalInfo {
    private Integer pid;
    private String pname;
    private String paddress;
    private Date dob;
    private Date dom;
    private Date doj;

    public PersonalInfo(Date dom, Date doj, Date dob, String paddress, String pname, Integer pid) {
        System.out.println("PersonalInfo :: 6 param constructor ");
        this.dom = dom;
        this.doj = doj;
        this.dob = dob;
        this.paddress = paddress;
        this.pname = pname;
        this.pid = pid;
    }


    @Override
    public String toString() {
        return "PersonalInfo{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", paddress='" + paddress + '\'' +
                ", dob=" + dob +
                ", dom=" + dom +
                ", doj=" + doj +
                '}';
    }
}

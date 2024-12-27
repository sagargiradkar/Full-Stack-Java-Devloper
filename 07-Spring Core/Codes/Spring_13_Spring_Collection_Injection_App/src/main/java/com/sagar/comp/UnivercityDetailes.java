package com.sagar.comp;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

public class UnivercityDetailes {

    private Map<Integer,String> facultyDetails;
    private Map <String, Date> datesInfo;
    private Properties iplInfo;

    public void setIplInfo(Properties iplInfo) {
        this.iplInfo = iplInfo;
        System.out.println("Implementation class of Map is ::"+iplInfo.getClass().getName());

    }

    public void setFacultyDetails(Map<Integer, String> facultyDetails) {
        this.facultyDetails = facultyDetails;
        System.out.println("Implementation class of Map is ::"+facultyDetails.getClass().getName());

    }

    public void setDatesInfo(Map<String, Date> datesInfo) {
        this.datesInfo = datesInfo;
    }

    @Override
    public String toString() {
        return "UnivercityDetailes{" +
                "facultyDetails=" + facultyDetails +
                ", datesInfo=" + datesInfo +
                ", iplInfo=" + iplInfo +
                '}';
    }
}

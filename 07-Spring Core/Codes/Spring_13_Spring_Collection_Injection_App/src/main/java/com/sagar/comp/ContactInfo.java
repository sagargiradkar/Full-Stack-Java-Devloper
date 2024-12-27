package com.sagar.comp;

import java.util.Date;
import java.util.Set;

public class ContactInfo {
    private Set<Long> phoneNumbers;
    private Set<Date> dates;

    public void setPhoneNumbers(Set<Long> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
        System.out.println("Implementation class ::"+phoneNumbers.getClass().getName());
    }

    public void setDates(Set<Date> dates) {
        this.dates = dates;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "phoneNumbers=" + phoneNumbers +
                ", dates=" + dates +
                '}';
    }
}

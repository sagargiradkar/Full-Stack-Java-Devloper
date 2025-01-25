package com.ineuron.model;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class Customer {

    private Integer cno;
    private String cname;
    private Float billAmount;
    private String[] favColor;
    private List<String> studies;
    private Set<Long> phoneNumbers;
    public Map<String,Object> idDetails;
    public Company company;
}

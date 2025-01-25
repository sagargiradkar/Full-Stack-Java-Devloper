package in.ineuron.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class CoronaVaccine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regNo;
    private String name;
    private String company;
    private String country;
    private Double price;
    private Integer requiredDoseCount;

    public CoronaVaccine() {
        System.out.println("Hibernate uses internally Zero param constructor");
    }

    public CoronaVaccine(String name, String company, String country, Double price, Integer requiredDoseCount) {
        this.name = name;
        this.company = company;
        this.country = country;
        this.price = price;
        this.requiredDoseCount = requiredDoseCount;
    }

    public Long getRegNo() {
        return regNo;
    }

    public void setRegNo(Long regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getRequiredDoseCount() {
        return requiredDoseCount;
    }

    public void setRequiredDoseCount(Integer requiredDoseCount) {
        this.requiredDoseCount = requiredDoseCount;
    }

    @Override
    public String toString() {
        return "CoronaVaccine{" +
                "regNo=" + regNo +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", country='" + country + '\'' +
                ", price=" + price +
                ", requiredDoseCount=" + requiredDoseCount +
                '}';
    }
}

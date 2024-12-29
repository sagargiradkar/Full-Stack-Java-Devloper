package in.ineuron.dto;

public class EmplyeeDTO {
    private String eid;
    private String ename;
    private String eage;
    private String eaddress;
    private Float esalary;
    private Float hikeAmount;

    public Float getEsalary() {
        return esalary;
    }

    public void setEsalary(Float esalary) {
        this.esalary = esalary;
    }

    public Float getHikeAmount() {
        return hikeAmount;
    }

    public void setHikeAmount(Float hikeAmount) {
        this.hikeAmount = hikeAmount;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getEaddress() {
        return eaddress;
    }

    public void setEaddress(String eaddress) {
        this.eaddress = eaddress;
    }

    public String getEage() {
        return eage;
    }

    public void setEage(String eage) {
        this.eage = eage;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Override
    public String toString() {
        return "EmplyeeDTO{" +
                "eid='" + eid + '\'' +
                ", ename='" + ename + '\'' +
                ", eage='" + eage + '\'' +
                ", eaddress='" + eaddress + '\'' +
                ", esalary=" + esalary +
                ", hikeAmount=" + hikeAmount +
                '}';
    }
}

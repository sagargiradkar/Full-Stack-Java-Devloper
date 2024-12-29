package in.ineuron.vo;

public class EmployeeVo {
    private String eid;
    private String ename;
    private String eage;
    private String eaddress;
    private String hikeAmt;

    public String getHikeAmt() {
        return hikeAmt;
    }

    public void setHikeAmt(String hikeAmt) {
        this.hikeAmt = hikeAmt;
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

    public void setEaddress(String eadress) {
        this.eaddress = eadress;
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
        return "EmployeeVo{" +
                "eid='" + eid + '\'' +
                ", ename='" + ename + '\'' +
                ", eage='" + eage + '\'' +
                ", eaddress='" + eaddress + '\'' +
                ", hikeAmt='" + hikeAmt + '\'' +
                '}';
    }
}

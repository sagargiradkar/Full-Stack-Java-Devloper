package in.ineuron.bo;

public class EmployeeBO {
	private int eid;
	private String ename;
	private Integer eage;
	private String eaddress;
	private String desg;
	private Integer eSalary;
	
	
	public int getEid() {
		return eid;
	}


	public void setEid(int eid) {
		this.eid = eid;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public Integer getEage() {
		return eage;
	}


	public void setEage(Integer eage) {
		this.eage = eage;
	}


	public String getEaddress() {
		return eaddress;
	}


	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}


	public String getDesg() {
		return desg;
	}


	public void setDesg(String desg) {
		this.desg = desg;
	}


	public Integer geteSalary() {
		return eSalary;
	}


	public void seteSalary(Integer eSalary) {
		this.eSalary = eSalary;
	}


	@Override
	public String toString() {
		return "EmployeeBO [eid=" + eid + ", ename=" + ename + ", eage=" + eage + ", eaddress=" + eaddress + ", desg="
				+ desg + ", eSalary=" + eSalary + "]";
	}
	
	
}

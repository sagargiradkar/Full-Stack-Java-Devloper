package in.ineuron.dto;

public class EmployeeDTO {
	private int eid;
	private String ename;
	private Integer eage;
	private String eaddress;
	private String desg;
	private Integer salary;
	
	
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


	public Integer getSalary() {
		return salary;
	}


	public void setSalary(Integer salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "EmployeeDTO [eid=" + eid + ", ename=" + ename + ", eage=" + eage + ", eaddress=" + eaddress + ", desg="
				+ desg + ", salary=" + salary + "]";
	}


	
	
}

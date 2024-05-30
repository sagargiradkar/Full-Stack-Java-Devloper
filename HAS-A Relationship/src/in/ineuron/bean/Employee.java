package in.ineuron.bean;

public class Employee {
	private String eid;
	private String ename;
	private String eaddr;
	
	//HAS-A relationship
	Account account;
	
	//Constructor Injection
	public Employee(String eid, String ename, String eaddr,	Account account
) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.eaddr = eaddr;
		this.account=account;
	}
	
	public void getEmployeeDetails() {
		System.out.println("Employee details are");
		System.out.println("EMPID ::"+eid);
		System.out.println("EMPNAME ::"+ename);
		System.out.println("EADDRESS ::"+eaddr);
		System.out.println("ACCOUNT Details Are ......");
		System.out.println("ACCONO ::"+account.accNo);
		System.out.println("ACCOUNT NAME ::"+account.accName);
		System.out.println("ACCOUNT Type ::"+account.accType);
	}
}

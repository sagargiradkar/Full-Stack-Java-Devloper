package in.ineurom.main;

import in.ineuron.bean.Account;
import in.ineuron.bean.Employee;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account("ABC123","Sagar","Saving");
		
		Employee employe = new Employee("IND10","sachin","MI",account);
		
		employe.getEmployeeDetails();
				
	}

}

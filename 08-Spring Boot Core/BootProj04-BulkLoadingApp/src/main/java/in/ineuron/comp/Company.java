package in.ineuron.comp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "org.info")
public class Company {
	
	private String name;
	private String location;
	private Integer size;
	private String pincode;
	
	
	static {
		System.out.println("Company.class file is loading..");
	}
	
	public Company() {
		System.out.println("Company.Company() contructor ");
	}
	
	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		System.out.println("Company.setName()");
		this.name = name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		System.out.println("Company.setLocation()");
		this.location = location;
	}


	public Integer getSize() {
		return size;
	}


	public void setSize(Integer size) {
		System.out.println("Company.setSize()");
		this.size = size;
	}


	@Override
	public String toString() {
		return "Company [name=" + name + ", location=" + location + ", size=" + size + ", pincode=" + pincode + "]";
	}
	
	

}

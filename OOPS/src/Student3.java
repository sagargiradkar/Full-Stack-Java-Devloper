class Student4{
	private String name;
	private int rollNo;
	private String cityName;
	private int age;
	
	

public Student4(String name, int rollNo, String cityName, int age) {
		super();
		//this();
		this.name = name;
		this.rollNo = rollNo;
		this.cityName = cityName;
		this.age = age;
	}
//	public Student4(String name, int rollNo, String cityName) {
//		this.name = name;
//		this.rollNo = rollNo;
//		this.cityName = cityName;
//	}
//	
//	public Student4() {
//		name="Sagar";
//		age = 22;
//		cityName="Bhnadara";
//	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getRollNo() {
		return rollNo;
	}
	public String getCityName() {
		return cityName;
	}

}
public class Student3 {

	public static void main(String[] args) {
	
		Student4 std = new Student4("Sagar",3051,"Bhnadara",22);
		
		
		System.out.println(std.getName());
		System.out.println(std.getRollNo());
		System.out.println(std.getCityName());
		
		//Student4 sdt2 = new Student4();
		System.out.println();
	}

}

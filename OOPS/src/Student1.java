class Student2{
	private String name;
	private int rollNo;
	private String cityName;
	
	public Student2(String name, int rollNo,String cityName) {
		this.name=name;
		this.rollNo=rollNo;
		this.cityName=cityName;
		
	}
	public String getName() {
		return name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public String getCityName() {
		return cityName;
	}
	
	public void serData(String name,int age,String city) {
		this.name = name;
		this.rollNo = age;
		this.cityName = city;
	}
}
public class Student1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student2 std = new Student2("Sagar",22,"Bhnadara");
		System.out.println(std.getName());
		System.out.println(std.getRollNo());
		System.out.println(std.getCityName());
	}

}

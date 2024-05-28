class Student
{
	//private
	 private int age; // instqance variable/Data members/Fields
	 private String name;//properties
	 private String city;
	 private boolean flag;
	 
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}


public class Encap {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
		Student st=new Student();
//		st.age=30;
//		st.name="sagar";
//		st.city="Bengluru";
		
		
		st.setAge(22);
		st.setName("Sagar");
		st.setCity("Bhandara");
		System.out.println(st.getAge());
		System.out.println(st.getName());
		System.out.println(st.getCity());
	
	}

}

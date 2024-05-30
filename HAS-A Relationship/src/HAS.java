class Student{
	private String name;
	private Integer sage;
	private Integer sid;
	
	public Student(String name, Integer sage, Integer sid) {
		super();
		this.name = name;
		this.sage = sage;
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSage() {
		return sage;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", sage=" + sage + ", sid=" + sid + "]";
	}
	
}
public class HAS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student obj = new Student("Sagar",25,25);
		System.out.println(obj);
	}

}

package in.ineuron.beam;

public class Srudent {
	private Integer sid;
	private String sname;
	private String saddress;
	private Integer sage;
	
	static {
		System.out.println("Srudent.enclosing_method()");
	}
	public Srudent() {
		System.out.println("Srudent.Srudent()");
	}
	public Integer getSid() {
		System.out.println("Srudent.getSid()");
		return sid;
	}
	public void setSid(Integer sid) {
		System.out.println("Srudent.setSid()");
		this.sid = sid;
	}
	public String getSname() {
		System.out.println("Srudent.getSname()");
		return sname;
	}
	public void setSname(String sname) {
		System.out.println("Srudent.setSname()");
		this.sname = sname;
	}
	public String getSaddress() {
		System.out.println("Srudent.getSaddress()");
		return saddress;
	}
	public void setSaddress(String saddress) {
		System.out.println("Srudent.setSaddress()");
		this.saddress = saddress;
	}
	public Integer getSage() {
		System.out.println("Srudent.getSage()");
		return sage;
	}
	public void setSage(Integer sage) {
		System.out.println("Srudent.setSage()");
		this.sage = sage;
	}
	@Override
	public String toString() {
		return "Srudent [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", sage=" + sage + "]";
	}
	
	
	
}

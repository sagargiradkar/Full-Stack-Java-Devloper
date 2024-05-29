class Demo1{
	String name = "Sagar";
	int age = 21;
	
	void disp()
	{
		System.out.println("Demo1 age :"+ age +"\nName :"+name);
	}
			
}
class Demo2 extends Demo1{
	
}
public class LaunichIn1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo2 d = new Demo2();
		d.disp();
	}

}

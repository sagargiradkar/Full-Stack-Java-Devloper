class Demo2{
	static int a;
	static
	{
		a=10;
	}
	static void disp() {
		System.out.println("Static disp :"+a);
	}
}
public class StaticBlockInitialization {
	static void disp2()
	{
		System.out.println("DispP2");
	}
	public static void main(String[] args) {
		System.out.println("Main Method");
		disp2();
		Demo2.disp();
		Demo2 d = new Demo2();
		d.disp();
	}
}

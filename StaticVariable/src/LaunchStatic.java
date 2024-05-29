class Demo
{
	static int a;
	static int b;
	Demo(){
		System.out.println("Construction");
	}
	static
	{
		System.out.println("Inside Static Block");
		a=10;
		b=20;
	}
	static void display() 
	{
		System.out.println("Static method");
		System.out.println(a);
		System.out.println(b);
	}
	int x;
	int y;
	{
		x=10;
		y=30;
		System.out.println("Non Static Java block");
	}
	void diplplay1() {
		System.out.println(x);
		System.out.println(y);
	}
}
public class LaunchStatic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo.display();
//		Demo d = new Demo();
//		d.diplplay1();
//		d.display();
	}

}

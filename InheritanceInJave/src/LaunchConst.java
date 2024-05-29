class Parrents
{
	int a,b;
	
	Parrents()
	{
		this(100,20051);
		a=10;
		b=50;
		System.out.println("Parent Constructor");
	}
	Parrents(int a,int b)
	{
		
		this.a=a;
		this.b=b;
		System.out.println("Parent Para constructor :"+a+" "+b);
	}

}

class Child extends Parrents
{
	int x,y;
	Child () 
	{
		//super(1000,2000);
		this(5000,8000);
		x = 100;
		y = 200;
		
		
	}
	Child(int x,int y)
	{
		this.x = x;
		this.y=y;
		System.out.println("Child Para constructor :"+x+" "+y);
		
	}
		void display()
	{
		System.out.println(a);
		System.out.println(b);
		System.out.println(x);
		System.out.println(y);
	}
}
public class LaunchConst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child ch = new Child();
		ch.display();
		
		Child ch1 = new Child();
		ch1.display();
		
	}

}

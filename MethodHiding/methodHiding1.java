class Parents
{
	public static void display()
	{
		System.out.println("Hello Parents ");
	}
}
class Child extends Parents
{
	public static void display() 
	{
		System.out.println("Hello child");
	}
}
//ststic methods do particiate in inheritance 
public class methodHiding1 {

	public static void main(String[] args) {
		
		
		Parents p=new Child(); 
		p.display();
		
		
		Child c = new Child();
		c.display();
		
		/*
		output :: Hello Parents 
				  Hello child
		*/
	}

}

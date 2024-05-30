class Parents 
{
	public void cry()
	{
		System.out.println("Parets crying");
	}
}
class Child1 extends Parents
{
	public void cry()
	{
		System.out.println("Child1 crying");
	}
}
class Child2 extends Parents
{
	public void cry()
	{
		System.out.println("childs2 crying");
	}
}
public class LaunchPoly {

	public static void main(String[] args) {
	
		Parents p = new Parents();
		p.cry();
		Parents p2 = new Child2();
		p2.cry();
	}

}

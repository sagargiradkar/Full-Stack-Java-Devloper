import java.util.Scanner;

class Farmer
{
	private float pa;
	private float td;
	private float si;
	private static float ri;
	
	static
	{
		ri=2.5f;
	}
	
	void input() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Kindly enter the principal ammonut ::");
		pa=sc.nextFloat();
		System.out.print("Kindly mention time duration required ::");
		td=sc.nextFloat();
	}
	void compute()
	{
		si=(pa*td*ri)/100;
	}
	void disp()
	{
		System.out.println("SI is :"+si);
	}
}
public class LaunchLoan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Farmer F1 = new Farmer();
		Farmer F2 = new Farmer();
		
		F1.input();
		F1.compute();
		F1.disp();
		
		
		F2.input();
		F2.compute();
		F2.disp();
		
	}

}

class Calculator{
	int a,b,c;
	
	void add() {
		a=10;
		b=20;
		c=a+b;
		
		System.out.println(c);
	}
	void disp()
	{
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
	}
	void add(int a,int b) {
		c=a+b;
		
		System.out.println(c);
	}
	int add1() {
		int res = a+b;
		return res;
	}
}


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	Calculator calc	= new Calculator();
	
	calc.add();
	calc.add(5, 15);
	System.out.println(calc.add1());
	}

}

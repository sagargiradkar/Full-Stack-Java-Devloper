class Demo1
{
	public void add(int... a)
	{
		System.out.println(a);
		System.out.println("Var-Arg Approach");
		for(int el:a) {
			System.out.println(el);
		}
	}
//	
//	public void add(int a,int b,int c)
//	{
//		System.out.println(a+b+c);
//	}
//	
//	public void add(int a,int b,int c,int d)
//	{
//		System.out.println(a+b+c+d);
//	}
}
public class varargAproch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1 d = new Demo1();
		d.add();
		d.add(25);
		d.add(435,565);
		d.add(40,55,50);
	}

}

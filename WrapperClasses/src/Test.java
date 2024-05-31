import java.util.ArrayList;

public class Test {
	static Integer i7=197870;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Boolean b1 = Boolean.valueOf(true);
		
		if(b1) {
			System.out.println("Hello");
		}
		
		ArrayList a1 = new ArrayList();
		a1.add(10);
		a1.add(15);
		System.out.println(a1);
		
		Integer i1 = Integer.valueOf(10);
		Integer i2 = 10;
		System.out.println(i1);
		System.out.println(i2);
		
		Integer i3 = new Integer("10");
		int i4 = i3 + 10;
		
		System.out.println(i4);
		
	
			int i9=i7;
			m1(i9);
		
		
	}
	public static void m1(Integer i7) {
		int k=i7;
		System.out.println(k);
	}
}

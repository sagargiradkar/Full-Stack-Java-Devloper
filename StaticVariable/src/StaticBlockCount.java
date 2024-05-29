class DemoClass{
	int a;
	int b;
	static int count;
	DemoClass(){
		
		count++;
	}
	DemoClass(int a,int b ){
		count++;
	}
}
public class StaticBlockCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DemoClass d1 = new DemoClass();
		DemoClass d2 = new DemoClass();
		System.out.println(DemoClass.count);
	}

}

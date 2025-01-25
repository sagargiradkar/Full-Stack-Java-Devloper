package ineuron.TestApp;

import java.util.Scanner;

public class TestApp {
	public void sayHello(String name) {
		System.out.println("Demo app say hello");
		for(int i=0; i<=10; i++) {
			System.out.println("name ::"+name);
		}
		System.out.println("End of say hello");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the message ::");
		String msg = scanner.next();
		
		displayMsg(msg);
	}
	private void displayMsg(String msg) {

		System.out.println("Demo app display mgs ::"+msg);
		System.out.println("TestApp.displayMsg()");
		printNumber(10);
	}
	private void printNumber(int n) {

		System.out.println("TestApp.printNumber()");
		for(int i=1; i<=n; i++) {
			System.out.println(i);
			
		}
		System.out.println("end");
	}
	public int add(int a,int b) {
		System.out.println("TestApp.add()");
		return a+b;
	}
	public int sub(int a,int b) {
		System.out.println("TestApp.sub()");
		return a-b;
	}
	
	public static void main(String[] args) {
		TestApp app = new TestApp();
		app.sayHello("sagar");
		app.add(10, 20);
		app.add(30, 30);
	}

}

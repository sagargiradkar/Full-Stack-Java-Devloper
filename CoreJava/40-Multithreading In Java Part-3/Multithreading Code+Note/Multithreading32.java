//Example-3
//->The allowed priorityNumber is from 1 to 10,if we try to 
//. give other values it woudld result in "IllegalArgumentException".

//->set priority of the thread to 100.
//->if we set 100 there will be no compile time error
//   but it results in run time error.
//->it throws IllegalArgumentException Exception

//=>Type in cmd javap java.lang.Thread
//   see setPriority method
//->public final void setPriority(int);
//->it accepts integer


//class MyThread extends Thread
//{
//	public void run() {
//		System.out.println("Priority of Child thread is "+Thread.currentThread().getPriority());
//		
//	}
//	
//}
//public class Multithreading32 {
//
//	public static void main(String[] args) {
//		
//        System.out.println("Priority of main thread is "+Thread.currentThread().getPriority()); 
//        MyThread  t=new MyThread();
//       //->Priority for thread is given
//        t.setPriority(100);
//        t.start();
//
//	}
//}

//output:
//Priority of main thread is 5
//Exception in thread "main" java.lang.IllegalArgumentException
//	at java.base/java.lang.Thread.setPriority(Thread.java:1138)
//	at Multithreading30.main(Multithreading30.java:185)

//Example-4: setting priority after starting thread.
//class MyThread extends Thread
//{
//	public void run() {
//		System.out.println("Priority of Child thread is "+Thread.currentThread().getPriority());
//		 
//	        for(int i=0;i<5;i++) {
//	        	System.out.println("Child thread");
//	        }
//	}
//	
//}
//public class Multithreading32 {
//
//	public static void main(String[] args) {
//		
//       
//        MyThread  t=new MyThread();
//       //->Priority for thread is given
//        t.start();
//        t.setPriority(100);
//        
//        System.out.println("Priority of main thread is "+Thread.currentThread().getPriority()); 
//        for(int i=0;i<5;i++) {
//        	System.out.println("Main thread");
//        }
//	}
//}

//output:
//	Exception in thread "main" Priority of Child thread is 5
//	Child thread
//	Child thread
//	Child thread
//	Child thread
//	Child thread
//	java.lang.IllegalArgumentException
//		at java.base/java.lang.Thread.setPriority(Thread.java:1138)
//		at Multithreading32.main(Multithreading32.java:63)


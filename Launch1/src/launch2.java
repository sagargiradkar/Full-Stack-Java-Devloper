import java.util.*;
public class launch2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//To stire and display marks of 5 students 
		
		int[] arr= new int[5];
		
		Scanner scan = new Scanner(System.in);
		
		for(int i=0 ; i<5 ; i++) {
			System.out.println("Please Enter marks of student " + i);
			arr[i] = scan.nextInt();
		}
		
		System.out.println("The marks of stidents are as follows");
		 
		for(int i=0 ; i<5 ;i++) {
			System.out.println(arr[i]+" ");
		}
	}

}

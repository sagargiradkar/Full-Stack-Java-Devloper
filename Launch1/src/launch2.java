import java.util.*;
public class launch2 
{

	public static void main(String[] args) 
	{

		//To stire and display marks of 5 students 
		
		int[] arr= new int[5];
		
		Scanner scan = new Scanner(System.in);
		
		for(int i=0 ; i<arr.length ; i++)
		{
			System.out.print("Please Enter marks of student " + i +":");
			arr[i] = scan.nextInt();
		}
		
		System.out.println("The marks of stidents are as follows");
		 
		for(int i=0 ; i<5 ;i++) 
		{
			System.out.print(arr[i]+" ");
		}

	}

}

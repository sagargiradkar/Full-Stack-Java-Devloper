import java.util.Scanner;

public class launch4 {
	public static void main(String[] args) 
	{

		Scanner sc = new Scanner(System.in);
		int [][] arr = new int[3][4];
		
		for(int i=0 ; i<arr.length ; i++) {
			for(int j=0 ; j<arr.length;j++) {
				System.out.print("Enter marks of class "+i+" Student "+j+" :");
				arr[i][j]=sc.nextInt();
				
			}
		}

		System.out.println("");
		for(int i=0 ; i<arr.length;i++) {
			for(int j=0 ;j<arr.length ;j++) {
				System.out.print(arr[i][j] + " ");
				
			}
			System.out.println(" ");
		}
	}

}

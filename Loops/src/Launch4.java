
public class Launch4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=1;
		do {
			System.out.print("* ");
			i++;
		}while(i<6);
		
		for( i=0 ; i<5 ; i++) {
			System.out.print("* ");
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		for(i=0 ; i<5 ; i++) {
			for(int j=0 ; j<5 ; j++) {
				System.out.print(" * ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		int n = 10 ;
		
		for(i=0 ; i<n ;i++) {
			for(int j=0 ; j<n ; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		for(i=0 ;i<n ; i++) 
		{
			for(int j=0 ; j<n ; j++) 
			{
				if(i==0 || i==n-1 || j==0 || j==n-1)
				{
					System.out.print("* ");
				}
				else
				{
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

}

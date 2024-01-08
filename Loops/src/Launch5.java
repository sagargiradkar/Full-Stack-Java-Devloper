
public class Launch5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Pattern Programming 
		int n = 10;
		for(int i=0 ;i<n ; i++) {
			for(int j=0 ; j<n ;j++) {
				if(j==0 || j==(n-1)/2 || i==(n-1)/2 && j<=(3*n)/4) {
					System.out.print("* ");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}

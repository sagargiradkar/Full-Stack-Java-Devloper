
public class Panagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String s1 = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
		
		s1=s1.replace(" ", "");
		
		char[] ch = s1.toCharArray();
		
		int[] ar = new int[26];
		
		for(int i=0;i<ch.length;i++) {
			int index = ch[i]-65;
			ar[index]++; //ar[19]++  ---> 0++  --> 1++ --->
			
		}
		
		for(int i=0; i<ar.length;i++) {
			if(ar[i]==0) {
				System.out.println("It is not pangram");
				flag=true;
			}
		}
		
		if(flag==false) {
			System.out.println("It is panagram");
		}
	}

}

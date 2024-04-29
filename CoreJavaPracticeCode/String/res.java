class Demo {
    //construction
    public Demo(){

    }
}

public class res {
    public static void main(String[] args) {
        System.out.println("Test Class");
        char[] ch ={'j','a','v','a'};
        String s1 = new String(ch);
        System.out.println(s1);
        String s2 = "Java";

        byte[] b = {65,66,67,68};
        String s3 = new String(b);
        System.out.println(s3); //ABCD

        StringBuffer sb = new StringBuffer("sachin");
        System.out.println("StringBuffer data is ::"+sb);
        String s4 = new String(sb);
        System.out.println("String data is ::"+s4);
        // System.out.println(s1.charAt(-1)); //String index out of range: -1 
        // System.out.println(s1.charAt(500));//String index out of range: 500
        // System.out.println(s1.charAt(0));

        String s = "sachin";
        System.out.println(s.length());

        int[] arr = {10,20,30};
        System.out.println(arr.length);
    
    }
}

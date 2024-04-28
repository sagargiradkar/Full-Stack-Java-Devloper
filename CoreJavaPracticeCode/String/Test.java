class Demo {
    //construction
    public Demo(){

    }
}

public class Test {
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
    }
}

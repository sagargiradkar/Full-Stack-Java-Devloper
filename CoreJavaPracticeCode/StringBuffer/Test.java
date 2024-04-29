public class Test {
    public static void main(String[] args) {
       final StringBuffer sb = new StringBuffer("sachin");
       sb.append("tendulakar");   
       System.out.println(sb);

       // sb = new StringBuffer("Kohali");//        The final local variable sb cannot be assigned. It must be blank and not using a compound assignment
        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());
        System.out.println(sb2.capacity());


        StringBuffer sb3 = new StringBuffer(100);
        System.out.println(sb3);
        StringBuffer sb4 = new StringBuffer("Sagar");
        System.out.println(sb4);

        StringBuffer sb5 = new StringBuffer(100);
        System.out.println(sb5.length());
        System.out.println(sb5.capacity());
        
    }
}

public class Test1 {
    public static void main(String[] args) {
        String s = new String("sachin");
        String s1 = "sachin";
        System.out.println(s1.equals("SACHIN"));
        System.out.println(s1.equalsIgnoreCase("SACHIN"));
        System.out.println();
        String s2 = "iNeuronTechnology";
        System.out.println(s2.length());
        System.out.println(s2.substring(0, 3));

        System.out.println(s2.substring(0, 15));
        System.out.println(s2.codePointAt(2));
        System.out.println(s2.concat(s));
        
    }
}

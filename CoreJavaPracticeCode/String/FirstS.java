public class FirstS{
    public static void main(String[] args) {
        String s1 = "Sagar";
        System.out.println(s1);//Sagar


        String s2 = new String("Kohli");
        System.out.println(s2);//Kohli

        String s3 = "SagarPrakash";
        s3.concat("Giradkar");
        System.out.println(s3);

        //Make string muttable 

        StringBuilder s4 = new StringBuilder("Sagar Prakash ");
        s4.append("Giradkar");
        System.out.println(s4);
    }
}
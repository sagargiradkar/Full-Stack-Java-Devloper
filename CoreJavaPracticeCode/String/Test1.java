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

        String name = "sachin";
        System.out.println(name.replace('a', 'z'));

        String data = "aabbccdd";
        System.out.println(data.replace('a', 'x'));
        System.out.println(data.repeat(10));

        String name1 = "sAchIn";
        System.out.println("name1 :: "+name1.toUpperCase());
        System.out.println("name1 :: "+name1.toLowerCase());


        String name2 = "iNeuron IND";
        System.out.println(name2.length());

        System.out.println();

        System.out.println(name2.trim());

        String state = "   Karnataka  ";
        String state1 = "   Karnataka  ";
        System.out.println(state.length());
        System.out.println(state.trim());
        System.out.println(state1.trim().length());

        System.out.println(state.indexOf('a'));
        System.out.println(state.lastIndexOf('a'));


    }
}

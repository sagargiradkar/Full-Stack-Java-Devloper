package in.ineuron.comp;

public class DTDC implements Courier{

    static {
        System.out.println("DTDC.class file is loading....");
    }

    public DTDC(){
        System.out.println("DTDC:: Zero parameterized constructor ...");
    }
    @Override
    public String deliver(int oid) {
        return null;
    }
}

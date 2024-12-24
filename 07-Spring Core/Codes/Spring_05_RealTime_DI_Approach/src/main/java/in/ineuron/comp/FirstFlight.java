package in.ineuron.comp;

public class FirstFlight implements Courier{

    static {
        System.out.println("Flipkart.class file is loading....");
    }

    public FirstFlight(){
        System.out.println("FirstFlight:: Zero parameterized constructor ...");
    }
    @Override
    public String deliver(int oid) {
        return null;
    }
}

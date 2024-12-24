package in.ineuron.comp;

//Target Object
public class Flipkart {
    //dependent object
    private Courier courier;
    private Float discount;
    static {
        System.out.println("Flipkart .class file is loading ");
    }


    public  Flipkart(){
        System.out.println("Flipcart object is instantiated...");
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
        System.out.println("setDiscount object is instantiated...");

    }

    public void setCourier(Courier courier) {
        this.courier = courier;
        System.out.println("Setter Method called ");
    }
    //Bussiness Logic
    public String doShopping(String []item,Float prices[]){
        System.out.println("Flipkart .doShopping");
        System.out.println("Implementation class is ::"+courier.getClass().getName());
        System.out.println("Discount ammount is "+discount);
        return "";
    }

    @Override
    public String toString() {
        return "Flipkart{" +
                "courier=" + courier +
                ", discount=" + discount +
                '}';
    }
}

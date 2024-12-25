package in.ineuron.comp;

import java.util.Arrays;
import java.util.Random;

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

        int oid = 0;
        Random random = null;
        float billAmt = 0.0f;
        for(float price:prices){
            billAmt+=price;
        }
        billAmt = billAmt - (discount/100.0f);
        random = new Random();
        oid = random.nextInt(1000);
        String msg = courier.deliver(oid);


        return Arrays.toString(item) +" with billAmount of "+billAmt+" ----------> "+msg;
    }

    @Override
    public String toString() {
        return "Flipkart{" +
                "courier=" + courier +
                ", discount=" + discount +
                '}';
    }
}

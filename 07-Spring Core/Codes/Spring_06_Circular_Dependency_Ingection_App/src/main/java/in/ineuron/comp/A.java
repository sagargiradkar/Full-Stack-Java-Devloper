package in.ineuron.comp;

public class A {

    private B b;
    static {
        System.out.println("A.class file loading ....");
    }
    public A()
    {
        System.out.println("A :: 0 param constructor ");

    }
    public void setB(B b){
        this.b = b;
        System.out.println("A.setB()");
    }

    public A(B b) {
        this.b = b;
        System.out.println("B : 1 param contructor");
    }

    @Override
    public String toString() {
        return "A{" +
                "b=" + b +
                '}';
    }
}

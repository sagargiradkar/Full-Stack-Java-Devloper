package in.ineuron.comp;

public class B {
    private A a;
    static {
        System.out.println("B.class file loading ....");
    }
public B(){
    System.out.println("B : 0 param contructor");
}

    public B(A a) {
        this.a = a;
        System.out.println("B : 1 param contructor");
    }

    public void setA(A a) {
        this.a = a;
        System.out.println("B.setB()");
    }

    @Override
    public String toString() {
        return "B{" +
                "a=" + a +
                '}';
    }
}

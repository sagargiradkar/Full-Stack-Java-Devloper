package in.ineuron;

public class App 
{
    public int add(int x,int y) {
    	return x+y;
    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        App app = new App();
        System.out.println("The sum is :: "+app.add(10, 20));
    }
}

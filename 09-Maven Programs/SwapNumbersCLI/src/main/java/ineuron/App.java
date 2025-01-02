package ineuron;

public class App {

    public static void main(String[] args) {
        int num1 = Integer.parseInt(System.getProperty("number1"));
        int num2 = Integer.parseInt(System.getProperty("number2"));

        System.out.println("Before Swap:");
        System.out.println("First Number: " + num1);
        System.out.println("Second Number: " + num2);

        // Swap logic
        int temp = num1;
        num1 = num2;
        num2 = temp;

        System.out.println("\nAfter Swap:");
        System.out.println("First Number: " + num1);
        System.out.println("Second Number: " + num2);
    }
}

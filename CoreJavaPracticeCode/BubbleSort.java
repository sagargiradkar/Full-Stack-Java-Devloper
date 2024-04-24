import java.util.Scanner;

public class BubbleSort {
    public static void BubbleSort1(int num, int arr[]) {
        for (int i = 0; i < num; i++) {
            for (int j = 1; j < num - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Program of Bubble Sort");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of array :");
        int num = sc.nextInt();
        int arr[] = new int[num];
        System.out.println("Enter array elements:");
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Print array elements before sorting ");
        
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println(); // Print a newline after array elements
        
        BubbleSort1(num, arr);
        System.out.println("Print array elements after sorting ");
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}

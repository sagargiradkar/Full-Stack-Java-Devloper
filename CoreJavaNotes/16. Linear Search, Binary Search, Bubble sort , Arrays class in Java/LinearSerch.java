import java.lang.reflect.Array;
import java.util.*;

public class LinearSerch {

    public static void BinarySearch(){
        int []arr = {10,20,30,40,50,60,70,80,90,100};
        int low = 0;
        int high = arr.length-1;
        System.out.println("Enter key :");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();

        while(low<=high){
            int mid = (low+high)/2;

            if(key == arr[mid]){
                System.out.print("Key found at index :"+ mid);
                break;
            }
            else if(key < arr[mid]){
                high = mid - 1;
            }
            else if(key > arr[mid]){
                low = mid + 1;
            }
        }
        if(low > high ){
            System.out.println("Key not found ");
        }
        
    }
    public static void main(String[] args){
        
        int []arr = {10,20,30,40,50,60,70,58};
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();

        for(int i=0 ; i<arr.length ; i++){
            if(key == arr[i]){
                flag = true;
                System.out.print("Element key found at index :"+i);
            }
        }

        if(flag == false){
            System.out.print("Element not found");
        }

        BinarySearch();

        int arr1 [] = {101,1,24,45,234,345,456,34645,645,47};
        Arrays.sort(arr1);
        for(int eme:arr1){
            System.out.print(eme+ " ");
        }
    }
}

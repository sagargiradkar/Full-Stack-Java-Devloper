class Fan {
    public
    int cost;
    String brand;
    int noOfWings;
    
}

public class array {
    public static void main(String[] args)
     
    
    {
        int [] a = new int[3];

        a[0] = 10;
        a[1] = 20;
        a[2] = 30;
        // a[3] = 40; lead to ArrayIndexOutOfBoundsException during runtime
        //Arrays in java are guarded with boundaries
        

        System.out.println("Statement after array");

        char []b = new char[5];
        b[0] = 's';
        b[1] = 'a';
        b[2] = 'g';
        b[3] = 'a';

        Fan f[] = new Fan[3];

        f[0] = new Fan();
        f[1] = new Fan();
        f[2] = new Fan();

        f[0].brand = "Sagar";
        f[0].cost = 1000;
        f[0].noOfWings = 5;

        int [][] ar = {{10,20},{20,30}};

        int [][] ar1 = {{10,20,30},{20,30}};

        int [][][] ar2 = {{{10,20},{20,30}},{{50,60},{25,87}}};

        int [][] ar3 = new int[] {20,30};

        int [][] ar4 = new int[][] {{10,20,30},{20,30}};

        int [][][] ar5 = {{{10,20},{20,30}},{{50,60},{25,87}}};


    }
}

import java.util.*;
public class BinarySearch {
    /*
    * The search function.
    * */
    public static int search(int[] arr, int n, int target) {
        // low starts at 0 and high starts at the end of the array
        int low = 0, high = n - 1;
        // if low crosses over high, then the element isn't in the array
        while(low < high) {
            // get the midpoint between low and high
            int mid = (high-low)/2 + low;
            // first case: we found the number!
            if(arr[mid] == target)
                return mid;
            // too smol
            else if(arr[mid] < target)
                low = mid+1;
            // too lorge
            else
                high = mid;
        }

        // did not find
        return -1;
    }
    public static void print(int[] arr, int size) {
        for(int i = 0; i < size; i++) {
            if(i > 0 && i % 10 == 0) {
                System.out.println();
            }
            System.out.print(arr[i]);
            if(i != size - 1)
                System.out.print(", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int input;
        int lowerBound = 0, upperBound = 100, size = 50;
        int[] arr = new int[size];
        /*
         * Generate the random array.
         * */
        for(int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(upperBound) + lowerBound;
        }
        Arrays.sort(arr);
        print(arr, size);
        System.out.println();
        do {
            System.out.print("Enter the value you'd like to search for (or -1 to exit): ");
            input = scan.nextInt();
            int index = search(arr, size, input);
            if(index > -1)
                System.out.println(input + " is in the array at index " + index + ".");
            else
                System.out.println(input + " is not in the array.");
        } while(input != -1);
    }
}

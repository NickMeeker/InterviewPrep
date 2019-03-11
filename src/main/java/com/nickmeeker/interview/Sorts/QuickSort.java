import java.util.*;

/**
 * You'll notice some duplicate boilerplate here that's copied from merge sort.
 * I want these examples to be self-contained, so I'm just copying it over instead of 
 * making a separate class for it. 
 */
public class QuickSort {
    /*
    * This is the recursive quickSort function, but the real magic is in the partition.
    * */
    public static void quickSort(int[] arr, int low, int high) {
        if(high < low)
            return;
        // Get the partition and "organize" the array around it
        int pivotIndex = partition(arr, low, high);
        /*
        * Note that we're using low-pivotIndex-1 and pivotIndex+1-high as our bounds.
        * This is because we know the element at pivotIndex is in the right place from
        * our partition function. As we're recursively calling quicksort, we can just
        * leave that one alone and focus on the parts of the array that still need to be sorted.
        * */
        quickSort(arr, low, pivotIndex-1);
        quickSort(arr, pivotIndex + 1, high);
    }

    /*
    * The partition function. Magic happens here.
    *
    * It selects a value to "pivot" around and puts it in the right index,
    * then returns that index.
    * */
    public static int partition(int[] arr, int low, int high) {
        // The value to pivot around. For this implementation, we're just always using the last element
        int pivotValue = arr[high];
        // The pivot index. It's going to start at low-1 and work it's way up to the right place
        int pivotIndex = low - 1;

        // iterating over the chunk of the array we care about (the range of low-high)
        for(int i = low; i < high; i++) {
            // if the value in the array is smaller, we need to swap it
            if(arr[i] <= pivotValue) {
                // move our pivot index up
                pivotIndex++;
                // and then swap!
                swap(arr, i, pivotIndex);
            }
        }
        // The very last step. The pivot value is still in arr[high],
        // and everything to the left of the pivotIndex is smaller than it,
        // so the only thing left to do is move the pivotIndex over and swap one last time.
        pivotIndex++;
        swap(arr, pivotIndex, high);
        // return the index
        return pivotIndex;
    }
    /*
    * Swap function that we need for the partition.
    *
    * It swaps elements i and j in array arr.
    * Might need to hit the textbooks for this one.
    * */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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

    /*
     * Used to compare array sorted with our sorting algorithm to an array sorted with Arrays.sort().
     * We want to see how we did!
     *
     * Plus it's good practice for this dp.
     *
     * See this link for my explanation of this algorithm:
     * https://github.com/NickMeeker/InterviewPrep/blob/master/src/main/java/com/nickmeeker/interview/RecursionDP/EditDistance.java
     * */
    public static int editDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+2];
        for(int i = 0; i < n+1; i++) {
            dp[i][0] = i;
        }
        for(int i = 0; i < m + 1; i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                int remove = dp[i-1][j] + 1;
                int insert = dp[i][j-1] + 1;
                int replace = dp[i-1][j-1];
                if(str1.charAt(i-1) != str2.charAt(j-1))
                    replace++;
                dp[i][j] = Math.min(remove, Math.min(insert, replace));
            }
        }
        return dp[n][m];
    }

    /*
     * Utility function to convert an array to a string.
     *
     * */
    public static String arrayToString(int[] arr) {
        String output = "";
        for(int num : arr)
            output += num + ",";
        return output;
    }
    public static void main(String[] args) {
        Random rand = new Random();
        int lowerBound = 0, upperBound = 100, size = 50;
        String controlString, sorted;
        int[] arr = new int[size];
        // Control will be sorted with Arrays.sort() so we can see how we did
        int[] control = new int[size];

        /*
         * Generate the random array and also our control array.
         *
         * */
        for(int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(upperBound) + lowerBound;
            control[i] = arr[i];
        }

        /*
         * Handle sorting the control array
         * */
        Arrays.sort(control);
        controlString = arrayToString(control);

        // Pre-sort
        System.out.println("Unsorted Array:");
        print(arr, size);
        System.out.println();

        // Sort
        System.out.println("Sorted Array:");
        quickSort(arr, 0, size - 1);
        sorted = arrayToString(arr);
        print(arr, size);

        /*
         * Results of our test.
         * */
        System.out.println();
        System.out.println("Control: Array sorted using Arrays.sort()");
        System.out.println(controlString);
        System.out.println();
        System.out.println("Test: Array sorted using our sorting algorithm");
        System.out.println(sorted);
        System.out.println();
        System.out.println("How did we do?");
        System.out.println("There are " + editDistance(controlString, sorted) + " differences"
                + " between the sorted array and the array sorted using Arrays.sort().");
    }
}

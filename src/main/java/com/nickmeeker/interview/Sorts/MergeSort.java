package com.nickmeeker.interview.Sorts;
import java.util.*;

/*
* My merge sort implementation.
* Driver on line 142.
* */
public class MergeSort {
    /*
    * This isn't really the interesting function.
    * This just recursively breaks down the array
    * till the left bound and the right bound are the same (i.e., the first base
    * case will be low == high == 1).
    *
    * Then we merge them back together!
    * */
    public static void mergeSort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr,mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    /*
    * Basic idea is to build a temp array using the values in the ranges
    * low-mid and mid+1-high, then merge these values.
    *
    * This function relies on the fact that the arrays are guaranteed to be sorted
    * to merge the two arrays. The mergeSort() function recurses down to a base case
    * of an array with just a single element, which is sorted. It starts merging
    * single-element arrays together, and then goes back up the recursive tree
    * with progressively larger arrays.
    * */
    public static void merge(int[] arr, int low, int mid, int high) {
        // our temp array, in the range of low-high
        int[] temp = new int[high - low + 1];

        /*
        * We're pulling values from the original array, so it's important to understand what's going on here.
        *
        * l = low so we can start looking from our lower range
        * r = mid+1 so we can start looking from our upper range
        * k --> the index for our temp array. of course this will start at 0
        * */
        int l = low, r = mid + 1, k = 0;
        // we can only go till either left && right are less than their bounds
        while(l < mid + 1 && r < high + 1) {
            /*
            * Now just compare values and fill up temp accordingly
            * */
            if(arr[l] <= arr[r]) {
                temp[k] = arr[l];
                l++;
            } else {
                temp[k] = arr[r];
                r++;
            }
            // increment k either way
            k++;
        }

        /*
        * If either one didn't finish in the above loop,
        * we have to just finish it here
        * */
        while(l < mid + 1) {
            temp[k] = arr[l];
            l++;
            k++;
        }
        while(r < high + 1) {
            temp[k] = arr[r];
            r++;
            k++;
        }

        /*
        * Finally, we can copy our values back into the original array.
        * */
        for(int i = low; i < high + 1; i++) {
            arr[i] = temp[i - low];
        }
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
        mergeSort(arr,0, size - 1);
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

/*
    try every permutation we can get by swapping two digits, compare them all?
        
    we always want to move the largest possible digit to the front of the number
        2736 -> 7236 
        
        
    largest possible premutation -> descending order
        9927 -> 9972
        
    1) find the largest digit, say num[j]
    2) just move it to the first index i where num[i] < num[j]
    
    this fails on 9738
    
    once the array STOPS being in non-descending order
    1) find the largest digit in the increasing "search space" of the array
    2) swap it with the first digit that's smaller than it

*/

class Solution {
  int getVal(char c) {
    return c - '0';
  }

  public int maximumSwap(int num) {
    StringBuilder number = new StringBuilder(Integer.toString(num));

    // find where array stops decreasing
    int pivot = -1;
    for (int i = 1; i < number.length(); i++) {
      int a = getVal(number.charAt(i));
      int b = getVal(number.charAt(i - 1));

      if (a > b) {
        pivot = i;
        break;
      }
    }

    if (pivot == -1)
      return num;

    // get max in that space
    int max = -1, maxIndex = -1;
    for (int i = pivot; i < number.length(); i++) {
      if (getVal(number.charAt(i)) >= max) {
        max = getVal(number.charAt(i));
        maxIndex = i;
      }
    }

    // swap max with first digit smaller than it
    char[] arr = number.toString().toCharArray();
    for (int i = 0; i < arr.length; i++) {
      if (max > getVal(arr[i])) {
        char temp = arr[i];
        arr[i] = arr[maxIndex];
        arr[maxIndex] = temp;
        break;
      }
    }

    number = new StringBuilder();
    for (char c : arr)
      number.append(c);

    return Integer.parseInt(number.toString());
  }
}
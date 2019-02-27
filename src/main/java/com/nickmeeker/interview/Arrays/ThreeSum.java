/*
    A big hint here is that we can't do better than o(n^2), so we can sort the array first.
    With a sorted array, we can process duplicate values to get it down to o(n^2) from the
    regular o(n^3) solution.
    
    We're using a two pointer approach and moving the l/r pointers according to certain conditions
*/

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> output = new ArrayList();
      Arrays.sort(nums);
      int len = nums.length;
      // only need to loop from 0 to len-2 since we need room for pointers
      for(int i = 0; i < len - 2; i++) {
          // we already checked this value - no duplicates
          if(i > 0 && nums[i] == nums[i-1])
              continue;
          int l = i + 1, r = len - 1;
          while(l < r) {
              int leftValue = nums[l];
              int rightValue = nums[r];
              
              // three cases:
                  // 1) the numbers add to zero
                  // 2) the left and right pointers add to a value that's too small 
                      // increase the left pointer
                  // 3) the left and right pointers add to a value that's too big
                      // decrease the right pointer
              
              // first case
              if(leftValue + rightValue + nums[i] == 0) {
                  List<Integer> toAdd = new ArrayList<>();
                  toAdd.add(leftValue);
                  toAdd.add(rightValue);
                  toAdd.add(nums[i]);
                  output.add(toAdd);
                  // no duplicates
                  while(l < len-1 && nums[l] == nums[l+1])
                      l++;
                  
                  // still no duplicates
                  while(r > 0 && nums[r] == nums[r-1])
                      r--;
                  
                  // move both pointers
                  l++;
                  r--;
              } 
              // other cases here
              else if (nums[l] + nums[r] < 0 - nums[i]) {
                  l++;
              } 
              else
                  r--;
          }
      }
      return output;
  }
  
  
}
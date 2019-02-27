class Solution {
  public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> output = new LinkedList();
      
      ArrayList<Integer> numsList = new ArrayList<Integer>();
      for(int i = 0; i < nums.length; i++) {
          numsList.add(nums[i]);
      }
      
      int n = nums.length; 
      backtrack(n, numsList, output, 0);
      return output;
  }
  
  public void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int index) {
      if(index == n)
          output.add(new ArrayList<Integer>(nums));
      
      for(int i = index; i < n; i++) {
          Collections.swap(nums, i, index);
          backtrack(n, nums, output, index + 1);
          Collections.swap(nums, i, index);
      }
  }
}
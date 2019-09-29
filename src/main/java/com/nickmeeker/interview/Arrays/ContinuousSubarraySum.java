class Solution {
  public boolean checkSubarraySum(int[] nums, int k) {
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        if (j - i >= 1 && ((k != 0 && sum % k == 0) || sum == k))
          return true;
      }
    }
    return false;
  }
}
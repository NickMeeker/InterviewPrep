class Solution {
  public int pivotIndex(int[] nums) {
    int left_sum = 0, right_sum = 0;
    for (int num : nums)
      right_sum += num;

    for (int i = 0; i < nums.length; i++) {
      right_sum -= nums[i];
      if (i > 0) {
        left_sum += nums[i - 1];
      }
      if (left_sum == right_sum)
        return i;
    }

    return -1;
  }
}
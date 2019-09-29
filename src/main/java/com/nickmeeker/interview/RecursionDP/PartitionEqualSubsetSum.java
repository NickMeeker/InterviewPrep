class Solution {
  Boolean[][] dp;

  boolean solve(int[] nums, int n, int index, int added, int skipped) {
    if (index == n) {
      return added == skipped;
    }

    if (dp[index][added] != null) {
      return dp[index][added];
    } else {
      dp[index][added] = solve(nums, n, index + 1, added + nums[index], skipped)
          || solve(nums, n, index + 1, added, skipped + nums[index]);
      return dp[index][added];
    }

  }

  public boolean canPartition(int[] nums) {
    int n = nums.length;
    int sum = 0;
    for (int num : nums)
      sum += num;

    dp = new Boolean[n][sum + 1];

    return solve(nums, n, 0, 0, 0);
  }
}
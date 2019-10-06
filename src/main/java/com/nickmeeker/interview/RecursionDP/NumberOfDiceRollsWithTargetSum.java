class Solution {
  int mod = (int) Math.pow(10, 9) + 7;

  int[][] dp;

  int solve(int i, int d, int f, int sum, int target) {
    if (i > d || sum > target) {
      return sum == target ? 1 : 0;
    }

    if (dp[i][sum] != -1)
      return dp[i][sum];

    dp[i][sum] = 0;
    for (int k = 1; k <= f; k++) {
      dp[i][sum] += solve(i + 1, d, f, sum + k, target);
      if (dp[i][sum] > mod)
        dp[i][sum] -= mod;
    }

    return dp[i][sum];
  }

  public int numRollsToTarget(int d, int f, int target) {
    dp = new int[d + 1][target + 1];
    for (int i = 1; i <= d; i++) {
      Arrays.fill(dp[i], -1);
    }
    return solve(1, d, f, 0, target);
  }
}
class Solution {
  public int maxProfit(int[] prices) {
      if(prices == null) return 0;
      if(prices.length == 0) return 0;
      int min = prices[0];
      int maxProfit = 0;
      for(int i = 1; i < prices.length; i++) {
          int temp = 0;
          if(prices[i] > min){
              temp = prices[i] - min;
              maxProfit = Math.max(maxProfit, temp);
          }
          if(prices[i] < min) {
              min = prices[i];
          }
      }
      return maxProfit;
  }
}
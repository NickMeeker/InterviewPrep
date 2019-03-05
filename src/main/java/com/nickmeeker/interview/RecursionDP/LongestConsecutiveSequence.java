/*

    [100, 4, 200, 1, 3, 2]
    
    100 --> map(100, 1)
    4 --> map(4, 1)
    200 --> map(200, 1)
    3 --> map contains 4 --> map(3, map.get(3+1)+1)
    1 --> get to 3 like normal, then just add streak + known streak at 3 --> 4
    big thing to note here is that we're adding each new streak element to the map
    so that we don't have to reprocess values, as in like:
    
        1->2->3->4
        we visit 4, then 1, but 1 visits 2 and 3 and adds them to the map. this way
        we don't need to redo 2 and 3, making the runtime O(n).
        
        
    Runtime: O(n)
    Space: O(n)
*/


class Solution {
  public int longestConsecutive(int[] nums) {
      Set<Integer> set = new HashSet<>();
      HashMap<Integer, Integer> map = new HashMap<>();
      int maxStreak = 0;
      for(int num : nums)
          set.add(num);
      
      int longest = 0;
      for(int i = 0; i < nums.length; i++) {
          int t = nums[i];
          int k = t;
          int streak = 1;
          // first case -- I've already visited this key
          if(map.containsKey(t))
              continue;
          while(set.contains(k+1)) {
              if(map.containsKey(k+1)) {
                  streak += map.get(k+1);
                  break;
              }
              streak++;
              k++;
              map.put(k, streak);
          }
          map.put(t, streak);
          maxStreak = Math.max(streak, maxStreak);
      }
      return maxStreak;
  }
}
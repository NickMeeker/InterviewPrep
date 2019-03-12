/*
    Sliding Window with two pointers: start and end
    
    1) move the end pointer until it hits a third type of fruit
        as i'm moving the end pointer, update my max
        
        once i've hit the third type of fruit
            i can advance the start pointer until i'm only working with two types of fruits
            
        use a hashmap
            end ptr: each time "collect" a fruit, update its value in the hash table (++)
            start ptr: each time i "drop" a fruit, update its value in the hash table (--)
        
        two conditions:
            track when i've added a new fruit
                - when map.get(fruit) was 0 and now it's not, 
                    then i've added a new type of fruit
                - need to initialize every type of fruit to 0
            track when i've removed the fruits
                - when map.get(fruit) == 0, then i know i've removed all of that fruit
                
        - count of types of fruit in my basket
            - when i get a new fruit, increment count
            - move start ptr when count == 3
                - when i've removed all instances of a certain fruit, decrement count 
        
    [0,1,2,2]
    
    basket: two different fruits
    max: 2
        0 -> 0
        1 -> 1
        2 -> 3
    
    0,1,2,2
          ^  
      ^    
      
    Running Time: O(n)
    Space Complexity: O(n)
*/


class Solution {
  public int totalFruit(int[] tree) {
      if(tree == null || tree.length == 0) 
          return 0;
      int start = 0, end = 0, count = 0, max = 0, currentNumberOfFruit = 0, n = tree.length;
      HashMap<Integer, Integer> map = new HashMap<>();
      
      for(int fruit : tree)
          map.put(fruit, 0);
      
      
      /*
          map:
              0->0
              1->1
              2->2
          0,1,2,2
          fruit = 2
          cvof = 0
          cnof = 3
          count = 2
          max = 3
      */
      while(end < n) {
          int fruit = tree[end];
          int currentValueOfFruit = map.get(fruit);
          map.put(fruit, map.get(fruit) + 1);
          currentNumberOfFruit++;
          if(currentValueOfFruit == 0) {
              count++;
          }
          while(count == 3) {
              fruit = tree[start];
              map.put(fruit, map.get(fruit) - 1);
              currentNumberOfFruit--;
              if(map.get(fruit) == 0)
                  count--;
              start++;
          }
          max = Math.max(max, currentNumberOfFruit);
          end++;
      }
      return max;
  }
}
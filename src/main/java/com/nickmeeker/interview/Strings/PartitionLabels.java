/*
    ababcbacadefegdehijhklij
    
    ababcb --> partition includes all Bs
    ababcbac --> better partition since it includes b and c
    ababcbaca --> still better partition since it include b and c and a
    ababcbacad --> introduce new letter, so new partition

    hashmap of frequencies
    
    defegde --> next letter is h, so stop here
    
    once a frequency hits 0, we have our first partition
    keep going until all letters in current partition are zero'd
    repeat
    
    how to store which letters are in the current partition
    
    HashMap<Character, Integer> freqs -> stores frequency of characters
    HashSet<Characters> charsInPartition -> characters in current partition
    
    NOTE: the inner for loop is bounded by the size of the alphabet, so runtime is /technically/
      O(n*a), where a is the size of the alphabet. For english, this is O(26n) = O(n). Space complexity
      is O(n).x
*/

class Solution {
  public List<Integer> partitionLabels(String S) {
      if(S == null || S.length() == 0) return new ArrayList<Integer>(0);
      HashMap<Character, Integer> freqs = new HashMap<>();
      HashSet<Character> charsInPartition = new HashSet<>();
      List<Integer> indeces = new ArrayList<Integer>();
      List<Integer> output = new ArrayList<Integer>();
      int end = 0, currentPartition = 0;

      for(char c : S.toCharArray()) {
          freqs.put(c, freqs.getOrDefault(c, 0) + 1);
      }
      
      while(end < S.length()) {
          char c = S.charAt(end);
          freqs.put(c, freqs.get(c) - 1);
          charsInPartition.add(c);
          boolean finishedPartition = true;
          for(char k : charsInPartition) {
              if(freqs.get(k) > 0) {
                  finishedPartition = false;
              }
          }
          if(finishedPartition){
              charsInPartition = new HashSet<>();
              charsInPartition.add(c);
              indeces.add(end);
              if(indeces.size() == 1) {
                  output.add(indeces.get(0) + 1);
              } else {
                  output.add(indeces.get(currentPartition) - indeces.get(currentPartition-1));
              }
              currentPartition++;
          }
          end++;
      }
      return output;
  }
}
/*
    Basically, we have this int[] match which indicates whether the string
    at that index matches the sources[] attempt for that index. Then, we can just
    iterate over the string, and if there's a match at that index, append the target
    string and move the index over by the length of the original substring. Otherwise, 
    just copy the current character and increment index.
*/


class Solution {
  public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
      int offset = 0;
      int[] match = new int[S.length()];
      Arrays.fill(match, -1);
      for(int i = 0; i < indexes.length; i++) {
          int index = indexes[i];
          String source = sources[i];
          String target = targets[i];
          if(index + source.length() <= S.length() &&
             S.substring(index, index+source.length()).equals(source)) {
              // cool, the substring matches source
              match[index] = i;
          }
      }
      StringBuilder output = new StringBuilder();
      int index = 0;
      while(index < S.length()) {
          if(match[index] >= 0) {
              output.append(targets[match[index]]);
              index += sources[match[index]].length();
          } else {
              output.append(S.charAt(index));
              index++;
          }
      }
      return output.toString();
  }
}
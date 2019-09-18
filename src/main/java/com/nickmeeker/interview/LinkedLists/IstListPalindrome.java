/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


/*
    Use arraylist()

*/
class Solution {
  public boolean isPalindrome(ListNode head) {
      ListNode temp = head;
      ArrayList<Integer> list = new ArrayList<>();
      while(temp != null) {
          int val = temp.val;
          list.add(val);
          temp = temp.next;
      }
      return isPal(list);
  }
  
  public boolean isPal(ArrayList<Integer> list) {
      for(int i = 0; i < list.size()/2; i++) {
          if((int)list.get(i) != (int)list.get((list.size() - 1 - i))) {
              return false;
          }
      }
      return true;
  }
}
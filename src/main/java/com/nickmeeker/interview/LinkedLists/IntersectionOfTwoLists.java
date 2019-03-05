/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 /**
  * Hash list b, check for element in A in the set. if no node in a is in the set, return null
  */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      ListNode tempA = headA, tempB = headB;
      HashSet<ListNode> set = new HashSet<>();
      while(tempB != null) {
          set.add(tempB);
          tempB = tempB.next;
      }
      
      while(tempA != null) {
          if(set.contains(tempA))
              return tempA;
          
          tempA = tempA.next;
      }
      return null;
  }
}
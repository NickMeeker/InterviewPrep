package com.nickmeeker.interview.LinkedLists;
import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


/*
    2->4->3 + 5->6->4
    
    Basically, we need to add the numbers (plus carry) and, if they're greater than 9, mod them 
    by 9 and set a carry value to 1 (set to 0 if less than 10). Iterate over the lists like normal,
    and then, once we hit the end of one list, just copy the remaining list over. Pretty
    straightforward

*/
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      int carry = 0;
      ListNode head = new ListNode(-1), temp = head;
      head.next = temp;
      while(l1 != null || l2 != null) {
          int l1Val = 0, l2Val = 0;
          if(l1 != null) 
              l1Val = l1.val;
          if(l2 != null)
              l2Val = l2.val;
          int sum = l1Val + l2Val + carry;
          if(sum > 9){
              sum %= 10;
              carry = 1;
          } else 
              carry = 0;
          temp.next = new ListNode(sum);
          temp = temp.next;
          if(l1 != null) l1 = l1.next;
          if(l2 != null) l2 = l2.next;
      }
      if(carry > 0)
          temp.next = new ListNode(carry);
      return head.next;
  }
}
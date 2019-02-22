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
class Solution {
  public ListNode reverseList(ListNode head) {
      if (head == null) return head;
      ListNode prev = null, current = head, next = head;
      while(current != null) {
          next = current.next;
          current.next = prev;
          prev = current;
          current = next;
      }
      return prev;
  }
}
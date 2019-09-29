/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public static class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode l1, ListNode l2) {
            return l1.val < l2.val ? -1 : 1;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> comparator = new ListNodeComparator();
        PriorityQueue<ListNode> heap = new PriorityQueue<>(5, comparator);

        for (ListNode head : lists)
            if (head != null)
                heap.add(head);

        ListNode dummyHead = new ListNode(-1), head = dummyHead;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            head.next = node;
            head = head.next;
            if (head.next != null)
                heap.add(head.next);
        }

        return dummyHead.next;
    }
}
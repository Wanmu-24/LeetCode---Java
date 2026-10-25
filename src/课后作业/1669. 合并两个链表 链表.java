/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur1 = list1;
        for(int i = 0; i < a -1; i++) {
            cur1 = cur1.next;
        }
        ListNode nodea = cur1.next;
        cur1.next = list2;
        ListNode cur2 = list2;
        while (cur2.next != null) {
            cur2 = cur2.next;
        }
        ListNode cur3 = nodea;
        for(int i = 0; i < b - a; i++) {
            cur3 = cur3.next;
        }
        cur2.next = cur3.next;
        return list1;
    }
}
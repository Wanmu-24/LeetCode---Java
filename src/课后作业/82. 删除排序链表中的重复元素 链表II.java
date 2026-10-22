// 课上例题
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            int num = cur.next.val;
            if (cur.next.next.val == num) {
                while(cur.next != null && cur.next.val == num) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

//题解
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            int val = cur.next.val;
            if (cur.next.next.val == val) { // 后两个节点值相同
                // 值等于 val 的节点全部删除
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/solutions/2004067/ru-he-qu-zhong-yi-ge-shi-pin-jiang-tou-p-2ddn/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        // 把 p0 移到 left 的上一个节点
        for (int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }

        ListNode pre = null;
        ListNode cur = p0.next;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode nxt = cur.next;
            cur.next = pre; // 每次循环只修改一个 next，方便大家理解
            pre = cur;
            cur = nxt;
        }

        // 见视频
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/reverse-linked-list-ii/description/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


// 自己写的 没考虑可能从第一个元素开始反转 没用哨兵
// 以及命名 格式 思路 可读性 都很差
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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left==right){
            return head;
        }

        ListNode cur =head;
        ListNode p0 = null;

        int l = left;
        while(l > 1) {
            p0 = cur;
            cur=cur.next;
            l--;
        }

        ListNode pre = null;
        while(left <= right) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
            left++;
        }
        p0.next.next=cur;
        p0.next=pre;
        return head;
    }
}
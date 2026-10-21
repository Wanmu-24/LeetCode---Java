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
    public int pairSum(ListNode head) {
        ListNode mid = findMidListNode(head);
        ListNode head2 = reverseListNode(mid);
        int sum = -1;
        while (head2 != null) {
            sum = Math.max(sum, head.val + head2.val);
            head = head.next;
            head2 = head2.next;
        }
        return sum;
    }

    private ListNode reverseListNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    private ListNode findMidListNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}


// 题解
class Solution {
    public int pairSum(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode head2 = reverseList(mid);
        
        int ans = 0;
        while (head2 != null) {
            ans = Math.max(ans, head.val + head2.val);
            head = head.next;
            head2 = head2.next;
        }
        return ans;
    }

    // 876. 链表的中间结点
    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 206. 反转链表
    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/maximum-twin-sum-of-a-linked-list/solutions/3974815/liang-chong-fang-fa-di-gui-zhao-zhong-di-czvg/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
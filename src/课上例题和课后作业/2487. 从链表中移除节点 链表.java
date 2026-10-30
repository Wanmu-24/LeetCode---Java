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
    public ListNode removeNodes(ListNode head) {
        ListNode head2 = reverse(head);
        ListNode cur = head2;
        int num = cur.val;
        while (cur.next != null) {
            if (cur.next.val < num) {
                cur.next = cur.next.next;
            } else {
                // 即 (cur.next.val >= num
                cur = cur.next;
                num = cur.val;
            }
        }
        return reverse(head2);
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt =cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}


// 题解 题解两种思路 递归哪种我没想到

// 递归
class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode node = removeNodes(head.next); // 返回的链表头一定是最大的
        if (node.val > head.val) {
            // 执行 head'.next = node 后，我们删除了从 head'（这里的 head' 是更前面的链表节点）到 node 之间的所有节点，包括当前的 head
            return node;
        }
        head.next = node;
        return head;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/remove-nodes-from-linked-list/solutions/1993491/di-gui-jian-ji-xie-fa-by-endlesscheng-jfwi/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// 迭代
class Solution {
    public ListNode removeNodes(ListNode head) {
        head = reverseList(head);
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val > cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return reverseList(head);
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
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
链接：https://leetcode.cn/problems/remove-nodes-from-linked-list/solutions/1993491/di-gui-jian-ji-xie-fa-by-endlesscheng-jfwi/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
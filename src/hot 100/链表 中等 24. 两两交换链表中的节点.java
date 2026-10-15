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

// 为25. K 个一组翻转链表 题 当k=2 时的情况 
// 所以思路和25一样 但是题解不是这样的思路 也可以学习一下
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode p0 = dummy;
        ListNode pre = null;
        ListNode cur = dummy.next;
        ListNode nxt = null;
        while(cur != null && cur.next != null) {
            for(int i = 0 ; i < 2; i++) {
                nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            ListNode temp = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = temp;
            pre = null;
        }
        return dummy.next;
    }
}

// 题解
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head); // 用哨兵节点简化代码逻辑
        ListNode node0 = dummy;
        ListNode node1 = head;
        while (node1 != null && node1.next != null) { // 至少有两个节点
            ListNode node2 = node1.next;
            ListNode node3 = node2.next;

            node0.next = node2; // 0 -> 2
            node2.next = node1; // 2 -> 1
            node1.next = node3; // 1 -> 3

            node0 = node1; // 下一轮交换，0 是 1
            node1 = node3; // 下一轮交换，1 是 3
        }
        return dummy.next; // 返回新链表的头节点
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/swap-nodes-in-pairs/solutions/2374872/tu-jie-die-dai-di-gui-yi-zhang-tu-miao-d-51ap/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
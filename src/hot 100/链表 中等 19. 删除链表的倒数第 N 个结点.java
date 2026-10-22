// 课上讲的例题
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;
        ListNode right = dummy;
        ListNode left = dummy;
        for(int i = 0; i < n; i++) {
            right = right.next;
        }
        while(right.next != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return dummy.next;

    }
}

// 题解
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 由于可能会删除链表头部，用哨兵节点简化代码
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = dummy;
        while (n-- > 0) {
            right = right.next; // 右指针先向右走 n 步
        }
        while (right.next != null) {
            left = left.next;
            right = right.next; // 左右指针一起走
        }
        left.next = left.next.next; // 左指针的下一个节点就是倒数第 n 个节点
        return dummy.next;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list/solutions/2004057/ru-he-shan-chu-jie-dian-liu-fen-zhong-ga-xpfs/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
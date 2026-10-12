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
// 思路 和题解的一样 先遍历总个数 
// 然后对于每 k 个进行翻转 和 92 反转链表Ⅱ 一样 
// 但是要考虑每k个一组反转
// 比如 1 2 3 4 5
// 第一次后 2 1 3 4 5
// 这是p0应该变成了 1   这就是和92不一样的地方（92 找一次p0 一组反转后就行了） （这里p0要变 多组反转）和要考的地方就在这里
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);
        ListNode cur = head;
        int num = 0;
        while(cur != null) {
            num++;
            cur = cur.next;
        }

        num = num - (num % k);
        ListNode p0 = dummy;
        
        ListNode pre = null;
        cur = p0.next;
        for(int i = 1; i <= num ; i++) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if(i % k == 0 ) {
                p0.next.next = cur;
                ListNode temp = p0.next;
                p0.next = pre;
                p0 = temp;
                pre = null;
            }
        }
        return dummy.next;
    }
}

// 题解 
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 统计节点个数
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode lastTail = dummy; // 上一组翻转后的尾节点

        // k 个一组处理
        for (; n >= k; n -= k) {
            ListNode pre = null;
            ListNode cur = lastTail.next;
            for (int i = 0; i < k; i++) { // 同 92 题
                ListNode nxt = cur.next;
                cur.next = pre; // 每次循环只修改一个 next，方便大家理解
                pre = cur;
                cur = nxt;
            }

            // 请结合视频中的图理解
            // 翻转后：
            // pre 是当前组的头节点
            // cur 是下一组的起始节点
            // lastTail 是上一组的尾节点
            // lastTail.next 是当前组的尾节点
            ListNode tail = lastTail.next;
            tail.next = cur; // 当前组的尾节点指向下一组的起始节点
            lastTail.next = pre; // 上一组的尾节点指向当前组的头节点
            lastTail = tail;
        }

        return dummy.next;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/reverse-nodes-in-k-group/solutions/1992228/you-xie-cuo-liao-yi-ge-shi-pin-jiang-tou-plfs/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
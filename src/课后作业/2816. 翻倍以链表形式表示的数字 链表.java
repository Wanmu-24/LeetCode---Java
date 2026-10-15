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
    public ListNode doubleIt(ListNode head) {
        head = rev(head);
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (head != null || carry > 0) {
            int sum = 0;
            if (head != null) {
                sum += head.val * 2;
                head = head.next;
            }    
            sum += carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        return rev(dummy.next);
    }

    public ListNode rev(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

}

// 题解
// 方法一
// 看成是 head 与 head 这两个链表相加。
class Solution {
    public ListNode doubleIt(ListNode head) {
        head = reverseList(head);
        ListNode res = double2(head); // 反转后，就变成【2. 两数相加】了
        return reverseList(res);
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

    // 2. 两数相加：自己和自己相加
    // 题解 https://leetcode.cn/problems/add-two-numbers/solution/dong-hua-jian-ji-xie-fa-cong-di-gui-dao-oe0di/
    private ListNode double2(ListNode l1) {
        ListNode dummy = new ListNode(); // 哨兵节点，作为新链表的头节点的前一个节点
        ListNode cur = dummy;
        int carry = 0; // 进位
        while (l1 != null) {
            carry += l1.val * 2; // 节点值和进位加在一起
            cur.next = new ListNode(carry % 10); // 每个节点保存一个数位
            carry /= 10; // 新的进位
            cur = cur.next; // 下一个节点
            l1 = l1.next; // 下一个节点
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next; // 哨兵节点的下一个节点就是头节点
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/double-a-number-represented-as-a-linked-list/solutions/2385962/o1-kong-jian-zuo-fa-kan-cheng-shi-head-y-1dco/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


// 方法二
// 如果不考虑进位，就是每个节点的值乘以 2。

// 什么时候会受到进位的影响呢？只有下一个节点大于 4 的时候，才会因为进位多加一。

// 特别地，如果链表头的值大于 4，那么需要在前面插入一个新的节点。
class Solution {
    public ListNode doubleIt(ListNode head) {
        if (head.val > 4) {
            head = new ListNode(0, head);
        }
        for (ListNode cur = head; cur != null; cur = cur.next) {
            cur.val = cur.val * 2 % 10;
            if (cur.next != null && cur.next.val > 4) {
                cur.val++;
            }
        }
        return head;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/double-a-number-represented-as-a-linked-list/solutions/2385962/o1-kong-jian-zuo-fa-kan-cheng-shi-head-y-1dco/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        int plus = 0;
        while(l1 != null || l2 !=null || plus > 0) {
            ListNode cur3 = new ListNode(0);
            if (l1!=null) {
                cur3.val += l1.val;
                l1 = l1.next;
            } 

            if (l2 != null) {
                cur3.val += l2.val;
                l2 = l2.next;
            }

            cur3.val += plus;

            plus = cur3.val / 10;
            cur3.val = cur3.val % 10;

            pre.next = cur3;
            pre = cur3;
            
        }
        return dummy.next;
    }
}

// 题解
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(); // 哨兵节点
        ListNode cur = dummy;
        int carry = 0; // 进位值
        while (l1 != null || l2 != null || carry != 0) { // 有一个不是空节点，或者还有进位，就继续迭代
            int sum = carry;
            if (l1 != null) {
                sum += l1.val; // 节点值和进位加在一起
                l1 = l1.next; // 下一个节点
            }
            if (l2 != null) {
                sum += l2.val; // 节点值和进位加在一起
                l2 = l2.next; // 下一个节点
            }
            cur = cur.next = new ListNode(sum % 10); // 每个节点保存一个数位
            carry = sum / 10; // 新的进位
        }
        return dummy.next; // 哨兵节点的下一个节点就是头节点
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/add-two-numbers/solutions/2327008/dong-hua-jian-ji-xie-fa-cong-di-gui-dao-oe0di/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
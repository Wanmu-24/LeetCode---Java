// 还是没想到递归的写法 写完迭代就交了
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode dummy = new ListNode();
        ListNode cur3 = dummy;
        while(cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur3.next = cur1;
                cur3 = cur3.next;
                cur1 = cur1.next;
            } else {
                cur3.next = cur2;
                cur3 = cur3.next;
                cur2 = cur2.next;
            }
        }
        // 这里其实可以优化成 cur3.next = cur1 != null ? cur1 : cur2;
        // 因为只是链起来就行 cur1或cur2 后面本来就有序 直接cur3.next = 就行
         if (cur1 == null) {
            while (cur2 != null) {
                cur3.next = cur2;
                cur3 = cur2;
                cur2 = cur2.next;
            }
        } else {
            while (cur1 != null) {
                cur3.next = cur1;
                cur3 = cur1;
                cur1 = cur1.next;
            }
        }

        return dummy.next;
    }
}

// 题解
// 方法一：迭代（尾插法）
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(); // 用哨兵节点简化代码逻辑
        ListNode cur = dummy; // cur 指向新链表的末尾
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1; // 把 list1 加到新链表中
                list1 = list1.next;
            } else { // 注：相等的情况加哪个节点都是可以的
                cur.next = list2; // 把 list2 加到新链表中
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2; // 拼接剩余链表
        return dummy.next;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/merge-two-sorted-lists/solutions/2373691/liang-chong-fang-fa-die-dai-di-gui-pytho-wf75/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


// 方法二：递归（头插法）
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2; // 注：如果都为空则返回空
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/merge-two-sorted-lists/solutions/2373691/liang-chong-fang-fa-die-dai-di-gui-pytho-wf75/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
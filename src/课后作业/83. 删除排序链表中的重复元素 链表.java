// 课上例题
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) { // 看看下个节点……
            if (cur.next.val == cur.val) { // 和我一样，删！
                cur.next = cur.next.next;
            } else { // 和我不一样，移动到下个节点
                cur = cur.next;
            }
        }
        return head;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-list/solutions/2004062/ru-he-qu-zhong-yi-ge-shi-pin-jiang-tou-p-98g7/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
// 经验不够 用二分来 每次都log n 一共就是链表长度 * log n
// 其实有查找O(1)的 比如 哈希集合（通用性强） 布尔数组（数组值域 就是长度n小的时候更快）
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        Arrays.sort(nums);
        int n = nums.length;
        while (cur.next != null) {
            if (isInArrays(cur.next,nums)) {
                cur.next = cur.next.next; 
            } else {
                cur = cur.next; 
            }
        }
        return dummy.next;
    }

    private Boolean isInArrays(ListNode cur, int[] nums) {
        int n = nums.length;
        int val = cur.val;
        if (val > nums[n - 1] || val < nums[0] ) {
            return false;
        }
        int left = -1;
        int right = n;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == val) {
                return true;
            } else if(nums[mid] > val) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return false;
    }

}

// 题解
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>(nums.length, 1); // 预分配空间
        for (int x : nums) {
            set.add(x);
        }

        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null) {
            ListNode nxt = cur.next;
            if (set.contains(nxt.val)) {
                cur.next = nxt.next; // 从链表中删除 nxt 节点
            } else {
                cur = nxt; // 不删除 nxt，继续向后遍历链表
            }
        }
        return dummy.next;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/delete-nodes-from-linked-list-present-in-array/solutions/2843071/shao-bing-jie-dian-yi-ci-bian-li-pythonj-imre/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
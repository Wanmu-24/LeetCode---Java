// https://leetcode.cn/problems/same-tree/description/
// 题解
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q; // 必须都是 null
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/same-tree/solutions/2015056/ru-he-ling-huo-yun-yong-di-gui-lai-kan-s-empk/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
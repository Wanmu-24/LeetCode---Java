class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int mn = Math.min(p.val, q.val);
        int mx = Math.max(p.val, q.val);
        return lowestCommonAncestor(root, mn, mx);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int mn, int mx) {
        // 一个在左子树 一个在右子树
        if (root.val > mn && root.val < mx) {
            return root;
        }
        // 自己就是p或q
        if (root.val == mn || root.val == mx) {
            return root;
        }
        // 都在右子树
        if (root.val < mn) {
            return lowestCommonAncestor(root.right, mn, mx);
        }
        // 最后一种情况 都在左子树
        return lowestCommonAncestor(root.left, mn, mx);
    }
}

// 题解
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int x = root.val;
        if (p.val < x && q.val < x) { // p 和 q 都在左子树
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > x && q.val > x) { // p 和 q 都在右子树
            return lowestCommonAncestor(root.right, p, q);
        }
        return root; // 其它
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/submissions/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
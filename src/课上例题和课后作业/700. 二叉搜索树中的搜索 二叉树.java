// https://leetcode.cn/problems/search-in-a-binary-search-tree/description/
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        }
        return null;
    }
}

// 题解
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        }
        return searchBST(val < root.val ? root.left : root.right, val);
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/search-in-a-binary-search-tree/solutions/1121178/er-cha-sou-suo-shu-zhong-de-sou-suo-by-l-d8zi/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
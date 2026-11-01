// https://leetcode.cn/problems/evaluate-boolean-binary-tree/description/
class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root.val == 0) {
            return false;
        } else if (root.val == 1) {
            return true;
        }
        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }
}

// 题解
class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null) {
            return root.val == 1;
        } 
        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/evaluate-boolean-binary-tree/solutions/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
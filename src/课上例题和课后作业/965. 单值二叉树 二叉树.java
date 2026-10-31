// https://leetcode.cn/problems/univalued-binary-tree/description/
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return dfs(root,root.val);
    }
    private boolean dfs(TreeNode node, int num) {
        if (node == null) {
            return true;
        }
        if(node.val != num) {
            return false;
        }
        return dfs(node.left, num) && dfs(node.right, num);
    }
}